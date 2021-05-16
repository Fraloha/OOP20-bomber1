package bomberone.views.game;


import bomberone.controllers.game.GameController;
import bomberone.model.Difficulty;
import bomberone.model.bomber.Bomber;
import bomberone.model.gameObjects.PowerUp;
import bomberone.model.user.Skins;
import bomberone.tools.ResourcesLoader;
import bomberone.tools.audio.SoundsHandler;
import bomberone.tools.audio.GameSounds;
import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import bomberone.views.basic.ViewImpl;
import bomberone.views.game.img.AnimatedObjectsSprites;
import bomberone.views.game.img.GameImages;
import bomberone.views.game.movement.ControlsMap;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class GameViewImpl extends ViewImpl implements GameView {

    private static final int FONT_SIZE = 30;
    private static final int ENEMY_WIDTH = 32;
    private static final int ENEMY_HEIGHT = 48;
    private static final int N_LIFES_ONE = 1;
    private static final int N_LIFES_TWO = 2;
    private static final int N_LIFES_THREE = 3;
    private static final int IMAGE_SIZE = 32;
    private static final int ANIMATED_ENTITY_IMAGE_HEIGHT = 16;
    private static final int WORLD_CELLS = 18;
    private static final int CELL_SIZE = 32;
    private static final int WORLD_WIDTH = 576;
    private static final int WORLD_HEIGHT = 576;
    private static final int BOMBER_N_ANIMATION = 4;
    private static final int ENEMY_N_ANIMATION = 3;
    private static final int FIRE_N_ANIMATION = 3;
    private static final int BOMB_N_ANIMATION = 15;

    @FXML
    private Label timeLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    private Canvas canvasBackground;

    @FXML
    private Canvas canvasForegrounds;

    @FXML
    private ImageView miniBomber;

    @FXML
    private ImageView lifeOne;

    @FXML
    private ImageView lifeTwo;

    @FXML
    private ImageView lifeThree;

    @FXML
    private ImageView clockImageView;

    @FXML
    private ImageView quitButton;

    private GraphicsContext gCForeground;
    private GraphicsContext gCBackground;
    private ControlsMap controlsMap;

    private Image[][] bomberSprites;
    private Image[][] enemySprites;

    /**
     * When the quitButton is pressed, this method stop the Game.
     */
    @FXML
    public void quitClicked() {
        SoundsHandler.stopAudio();
        ((GameController) this.getController()).quitGame();
        ViewsSwitcher.switchView(this.getStage(), ViewType.HOME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        SoundsHandler.start(GameSounds.CLASSIC);
        this.scoreLabel.setFont(ResourcesLoader.getFont(FONT_SIZE));
        this.timeLabel.setFont(ResourcesLoader.getFont(FONT_SIZE));
        this.gCBackground = this.canvasBackground.getGraphicsContext2D();
        this.gCForeground = this.canvasForegrounds.getGraphicsContext2D();
        this.getController().init();
        this.drawGame();
        this.controlsMap = new ControlsMap(((GameController) this.getController()).getPlayerOfTheGame().getControls(),
                ((GameController) this.getController()).getCommandListener().getPlayerBehaviour());
        this.setViewEventListener();
    }

    /**
     * Prepare the EventListener of the View.
     */
    private void setViewEventListener() {
        this.getStage().getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(final KeyEvent e) {
                if (controlsMap.getControlMap().keySet().contains(e.getCode().getCode())) {
                    controlsMap.getControlMap().get(e.getCode().getCode()).accept(Boolean.TRUE);
                }
            }
        });

        this.getStage().getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(final KeyEvent e) {
                if (controlsMap.getControlMap().keySet().contains(e.getCode().getCode())) {
                    controlsMap.getControlMap().get(e.getCode().getCode()).accept(Boolean.FALSE);
                }
            }
        });

        /**
         * Stop the Threads when the game is closed.
         */
        this.getStage().setOnCloseRequest(event -> {
            ((GameController) this.getController()).quitGame();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawGame() {
        /* Draw the timer */
        this.clockImageView.setImage(GameImages.CLOCK.getImage());
        this.setUpSprites();
        this.drawLifes();
        this.quitButton.setImage(GameImages.QUIT_GAME.getImage());
        /* Draw the background */
        Image backgroundImage = GameImages.BACKGROUND.getImage();
        for (int i = 0; i < WORLD_CELLS; i++) {
            for (int j = 0; j < WORLD_CELLS; j++) {
                gCBackground.drawImage(backgroundImage, i * CELL_SIZE, j * CELL_SIZE);
            }
        }
        /* Draw the spawner */
        double spawnCord = CELL_SIZE * WORLD_CELLS / 2 - CELL_SIZE / 2;
        gCBackground.drawImage(GameImages.SPAWN.getImage(), spawnCord, spawnCord);

        /* Draw the Walls */
        Image wallImage = GameImages.HARDWALL.getImage();
        ((GameController) this.getController()).getObjList().getHardWallList().stream()
                .forEach(wall -> {
                    gCBackground.drawImage(wallImage, wall.getPosition().getX(), wall.getPosition().getY());
                });

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render() {
        /* Update Scorebar */
        this.drawLifes();
        Platform.runLater(() -> this.timeLabel.setText(((GameController) this.getController()).getTimer().toString()));
        Platform.runLater(() -> this.scoreLabel.setText(((GameController) this.getController()).getScore() + ""));
        Platform.runLater(() -> this.gCForeground.clearRect(0, 0, WORLD_WIDTH, WORLD_HEIGHT));

        /* Draw the boxes */
        Platform.runLater(() -> {
            Image boxImage = GameImages.BOX.getImage();
            ((GameController) this.getController()).getObjList().getBoxList().forEach(box -> {
                this.gCForeground.drawImage(boxImage, box.getPosition().getX(), box.getPosition().getY(), IMAGE_SIZE,
                        IMAGE_SIZE);
            });
        });

        /* Draw the powerUp */
        Platform.runLater(() -> {
            ((GameController) this.getController()).getObjList().getPowerUpList().stream()
                    .filter(PowerUp::isReleased).forEach(pUp -> {
                        Image powerUpImage = null;
                        PowerUp.Type type = pUp.getType();
                        if (type.equals(PowerUp.Type.FirePower)) {
                            powerUpImage = GameImages.POWER_FIREPOWER.getImage();
                        }
                        if (type.equals(PowerUp.Type.Pierce)) {
                            powerUpImage = GameImages.POWER_PIERCE.getImage();
                        }
                        if (type.equals(PowerUp.Type.Speed)) {
                            powerUpImage = GameImages.POWER_SPEED.getImage();
                        }
                        if (type.equals(PowerUp.Type.Time)) {
                            powerUpImage = GameImages.POWER_TIMER.getImage();
                        }
                        if (type.equals(PowerUp.Type.Ammo)) {
                            powerUpImage = GameImages.POWER_BOMB.getImage();
                        }
                        this.gCForeground.drawImage(powerUpImage,
                                pUp.getPosition().getX(), pUp.getPosition().getY());
                    });
        });

        /* Draw bombs */
        Platform.runLater(() -> {
            ((GameController) this.getController()).getObjList().getBombList().stream()
                    .forEach(bomb -> {
                        if (bomb.getPierce()) {
                            this.gCForeground.drawImage(
                                            AnimatedObjectsSprites.PIERCE_BOMB.getSprites()[0][bomb.getIndexAnimation()
                                                    % BOMB_N_ANIMATION],
                                    bomb.getPosition().getX(), bomb.getPosition().getY());
                        } else {
                            this.gCForeground.drawImage(
                                            AnimatedObjectsSprites.BOMB.getSprites()[0][bomb.getIndexAnimation()
                                                    % BOMB_N_ANIMATION],
                                    bomb.getPosition().getX(), bomb.getPosition().getY());
                        }

                    });
        });

        /* Draw the fire */
        Platform.runLater(() -> {
            ((GameController) this.getController()).getObjList().getFireList().forEach(fire -> {
                this.gCForeground.drawImage(
                        AnimatedObjectsSprites.FIRE.getSprites()[0][fire.getIndexAnimation() % FIRE_N_ANIMATION],
                        fire.getPosition().getX(), fire.getPosition().getY());
            });
        });

        /* Draw enemies */
        Platform.runLater(() -> {
            ((GameController) this.getController()).getObjList().getEnemyList().stream()
                    .forEach(enemy -> {
                        this.gCForeground.drawImage(this.enemySprites[enemy.getSpriteIndex()][enemy.getAnimationIndex()
                                                % ENEMY_N_ANIMATION],
                                enemy.getPosition().getX(), enemy.getPosition().getY() - ANIMATED_ENTITY_IMAGE_HEIGHT,
                                ENEMY_WIDTH, ENEMY_HEIGHT);
                    });
        });

        /* Draw the BomberMan */
        Bomber bomberTemp = ((GameController) this.getController()).getBomber();
        Platform.runLater(() -> this.gCForeground.drawImage(this.bomberSprites[bomberTemp.getSpriteIndex()][bomberTemp.getAnimationIndex()
                        % BOMBER_N_ANIMATION],
                bomberTemp.getPosition().getX(), bomberTemp.getPosition().getY() - ANIMATED_ENTITY_IMAGE_HEIGHT));

    }

    /**
     * Draw the hearts depending on the number of Bomber's Lifes.
     */
    private void drawLifes() {
        int nLifes = ((GameController) this.getController()).getBomber().getLifes();
        Image lifeYes = GameImages.LIFE_YES.getImage();
        Image lifeNo = GameImages.LIFE_NO.getImage();
        Platform.runLater(() -> this.lifeThree.setImage((nLifes >= N_LIFES_THREE) ? lifeYes : lifeNo));
        Platform.runLater(() -> this.lifeTwo.setImage((nLifes >= N_LIFES_TWO) ? lifeYes : lifeNo));
        Platform.runLater(() -> this.lifeOne.setImage((nLifes >= N_LIFES_ONE) ? lifeYes : lifeNo));
    }

    /**
     * SetUp the sprites used for drawing Enemies and Bomber.
     */
    private void setUpSprites() {
        Image[][] spritesEnemy = null;
        // Choosing the enemy sprites on the basis of the difficulty game mode chosen.
        if (((GameController) this.getController()).getDifficulty().equals(Difficulty.STANDARD)) {
            spritesEnemy = AnimatedObjectsSprites.ENEMIES_STANDARD.getSprites();
        } else {
            spritesEnemy = AnimatedObjectsSprites.ENEMIES_HARD.getSprites();
        }
        this.enemySprites = spritesEnemy;
        Image[][] spritesBomber = null;
        Skins color = ((GameController) this.getController()).getPlayerOfTheGame().getSkin();

        // Draw the icon of the Bomber and setUp his sprite.
        if (color.equals(Skins.WHITE)) {
            Platform.runLater(
                    () -> miniBomber.setImage(GameImages.BOMBER1SCOREBOARD.getImage()));
            spritesBomber = AnimatedObjectsSprites.BOMBER_WHITE.getSprites();
        }
        if (color.equals(Skins.BLACK)) {
            Platform.runLater(
                    () -> miniBomber.setImage(GameImages.BOMBER2SCOREBOARD.getImage()));
            spritesBomber = AnimatedObjectsSprites.BOMBER_BLACK.getSprites();
        }

        if (color.equals(Skins.RED)) {
            Platform.runLater(
                    () -> miniBomber.setImage(GameImages.BOMBER3SCOREBOARD.getImage()));
            spritesBomber = AnimatedObjectsSprites.BOMBER_RED.getSprites();
        }

        if (color.equals(Skins.BLUE)) {
            Platform.runLater(
                    () -> miniBomber.setImage(GameImages.BOMBER4SCOREBOARD.getImage()));
            spritesBomber = AnimatedObjectsSprites.BOMBER_BLUE.getSprites();
        }
        this.bomberSprites = spritesBomber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchToRank() {
        SoundsHandler.stopAudio();
        Platform.runLater(() -> ViewsSwitcher.switchView(this.getStage(), ViewType.RANK));
    }

}

package bomberone.views.game;

import java.awt.image.BufferedImage;

import bomberone.controllers.game.GameController;
import bomberone.model.Difficulty;
import bomberone.model.GameModelImpl;
import bomberone.model.bomber.Bomber;
import bomberone.model.gameObjects.PowerUp;
import bomberone.model.user.Skins;
import bomberone.tools.ResourcesLoader;
import bomberone.tools.audio.AudioHandler;
import bomberone.tools.audio.GameAudio;
import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import bomberone.views.basic.ViewImpl;
import bomberone.views.game.img.AnimatedObjectsSprites;
import bomberone.views.game.img.GameImages;
import bomberone.views.game.movement.ControlsMap;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
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

    private BufferedImage[][] bomberSprites;
    private BufferedImage[][] enemySprites;

    /**
     * When the quitButton is pressed, this method stop the Game.
     */
    @FXML
    public void quitClicked() {
        AudioHandler.stopAudio();
        AudioHandler.start(GameAudio.HOME);
        ((GameController) this.getController()).quitGame();
        ViewsSwitcher.switchView(this.getStage(), ViewType.HOME, new GameModelImpl());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        AudioHandler.start(GameAudio.CLASSIC);
        this.scoreLabel.setFont(ResourcesLoader.getFont(FONT_SIZE));
        this.timeLabel.setFont(ResourcesLoader.getFont(FONT_SIZE));
        this.gCBackground = this.canvasBackground.getGraphicsContext2D();
        this.gCForeground = this.canvasForegrounds.getGraphicsContext2D();
        this.getController().init();
        this.setUpSprites();
        this.drawGame();
        this.controlsMap = new ControlsMap(this.getController().getModel().getUser().getControls(),
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
        this.clockImageView.setImage(SwingFXUtils.toFXImage(GameImages.CLOCK.getImage(), null));
        this.drawBomberOnScoreBoard();
        this.drawLifes();
        this.quitButton.setImage(SwingFXUtils.toFXImage(GameImages.QUIT_GAME.getImage(), null));
        /* Draw the background */
        Image backgroundImage = SwingFXUtils.toFXImage(GameImages.BACKGROUND.getImage(), null);
        for (int i = 0; i < WORLD_CELLS; i++) {
            for (int j = 0; j < WORLD_CELLS; j++) {
                gCBackground.drawImage(backgroundImage, i * CELL_SIZE, j * CELL_SIZE);
            }
        }
        /* Draw the spawner */
        double spawnCord = CELL_SIZE * WORLD_CELLS / 2 - CELL_SIZE / 2;
        gCBackground.drawImage(SwingFXUtils.toFXImage(GameImages.SPAWN.getImage(), null), spawnCord, spawnCord);

        /* Draw the Walls */
        Image wallImage = SwingFXUtils.toFXImage(GameImages.HARDWALL.getImage(), null);
        this.getController().getModel().getWorld().getGameObjectCollection().getHardWallList().stream()
                .forEach(wall -> {
                    gCBackground.drawImage(wallImage, wall.getPosition().getX(), wall.getPosition().getY());
                });

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render() {

        this.drawLifes();
        Platform.runLater(() -> this.timeLabel.setText(this.getController().getModel().getTimer().toString()));
        Platform.runLater(() -> this.timeLabel.setText(this.getController().getModel().getTimer().toString()));
        Platform.runLater(() -> this.scoreLabel.setText(this.getController().getModel().getScore() + ""));
        Platform.runLater(() -> this.gCForeground.clearRect(0, 0, WORLD_WIDTH, WORLD_HEIGHT));

        /* Draw the boxes */
        Platform.runLater(() -> {
            Image boxImage = SwingFXUtils.toFXImage(GameImages.BOX.getImage(), null);
            this.getController().getModel().getWorld().getGameObjectCollection().getBoxList().forEach(box -> {
                this.gCForeground.drawImage(boxImage, box.getPosition().getX(), box.getPosition().getY(), IMAGE_SIZE,
                        IMAGE_SIZE);
            });
        });

        /* Draw the powerUp */
        Platform.runLater(() -> {
            this.getController().getModel().getWorld().getGameObjectCollection().getPowerUpList().stream()
                    .filter(PowerUp::isReleased).forEach(pUp -> {
                        BufferedImage powerUpImage = null;
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
                        this.gCForeground.drawImage(SwingFXUtils.toFXImage(powerUpImage, null),
                                pUp.getPosition().getX(), pUp.getPosition().getY());
                    });
        });

        /* Draw bombs */
        Platform.runLater(() -> {
            this.getController().getModel().getWorld().getGameObjectCollection().getBombList().stream()
                    .forEach(bomb -> {
                        if (this.getController().getModel().getWorld().getBomber().getPierce()) {
                            this.gCForeground.drawImage(SwingFXUtils.toFXImage(
                                            AnimatedObjectsSprites.PIERCE_BOMB.getSprites()[0][bomb.getIndexAnimation()], null),
                                    bomb.getPosition().getX(), bomb.getPosition().getY());
                        } else {
                            this.gCForeground.drawImage(SwingFXUtils.toFXImage(
                                    AnimatedObjectsSprites.BOMB.getSprites()[0][bomb.getIndexAnimation()], null),
                                    bomb.getPosition().getX(), bomb.getPosition().getY());
                        }

                    });
        });

        /* Draw the fire */
        Platform.runLater(() -> {
            this.getController().getModel().getWorld().getGameObjectCollection().getFireList().forEach(fire -> {
                this.gCForeground
                        .drawImage(
                                SwingFXUtils.toFXImage(
                                        AnimatedObjectsSprites.FIRE.getSprites()[0][fire.getIndexAnimation()], null),
                                fire.getPosition().getX(), fire.getPosition().getY());
            });
        });

        /* Draw enemies */
        Platform.runLater(() -> {
            this.getController().getModel().getWorld().getGameObjectCollection().getEnemyList().stream()
                    .forEach(enemy -> {
                        this.gCForeground.drawImage(
                                SwingFXUtils.toFXImage(
                                        this.enemySprites[enemy.getSpriteIndex()][enemy.getAnimationIndex()], null),
                                enemy.getPosition().getX(), enemy.getPosition().getY() - ANIMATED_ENTITY_IMAGE_HEIGHT,
                                ENEMY_WIDTH, ENEMY_HEIGHT);
                    });
        });

        /* Draw the BomberMan */
        Bomber bomberTemp = this.getController().getModel().getWorld().getBomber();
        Platform.runLater(() -> this.gCForeground.drawImage(
                SwingFXUtils.toFXImage(this.bomberSprites[bomberTemp.getSpriteIndex()][bomberTemp.getAnimationIndex()],
                        null),
                bomberTemp.getPosition().getX(), bomberTemp.getPosition().getY() - ANIMATED_ENTITY_IMAGE_HEIGHT));

    }

    /**
     * Load the corrected Icon of the Bomber based on the skin choised by the user.
     */
    private void drawBomberOnScoreBoard() {
        Skins color = this.getController().getModel().getUser().getSkin();
        // Draw the icon of the Bomber
        if (color.equals(Skins.WHITE)) {
            Platform.runLater(
                    () -> miniBomber.setImage(SwingFXUtils.toFXImage(GameImages.BOMBER1SCOREBOARD.getImage(), null)));
        }
        if (color.equals(Skins.BLACK)) {
            Platform.runLater(
                    () -> miniBomber.setImage(SwingFXUtils.toFXImage(GameImages.BOMBER2SCOREBOARD.getImage(), null)));
        }

        if (color.equals(Skins.RED)) {
            Platform.runLater(
                    () -> miniBomber.setImage(SwingFXUtils.toFXImage(GameImages.BOMBER3SCOREBOARD.getImage(), null)));
        }

        if (color.equals(Skins.BLUE)) {
            Platform.runLater(
                    () -> miniBomber.setImage(SwingFXUtils.toFXImage(GameImages.BOMBER4SCOREBOARD.getImage(), null)));
        }
    }

    /**
     * Draw the hearts depending on the number of Bomber's Lifes.
     */
    private void drawLifes() {
        int nLifes = this.getController().getModel().getWorld().getBomber().getLifes();
        Image lifeYes = SwingFXUtils.toFXImage(GameImages.LIFE_YES.getImage(), null);
        Image lifeNo = SwingFXUtils.toFXImage(GameImages.LIFE_NO.getImage(), null);
        Platform.runLater(() -> this.lifeThree.setImage((nLifes >= N_LIFES_THREE) ? lifeYes : lifeNo));
        Platform.runLater(() -> this.lifeTwo.setImage((nLifes >= N_LIFES_TWO) ? lifeYes : lifeNo));
        Platform.runLater(() -> this.lifeOne.setImage((nLifes >= N_LIFES_ONE) ? lifeYes : lifeNo));
    }

    private void setUpSprites() {
        BufferedImage[][] spritesEnemy = null;
        // Choosing the enemy sprites on the basis of the difficulty game mode chosen.
        if (this.getController().getModel().getDifficulty().equals(Difficulty.STANDARD)) {
            spritesEnemy = AnimatedObjectsSprites.ENEMIES_STANDARD.getSprites();
        } else {
            spritesEnemy = AnimatedObjectsSprites.ENEMIES_HARD.getSprites();
        }
        this.enemySprites = spritesEnemy;
        BufferedImage[][] spritesBomber = null;
        if (this.getController().getModel().getUser().getSkin().equals(Skins.WHITE)) {
            spritesBomber = AnimatedObjectsSprites.BOMBER_WHITE.getSprites();
        }
        if (this.getController().getModel().getUser().getSkin().equals(Skins.BLACK)) {
            spritesBomber = AnimatedObjectsSprites.BOMBER_BLACK.getSprites();
        }
        if (this.getController().getModel().getUser().getSkin().equals(Skins.RED)) {
            spritesBomber = AnimatedObjectsSprites.BOMBER_RED.getSprites();
        }
        if (this.getController().getModel().getUser().getSkin().equals(Skins.BLUE)) {
            spritesBomber = AnimatedObjectsSprites.BOMBER_BLUE.getSprites();
        }
        this.bomberSprites = spritesBomber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchToRank() {
        AudioHandler.stopAudio();
        ViewsSwitcher.switchView(this.getStage(), ViewType.RANK, this.getController().getModel());
    }

}

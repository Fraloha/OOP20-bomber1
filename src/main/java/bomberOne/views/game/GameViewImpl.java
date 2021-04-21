package bomberOne.views.game;

import bomberOne.model.bomber.Bomber;
import bomberOne.model.enemy.EnemyImpl;
import bomberOne.model.gameObjects.HardWall;
import bomberOne.model.gameObjects.PowerUpImpl;
import bomberOne.model.user.Skins;
import bomberOne.tools.img.ObjectsImages;
import bomberOne.views.ViewImpl;
import bomberOne.views.ViewType;
import bomberOne.views.ViewsSwitcher;
import bomberOne.views.game.movement.ControlsMap;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public final class GameViewImpl extends ViewImpl implements GameView {

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

    private GraphicsContext gCForeground;
    private GraphicsContext gCBackground;
    private ControlsMap controlsMap;

    @Override
    public void init() {
        this.gCBackground = this.canvasBackground.getGraphicsContext2D();
        this.gCForeground = this.canvasForegrounds.getGraphicsContext2D();
        this.drawGame();
        this.getController().init();
        this.controlsMap = new ControlsMap(this.getController().getModel().getUser().getControls(), this);
        this.getStage().getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                if (controlsMap.getControlMap().keySet().contains(e.getCode().getCode())) {
                    controlsMap.getControlMap().get(e.getCode().getCode()).run();
                    getController().getModel().getWorld().getBomber().setStatic(false);
                }
            }
        });

        this.getStage().getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                if (controlsMap.getControlMap().keySet().contains(e.getCode().getCode())) {
                    getController().getModel().getWorld().getBomber().setStatic(true);
                }
            }
        });
    }

    @Override
    public void drawGame() {
        this.clockImageView.setImage(SwingFXUtils.toFXImage(ObjectsImages.CLOCK.getImage(), null));
        this.drawBomberOnScoreBoard();
//        this.drawLifes();

        // Draw the background
        for (int i = 0; i < WORLD_CELLS; i++) {
            for (int j = 0; j < WORLD_CELLS; j++) {
                gCBackground.drawImage(SwingFXUtils.toFXImage(ObjectsImages.BACKGROUND.getImage(), null), i * CELL_SIZE,
                        j * CELL_SIZE);
            }
        }
        // Draw the spawner
        double spawnCord = CELL_SIZE * WORLD_CELLS / 2 - CELL_SIZE / 2;
        gCBackground.drawImage(SwingFXUtils.toFXImage(ObjectsImages.SPAWN.getImage(), null), spawnCord, spawnCord);

        // Draw the Walls
        this.getController().getModel().getWorld().getGameObjectCollection().getHardWallList().stream()
                .forEach(wall -> {
                    gCBackground.drawImage(SwingFXUtils.toFXImage(wall.getImage(), null), wall.getPosition().getX(),
                            wall.getPosition().getY());
                });

    }

    @Override
    public void render() {
        Platform.runLater(() -> this.timeLabel.setText(this.getController().getModel().getTimer().toString()));
        Platform.runLater(() -> this.timeLabel.setText(this.getController().getModel().getTimer().toString()));
        Platform.runLater(() -> this.scoreLabel.setText(this.getController().getModel().getScore() + ""));
        Platform.runLater(() -> this.gCForeground.clearRect(0, 0, WORLD_WIDTH, WORLD_HEIGHT));
        /* Draw the BomberMan */
        Bomber bomberTemp = this.getController().getModel().getWorld().getBomber();
        Platform.runLater(() -> this.gCForeground.drawImage(SwingFXUtils.toFXImage(bomberTemp.getImage(), null),
                bomberTemp.getPosition().getX(), bomberTemp.getPosition().getY() - ANIMATED_ENTITY_IMAGE_HEIGHT));
        /* Draw all the updateable Objects but not enemies */
        Platform.runLater(
                () -> this.getController().getModel().getWorld().getGameObjectCollection().getGameObjectCollection()
                        .stream().filter(elem -> !elem.getClass().equals(HardWall.class)).forEach(obj -> {
                            if (obj.getClass().equals(EnemyImpl.class)) {
                                this.gCForeground.drawImage(SwingFXUtils.toFXImage(obj.getImage(), null),
                                        obj.getPosition().getX(),
                                        obj.getPosition().getY() - ANIMATED_ENTITY_IMAGE_HEIGHT);
                            }
                            if (obj.getClass().equals(PowerUpImpl.class)) {
                                if (((PowerUpImpl) obj).isReleased()) {
                                    this.gCForeground.drawImage(SwingFXUtils.toFXImage(obj.getImage(), null),
                                            obj.getPosition().getX(), obj.getPosition().getY());
                                }
                            } else {
                                this.gCForeground.drawImage(SwingFXUtils.toFXImage(obj.getImage(), null),
                                        obj.getPosition().getX(), obj.getPosition().getY());
                            }
                        }));

    }

    /**
     * Load the corrected Icon of the Bomber based on the skin choised by the user.
     */
    private void drawBomberOnScoreBoard() {
        Skins color = this.getController().getModel().getUser().getSkin();
        // Draw the icon of the Bomber
        if (color.equals(Skins.WHITE)) {
            miniBomber.setImage(SwingFXUtils.toFXImage(ObjectsImages.BOMBER1SCOREBOARD.getImage(), null));
        }
        if (color.equals(Skins.BLACK)) {
            miniBomber.setImage(SwingFXUtils.toFXImage(ObjectsImages.BOMBER2SCOREBOARD.getImage(), null));
        }

        if (color.equals(Skins.RED)) {
            miniBomber.setImage(SwingFXUtils.toFXImage(ObjectsImages.BOMBER3SCOREBOARD.getImage(), null));
        }

        if (color.equals(Skins.BLUE)) {
            miniBomber.setImage(SwingFXUtils.toFXImage(ObjectsImages.BOMBER4SCOREBOARD.getImage(), null));
        }
    }

    /**
     * Draw the hearts depending on the number of Bomber's Lifes.
     */
    private void drawLifes() {
        int nLifes = this.getController().getModel().getWorld().getBomber().getLifes();
        switch (nLifes) {
        case 3:
            this.lifeOne.setImage(SwingFXUtils.toFXImage(ObjectsImages.LIFE_YES.getImage(), null));
            this.lifeTwo.setImage(SwingFXUtils.toFXImage(ObjectsImages.LIFE_YES.getImage(), null));
            this.lifeThree.setImage(SwingFXUtils.toFXImage(ObjectsImages.LIFE_YES.getImage(), null));
            break;
        case 2:
            this.lifeOne.setImage(SwingFXUtils.toFXImage(ObjectsImages.LIFE_YES.getImage(), null));
            this.lifeTwo.setImage(SwingFXUtils.toFXImage(ObjectsImages.LIFE_YES.getImage(), null));
            this.lifeThree.setImage(SwingFXUtils.toFXImage(ObjectsImages.LIFE_NO.getImage(), null));
            break;
        case 1:
            this.lifeOne.setImage(SwingFXUtils.toFXImage(ObjectsImages.LIFE_YES.getImage(), null));
            this.lifeTwo.setImage(SwingFXUtils.toFXImage(ObjectsImages.LIFE_NO.getImage(), null));
            this.lifeThree.setImage(SwingFXUtils.toFXImage(ObjectsImages.LIFE_NO.getImage(), null));
            break;
        case 0:
            this.lifeOne.setImage(SwingFXUtils.toFXImage(ObjectsImages.LIFE_NO.getImage(), null));
            this.lifeTwo.setImage(SwingFXUtils.toFXImage(ObjectsImages.LIFE_NO.getImage(), null));
            this.lifeThree.setImage(SwingFXUtils.toFXImage(ObjectsImages.LIFE_NO.getImage(), null));
            break;
        default:
            break;
        }

    }

    @Override
    public void switchToRank() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.RANK, this.getController().getModel());
    }

}

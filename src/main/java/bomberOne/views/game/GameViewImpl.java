package bomberOne.views.game;

import bomberOne.model.Skins;
import bomberOne.model.gameObjects.HardWall;
import bomberOne.tools.img.ImagesObj;
import bomberOne.views.ViewImpl;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class GameViewImpl extends ViewImpl implements GameView{

	private static int WORLD_CELLS = 18;
	private static int CELL_SIZE = 32;
	private static int WORLD_WIDTH = 576;
	private static int WORLD_HEIGHT = 576;
	
	@FXML
	Label timeLabel;
	
	@FXML
	Label scoreLabel;
	
	@FXML
	Canvas canvasBackground;
	
	@FXML
	Canvas canvasForegrounds;
	
	@FXML
	ImageView miniBomber;

	GraphicsContext gCForeground;

	@Override
	public void drawGame() {
		Skins color = this.getController().getModel().getUser().getSkin();
		GraphicsContext gCBackground = this.canvasBackground.getGraphicsContext2D();
		
		if(color.equals(Skins.WHITE)) {
			miniBomber.setImage(SwingFXUtils.toFXImage(ImagesObj.BOMBER1SCOREBOARD.getImage(), null));
		}
		
		if(color.equals(Skins.BLACK)) {
			miniBomber.setImage(SwingFXUtils.toFXImage(ImagesObj.BOMBER2SCOREBOARD.getImage(), null));
		}
		
		if(color.equals(Skins.RED)) {
			miniBomber.setImage(SwingFXUtils.toFXImage(ImagesObj.BOMBER3SCOREBOARD.getImage(), null));
		}
		
		if(color.equals(Skins.BLUE)) {
			miniBomber.setImage(SwingFXUtils.toFXImage(ImagesObj.BOMBER4SCOREBOARD.getImage(), null));
		}
		
		//Draw the background
		for(int i = 0; i < WORLD_CELLS; i++) {
			for(int j = 0; j < WORLD_CELLS; j++) {
				gCBackground.drawImage(SwingFXUtils.toFXImage(ImagesObj.BACKGROUND.getImage(), null), i * CELL_SIZE, j * CELL_SIZE);
			}
		}
		
		//Draw the Walls
		this.getController().getModel().getWorld().getGameObjectCollection().getHardWallList()
			.stream()
			.forEach(wall -> {
				gCBackground.drawImage(SwingFXUtils.toFXImage(ImagesObj.HARDWALL.getImage(), null), wall.getPosition().getX(), wall.getPosition().getY());
			});
		
	}

	@Override
	public void render() {
		this.timeLabel.setText(this.getController().getModel().getTime().getTime().toString());
		this.scoreLabel.setText(this.getController().getModel().getScore() + "");
		this.gCForeground.clearRect(0, 0, WORLD_WIDTH, WORLD_HEIGHT);
		this.getController().getModel().getWorld().getGameObjectCollection().getGameObjectCollection()
			.stream()
			.filter(elem -> !elem.getClass().equals(HardWall.class))
			.forEach(obj -> gCForeground.drawImage(SwingFXUtils.toFXImage(obj.getImage(), null), obj.getPosition().getX(), obj.getPosition().getY()));
		
		
	}

	@Override
	public void init() {
		this.drawGame();
		this.getController().init();
		this.gCForeground = this.canvasForegrounds.getGraphicsContext2D();
	}


	
	
}

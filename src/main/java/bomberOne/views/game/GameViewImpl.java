package bomberOne.views.game;

import java.awt.event.KeyEvent;

import bomberOne.controllers.game.GameController;
import bomberOne.model.Skins;
import bomberOne.model.gameObjects.HardWall;
import bomberOne.model.input.movement.MoveDown;
import bomberOne.model.input.movement.MoveLeft;
import bomberOne.model.input.movement.MoveRight;
import bomberOne.model.input.movement.MoveUp;
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

	private GraphicsContext gCForeground;
	private GraphicsContext gCBackground;
	
	@Override
	public void drawGame() {
		this.drawBomberOnScoreBoard();
		this.drawLifes();
		
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

	public void keyPressed(KeyEvent e) {
     	if (e.getKeyCode() == 38){
     		 ((GameController) this.getController()).getCommandListener().addCommand(new MoveUp());
     	} else if (e.getKeyCode() == 40){
     		 ((GameController) this.getController()).getCommandListener().addCommand(new MoveDown());  	     
     	} else if (e.getKeyCode() == 39){
     		 ((GameController) this.getController()).getCommandListener().addCommand(new MoveLeft());    	     		
     	} else if (e.getKeyCode() == 37){	 
     		((GameController) this.getController()).getCommandListener().addCommand(new MoveRight());
     	}
     }
	
	@Override
	public void init() {
		this.drawGame();
		this.getController().init();
		this.gCBackground = this.canvasBackground.getGraphicsContext2D();
		this.gCForeground = this.canvasForegrounds.getGraphicsContext2D();
	}

	/**
	 * Load the corrected Icon of the Bomber based on the skin choised by the user
	 */
	private void drawBomberOnScoreBoard() {
		Skins color = this.getController().getModel().getUser().getSkin();
		//Draw the icon of the Bomber
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
	}
	
	/**
	 * Draw the hearts depending on the number of Bomber's Lifes
	 */
	private void drawLifes() {
		int nLifes = this.getController().getModel().getWorld().getBomber().getLifes();
		switch(nLifes) {
		case 3:		
			this.lifeOne.setImage(SwingFXUtils.toFXImage(ImagesObj.LIFE_YES.getImage(), null));
			this.lifeTwo.setImage(SwingFXUtils.toFXImage(ImagesObj.LIFE_YES.getImage(), null));
			this.lifeThree.setImage(SwingFXUtils.toFXImage(ImagesObj.LIFE_YES.getImage(), null));
			break;
		case 2:
			this.lifeOne.setImage(SwingFXUtils.toFXImage(ImagesObj.LIFE_YES.getImage(), null));
			this.lifeTwo.setImage(SwingFXUtils.toFXImage(ImagesObj.LIFE_YES.getImage(), null));
			this.lifeThree.setImage(SwingFXUtils.toFXImage(ImagesObj.LIFE_NO.getImage(), null));
			break;
		case 1:
			this.lifeOne.setImage(SwingFXUtils.toFXImage(ImagesObj.LIFE_YES.getImage(), null));
			this.lifeTwo.setImage(SwingFXUtils.toFXImage(ImagesObj.LIFE_NO.getImage(), null));
			this.lifeThree.setImage(SwingFXUtils.toFXImage(ImagesObj.LIFE_NO.getImage(), null));
			break;
		case 0:
			this.lifeOne.setImage(SwingFXUtils.toFXImage(ImagesObj.LIFE_NO.getImage(), null));
			this.lifeTwo.setImage(SwingFXUtils.toFXImage(ImagesObj.LIFE_NO.getImage(), null));
			this.lifeThree.setImage(SwingFXUtils.toFXImage(ImagesObj.LIFE_NO.getImage(), null));
			break;
		}
		
	}

	
	
}

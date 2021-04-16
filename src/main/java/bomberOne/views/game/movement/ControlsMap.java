package bomberOne.views.game.movement;

import java.util.HashMap;
import java.util.Map;

import bomberOne.controllers.game.GameController;
import bomberOne.model.input.PlantBomb;
import bomberOne.model.input.movement.MoveDown;
import bomberOne.model.input.movement.MoveLeft;
import bomberOne.model.input.movement.MoveRight;
import bomberOne.model.input.movement.MoveUp;
import bomberOne.model.user.Controls;
import bomberOne.views.View;

/**
 * A map that attach for each Key (key-code of the keyPressed/released) an action to perform
 * @author Luigi
 *
 */
public class ControlsMap {

	private static final int KEY_D = 68;
	private static final int KEY_A = 65;
	private static final int KEY_S = 83;
	private static final int KEY_W = 87;
	private static final int KEY_ARROW_RIGHT = 37;
	private static final int KEY_ARROW_LEFT = 39;
	private static final int KEY_ARROW_DOWN = 40;
	private static final int KEY_ARROW_UP = 38;
	private static final int KEY_SPACE_BAR = 32;
	
	
	private Map<Integer, Runnable> controlMap;
	private View view;
	
	public ControlsMap(Controls type, View view) {
		this.controlMap = new HashMap<>();
		this.view = view;
		if(type.equals(Controls.ARROW)) {
			this.initArrowsControls();
		}
		else {
			this.initWasdControls();
		}
		this.controlMap.put(KEY_SPACE_BAR, () ->  ((GameController) this.view.getController()).getCommandListener().addCommand(new PlantBomb()));
	}
	
	/**
	 * Initialize the map if the User chose the "Arrow" Controls
	 */
	private void initArrowsControls() {
		this.controlMap.put(KEY_ARROW_UP, () ->  ((GameController) this.view.getController()).getCommandListener().addCommand(new MoveUp()));
		this.controlMap.put(KEY_ARROW_DOWN, () -> ((GameController) this.view.getController()).getCommandListener().addCommand(new MoveDown()));
		this.controlMap.put(KEY_ARROW_LEFT, () -> ((GameController) this.view.getController()).getCommandListener().addCommand(new MoveLeft()));
		this.controlMap.put(KEY_ARROW_RIGHT, () -> ((GameController) this.view.getController()).getCommandListener().addCommand(new MoveRight()));
	}
	
	/**
	 * Initialize the map if the User chose the "Wasd" Controls
	 */
	private void initWasdControls() {
		this.controlMap.put(KEY_W, () ->  ((GameController) this.view.getController()).getCommandListener().addCommand(new MoveUp()));
		this.controlMap.put(KEY_S, () -> ((GameController) this.view.getController()).getCommandListener().addCommand(new MoveDown()));
		this.controlMap.put(KEY_A, () -> ((GameController) this.view.getController()).getCommandListener().addCommand(new MoveLeft()));
		this.controlMap.put(KEY_D, () -> ((GameController) this.view.getController()).getCommandListener().addCommand(new MoveRight()));
	}
	
	public Map<Integer, Runnable> getControlMap(){
		return this.controlMap;
	}
}

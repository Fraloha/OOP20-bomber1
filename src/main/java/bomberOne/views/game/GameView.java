package bomberOne.views.game;

import bomberOne.views.View;

public interface GameView extends View {

	/**
	 * Prepare the world with the walls and the background
	 */
	public void drawGame();
	
	/**
	 * Render the view every Frame
	 */
	public void render();
}

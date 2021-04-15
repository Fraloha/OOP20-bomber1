package bomberone.views.game;

import bomberone.views.View;

public interface GameView extends View {

	/**
	 * Prepare the world with the walls and the background
	 */
	public void drawGame();
	
	/**
	 * Render the view every Frame
	 */
	public void render();
	
	/**
	 * When the Game ends, it switch the View to the RankView
	 */
	public void switchToRank();
}

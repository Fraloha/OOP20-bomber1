package bomberOne.views;

public enum ViewType {

	HOME,
	SETUP,
	GAME,
	RANK;
	
	/**
	 * Style files path
	 */
	private static final String DIRECTORY = "viewStyle/";
	private static final String FORMAT = ".fxml";
	
	private String path;
	
	
	public String getPath() {
		ViewType.GAME.path = DIRECTORY + "gameView" + FORMAT; 
		ViewType.SETUP.path = DIRECTORY + "setUpView" + FORMAT; 
		return this.path;
	}
	
}

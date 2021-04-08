package bomberOne.views;

import java.io.File;

public enum ViewType {

	HOME("HomeView"),
	SETUP("SetUpView"),
	GAME("GameView"),
	RANK("RankView");
	
	/**
	 * Style files path
	 */
	private static final String DIRECTORY = "viewsStyle" + File.separator;
	private static final String FORMAT = ".fxml";
	
	private String fileName;


	private ViewType(String string) {
		this.fileName = string;
	}


	public String getPath() {
		return DIRECTORY + this.fileName + FORMAT;
	}
	
}

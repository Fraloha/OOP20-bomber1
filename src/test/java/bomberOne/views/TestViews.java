package bomberOne.views;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestViews {

	private static final String DIRECTORY = "viewStyle/";
	private static final String FORMAT = ".fxml";
	
	@Test
	public void testViewsPath() {	
		assertEquals(DIRECTORY + "gameView" + FORMAT, ViewType.GAME.getPath());
	}
}

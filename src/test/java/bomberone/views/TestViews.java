package bomberone.views;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;


public class TestViews {

    private static final String DIRECTORY = "viewsStyle" + File.separator;
    private static final String FORMAT = ".fxml";

    /**
     * Test if VIEWTYPE enum .getPath() returns the correct Path of FXML file.
     */
    @Test
    public void testViewsPath() {
        assertEquals(DIRECTORY + "GameView" + FORMAT, ViewType.MATCH.getPath());
    }
}

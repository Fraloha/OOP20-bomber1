package bomberOne.views.rank;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import bomberOne.tools.RankLoader;
import bomberOne.model.user.UserImpl;
import java.util.LinkedList;

public final class RankView extends Application {
    
        /* Fields. */
        private LinkedList<UserImpl> playersRankStandardMode;
        private LinkedList<UserImpl> playersRankHardMode;
        
        @FXML
        TableView<UserImpl> tableView;
        
	@Override
	public void start(Stage primaryStage) {
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private void onExitClickButton() {
	    
	}
}
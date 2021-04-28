package bomberOne.views.rank;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import bomberOne.tools.RankLoader;
import bomberOne.model.user.UserImpl;
import bomberOne.views.BasicExitAlertBox;
import bomberOne.views.basic.ViewImpl;

import java.util.LinkedList;

public final class RankView extends ViewImpl {

    /* Fields. */
    private LinkedList<UserImpl> playersRankStandardMode;
    private LinkedList<UserImpl> playersRankHardMode;

    @FXML
    private TableView<UserImpl> tableView;

    @FXML
    private VBox vBoxImages;

    @FXML
    private ImageView imageViewRankTitle;

    @FXML
    private ImageView imageViewDifficulty;

    @FXML
    private HBox hBoxOptions;

    @FXML
    private Button hBoxButtonPrevious;

    @FXML
    private Button hBoxButtonExit;

    @FXML
    private Button hBoxButtonMainMenu;

    @FXML
    Button hBoxButtonNext;

    @Override
    public void init() {

    }
    
    private void onClickExitButton() {
        //Asking if the user is sure about the window closing.
        if (new BasicExitAlertBox().display()) {
            this.getStage().close();
        }
    }
}
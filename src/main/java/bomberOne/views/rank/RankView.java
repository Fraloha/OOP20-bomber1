package bomberOne.views.rank;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import bomberOne.tools.RankLoader;
import bomberOne.views.rank.UserDataModel;
import bomberOne.views.BasicExitAlertBox;
import bomberOne.views.basic.ViewImpl;
import javafx.scene.image.Image;

public final class RankView extends ViewImpl {

    /* Fields. */
    private int currentRank;
    
    private Image rankDifficultyImages[] = new Image[3];
    
    private ObservableList<UserDataModel> ranks [] = new ObservableList[3];

    @FXML
    private TableView<UserDataModel> tableView;

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
    private Button hBoxButtonNext;

    @Override
    public void init() {
        
    }
    
    private void LoadImages() {
        this.rankDifficultyImages[0] = new Image("..\\..\\..\\resources\\images\\RankViewImages\\EasyModeImage.png");
        this.rankDifficultyImages[1] = new Image("..\\..\\..\\resources\\images\\RankViewImages\\HardModeImage.png");
    }
}
package bomberOne.views.rank;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import bomberOne.tools.RankLoader;
import bomberOne.views.rank.UserDataModel;
import bomberOne.views.BasicExitAlertBox;
import bomberOne.views.basic.ViewImpl;
import javafx.scene.image.Image;

public final class RankView extends ViewImpl {

    /* Fields. */
    private static final int RANKS = 2;
    
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
    
    private void loadImages() {
        this.rankDifficultyImages[0] = new Image("..\\..\\..\\resources\\images\\RankViewImages\\EasyModeImage.png");
        this.rankDifficultyImages[1] = new Image("..\\..\\..\\resources\\images\\RankViewImages\\HardModeImage.png");
    }
    
    private void onClickChangeRank(boolean next) {
        //Checking if the user wants to watch the next rank or the previous.
        this.currentRank = (next ? this.currentRank++ : this.currentRank--) % RankView.RANKS;
        
        //Setting the right image and rank.
        this.imageViewDifficulty.setImage(this.rankDifficultyImages[this.currentRank]);
        this.tableView.setItems(this.ranks[this.currentRank]);
    }
}
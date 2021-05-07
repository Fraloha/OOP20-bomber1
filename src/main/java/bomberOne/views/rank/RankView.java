package bomberOne.views.rank;

import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import bomberOne.model.common.GameImages;
import bomberOne.tools.RankLoader;
import bomberOne.views.rank.UserDataModel;
import bomberOne.views.basic.ViewImpl;
import bomberOne.views.ViewType;
import bomberOne.views.ViewsSwitcher;
import javafx.scene.image.Image;

public final class RankView extends ViewImpl {

    /* Fields. */
    private static final int RANKS = 2;
    
    private int currentRank;
    
    private Image rankDifficultyImages[];
    
    private ObservableList<UserDataModel> ranks[];

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
        this.rankDifficultyImages[0] = SwingFXUtils.toFXImage(GameImages.EASYMODE.getImage(), null);
        this.rankDifficultyImages[1] = SwingFXUtils.toFXImage(GameImages.HARDMODE.getImage(), null);
    }
    
    private void onClickChangeRank(boolean next) {
        //Checking if the user wants to watch the next rank or the previous.
        this.currentRank = (next ? this.currentRank++ : this.currentRank--) % RankView.RANKS;
        
        //Setting the right image and rank.
        this.imageViewDifficulty.setImage(this.rankDifficultyImages[this.currentRank]);
        this.tableView.setItems(this.ranks[this.currentRank]);
    }
    
    private void onClickBackToMainMenu() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.HOME, this.getController().getModel());
    }
}
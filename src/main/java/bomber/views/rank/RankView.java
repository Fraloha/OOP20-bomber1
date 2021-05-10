package bomber.views.rank;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import bomber.model.common.GameImages;
import bomber.model.user.User;
import bomber.model.user.UserImpl;
import bomber.tools.RankLoader;
import bomber.views.ViewType;
import bomber.views.ViewsSwitcher;
import bomber.views.basic.ViewImpl;
import bomber.views.rank.UserDataModel;
import javafx.scene.image.Image;

/**
 * This class is used to sort the ObservableLists.
 */
final class SortByScore implements Comparator<Integer> {

    public int compare(final Integer firstValue, final Integer secondValue) {
        return firstValue > secondValue ? 1 : -1;
    }
}

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
        // Setting all the button event handlers.
        this.hBoxButtonExit.setOnAction((event) -> {
            this.getStage().close();
        });
        this.hBoxButtonMainMenu.setOnAction((event) -> {
            this.onClickBackToMainMenu();
        });
        this.hBoxButtonNext.setOnAction((event) -> {
            this.onClickChangeRank(true);
        });
        this.hBoxButtonPrevious.setOnAction((event) -> {
            this.onClickChangeRank(false);
        });

        // Setting the TableView to be not editable.
        this.tableView.setEditable(false);

        // Loading all the images that indicates the rank difficulty.
        this.loadImages();

        // Loading the ranks.
        this.loadRanks();

        // Setting the initial rank to show.
        this.currentRank = 0;
        //this.tableView.setItems(this.ranks[currentRank]);
    }

    private void loadImages() {
        this.rankDifficultyImages = new Image[RankView.RANKS];
        this.rankDifficultyImages[0] = SwingFXUtils.toFXImage(GameImages.EASYMODE.getImage(), null);
        this.rankDifficultyImages[1] = SwingFXUtils.toFXImage(GameImages.HARDMODE.getImage(), null);
    }

    private void loadRanks() {
        // Loading the ranks from the files.
        List ranks[] = { RankLoader.getRankStandard(), RankLoader.getRankHard() };
        
        // Converting the UserImpl data into UserDataModel data.
        // This conversion is needed to create some ObservableLists to bind with the
        // TableView.
        for (int i = 0; i < RankView.RANKS; i++) {
            @SuppressWarnings("unchecked")
            ListIterator<UserImpl> rankIterator = ranks[i].listIterator();

            while (rankIterator.hasNext()) {
                UserImpl currentUser = (UserImpl) rankIterator.next();
                this.ranks[i].add(new UserDataModel(currentUser.getName(), currentUser.getScore()));
                rankIterator.next();
            }
        }
    }

    private void onClickChangeRank(boolean next) {
        // Checking if the user wants to watch the next rank or the previous.
        this.currentRank = (next ? this.currentRank++ : this.currentRank--) % RankView.RANKS;

        // Setting the right image and rank.
        this.imageViewDifficulty.setImage(this.rankDifficultyImages[this.currentRank]);
        this.tableView.setItems(this.ranks[this.currentRank]);
    }

    private void onClickBackToMainMenu() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.HOME, this.getController().getModel());
    }
}
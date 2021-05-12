package bomberone.views.rank;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import java.util.ArrayList;
import javafx.util.Callback;
import bomberone.tools.RankLoader;
import bomberone.tools.ResourcesLoader;
import bomberone.views.basic.ViewImpl;
import bomberone.views.game.img.GameImages;
import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import bomberone.model.user.User;
import javafx.scene.image.Image;

/**
 * This is the class that defines the view of the ranks.
 */
public final class RankView extends ViewImpl {

    /* Fields. */
    private static final int RANKS = 2;

    private int currentRank;

    private Image rankDifficultyImages[];

    private ArrayList<SortedList<User>> ranks;

    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<User, String> tableViewPlayers;

    @FXML
    private TableColumn<User, Integer> tableViewScores;

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

        // Initializing the buttons.
        this.setButtonsFonts();
        this.setButtonsEventHandlers();

        // Initializing the TableView.
        this.tableViewInitialization(ResourcesLoader.getFont(20));
        // Loading all the images that indicates the rank difficulty.
        this.loadImages();

        // Loading the ranks.
        this.loadRanks();

        // Setting the initial rank to show.
        this.currentRank = 0;
        // this.tableView.setItems(this.ranks.get(this.currentRank));
    }

    private void setButtonsFonts() {
        Font fontToSet = ResourcesLoader.getFont(20);

        this.hBoxButtonExit.setFont(fontToSet);
        this.hBoxButtonMainMenu.setFont(fontToSet);
        this.hBoxButtonNext.setFont(fontToSet);
        this.hBoxButtonPrevious.setFont(fontToSet);
    }

    /**
     * This method sets all the buttons event handlers.
     */
    private void setButtonsEventHandlers() {
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
    }

    private void tableViewInitialization(Font fontToSet) {

        this.tableView.setEditable(false);
        this.tableViewPlayers.setEditable(false);
        this.tableViewScores.setEditable(false);

        // Setting the font.
        this.tableViewPlayers.setCellFactory(new Callback<TableColumn<User, String>, TableCell<User, String>>() {

            @Override
            public TableCell<User, String> call(TableColumn<User, String> param) {
                return new TableCell<User, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (isEmpty()) {
                            setText("");
                        } else {
                            setFont(fontToSet);
                            setText(item);
                        }
                    }
                };
            }

        });

        this.tableViewScores.setCellFactory(new Callback<TableColumn<User, Integer>, TableCell<User, Integer>>() {

            @Override
            public TableCell<User, Integer> call(TableColumn<User, Integer> param) {
                return new TableCell<User, Integer>() {
                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);

                        if (isEmpty()) {
                            setText("");
                        } else {
                            setFont(fontToSet);
                            setText(item.toString());
                        }
                    }
                };
            }
        });
    }

    /**
     * This method loads all the images that have to be set in the view.
     */
    private void loadImages() {
        this.rankDifficultyImages = new Image[RankView.RANKS];
        this.rankDifficultyImages[0] = SwingFXUtils.toFXImage(GameImages.EASYMODE.getImage(), null);
        this.rankDifficultyImages[1] = SwingFXUtils.toFXImage(GameImages.HARDMODE.getImage(), null);
        this.imageViewRankTitle.setImage(SwingFXUtils.toFXImage(GameImages.RANKVIEWTITLE.getImage(), null));
    }

    private void loadRanks() {
        // Loading the ranks.
        ObservableList<User> standardRank = FXCollections.observableList(RankLoader.getRankStandard());
        ObservableList<User> hardRank = FXCollections.observableList(RankLoader.getRankHard());

        // Creating the sorted ranks.
        this.ranks.add(new SortedList<User>(standardRank));
        this.ranks.add(new SortedList<User>(hardRank));
    }

    private void onClickChangeRank(final boolean next) {
        // Checking if the user wants to watch the next rank or the previous.
        this.currentRank = Math.abs((next ? this.currentRank + 1 : this.currentRank - 1)) % RankView.RANKS;

        // Setting the right image and rank.
        this.imageViewDifficulty.setImage(this.rankDifficultyImages[this.currentRank]);
        this.tableView.setItems(this.ranks.get(this.currentRank));
    }

    private void onClickBackToMainMenu() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.HOME, this.getController().getModel());
    }
}
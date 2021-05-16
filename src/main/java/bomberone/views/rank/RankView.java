package bomberone.views.rank;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.Comparator;
import javafx.util.Callback;
import bomberone.tools.RankLoader;
import bomberone.tools.ResourcesLoader;
import bomberone.tools.audio.GameSounds;
import bomberone.tools.audio.SoundsHandler;
import bomberone.views.basic.ViewImpl;
import bomberone.views.game.img.GameImages;
import bomberone.views.ViewType;
import bomberone.views.ViewsSwitcher;
import bomberone.controllers.rank.RankController;
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
    private BorderPane borderPane;

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
        SoundsHandler.start(GameSounds.HOME);
        // Initializing the buttons.
        this.setButtonsFonts(ResourcesLoader.getFont(20));
        this.setButtonsEventHandlers();

        // Initializing the TableView.
        this.tableViewInitialization(ResourcesLoader.getFont(20));

        // Loading all the images that indicates the rank difficulty.
        this.loadImages();

        // Loading the ranks.
        this.loadRanks();

        // Setting the initial rank to show.
        this.currentRank = 0;
        this.imageViewDifficulty.setImage(this.rankDifficultyImages[this.currentRank]);
        this.tableView.setItems(this.ranks.get(this.currentRank));
    }

    private void setButtonsFonts(Font fontToSet) {
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

    private void tableViewInitialization(final Font fontToSet) {

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
                            setText(Integer.toString(item));
                        }
                    }
                };
            }
        });

        // Binding the columns with the data.
        this.tableViewPlayers.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        this.tableViewScores.setCellValueFactory(new PropertyValueFactory<User, Integer>("score"));

        // Adding a sort policy in the TableView.
        this.tableViewScores.setSortType(SortType.ASCENDING);
        this.tableView.getSortOrder().add(tableViewScores);
        this.tableView.sort();
    }

    /**
     * This method loads all the images that have to be set in the view.
     */
    private void loadImages() {
        this.rankDifficultyImages = new Image[RankView.RANKS];
        this.rankDifficultyImages[0] = GameImages.EASYMODE.getImage();
        this.rankDifficultyImages[1] = GameImages.HARDMODE.getImage();
        this.imageViewRankTitle.setImage(GameImages.RANKVIEWTITLE.getImage());
    }

    private void loadRanks() {
        // Loading the ranks.
        
        ObservableList<User> standardRank = FXCollections.observableList(((RankController) this.getController()).getStdRank());
        ObservableList<User> hardRank = FXCollections.observableList(((RankController) this.getController()).getHardRank());

        // Creating the sorted ranks.
        this.ranks = new ArrayList<SortedList<User>>();
        this.ranks.add(new SortedList<User>(standardRank));
        this.ranks.add(new SortedList<User>(hardRank));

        // Adding the sort comparator to all the lists.
        for (SortedList<User> list : this.ranks) {
            list.setComparator(new Comparator<User>() {
                @Override
                public int compare(final User firstUser, final User secondUser) {
                    return secondUser.getScore() - firstUser.getScore();
                }
            });
        }
    }

    private void onClickChangeRank(final boolean next) {
        // Checking if the user wants to watch the next rank or the previous.
        this.currentRank = Math.abs((next ? this.currentRank + 1 : this.currentRank - 1)) % RankView.RANKS;

        // Setting the right image and rank.
        this.imageViewDifficulty.setImage(this.rankDifficultyImages[this.currentRank]);
        this.tableView.setItems(this.ranks.get(this.currentRank));
    }

    private void onClickBackToMainMenu() {
        ViewsSwitcher.switchView(this.getStage(), ViewType.HOME);
    }
}
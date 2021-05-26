package bomberone.views.rank;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.Comparator;
import javafx.util.Callback;
import bomberone.tools.ResourcesLoader;
import bomberone.tools.audio.GameSounds;
import bomberone.tools.audio.SoundsHandler;
import bomberone.views.common.GameImages;
import bomberone.views.ViewImpl;
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
    private static final int BUTTONS_IMAGES = 2;

    private int currentRank;
    private Image rankDifficultyImages[];
    private Image imagesPrevButtons[];
    private Image imagesNextButtons[];
    private ArrayList<SortedList<User>> ranks;

    @FXML
    private VBox vBoxTable;
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
    private ImageView imageViewPreviousButton;

    @FXML
    private ImageView imageViewHomeButton;

    @FXML
    private ImageView imageViewNextButton;

    @Override
    public void init() {
        SoundsHandler.getInstance().start(GameSounds.HOME);

        // Initializing the buttons.
        this.setButtonImages();
        this.setButtonsEventHandlers();

        // Initializing the TableView.
        this.tableViewInitialization(ResourcesLoader.getInstance().getFont(20));

        // Loading all the images that indicates the rank difficulty.
        this.loadImages();

        // Loading the ranks.
        this.loadRanks();

        // Setting the initial rank to show.
        this.currentRank = 0;
        this.imageViewDifficulty.setImage(this.rankDifficultyImages[this.currentRank]);
        this.tableView.setItems(this.ranks.get(this.currentRank));
    }

    /**
     * This method sets an Image object to an ImageView object, on the basis of a
     * boolean value. If the first parameter is true, the "verified" argument is set
     * as the image of the ImageView object, otherwise the "notVerified" argument is
     * set.
     * 
     * @param set         The boolean value that acts like a condition.
     * @param verified    The Image object that has to be set if the "set" argument
     *                    is true.
     * @param notVerified The Image object that has to be set if the "set argument
     *                    is false.
     * @param imageToSet  The ImageView where the second or third argument has to be
     *                    set.
     */
    private void setButton(boolean set, Image verified, Image notVerified, ImageView imageToSet) {
        Image image = set ? verified : notVerified;
        imageToSet.setImage(image);
    }

    /**
     * This method sets the initial images at the form initialization.
     */
    private void setButtonImages() {
        this.setButton(false, GameImages.PREV_SET.getImage(), GameImages.PREV_UNSET.getImage(),
                this.imageViewPreviousButton);
        this.setButton(false, GameImages.NEXT_SET.getImage(), GameImages.NEXT_UNSET.getImage(),
                this.imageViewNextButton);
        this.imageViewHomeButton.setImage(GameImages.HOME_BUTTON.getImage());
    }

    /**
     * This method sets all the buttons event handlers.
     */
    private void setButtonsEventHandlers() {
        this.imageViewPreviousButton.setOnMouseEntered(e -> {
            setButton(true, this.imagesPrevButtons[0], this.imagesPrevButtons[1], this.imageViewPreviousButton);
        });

        this.imageViewPreviousButton.setOnMouseExited(e -> {
            setButton(false, this.imagesPrevButtons[0], this.imagesPrevButtons[1], this.imageViewPreviousButton);
        });

        this.imageViewNextButton.setOnMouseEntered(e -> {
            setButton(true, this.imagesNextButtons[0], this.imagesNextButtons[1], this.imageViewNextButton);
        });

        this.imageViewNextButton.setOnMouseExited(e -> {
            setButton(false, this.imagesNextButtons[0], this.imagesNextButtons[1], this.imageViewNextButton);
        });
    }

    private void tableViewInitialization(final Font fontToSet) {

        this.tableView.setEditable(false);
        this.tableViewPlayers.setEditable(false);
        this.tableViewScores.setEditable(false);
        this.tableViewPlayers.setSortable(false);
        this.tableViewScores.setSortable(false);

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
        this.imagesPrevButtons = new Image[RankView.BUTTONS_IMAGES];
        this.imagesNextButtons = new Image[RankView.BUTTONS_IMAGES];

        // Loading the images.
        this.rankDifficultyImages[0] = GameImages.EASYMODE.getImage();
        this.rankDifficultyImages[1] = GameImages.HARDMODE.getImage();
        this.imagesPrevButtons[0] = GameImages.PREV_SET.getImage();
        this.imagesPrevButtons[1] = GameImages.PREV_UNSET.getImage();
        this.imagesNextButtons[0] = GameImages.NEXT_SET.getImage();
        this.imagesNextButtons[1] = GameImages.NEXT_UNSET.getImage();

        this.imageViewHomeButton.setImage(GameImages.HOME_BUTTON.getImage());
        this.imageViewRankTitle.setImage(GameImages.RANKVIEWTITLE.getImage());
    }

    private void loadRanks() {
        // Loading the ranks.

        ObservableList<User> standardRank = FXCollections
                .observableList(((RankController) this.getController()).getStdRank());
        ObservableList<User> hardRank = FXCollections
                .observableList(((RankController) this.getController()).getHardRank());

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

    private void changeRank(final boolean next) {
        // Checking if the user wants to watch the next rank or the previous.
        this.currentRank = Math.abs((next ? this.currentRank + 1 : this.currentRank - 1)) % RankView.RANKS;

        // Setting the right image and rank.
        this.imageViewDifficulty.setImage(this.rankDifficultyImages[this.currentRank]);
        this.tableView.setItems(this.ranks.get(this.currentRank));
    }

    public void onBackToMainMenuClicked() {
        ViewsSwitcher.getInstance().switchView(this.getStage(), ViewType.HOME, this.getController().getModel());
    }

    public void onNextClicked() {
        this.changeRank(true);
    }

    public void onPreviousClicked() {
        this.changeRank(false);
    }
}
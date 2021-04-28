package bomberOne.views.rank;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
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
    TableView<UserImpl> tableView;

    @Override
    public void init() {

    }
}
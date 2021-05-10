package bomberone.views.rank;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * This class defines a generic entry contained in the TableView object.
 */

public final class UserDataModel {
    
    /* Fields. */
    private SimpleStringProperty playerName;
    private SimpleIntegerProperty score;
    
    /* Constructor. */
    public UserDataModel(final String newPlayerName, final int newPlayerScore) {
        this.playerName = new SimpleStringProperty(newPlayerName);
        this.score = new SimpleIntegerProperty(newPlayerScore);
    }
    
    /* Methods. */
    public void setPlayerName(final String player) {
        this.playerName = new SimpleStringProperty(player);
    }
    
    public String getPlayerName() {
        return this.playerName.get();
    }
    
    public void setPlayerScore(final int newScore) {
        this.score = new SimpleIntegerProperty(newScore);
    }
    
    public int getPlayerScore() {
        return this.score.get();
    }
}
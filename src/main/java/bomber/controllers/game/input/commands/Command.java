package bomber.controllers.game.input.commands;

import bomber.model.GameModel;
import bomber.model.common.Direction;

public interface Command {

    /**
     * Execute the command on "gameModel".
     * 
     * @param gameModel
     */
    void execute(GameModel gameModel);
    
    Direction dir();
}
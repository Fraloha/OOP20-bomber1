package bomberone.controllers.game.input.commands;

import bomberone.model.GameModel;
import bomberone.model.common.Direction;

public interface Command {

    /**
     * Execute the command on "gameModel".
     * 
     * @param gameModel
     */
    void execute(GameModel gameModel);
    
    Direction dir();
}
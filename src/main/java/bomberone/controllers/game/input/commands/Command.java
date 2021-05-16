package bomberone.controllers.game.input.commands;

import bomberone.model.GameMatch;
import bomberone.model.common.Direction;

public interface Command {

    /**
     * Execute the command on "gameModel".
     * 
     * @param gameModel
     */
    void execute(GameMatch gameModel);
    
    Direction dir();
}
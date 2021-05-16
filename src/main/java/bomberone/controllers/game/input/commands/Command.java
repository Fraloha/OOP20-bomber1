package bomberone.controllers.game.input.commands;

import bomberone.model.common.Direction;
import bomberone.model.match.GameMatch;

public interface Command {

    /**
     * Execute the command on "gameModel".
     * 
     * @param gameModel
     */
    void execute(GameMatch gameModel);
    
    Direction dir();
}
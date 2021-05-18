package bomberone.controllers.match.input.commands;

import bomberone.model.common.Direction;
import bomberone.model.match.GameMatch;

public interface Command {

    /**
     * Execute the command on "gameMatch".
     * 
     * @param gameMatch
     */
    void execute(GameMatch gameMatch);
    
    Direction dir();
}
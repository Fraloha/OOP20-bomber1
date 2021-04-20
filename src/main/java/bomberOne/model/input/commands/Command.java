package bomberOne.model.input.commands;

import bomberOne.model.GameModel;

public interface Command {

    /**
     * Execute the command on "gameModel".
     * 
     * @param gameModel
     */
    void execute(GameModel gameModel);
}
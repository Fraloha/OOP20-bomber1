package bomberone.controllers.game.input;


import bomberone.model.GameMatch;

public interface CommandListener {

    /**
     * Scroll all the commandList and call the method execute() on all the command
     * of the commandList.
     */
    void executeCommands();

    /**
     * Attach the "game" at the GameModel.
     * 
     * @param game
     */
    void setGameModel(GameMatch game);

    /**
     * Method that return the GameModel attached.
     * 
     * @return GameModel
     */
    GameMatch getGameModel();

    /**
     * 
     * @return the PlayerBeaviour
     */
    PlayerBehavior getPlayerBehaviour();
}

package bomberone.controllers.match.input;


import bomberone.model.match.GameMatch;

public interface CommandListener {

    /**
     * Scroll all the commandList and call the method execute() on all the command
     * of the commandList.
     */
    void executeCommands();

    /**
     * Attach the "game" to the GameMatch.
     * 
     * @param game
     */
    void setGameMatch(GameMatch game);

    /**
     * Method that return the GameMatch attached.
     * 
     * @return GameMatch
     */
    GameMatch getGameMatch();

    /**
     * 
     * @return the PlayerBeaviour
     */
    PlayerBehavior getPlayerBehaviour();
}

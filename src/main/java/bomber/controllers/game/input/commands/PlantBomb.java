package bomber.controllers.game.input.commands;

import java.util.Optional;

import bomber.model.GameModel;
import bomber.model.common.Direction;
import bomber.model.gameObjects.Bomb;

public class PlantBomb implements Command {

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final GameModel gameModel) {
        Optional<Bomb> bomb = gameModel.getWorld().getBomber().plantBomb();
        if(!bomb.isEmpty()) {
            gameModel.getWorld().getGameObjectCollection().spawn(bomb.get());
        }
    }

    @Override
    public Direction dir() {
        // TODO Auto-generated method stub
        return null;
    }

}
package bomberOne.model.input.commands;

import java.util.Optional;

import bomberOne.model.GameModel;
import bomberOne.model.common.Direction;
import bomberOne.model.gameObjects.Bomb;

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
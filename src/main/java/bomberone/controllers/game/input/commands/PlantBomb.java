package bomberone.controllers.game.input.commands;

import java.util.Optional;

import bomberone.model.common.Direction;
import bomberone.model.gameObjects.Bomb;
import bomberone.model.match.GameMatch;

public class PlantBomb implements Command {

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final GameMatch gameModel) {
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
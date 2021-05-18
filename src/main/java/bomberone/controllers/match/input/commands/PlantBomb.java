package bomberone.controllers.match.input.commands;

import java.util.Optional;

import bomberone.model.common.Direction;
import bomberone.model.gameObjects.bomb.Bomb;
import bomberone.model.match.GameMatch;

public class PlantBomb implements Command {

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final GameMatch gameMatch) {
        Optional<Bomb> bomb = gameMatch.getWorld().getBomber().plantBomb();
        if(!bomb.isEmpty()) {
            gameMatch.getWorld().getGameObjectCollection().spawn(bomb.get());
        }
    }

    @Override
    public Direction dir() {
        // TODO Auto-generated method stub
        return null;
    }

}
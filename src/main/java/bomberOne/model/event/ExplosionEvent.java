package bomberOne.model.event;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import bomberOne.model.GameModel;
import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.Explosion;

/**
 * When a bomb explode, it generates an ExplosionEvent.
 * 
 *
 */
public class ExplosionEvent implements WorldEvent {

    private static final int OBJ_DIMETIONS = 32;
    private Explosion explosion;

    public ExplosionEvent(final Explosion exp) {
        this.explosion = exp;
    }

    /**
     * 
     * @return the Explosion
     */
    public Explosion getExplosion() {
        return this.explosion;
    }

    /**
     * Handle & Resize the explosion and Spawn the Fire on the Map.
     * 
     * 
     */
    @Override
    public void process(final GameModel model) {
        Explosion exp = this.explosion;
        model.getWorld().getGameObjectCollection()
                .spawn(model.getWorld().getGameObjectFactory().createFire(exp.getCenter()));
        List<P2d> wallsListPos = new ArrayList<>();
        List<P2d> boxListPos = new ArrayList<>();
        boxListPos.addAll(model.getWorld().getGameObjectCollection().getBoxList().stream().map(e -> e.getPosition())
                .collect(Collectors.toList()));
        wallsListPos.addAll(model.getWorld().getGameObjectCollection().getHardWallList().stream()
                .map(e -> e.getPosition()).collect(Collectors.toList()));

        // Left Direction
        for (int i = 1; i <= exp.getFirePower(); i++) {
            P2d newPos = new P2d(exp.getCenter().getX() - (OBJ_DIMETIONS * i), exp.getCenter().getY());
            // The fire cannot be spawned over the Walls, but it can be spawner over the
            // other Objects
            if (!wallsListPos.contains(newPos)) {
                model.getWorld().getGameObjectCollection()
                        .spawn(model.getWorld().getGameObjectFactory().createFire(newPos));
            } else {
                break;
            }
            if (boxListPos.contains(newPos) && !exp.getPierce()) {
                break;
            }
        }

        // Right Direction
        for (int i = 1; i <= exp.getFirePower(); i++) {
            P2d newPos = new P2d(exp.getCenter().getX() + (OBJ_DIMETIONS * i), exp.getCenter().getY());
            // The fire cannot be spawned over the Walls, but it can be spawner over the
            // other Objects
            if (!wallsListPos.contains(newPos)) {
                model.getWorld().getGameObjectCollection()
                        .spawn(model.getWorld().getGameObjectFactory().createFire(newPos));
            } else {
                break;
            }
            if (boxListPos.contains(newPos) && !exp.getPierce()) {
                break;
            }
        }

        // Up Directions
        for (int i = 1; i <= exp.getFirePower(); i++) {
            P2d newPos = new P2d(exp.getCenter().getX(), exp.getCenter().getY() - (OBJ_DIMETIONS * i));
            // The fire cannot be spawned over the Walls, but it can be spawner over the
            // other Objects
            if (!wallsListPos.contains(newPos)) {
                model.getWorld().getGameObjectCollection()
                        .spawn(model.getWorld().getGameObjectFactory().createFire(newPos));
            } else {
                break;
            }
            if (boxListPos.contains(newPos) && !exp.getPierce()) {
                break;
            }
        }

        // Down Directions
        for (int i = 1; i <= exp.getFirePower(); i++) {
            P2d newPos = new P2d(exp.getCenter().getX(), exp.getCenter().getY() + (OBJ_DIMETIONS * i));
            // The fire cannot be spawned over the Walls, but it can be spawner over the
            // other Objects
            if (!wallsListPos.contains(newPos)) {
                model.getWorld().getGameObjectCollection()
                        .spawn(model.getWorld().getGameObjectFactory().createFire(newPos));
            } else {
                break;
            }
            if (boxListPos.contains(newPos) && !exp.getPierce()) {
                break;
            }
        }
        model.getWorld().getBomber().restoreAmmo();
    }

}

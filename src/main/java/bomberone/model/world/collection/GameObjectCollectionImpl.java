package bomberone.model.world.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import bomberone.model.enemy.Enemy;
import bomberone.model.enemy.EnemyImpl;
import bomberone.model.gameObjects.GameObject;
import bomberone.model.gameObjects.bomb.Bomb;
import bomberone.model.gameObjects.bomb.BombImpl;
import bomberone.model.gameObjects.bomb.Explosion;
import bomberone.model.gameObjects.bomb.ExplosionImpl;
import bomberone.model.gameObjects.box.Box;
import bomberone.model.gameObjects.box.BoxImpl;
import bomberone.model.gameObjects.fire.Fire;
import bomberone.model.gameObjects.fire.FireImpl;
import bomberone.model.gameObjects.hardwall.HardWall;
import bomberone.model.gameObjects.powerUp.PowerUp;
import bomberone.model.gameObjects.powerUp.PowerUpImpl;

public class GameObjectCollectionImpl implements GameObjectCollection {

    private List<GameObject> gameObjectList;

    public GameObjectCollectionImpl() {
        this.gameObjectList = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<GameObject> getGameObjectCollection() {
        return this.gameObjectList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<Bomb> getBombList() {
        List<Bomb> bombList = new ArrayList<>();
        this.gameObjectList.stream().filter(p -> p != null).filter(p -> p.getClass().equals(BombImpl.class)).forEach(e -> {
            bombList.add((Bomb) e);
        });
        return bombList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<Explosion> getExplosionList() {
        List<Explosion> explosionList = new ArrayList<>();
        this.gameObjectList.stream().filter(p -> p != null).filter(p -> p.getClass().equals(ExplosionImpl.class)).forEach(e -> {
            explosionList.add((Explosion) e);
        });
        return explosionList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<Box> getBoxList() {
        List<Box> boxList = new ArrayList<>();
        this.gameObjectList.stream().filter(p -> p != null).filter(p -> p.getClass().equals(BoxImpl.class)).forEach(e -> {
            boxList.add((Box) e);
        });
        return boxList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<HardWall> getHardWallList() {
        List<HardWall> hardWallList = new ArrayList<>();
        this.gameObjectList.stream().filter(p -> p != null).filter(p -> p.getClass().equals(HardWall.class)).forEach(e -> {
            hardWallList.add((HardWall) e);
        });
        return hardWallList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<PowerUp> getPowerUpList() {
        List<PowerUp> powerUpList = new ArrayList<>();
        this.gameObjectList.stream().filter(p -> p != null).filter(p -> p.getClass().equals(PowerUpImpl.class)).forEach(e -> {
            powerUpList.add((PowerUp) e);
        });
        return powerUpList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<Enemy> getEnemyList() {
        List<Enemy> enemyList = new ArrayList<>();
        this.gameObjectList.stream().filter(p -> p != null).filter(p -> p.getClass().equals(EnemyImpl.class)).forEach(e -> {
            enemyList.add((Enemy) e);
        });
        return enemyList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<Fire> getFireList() {
        List<Fire> fireList = new ArrayList<>();
        this.gameObjectList.stream().filter(p -> p != null).filter(p -> p.getClass().equals(FireImpl.class)).forEach(e -> {
            fireList.add((Fire) e);
        });
        return fireList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void spawn(final GameObject obj) {
        this.gameObjectList.add(obj);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void despawn(final GameObject obj) {
        this.gameObjectList.remove(obj);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<GameObject> getDespawnedObject() {
        return this.gameObjectList.stream()
                .filter(e -> !e.isAlive()).collect(Collectors.toList());
    }

}

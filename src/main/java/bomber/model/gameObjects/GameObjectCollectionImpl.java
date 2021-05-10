package bomber.model.gameObjects;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import bomber.model.enemy.Enemy;
import bomber.model.enemy.EnemyImpl;

public class GameObjectCollectionImpl implements GameObjectCollection {

    private List<GameObject> gameObjectList;

    public GameObjectCollectionImpl() {
        this.gameObjectList = new LinkedList<>();
    }

    @Override
    public final List<GameObject> getGameObjectCollection() {
        return gameObjectList;
    }

    @Override
    public final List<Bomb> getBombList() {
        List<Bomb> bombList = new LinkedList<>();
        gameObjectList.stream().filter(p -> p.getClass().equals(BombImpl.class)).forEach(e -> {
            bombList.add((Bomb) e);
        });
        return bombList;
    }

    @Override
    public final List<Explosion> getExplosionList() {
        List<Explosion> explosionList = new LinkedList<>();
        gameObjectList.stream().filter(p -> p.getClass().equals(ExplosionImpl.class)).forEach(e -> {
            explosionList.add((Explosion) e);
        });
        return explosionList;
    }

    @Override
    public final List<Box> getBoxList() {
        List<Box> boxList = new LinkedList<>();
        gameObjectList.stream().filter(p -> p.getClass().equals(BoxImpl.class)).forEach(e -> {
            boxList.add((Box) e);
        });
        return boxList;
    }

    @Override
    public final List<HardWall> getHardWallList() {
        List<HardWall> hardWallList = new LinkedList<>();
        gameObjectList.stream().filter(p -> p.getClass().equals(HardWall.class)).forEach(e -> {
            hardWallList.add((HardWall) e);
        });
        return hardWallList;
    }

    @Override
    public final List<PowerUp> getPowerUpList() {
        List<PowerUp> powerUpList = new LinkedList<>();
        gameObjectList.stream().filter(p -> p.getClass().equals(PowerUpImpl.class)).forEach(e -> {
            powerUpList.add((PowerUp) e);
        });
        return powerUpList;
    }

    @Override
    public final List<Enemy> getEnemyList() {
        List<Enemy> enemyList = new LinkedList<>();
        gameObjectList.stream().filter(p -> p.getClass().equals(EnemyImpl.class)).forEach(e -> {
            enemyList.add((Enemy) e);
        });
        return enemyList;
    }

    @Override
    public final List<Fire> getFireList() {
        List<Fire> fireList = new LinkedList<>();
        gameObjectList.stream().filter(p -> p.getClass().equals(FireImpl.class)).forEach(e -> {
            fireList.add((Fire) e);
        });
        return fireList;
    }

    @Override
    public final void spawn(final GameObject obj) {
        gameObjectList.add(obj);
    }

    @Override
    public final void despawn(final GameObject obj) {
        gameObjectList.remove(obj);
    }

    @Override
    public final List<GameObject> getDespawnedObject() {
        return this.gameObjectList.stream()
                .filter(e -> !e.isAlive()).collect(Collectors.toList());
    }

}

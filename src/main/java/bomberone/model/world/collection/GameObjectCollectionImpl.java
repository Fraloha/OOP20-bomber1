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

    @Override
    public final List<GameObject> getGameObjectCollection() {
        return gameObjectList;
    }

    @Override
    public final List<Bomb> getBombList() {
        List<Bomb> bombList = new ArrayList<>();
        gameObjectList.stream().filter(p -> p.getClass().equals(BombImpl.class)).forEach(e -> {
            bombList.add((Bomb) e);
        });
        return bombList;
    }

    @Override
    public final List<Explosion> getExplosionList() {
        List<Explosion> explosionList = new ArrayList<>();
        gameObjectList.stream().filter(p -> p.getClass().equals(ExplosionImpl.class)).forEach(e -> {
            explosionList.add((Explosion) e);
        });
        return explosionList;
    }

    @Override
    public final List<Box> getBoxList() {
        List<Box> boxList = new ArrayList<>();
        gameObjectList.stream().filter(p -> p.getClass().equals(BoxImpl.class)).forEach(e -> {
            boxList.add((Box) e);
        });
        return boxList;
    }

    @Override
    public final List<HardWall> getHardWallList() {
        List<HardWall> hardWallList = new ArrayList<>();
        gameObjectList.stream().filter(p -> p.getClass().equals(HardWall.class)).forEach(e -> {
            hardWallList.add((HardWall) e);
        });
        return hardWallList;
    }

    @Override
    public final List<PowerUp> getPowerUpList() {
        List<PowerUp> powerUpList = new ArrayList<>();
        gameObjectList.stream().filter(p -> p.getClass().equals(PowerUpImpl.class)).forEach(e -> {
            powerUpList.add((PowerUp) e);
        });
        return powerUpList;
    }

    @Override
    public final List<Enemy> getEnemyList() {
        List<Enemy> enemyList = new ArrayList<>();
        gameObjectList.stream().filter(p -> p.getClass().equals(EnemyImpl.class)).forEach(e -> {
            enemyList.add((Enemy) e);
        });
        return enemyList;
    }

    @Override
    public final List<Fire> getFireList() {
        List<Fire> fireList = new ArrayList<>();
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

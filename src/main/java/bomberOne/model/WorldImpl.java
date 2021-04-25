package bomberOne.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import bomberOne.model.bomber.BomberImpl;
import bomberOne.model.common.P2d;
import bomberOne.model.enemy.Enemy;
import bomberOne.model.event.ExplosionEvent;
import bomberOne.model.event.HitBorderEvent;
import bomberOne.model.event.HitEntityEvent;
import bomberOne.model.event.PickPowerUpEvent;
import bomberOne.model.event.WorldEventListener;
import bomberOne.model.factory.GameObjectFactory;
import bomberOne.model.factory.GameObjectFactoryImpl;
import bomberOne.model.gameObjects.Bomb;
import bomberOne.model.gameObjects.Box;
import bomberOne.model.gameObjects.Fire;
import bomberOne.model.gameObjects.GameObject;
import bomberOne.model.gameObjects.GameObjectCollection;
import bomberOne.model.gameObjects.GameObjectCollectionImpl;
import bomberOne.model.gameObjects.PowerUp;
import bomberOne.model.user.Difficulty;
import bomberOne.model.user.Skins;
import bomberOne.tools.maps.Maps;

public class WorldImpl implements World {

    private static final int ENEMYNUMBER = 3;
    private static final int DIMENSION = 18;
    private static final int FRAME = 32;
    private static final int NORMALBOX = 80;
    // private static final int HARDBOX = 100;
    private static final int NUMTYPEPOWERUP = 5;

    private GameObjectCollection collection = new GameObjectCollectionImpl();
    private GameObjectFactory objectFactory = new GameObjectFactoryImpl();
    private WorldEventListener listener;
    private BomberImpl bomberMan;
    private boolean respawn;
    private Difficulty difficulty;
    private List<List<String>> mapLayout;
    private GameModel model;

    public WorldImpl(final Difficulty difficulty, final Skins skin) {
        this.difficulty = difficulty;
        if (difficulty.equals(Difficulty.STANDARD)) {
            this.respawn = false;
        } else {
            this.respawn = true;
        }
        this.bomberMan = (BomberImpl) objectFactory.createBomber(new P2d(32, 32), skin);
        this.mapLayout = Maps.MAP1.getList();
        this.setHardWall();
        this.setBox(this.difficulty);
    }

    public void setModel(final GameModel model) {
        this.model = model;
    }

    /**
     * This method creates all HardWall in the World.
     */
    private void setHardWall() {
        for (int y = 0; y < WorldImpl.DIMENSION; y++) {
            for (int x = 0; x < WorldImpl.DIMENSION; x++) {
                if (mapLayout.get(y).get(x).equals("H")) {
                    collection.spawn(objectFactory.createHardWall(new P2d(x * WorldImpl.FRAME, y * WorldImpl.FRAME)));
                }
            }
        }
    }

    /**
     * This method creates all HardWall in the World.
     */
    private void setBox(final Difficulty difficulty) {
        int powerUpCount = 0;
        int boxCount = 0;
        List<P2d> objectList = this.collection.getGameObjectCollection().stream().map(e -> e.getPosition())
                .collect(Collectors.toList());
        objectList.add(this.bomberMan.getPosition());
        int center = (WorldImpl.DIMENSION / 2) - 1;
        for (int i = center; i <= (WorldImpl.DIMENSION / 2) + 1; i++) {
            for (int j = center; j <= (WorldImpl.DIMENSION / 2) + 1; j++) {
                objectList.add(new P2d(i * WorldImpl.FRAME, j * WorldImpl.FRAME));
            }
        }
        objectList.add(
                new P2d(this.bomberMan.getPosition().getX() + WorldImpl.FRAME, this.bomberMan.getPosition().getY()));
        objectList.add(
                new P2d(this.bomberMan.getPosition().getX(), this.bomberMan.getPosition().getY() + WorldImpl.FRAME));
        Random rand = new Random();
        while (boxCount < WorldImpl.NORMALBOX) {
            int col = rand.nextInt(WorldImpl.DIMENSION);
            int line = rand.nextInt(WorldImpl.DIMENSION);
            P2d pos = new P2d(line * WorldImpl.FRAME, col * WorldImpl.FRAME);
            if (!objectList.contains(pos)) {
                objectList.add(pos);
                Box box = (Box) this.objectFactory.createBox(pos);
                if (boxCount % 4 == 0) {
                    PowerUp powerUp;
                    switch (powerUpCount % WorldImpl.NUMTYPEPOWERUP) {
                    case 0:
                        powerUp = (PowerUp) this.objectFactory.createPowerUp(pos, PowerUp.Type.FirePower);
                        break;
                    case 1:
                        powerUp = (PowerUp) this.objectFactory.createPowerUp(pos, PowerUp.Type.Speed);
                        break;
                    case 2:
                        powerUp = (PowerUp) this.objectFactory.createPowerUp(pos, PowerUp.Type.Pierce);
                        break;
                    case 3:
                        powerUp = (PowerUp) this.objectFactory.createPowerUp(pos, PowerUp.Type.FirePower);
                        break;
                    default:
                        powerUp = (PowerUp) this.objectFactory.createPowerUp(pos, PowerUp.Type.Ammo);
                        break;
                    }
                    powerUpCount++;
                    box.addPowerUp(powerUp);
                    this.collection.spawn(powerUp);
                }
                this.collection.spawn(box);
                boxCount++;
            }
        }
    }

    @Override
    public final boolean getRespawn() {
        return this.respawn;
    }

    @Override
    public final GameObjectCollection getGameObjectCollection() {
        return collection;
    }

    @Override
    public final GameObjectFactory getGameObjectFactory() {
        return objectFactory;
    }

    @Override
    public final void setEventListener(final WorldEventListener event) {
        this.listener = event;
    }

    @Override
    public final BomberImpl getBomber() {
        return this.bomberMan;
    }

    @Override
    public final void updateState(final int time) {
        this.bomberMan.update(time);
        for (GameObject obj : collection.getGameObjectCollection()) {
            obj.update(time);
        }
        List<GameObject> deathObject = collection.getGameObjectCollection().stream().filter(p -> !p.isAlive())
                .collect(Collectors.toList());
        for (Enemy enemy : collection.getEnemyList()) {
            enemy.update(this.bomberMan.getPosition());
        }
        this.checkExplosion();
        for (GameObject obj : deathObject) {
            collection.despawn(obj);
        }
        this.checkCollision();
        this.checkRespawn();
        this.checkBoundary();
    }

    @Override
    public final void checkCollision() {
        List<Fire> fireList = collection.getFireList();
        List<GameObject> list = new LinkedList<>();
        list.add(bomberMan);
        list.addAll(collection.getBoxList());
        list.addAll(collection.getEnemyList());
        for (GameObject obj : list) {
            for (Fire fire : fireList) {
                if (fire.getBoundingBox().intersects(obj.getBoundingBox())) {
                    this.listener.notifyEvent(new HitEntityEvent(obj));
                }
            }
        }
        List<PowerUp> powerUpList = collection.getPowerUpList().stream().filter(p -> p.isReleased())
                .collect(Collectors.toList());
        for (PowerUp power : powerUpList) {
            if (power.getBoundingBox().intersects(bomberMan.getBoundingBox())) {
                this.listener.notifyEvent(new PickPowerUpEvent(power));
            }
        }
        /* Check if enemy hit Bomberman */
        this.collection.getEnemyList().stream().forEach(enemy -> {
            if (enemy.getBoundingBox().intersects(this.bomberMan.getBoundingBox())) {
                this.listener.notifyEvent(new HitEntityEvent(this.bomberMan));
            }
        });
    }

    @Override
    public final void checkRespawn() {
        if (collection.getBoxList().size() == 0) {
            this.respawn = false;
        }
        if (this.respawn) {
            if (collection.getEnemyList().size() != WorldImpl.ENEMYNUMBER) {
                collection.spawn(objectFactory.createEnemy(new P2d((WorldImpl.DIMENSION / 2) * WorldImpl.FRAME,
                        (WorldImpl.DIMENSION / 2) * WorldImpl.FRAME), this.difficulty));
            }
        }
    }

    @Override
    public final void checkBoundary() {
        List<Enemy> enemyList = collection.getEnemyList();
        List<GameObject> wallBoxList = new LinkedList<>();
        wallBoxList.addAll(collection.getHardWallList());
        wallBoxList.addAll(collection.getBoxList());
        for (GameObject wall : wallBoxList) {
            if (wall.getBoundingBox().intersects(this.bomberMan.getBoundingBox())) {
                listener.notifyEvent(new HitBorderEvent(this.bomberMan, wall));
            }
        }
        for (Enemy enemy : enemyList) {
            for (GameObject wall : wallBoxList) {
                if (wall.getBoundingBox().intersects(enemy.getBoundingBox())) {
                    listener.notifyEvent(new HitBorderEvent(enemy, wall));
                }
            }
        }
    }

    @Override
    public final void checkExplosion() {
        List<Bomb> bombList = collection.getBombList();
        for (Bomb bomb : bombList) {
            if (!bomb.getExplosion().equals(Optional.empty())) {
                listener.notifyEvent(new ExplosionEvent(bomb.getExplosion().get()));
            }
        }
    }

}

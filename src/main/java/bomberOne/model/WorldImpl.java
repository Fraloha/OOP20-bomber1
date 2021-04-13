package bomberOne.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import bomberOne.model.bomber.BomberImpl;
import bomberOne.model.common.P2d;
import bomberOne.model.enemy.Enemy;
import bomberOne.model.event.ExplosionEvent;
import bomberOne.model.event.HitBorderEvent;
import bomberOne.model.event.HitFireEvent;
import bomberOne.model.event.PickPowerUpEvent;
import bomberOne.model.event.WorldEventListener;
import bomberOne.model.event.WorldEventListenerImpl;
import bomberOne.model.factory.GameObjectFactory;
import bomberOne.model.factory.GameObjectFactoryImpl;
import bomberOne.model.gameObjects.Bomb;
import bomberOne.model.gameObjects.Fire;
import bomberOne.model.gameObjects.GameObject;
import bomberOne.model.gameObjects.GameObjectCollection;
import bomberOne.model.gameObjects.GameObjectCollectionImpl;
import bomberOne.model.gameObjects.PowerUp;
import bomberOne.model.user.Difficulty;
import bomberOne.model.user.Skins;


public class WorldImpl implements World {

	private static int ENEMYNUMBER = 3;
	private static int DIMENSION = 18;
	private static int FRAME = 32;
	
	private GameObjectCollection collection = new GameObjectCollectionImpl();
	private GameObjectFactory objectFactory = new GameObjectFactoryImpl();
	private WorldEventListener listener = new WorldEventListenerImpl();
	private BomberImpl bomberMan;
	private boolean respawn;
	private Difficulty difficulty;
		
	public WorldImpl(Difficulty difficulty, Skins skin) {
		this.difficulty=difficulty;
		if(difficulty.equals(Difficulty.STANDARD)) {
			this.respawn=false;
		} else {
			this.respawn=true;
		}
		this.bomberMan = (BomberImpl) objectFactory.createBomber(new P2d(32,32), skin);
		//TODO Riempire il World
		this.setHardWall();
		this.setBox();
	}
	
	/**
	 * This method create all HardWall and Box in the World
	 */
	private void setHardWall() {
		//Edge of the map
		for(int i=0; i<WorldImpl.DIMENSION;i++) {
			this.createHardWall(new P2d(i*WorldImpl.FRAME,0));
			this.createHardWall(new P2d(i*WorldImpl.FRAME,(WorldImpl.DIMENSION-1)*WorldImpl.FRAME));
			if(i!=0 && i!=18) {
				this.createHardWall(new P2d(0,i*WorldImpl.FRAME));
				this.createHardWall(new P2d((WorldImpl.DIMENSION-1)*WorldImpl.FRAME,i*WorldImpl.FRAME));
			}
		}
		
		//Line 2,15
		int i=2;
		while(i!=0) {
			this.createHardWall(new P2d(i*WorldImpl.FRAME,2*WorldImpl.FRAME));
			this.createHardWall(new P2d(i*WorldImpl.FRAME,3*WorldImpl.FRAME));
			this.createHardWall(new P2d(i*WorldImpl.FRAME,5*WorldImpl.FRAME));
			this.createHardWall(new P2d(i*WorldImpl.FRAME,7*WorldImpl.FRAME));
			this.createHardWall(new P2d(i*WorldImpl.FRAME,10*WorldImpl.FRAME));
			this.createHardWall(new P2d(i*WorldImpl.FRAME,12*WorldImpl.FRAME));
			this.createHardWall(new P2d(i*WorldImpl.FRAME,14*WorldImpl.FRAME));
			this.createHardWall(new P2d(i*WorldImpl.FRAME,15*WorldImpl.FRAME));
			if(i==2) {
				i=15;
			} else {
				i=0;
			}
		}
		
		//Line 3,5,7,10,12,14
		i=3;
		while(i!=0) {
			this.createHardWall(new P2d(i*WorldImpl.FRAME,2*WorldImpl.FRAME));
			this.createHardWall(new P2d(i*WorldImpl.FRAME,15*WorldImpl.FRAME));
			switch(i) {
				case 3:
					i=5;
					break;
				case 5:
					i=7;
					break;
				case 7:
					i=10;
					break;
				case 10:
					i=12;
					break;
				case 12:
					i=14;
					break;
				case 14:
					i=0;
					break;
			}
		}
		
		//Line 4,6,11,13
		i=4;
		while(i!=0) {
			this.createHardWall(new P2d(i*WorldImpl.FRAME,4*WorldImpl.FRAME));
			this.createHardWall(new P2d(i*WorldImpl.FRAME,6*WorldImpl.FRAME));
			this.createHardWall(new P2d(i*WorldImpl.FRAME,11*WorldImpl.FRAME));
			this.createHardWall(new P2d(i*WorldImpl.FRAME,13*WorldImpl.FRAME));
			switch(i) {
			case 4:
				i=6;
				break;
			case 6:
				i=11;
				break;
			case 11:
				i=13;
				break;
			case 13:
				i=0;
				break;
			}
		}
		
		//The center of the map
		this.createHardWall(new P2d(6*WorldImpl.FRAME, 8*WorldImpl.FRAME));
		this.createHardWall(new P2d(6*WorldImpl.FRAME, 9*WorldImpl.FRAME));
		this.createHardWall(new P2d(8*WorldImpl.FRAME, 6*WorldImpl.FRAME));
		this.createHardWall(new P2d(8*WorldImpl.FRAME, 11*WorldImpl.FRAME));
		this.createHardWall(new P2d(9*WorldImpl.FRAME, 6*WorldImpl.FRAME));
		this.createHardWall(new P2d(9*WorldImpl.FRAME, 11*WorldImpl.FRAME));
		this.createHardWall(new P2d(11*WorldImpl.FRAME, 8*WorldImpl.FRAME));
		this.createHardWall(new P2d(11*WorldImpl.FRAME, 9*WorldImpl.FRAME));
	}

	private void createHardWall(P2d pos) {
		this.collection.spawn(this.objectFactory.createHardWall(pos));
	}
	
	private void setBox() {
		
	}
	
	@Override
	public boolean getRespawn() {
		// TODO Auto-generated method stub
		return this.respawn;
	}

	@Override
	public GameObjectCollection getGameObjectCollection() {
		// TODO Auto-generated method stub
		return collection;
	}

	@Override
	public GameObjectFactory getGameObjectFactory() {
		// TODO Auto-generated method stub
		return objectFactory;
	}

	@Override
	public void setEventListener(WorldEventListener event) {
		// TODO Auto-generated method stub
		this.listener=event;
	}

	@Override
	public BomberImpl getBomber() {
		// TODO Auto-generated method stub
		return this.bomberMan;
	}

	@Override
	public void updateState(int time) {
		// TODO Auto-generated method stub
		this.bomberMan.update(time);
		for(GameObject obj : collection.getGameObjectCollection()) {
			obj.update(time);
		}
		List<GameObject> deathObject = collection.getGameObjectCollection().stream()
				.filter(p -> p.isAlive() == false).collect(Collectors.toList());
		for(GameObject obj : deathObject) {
			collection.despawn(obj);
		}
	}

	@Override
	public void checkCollision() {
		// TODO Auto-generated method stub
		List<Fire> fireList = collection.getFireList();
		List<GameObject> list = new LinkedList<>();
		list.add(bomberMan);
		list.addAll(collection.getBoxList());
		list.addAll(collection.getEnemyList());
		for(GameObject obj : list) {
			for(Fire fire : fireList) {
				if(fire.getBoundingBox().isCollidingWith(obj.getBoundingBox())) {
					this.listener.notifyEvent(new HitFireEvent(obj));
				}
			}
		}
		List<PowerUp> powerUpList = collection.getPowerUpList().stream()
				.filter(p -> p.isReleased() == true).collect(Collectors.toList());
		for(PowerUp power : powerUpList) {
			if(power.getBoundingBox().isCollidingWith(bomberMan.getBoundingBox())) {
				this.listener.notifyEvent(new PickPowerUpEvent(power));
			}
		}
	}

	@Override
	public void checkRespawn() {
		// TODO Auto-generated method stub
		if(collection.getBoxList().size() == 0) {
				this.respawn=false;
		}
		if(this.respawn) {
			if(collection.getEnemyList().size() != WorldImpl.ENEMYNUMBER) {
				collection.spawn(objectFactory.createEnemy(new P2d(32,32), this.difficulty)); //da mettere in mezzo alla mappa
			}
		}
	}

	@Override
	public void checkBoundary() {
		// TODO Auto-generated method stub
		List<Enemy> enemyList = collection.getEnemyList();
		List<GameObject> wallBoxList = new LinkedList<>();
		wallBoxList.addAll(collection.getHardWallList());
		wallBoxList.addAll(collection.getBoxList());
		for(GameObject wall : wallBoxList) {
			if(wall.getBoundingBox().isCollidingWith(this.bomberMan.getBoundingBox())) {
				listener.notifyEvent(new HitBorderEvent(this.bomberMan, wall));
			}
		}
		for(Enemy enemy : enemyList) {
			for(GameObject wall : wallBoxList) {
				if(wall.getBoundingBox().isCollidingWith(enemy.getBoundingBox())) {
					listener.notifyEvent(new HitBorderEvent(enemy, wall));
				}
			}
		}
	}

	@Override
	public void checkExplosion() {
		// TODO Auto-generated method stub
		List<Bomb> bombList= collection.getBombList();
		for(Bomb bomb : bombList) {
			if(!bomb.getExplosion().equals(Optional.empty())) {
				listener.notifyEvent(new ExplosionEvent(bomb.getExplosion().get()));
			}
		}
	}

}

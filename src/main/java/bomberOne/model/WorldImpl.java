package bomberOne.model;

import bomberOne.model.bomber.Bomber;
import bomberOne.model.common.P2d;
import bomberOne.model.event.WorldEventListener;
import bomberOne.model.event.WorldEventListenerImpl;
import bomberOne.model.factory.GameObjectFactory;
import bomberOne.model.factory.GameObjectFactoryImpl;
import bomberOne.model.gameObjects.GameObject;
import bomberOne.model.gameObjects.GameObjectCollection;
import bomberOne.model.gameObjects.GameObjectCollectionImpl;
import bomberOne.tools.img.SpriteMapsObj;

public class WorldImpl implements World {

	private GameObjectCollection collection = new GameObjectCollectionImpl();
	private GameObjectFactory objectFactory = new GameObjectFactoryImpl();
	private WorldEventListener listener = new WorldEventListenerImpl();
	private Bomber bomberMan = new Bomber(new P2d(1,1), SpriteMapsObj.PLAYER_1.getImage(), 3, true);
	boolean respawn;
		
	public WorldImpl(boolean respawn) {
		this.respawn = respawn;
		//TODO Riempire il World
	}

	@Override
	public boolean getRespawn() {
		// TODO Auto-generated method stub
		return respawn;
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
	public Bomber getBomber() {
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
	}

	@Override
	public void checkCollision() {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkRespawn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkBoundary() {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkExplosion() {
		// TODO Auto-generated method stub

	}

}
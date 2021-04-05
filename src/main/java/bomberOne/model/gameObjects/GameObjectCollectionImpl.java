package bomberOne.model.gameObjects;

import java.util.LinkedList;
import java.util.List;
import bomberOne.model.enemy.Enemy;

public class GameObjectCollectionImpl implements GameObjectCollection {

	private List<GameObject> gameObjectList;
	
	public GameObjectCollectionImpl() {
		this.gameObjectList = new LinkedList<>();
	}

	@Override
	public List<GameObject> getGameObjectCollection() {
		return gameObjectList;
	}

	@Override
	public List<Bomb> getBombList() {
		List<Bomb> bombList = new LinkedList<>();
		gameObjectList.stream()
			.filter(p -> p.getClass().equals(BombImpl.class)).forEach(e -> {
				bombList.add((Bomb) e);
			});
		return bombList;
	}

	@Override
	public List<Explosion> getExplosionList() {
		List<Explosion> explosionList = new LinkedList<>();
		gameObjectList.stream()
			.filter(p -> p.getClass().equals(ExplosionImpl.class)).forEach(e -> {
				explosionList.add((Explosion) e);
			});
		return explosionList;
	}

	@Override
	public List<Box> getBoxList() {
		List<Box> boxList = new LinkedList<>();
		gameObjectList.stream().filter(p -> p.getClass().equals(BoxImpl.class)).forEach(e -> {
				boxList.add((Box) e);
			});
		return boxList;
	}

	@Override
	public List<HardWall> getHardWallList() {
		List<HardWall> hardWallList = new LinkedList<>();
		gameObjectList.stream()
			.filter(p -> p.getClass().equals(HardWall.class)).forEach(e -> {
				hardWallList.add((HardWall) e);
			});
		return hardWallList;
	}

	@Override
	public List<PowerUp> getPowerUpList() {
		List<PowerUp> powerUpList = new LinkedList<>();
		gameObjectList.stream()
			.filter(p -> p.getClass().equals(PowerUpImpl.class)).forEach(e -> {
				powerUpList.add((PowerUp) e);
			});
		return powerUpList;
	}
	
	@Override
	public List<Enemy> getEnemyList() {
		List<Enemy> enemyList = new LinkedList<>();
		gameObjectList.stream()
			.filter(p -> p.getClass().equals(Enemy.class)).forEach(e -> {
				enemyList.add((Enemy) e);
			});
		return enemyList;
	}
	
	@Override
	public List<Fire> getFireList() {
		List<Fire> fireList = new LinkedList<>();
		gameObjectList.stream()
			.filter(p -> p.getClass().equals(FireImpl.class)).forEach(e -> {
				fireList.add((Fire) e);
			});
		return fireList;
	}
	
	@Override
	public void spawn(GameObject obj) {
		gameObjectList.add(obj);
	}

	@Override
	public void despawn(GameObject obj) {
		gameObjectList.remove(obj);
	}

	
}

package bomberOne.model.event;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import bomberOne.model.GameModel;
import bomberOne.model.common.Direction;
import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.Explosion;

public class WorldEventListenerImpl implements WorldEventListener {

	private static final int OBJ_DIMETIONS = 32;
	private static final int WORLD_SIZE = 16;
	
	private GameModel model;
	private List<WorldEvent> eventList = new ArrayList<>();
	
	@Override
	public void notifyEvent(WorldEvent event) {
		this.eventList.add(event);
	}

	@Override
	public List<WorldEvent> getEventList() {
		return this.eventList;
	}

	@Override
	public void processEvents() {
		this.eventList.stream().forEach(event -> {
			if (event.getClass().equals(PickPowerUpEvent.class)){
				this.processPickPowerUpEvent((PickPowerUpEvent) event);
			}
			if (event.getClass().equals(HitFireEvent.class)){
				this.processHitFireEvent((HitFireEvent) event);
			}
			if (event.getClass().equals(HitBorderEvent.class)){
				this.processHitBorderEvent((HitBorderEvent) event);
			}
			if (event.getClass().equals(ExplosionEvent.class)){
				this.processExplosionEvent((ExplosionEvent) event);
			}
		});
		this.eventList.clear();
	}

	@Override
	public void setGameModel(GameModel game) {
		this.model = game;
	}

	@Override
	public GameModel getGameModel() {
		return this.model;
	}

	/*
	 * When the Bomber picks the PowerUp, this method applies the PowerUp to the Bomber
	 */
	private void processPickPowerUpEvent(PickPowerUpEvent event) {
		this.model.getWorld().getBomber().applyPowerUp(event.getPowerUp().getType());
		event.getPowerUp().hitted();
	}
	
	/**
	 * When an GameObject is Colliding with the fire, it calls "hitted()" on the Object
	 * @param event
	 */
	private void processHitFireEvent(HitFireEvent event) {
		event.getEntity().hitted();
	}
	
	/**
	 * Repositioning of the AniatedEntity that is colliding with the Wall/Box
	 * @param event
	 */
	private void processHitBorderEvent(HitBorderEvent event) {
		if(event.getEntity().getDir().equals(Direction.UP)){
			event.getEntity().setPosition(new P2d(event.getEntity().getPosition().getX(), event.getWall().getPosition().getY() + OBJ_DIMETIONS));
		}
		if(event.getEntity().getDir().equals(Direction.DOWN)){
			event.getEntity().setPosition(new P2d(event.getEntity().getPosition().getX(), event.getWall().getPosition().getY() - OBJ_DIMETIONS));
		}
		
		if(event.getEntity().getDir().equals(Direction.LEFT)){
			event.getEntity().setPosition(new P2d(event.getWall().getPosition().getX() + OBJ_DIMETIONS, event.getEntity().getPosition().getY()));
		}
		if(event.getEntity().getDir().equals(Direction.RIGHT)){
			event.getEntity().setPosition(new P2d(event.getWall().getPosition().getX() - OBJ_DIMETIONS, event.getEntity().getPosition().getY()));
		}
	}
	
	/**
	 * Handle the explosion and Spawn the Fire on the Map
	 * @param event
	 */
	private void processExplosionEvent(ExplosionEvent event) {
		Explosion exp = event.getExplosion();
		this.model.getWorld().getGameObjectFactory().createFire(exp.getCenter());
		List<P2d> wallsList = new ArrayList<>();
		wallsList.addAll(this.model.getWorld().getGameObjectCollection().getBoxList().stream().map(e -> e.getPosition()).collect(Collectors.toList()));
		wallsList.addAll(this.model.getWorld().getGameObjectCollection().getHardWallList().stream().map(e -> e.getPosition()).collect(Collectors.toList()));
		
		//Pierced
		if(exp.getPierce()) {
			for(int i = 1; i < exp.getFirePower(); i++) {
				if(exp.getCenter().getX() - OBJ_DIMETIONS * i >= OBJ_DIMETIONS * 1) {
					this.model.getWorld().getGameObjectCollection().spawn(this.model.getWorld().getGameObjectFactory().createFire(new P2d(exp.getCenter().getX() - OBJ_DIMETIONS * i, exp.getCenter().getY())));					
				}
				if(exp.getCenter().getX() + OBJ_DIMETIONS * i <= WORLD_SIZE * OBJ_DIMETIONS) {
					this.model.getWorld().getGameObjectCollection().spawn(this.model.getWorld().getGameObjectFactory().createFire(new P2d(exp.getCenter().getX() + OBJ_DIMETIONS * i, exp.getCenter().getY())));					
				}
				if(exp.getCenter().getY() - OBJ_DIMETIONS * i >= OBJ_DIMETIONS * 1) {
					this.model.getWorld().getGameObjectCollection().spawn(this.model.getWorld().getGameObjectFactory().createFire(new P2d(exp.getCenter().getX(), exp.getCenter().getY() - OBJ_DIMETIONS * i)));
				}
				if(exp.getCenter().getY() + OBJ_DIMETIONS * i <= WORLD_SIZE * OBJ_DIMETIONS) {
					this.model.getWorld().getGameObjectCollection().spawn(this.model.getWorld().getGameObjectFactory().createFire(new P2d(exp.getCenter().getX(), exp.getCenter().getY() + OBJ_DIMETIONS * i)));
				}
			}
		}
		//NotPierced
		else {
			//Left Direction
			for(int i = 1; i < exp.getFirePower(); i++) {
				P2d newPos = new P2d(exp.getCenter().getX() - OBJ_DIMETIONS, exp.getCenter().getY());
				this.model.getWorld().getGameObjectCollection().spawn(this.model.getWorld().getGameObjectFactory().createFire(newPos));
				if(wallsList.contains(newPos)) {
					break;
				}
			}
			
			//Right Direction
			for(int i = 1; i < exp.getFirePower(); i++) {
				P2d newPos = new P2d(exp.getCenter().getX() + OBJ_DIMETIONS, exp.getCenter().getY());
				this.model.getWorld().getGameObjectCollection().spawn(this.model.getWorld().getGameObjectFactory().createFire(newPos));
				if(wallsList.contains(newPos)) {
					break;
				}
			}
			
			//Up Directions
			for(int i = 1; i < exp.getFirePower(); i++) {
				P2d newPos = new P2d(exp.getCenter().getX(), exp.getCenter().getY() - OBJ_DIMETIONS);
				this.model.getWorld().getGameObjectCollection().spawn(this.model.getWorld().getGameObjectFactory().createFire(newPos));
				if(wallsList.contains(newPos)) {
					break;
				}
			}
			
			//Down Directions
			for(int i = 1; i < exp.getFirePower(); i++) {
				P2d newPos = new P2d(exp.getCenter().getX(), exp.getCenter().getY() + OBJ_DIMETIONS);
				this.model.getWorld().getGameObjectCollection().spawn(this.model.getWorld().getGameObjectFactory().createFire(newPos));
				if(wallsList.contains(newPos)) {
					break;
				}
			}
			
		}
	}
}


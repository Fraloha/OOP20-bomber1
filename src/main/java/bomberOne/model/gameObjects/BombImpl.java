package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;
import java.util.Optional;

import bomberOne.model.common.P2d;
/**
 * This class implements a simple Bomb who extends a GameObject
 * @author Gustavo Mazzanti
 *
 */
public class BombImpl extends GameObjectImpl implements Bomb {
	
	private int timeToExplode;
	private int thicks;
	private final int firePower;
	private final boolean pierced;
	private Optional<Explosion> explosion;

	public BombImpl(P2d pos, BufferedImage img, int lifes, boolean isBreakable, int firePower, boolean pierced) {
		super(pos, img, lifes, isBreakable);
		this.explosion = Optional.empty();
		this.firePower = firePower;
		this.pierced = pierced;
		this.timeToExplode = 270;
		this.thicks = 0;
	}

	@Override
	public Explosion explode() {
		Explosion boom = new ExplosionImpl(this.firePower, this.pierced, this.position);
		this.explosion = Optional.of(boom);
		this.lifes--;
		return boom;
	}

	@Override
	public Optional<Explosion> getExplosion() {
		return this.explosion;
	}

	@Override
	public void update(int elapsed) {
		if(this.thicks++ == timeToExplode) {
			this.explode();
		}
		
		if(this.getLifes() == 0) {
			this.isAlive = false;
		}
	}

}

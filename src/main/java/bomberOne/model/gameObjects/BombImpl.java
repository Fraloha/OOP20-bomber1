package bomberOne.model.gameObjects;

import java.awt.image.BufferedImage;
import java.util.Optional;

import bomberOne.model.common.P2d;

public class BombImpl extends GameObjectImpl implements Bomb {
	private final int firePower;
	private final boolean pierced;
	private Optional<Explosion> explosion;

	public BombImpl(P2d pos, BufferedImage img, int lifes, boolean isBreakable, int firePower, boolean pierced) {
		super(pos, img, lifes, isBreakable);
		this.explosion = Optional.empty();
		this.firePower = firePower;
		this.pierced = pierced;
	}

	@Override
	public Explosion explode() {
		Explosion boom = new ExplosionImpl(this.firePower, this.pierced, this.position);
		this.explosion = Optional.of(boom);
		return boom;
	}

	@Override
	public Optional<Explosion> getExplosion() {
		return this.explosion;
	}

	@Override
	public void update() {
		if(this.lifes == 0) {
			this.isAlive = false;
			this.explode();
		}

	}

}

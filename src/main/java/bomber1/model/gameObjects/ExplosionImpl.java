package bomber1.model.gameObjects;

import bomber1.model.common.P2d;

/**
 * This class implements a single Explosion.
 *
 */
public class ExplosionImpl implements Explosion {
	
	private final int firePower;
	private final boolean pierce;
	private final P2d center;
	
	public ExplosionImpl(final int firePower, final boolean pierce, final P2d center) {
		this.firePower = firePower;
		this.pierce = pierce;
		this.center = center;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getFirePower() {
		return this.firePower;
	}

	/**
         * {@inheritDoc}
         */
	@Override
	public boolean getPierce() {
		return this.pierce;
	}

	/**
         * {@inheritDoc}
         */
	@Override
	public P2d getCenter() {
		return this.center;
	}
}

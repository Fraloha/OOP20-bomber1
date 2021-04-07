package bomberOne.model.gameObjects;

import bomberOne.model.common.P2d;

/**
 * This class implements a single Explosion
 * @author Gustavo Mazzanti
 *
 */
public class ExplosionImpl implements Explosion {
	
	private final int firePower;
	private final boolean pierce;
	private final P2d center;
	
	public ExplosionImpl(int firePower, boolean pierce, P2d center) {
		this.firePower = firePower;
		this.pierce = pierce;
		this.center = center;
	}

	@Override
	public int getFirePower() {
		return this.firePower;
	}

	@Override
	public boolean getPierce() {
		return this.pierce;
	}

	@Override
	public P2d getCenter() {
		return this.center;
	}
}

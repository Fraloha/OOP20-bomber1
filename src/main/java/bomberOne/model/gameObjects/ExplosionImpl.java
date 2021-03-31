package bomberOne.model.gameObjects;

import java.util.LinkedList;
import java.util.List;

import bomberOne.model.common.P2d;

public class ExplosionImpl implements Explosion {
	private final int firePower;
	private final boolean pierce;
	private final Fire center;
	private final List<Fire> verticalFire;
	private final List<Fire> horizontalFire;
	
	public ExplosionImpl(int firePower, boolean pierce, P2d center) {
		this.firePower = firePower;
		this.pierce = pierce;
		this.center = new FireImpl(center, null, 4, false);
		this.verticalFire = new LinkedList<>();
		this.horizontalFire = new LinkedList<>();
		for(int c = 1; c<=this.firePower; c++) {
			this.verticalFire.add(new FireImpl(new P2d(center.getX(), center.getY()+c), null, 4, false));
			this.verticalFire.add(new FireImpl(new P2d(center.getX(), center.getY()-c), null, 4, false));
			this.horizontalFire.add(new FireImpl(new P2d(center.getX()+c, center.getY()), null, 4, false));
			this.horizontalFire.add(new FireImpl(new P2d(center.getX()-c, center.getY()), null, 4, false));
		}
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
	public Fire getCenter() {
		return this.center;
	}

	@Override
	public List<Fire> getVerticalFire() {
		return this.verticalFire;
	}

	@Override
	public List<Fire> getHorizontalFire() {
		return this.horizontalFire;
	}

}

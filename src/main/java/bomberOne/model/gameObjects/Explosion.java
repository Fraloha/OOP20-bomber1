package bomberOne.model.gameObjects;

import java.util.List;

public interface Explosion extends GameObject {
	
	
	
	public int getFirePower();
	
	public boolean getPierce();
	
	public List<Fire> getFire();
	
}

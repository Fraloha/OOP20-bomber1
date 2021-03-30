package bomberOne.model.gameObjects;

import java.util.Optional;

public interface Bomb extends GameObject {
	
	public Explosion explode();
	
	public Optional<Explosion> getExplosion();
}

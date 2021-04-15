package bomberone.model.gameObjects;

import java.util.Optional;

public interface Bomb extends GameObject {
	
	/**
	 * This method generate the explosion of @this Bomb, and it
	 * @return the Explosion
	 */
	public Explosion explode();
	
	/**
	 * 
	 * @return Optional.empty() if explode() isn't already called,
	 *	else 
	 * @return the Explosion 
	 */
	public Optional<Explosion> getExplosion();
	
	
}

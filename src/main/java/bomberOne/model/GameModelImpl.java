package bomberOne.model;

import bomberOne.model.timer.TimerImpl;

public class GameModelImpl implements GameModel {

	World world;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDifficulty(Difficulty difficulty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public World getWorld() {
		return this.world;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWorld(World world) {
		this.world = world;
	}

	@Override
	public void decScore(int dec) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incScore(int inc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGame(int elapsed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void checkGameOver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TimerImpl getTime() {
		// TODO Auto-generated method stub
		return null;
	}

}

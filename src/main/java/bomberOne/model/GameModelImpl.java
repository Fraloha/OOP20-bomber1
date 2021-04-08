package bomberOne.model;

import bomberOne.model.factory.WorldFactory;
import bomberOne.model.timer.Timer;
import bomberOne.model.timer.TimerImpl;

public class GameModelImpl implements GameModel {

	private static int TIME=30;
	private User user;
	private World world;
	private Difficulty difficulty;
	private int score=0;
	private WorldFactory factory;
	private Timer timer = new TimerImpl(GameModelImpl.TIME);
	private Controls controls;
	private boolean gameOver = false;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		if(this.difficulty.equals(Difficulty.STANDARD)) {
			this.world=factory.createWorldStandard(this.user);
		} else {
			this.world=factory.createWorldHard(this.user);
		}
	}

	@Override
	public void setUser(User user) {
		// TODO Auto-generated method stub
		this.user=user;
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return this.user;
	}

	@Override
	public void setDifficulty(Difficulty difficulty) {
		// TODO Auto-generated method stub
		this.difficulty=difficulty;
	}

	@Override
	public World getWorld() {
		return this.world;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return this.score;
	}

	@Override
	public void setWorld(World world) {
		this.world = world;
	}

	@Override
	public void decScore(int dec) {
		// TODO Auto-generated method stub
		this.score-=dec;
	}

	@Override
	public void incScore(int inc) {
		// TODO Auto-generated method stub
		this.score+=inc;
	}

	@Override
	public void updateGame(int elapsed) {
		// TODO Auto-generated method stub
		world.updateState(elapsed);
	}

	@Override
	public boolean getGameOver() {
		// TODO Auto-generated method stub
		return this.gameOver;
	}

	@Override
	public void checkGameOver() {
		// TODO Auto-generated method stub
		if(!this.world.getBomber().isAlive()) {
			this.gameOver=true;
		} else {
			this.gameOver=false;
		}
	}

	@Override
	public Timer getTime() {
		// TODO Auto-generated method stub
		return this.timer;
	}

	@Override
	public void setControls(Controls controls) {
		// TODO Auto-generated method stub
		this.controls=controls;
	}

	@Override
	public Controls getControls() {
		// TODO Auto-generated method stub
		return this.controls;
	}
}

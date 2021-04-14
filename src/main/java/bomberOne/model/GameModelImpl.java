package bomberOne.model;

import bomberOne.model.factory.WorldFactory;
import bomberOne.model.timer.Timer;
import bomberOne.model.timer.TimerImpl;
import bomberOne.model.timer.TimerThread;
import bomberOne.model.user.Difficulty;
import bomberOne.model.user.User;

public class GameModelImpl implements GameModel {

	private static int TIME=30;
	private User user;
	private World world;
	private Difficulty difficulty;
	private int score=0;
	private WorldFactory factory;
	private Timer timer = new TimerImpl(GameModelImpl.TIME);
	private boolean gameOver = false;
	private TimerThread thread = new TimerThread(timer);

	public GameModelImpl(User user) {
		this.user=user;
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		if(this.difficulty.equals(Difficulty.STANDARD)) {
			this.world=factory.createWorldStandard(this.user);
		} else {
			this.world=factory.createWorldHard(this.user);
		}
		this.thread.start();
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
		if(this.world.getBomber().getLifes()==0) {
			this.thread.interrupt();
			this.gameOver=true;
		} else if (this.world.getGameObjectCollection().getBoxList().size()==0 && 
					this.world.getGameObjectCollection().getEnemyList().size()==0) {
			this.thread.interrupt();
			this.gameOver=true;
		} else if(this.timer.getTime().getTotal()==0) {
			this.thread.interrupt();
			this.gameOver=true;
		} else {
			this.gameOver=false;
		}
	}

	@Override
	public Timer getTimer() {
		// TODO Auto-generated method stub
		return this.timer;
	}
	
}

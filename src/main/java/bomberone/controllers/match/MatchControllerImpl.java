
package bomberone.controllers.match;

import java.util.ArrayList;
import java.util.List;

import bomberone.controllers.ControllerImpl;
import bomberone.controllers.match.event.WorldEventListener;
import bomberone.controllers.match.event.WorldEventListenerImpl;
import bomberone.controllers.match.input.CommandListener;
import bomberone.controllers.match.input.CommandListenerImpl;
import bomberone.model.bomber.Bomber;
import bomberone.model.enemy.Enemy;
import bomberone.model.gameObjects.bomb.Bomb;
import bomberone.model.gameObjects.box.Box;
import bomberone.model.gameObjects.fire.Fire;
import bomberone.model.gameObjects.hardwall.HardWall;
import bomberone.model.gameObjects.powerUp.PowerUp;
import bomberone.model.match.Difficulty;
import bomberone.model.timer.Timer;
import bomberone.model.user.User;
import bomberone.tools.RankLoader;
import bomberone.views.match.MatchView;

/**
 * An implementation of GameController.
 *
 */
public class MatchControllerImpl extends ControllerImpl implements MatchController, Runnable {

    private static final double PERIOD = 16.6666;

    private WorldEventListener eventHandler;
    private CommandListener commandHandler;
    private Thread game;
    private boolean wasQuitted;

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (!this.getModel().getCurrentMatch().getGameOver()) {
            long current = System.currentTimeMillis();
            int elapsed = (int) (current - lastTime);
            this.processInput();
            this.updateGame(elapsed);
            this.render();
            this.waitForNextFrame(current);
            lastTime = current;

        }
        this.getModel().getCurrentMatch().getTimerThread().stopTimer();
        this.getModel().getCurrentMatch().getUser().setScore(this.getModel().getCurrentMatch().getScore());
        if (!this.wasQuitted) {
            /* Add the user on the specific rank */
            if (this.getModel().getCurrentMatch().getDifficulty().equals(Difficulty.HARD)) {
                this.getModel().getHardRank().add(this.getModel().getCurrentMatch().getUser());
            } else {
                this.getModel().getStdRank().add(this.getModel().getCurrentMatch().getUser());
            }
            RankLoader.writeUsers(this.getModel().getHardRank(), this.getModel().getStdRank());
            ((MatchView) this.getView()).switchToRank();
        } else {
            this.wasQuitted = false;
        }

    }

    private void waitForNextFrame(final long current) {
        long dt = System.currentTimeMillis() - current;
        if (dt < PERIOD) {
            try {
                Thread.sleep((long) (PERIOD - dt));
            } catch (Exception ex) {
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void quitGame() {
        this.getModel().getCurrentMatch().setGameOver(true);
        this.wasQuitted = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processInput() {
        commandHandler.executeCommands();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render() {
        ((MatchView) this.getView()).render();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateGame(final int elapsedTime) {
        this.getModel().getCurrentMatch().updateGame(elapsedTime);
        this.getModel().getCurrentMatch().getWorld().checkBoundary();
        this.processEvent();
        this.getModel().getCurrentMatch().getWorld().checkCollision();
        this.getModel().getCurrentMatch().getWorld().checkRespawn();
        this.processEvent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        this.eventHandler = new WorldEventListenerImpl();
        this.commandHandler = new CommandListenerImpl();
        this.eventHandler.setGameMatch(this.getModel().getCurrentMatch());
        this.commandHandler.setGameMatch(this.getModel().getCurrentMatch());
        this.getModel().getCurrentMatch().init();
        this.getModel().getCurrentMatch().getWorld().setEventListener(this.eventHandler);
        this.game = new Thread(this);
        this.game.setName("LOOP");
        this.game.start();
        this.getModel().getCurrentMatch().getTimerThread().start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processEvent() {
        this.eventHandler.processEvents();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CommandListener getCommandListener() {
        return this.commandHandler;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bomber getBomber() {
        return this.getModel().getCurrentMatch().getWorld().getBomber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timer getTimer() {
        return this.getModel().getCurrentMatch().getTimer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUserOfTheMatch() {
        return this.getModel().getCurrentMatch().getUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getScore() {
        return this.getModel().getCurrentMatch().getScore();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Difficulty getDifficulty() {
        return this.getModel().getCurrentMatch().getDifficulty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Fire> getFireList() {
        List<Fire> fireList = new ArrayList<>();
        fireList.addAll(this.getModel().getCurrentMatch().getWorld().getGameObjectCollection().getFireList());
        return fireList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Bomb> getBombList() {
        List<Bomb> bombList = new ArrayList<>();
        bombList.addAll(this.getModel().getCurrentMatch().getWorld().getGameObjectCollection().getBombList());
        return bombList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Box> getBoxList() {
        List<Box> boxList = new ArrayList<>();
        boxList.addAll(this.getModel().getCurrentMatch().getWorld().getGameObjectCollection().getBoxList());
        return boxList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<HardWall> getHardWallList() {
        List<HardWall> wallList = new ArrayList<>();
        wallList.addAll(this.getModel().getCurrentMatch().getWorld().getGameObjectCollection().getHardWallList());
        return wallList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Enemy> getEnemyList() {
        List<Enemy> enemyList = new ArrayList<>();
        enemyList.addAll(this.getModel().getCurrentMatch().getWorld().getGameObjectCollection().getEnemyList());
        return enemyList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PowerUp> getPowerUpList() {
        List<PowerUp> pUpList = new ArrayList<>();
        pUpList.addAll(this.getModel().getCurrentMatch().getWorld().getGameObjectCollection().getPowerUpList());
        return pUpList;
    }

}

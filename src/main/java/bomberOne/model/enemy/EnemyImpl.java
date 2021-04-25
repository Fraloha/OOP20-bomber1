package bomberOne.model.enemy;

import bomberOne.model.common.Direction;
import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.AnimatedEntityImpl;
import java.awt.image.BufferedImage;
import bomberOne.model.enemy.actions.Actions;
import bomberOne.model.enemy.actions.IntermediateBehavior;
import bomberOne.model.enemy.actions.BasicBehavior;
import bomberOne.model.user.Difficulty;
import java.util.LinkedList;
import java.util.Queue;

public final class EnemyImpl extends AnimatedEntityImpl implements Enemy {

        /* Fields. */
        private static final int SECONDS_TO_WAIT = 4;
        private static final int FRAME_PER_SECOND = 60;
        private Actions behavior;
        private int frameCounter;
        private Queue<P2d> badPath;
        private Queue<P2d> normalPath;
        private Queue<Direction> nextDirections;
        
        /* Constructors. */
        public EnemyImpl(final P2d position, final BufferedImage [][] img, final int lifes, Difficulty mode) {
            super(position, img, lifes, img[0][0]);
            
            //Setting the number of frames that the enemy has to wait before start moving.
            this.frameCounter = SECONDS_TO_WAIT * FRAME_PER_SECOND;
            
            this.badPath = new LinkedList<P2d>();
            this.normalPath = new LinkedList<P2d>();
            this.nextDirections = new LinkedList<Direction>();
            
            //Creating the enemy behavior on the basis of the mode chosen by the user.
            if (mode.equals(Difficulty.STANDARD)) {
                this.behavior = new BasicBehavior(this);
            } else if (mode.equals(Difficulty.HARD)){
                this.behavior = new IntermediateBehavior(this);
            }
        }

        /* Methods. */
        
        /**
         * {@inheritDoc}
         */
        public void update(P2d playerPosition) {
            super.update(this.getTimeElapsed());

            //The enemy before acts has to wait four second that are 240 frames.
            //Checking if the frame counter is greater than zero.
            if (this.frameCounter > 0) {
                this.frameCounter--;
            } else {
                //If the enemy has an IntermediateBehavior, the player position
                //has to be passed.
                if(this.behavior instanceof IntermediateBehavior) {
                    ((IntermediateBehavior) this.behavior).setPlayerPosition(playerPosition);
                    ((IntermediateBehavior) this.behavior).isFound(playerPosition);
                }

                //Executing the behavior.
                this.behavior.doActions();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void changePath() {
            //Setting the bad path to not walk through the path that makes the enemy
            //collide.
            this.badPath = this.normalPath;
            this.normalPath.clear();
        }
}
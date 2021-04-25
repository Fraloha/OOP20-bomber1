package bomberOne.model.enemy;

import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.AnimatedEntityImpl;
import java.awt.image.BufferedImage;
import bomberOne.model.enemy.actions.Actions;
import bomberOne.model.enemy.actions.IntermediateBehavior;
import bomberOne.model.enemy.actions.BasicBehavior;
import bomberOne.model.user.Difficulty;

public final class EnemyImpl extends AnimatedEntityImpl implements Enemy {

        /* Fields. */
        private static final int SECONDS_TO_WAIT = 4;
        private static final int FRAME_PER_SECOND = 60;
        private Actions behavior;
        private int frameCounter;
        
        /* Constructors. */
        public EnemyImpl(final P2d position, final BufferedImage [][] img, final int lifes, Difficulty mode) {
            super(position, img, lifes, img[0][0]);
            
            //Setting the number of frames that the enemy has to wait before start moving.
            this.frameCounter = SECONDS_TO_WAIT * FRAME_PER_SECOND;

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
                super.update(this.getTimeElapsed());
            }
        }
}
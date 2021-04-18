package bomberOne.model.enemy;

import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.AnimatedEntityImpl;
import java.awt.image.BufferedImage;
import bomberOne.model.enemy.actions.Actions;
import bomberOne.model.enemy.actions.IntermediateBehavior;
import bomberOne.model.enemy.actions.BasicBehavior;
import java.util.LinkedList;
import java.util.Queue;

public final class EnemyImpl extends AnimatedEntityImpl implements Enemy {

        /* Fields. */
        private static final int SECONDS_TO_WAIT = 4;
        private static final int FRAME_PER_SECOND = 60;
        private Actions behavior;
        private int frameCounter;
        private Queue<P2d> badPath;
        
        /* Constructors. */
        public EnemyImpl(final P2d position, final BufferedImage [][] img, final int lifes) {
            super(position, img, lifes, img[0][0]);
            
            //Setting the number of frames that the enemy has to wait before start moving.
            this.frameCounter = SECONDS_TO_WAIT * FRAME_PER_SECOND;
            
            this.badPath = new LinkedList<P2d>();
        }

        /* Methods. */
        
        /**
         * {@inheritDoc}
         */
        public void update(P2d playerPosition) {
            super.update(0);
        }
        
        /**
         * {@inheritDoc}
         */
        @Override
        public void changePath() {

        }
}
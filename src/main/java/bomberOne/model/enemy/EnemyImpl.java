package bomberOne.model.enemy;

import bomberOne.model.common.P2d;
import bomberOne.model.gameObjects.AnimatedEntityImpl;
import java.awt.image.BufferedImage;
import bomberOne.model.enemy.actions.BehaviorExecutor;
import bomberOne.model.enemy.actions.IntermediateBehavior;
import bomberOne.model.enemy.actions.BasicBehavior;

public final class EnemyImpl extends AnimatedEntityImpl implements Enemy {

        /* Fields. */
        private BehaviorExecutor executor;

        /* Constructors. */
        public EnemyImpl(final P2d position, final BufferedImage img, final int lifes) {
            super(position, img, lifes);
        }

        /* Methods. */

        @Override
        public void setBasicEnemy() {
            this.executor = new BehaviorExecutor(new BasicBehavior(this));
        }

        @Override
        public void setHardEnemy(final P2d playerPosition) {
            this.executor = new BehaviorExecutor(new IntermediateBehavior(this, playerPosition));
        }

        @Override
        public void keepTrack(final P2d playerPosition) {

        }
}

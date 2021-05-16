package bomberone.model.enemy.actions;

import java.util.Random;

import bomberone.model.common.Direction;
import bomberone.model.enemy.Enemy;
import bomberone.model.enemy.EnemyImpl;

public final class BasicBehavior extends AbstractActions {

    /* Fields. */

    /* Constructors. */
    public BasicBehavior(final Enemy enemy) {
        super(enemy);
        this.randomGenerator = new Random();
    }

    /* Methods. */
}
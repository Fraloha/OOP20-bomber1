package bomberone.views.game.movement;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import bomberone.controllers.game.input.PlayerBehavior;
import bomberone.model.user.Controls;

/**
 * Class that map to every specific KeyCode, an action to perform.
 *
 */
public class ControlsMap {

    private static final int KEY_D = 68;
    private static final int KEY_A = 65;
    private static final int KEY_S = 83;
    private static final int KEY_W = 87;
    private static final int KEY_ARROW_RIGHT = 39;
    private static final int KEY_ARROW_LEFT = 37;
    private static final int KEY_ARROW_DOWN = 40;
    private static final int KEY_ARROW_UP = 38;
    private static final int KEY_SPACE_BAR = 32;

    private Map<Integer, Consumer<Boolean>> controlMap;
    private PlayerBehavior player;

    public ControlsMap(final Controls type, final PlayerBehavior player) {
        this.controlMap = new HashMap<>();
        this.player = player;
        if (type.equals(Controls.ARROW)) {
            this.initArrowsControls();
        } else {
            this.initWasdControls();
        }
        this.controlMap.put(KEY_SPACE_BAR, (value) -> this.player.setToggleActionPressed(value));
    }

    /**
     * Initialize the map if the User chose the "Arrow" Controls.
     */
    private void initArrowsControls() {
        this.controlMap.put(KEY_ARROW_UP, (value) -> this.player.setToggleUpPressed(value));
        this.controlMap.put(KEY_ARROW_DOWN, (value) -> this.player.setToggleDownPressed(value));
        this.controlMap.put(KEY_ARROW_LEFT, (value) -> this.player.setToggleLeftPressed(value));
        this.controlMap.put(KEY_ARROW_RIGHT, (value) -> this.player.setToggleRightPressed(value));
    }

    /**
     * Initialize the map if the User chose the "Wasd" Controls.
     */
    private void initWasdControls() {
        this.controlMap.put(KEY_W, (value) -> this.player.setToggleUpPressed(value));
        this.controlMap.put(KEY_S, (value) -> this.player.setToggleDownPressed(value));
        this.controlMap.put(KEY_A, (value) -> this.player.setToggleLeftPressed(value));
        this.controlMap.put(KEY_D, (value) -> this.player.setToggleRightPressed(value));
    }

    /**
     * 
     * @return the controllMap
     */
    public Map<Integer, Consumer<Boolean>> getControlMap() {
        return this.controlMap;
    }
}

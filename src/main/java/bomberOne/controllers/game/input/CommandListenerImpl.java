package bomberOne.controllers.game.input;

import java.util.LinkedList;
import java.util.List;

import bomberOne.model.GameModel;
import bomberOne.controllers.game.input.commands.Command;
import bomberOne.controllers.game.input.commands.MoveDown;
import bomberOne.controllers.game.input.commands.MoveLeft;
import bomberOne.controllers.game.input.commands.MoveRight;
import bomberOne.controllers.game.input.commands.MoveUp;
import bomberOne.controllers.game.input.commands.PlantBomb;

/**
 * That class is the CommandListner of the game.
 *
 */
public class CommandListenerImpl implements CommandListener {
    private List<Command> commandList;
    private GameModel game;
    private PlayerBehavior behaviour;
    private boolean isActionCompleted;

    public CommandListenerImpl() {
        this.commandList = new LinkedList<>();
        this.behaviour = new PlayerBehavior();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCommand(final Command command) {
        if (command.getClass().equals(PlantBomb.class) || this.commandList.isEmpty()
                || this.commandList.get(0).getClass().equals(command.getClass())) {
            this.commandList.add(command);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Command> getCommandList() {
        return this.commandList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void executeCommands() {
        if (this.behaviour.isToggleDownPressed()) {
            new MoveDown().execute(game);
        }
        if (this.behaviour.isToggleUpPressed()) {
            new MoveUp().execute(game);
        }
        if (this.behaviour.isToggleLeftPressed()) {
            new MoveLeft().execute(game);
        }
        if (this.behaviour.isToggleRightPressed()) {
            new MoveRight().execute(game);
        }
        if (!this.behaviour.isToggleLeftPressed() && !this.behaviour.isToggleDownPressed() && !this.behaviour.isToggleRightPressed() && !this.behaviour.isToggleUpPressed()) {
            this.getGameModel().getWorld().getBomber().setStatic(true);
        }
        if (this.behaviour.isToggleActionPressed()) {
            if (!this.isActionCompleted) {
                new PlantBomb().execute(game);
                this.isActionCompleted = true;
            }
        } else {
            this.isActionCompleted = false;
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setGameModel(final GameModel game) {
        this.game = game;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameModel getGameModel() {
        return this.game;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerBehavior getPlayerBehaviour() {
        return this.behaviour;
    }
}

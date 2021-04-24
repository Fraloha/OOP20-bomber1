package bomberOne.model.input;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import bomberOne.model.GameModel;
import bomberOne.model.input.commands.Command;
import bomberOne.model.input.commands.MoveDown;
import bomberOne.model.input.commands.MoveLeft;
import bomberOne.model.input.commands.MoveRight;
import bomberOne.model.input.commands.MoveUp;
import bomberOne.model.input.commands.PlantBomb;

/**
 * That class is the CommandListner of the game.
 *
 */
public class CommandListenerImpl implements CommandListener {
    private List<Command> commandList;
    private GameModel game;
    private Command lastCommand;
    private boolean first = true;

    public CommandListenerImpl() {
        this.commandList = new LinkedList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCommand(final Command command) {
        if(command.getClass().equals(PlantBomb.class) || this.commandList.isEmpty() || this.commandList.get(0).getClass().equals(command.getClass())) {
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
    public void executeAll() {

        if(Player.isToggleDownPressed()) {
            new MoveDown().execute(game);
        }
        if(Player.isToggleUpPressed()) {
            new MoveUp().execute(game);
        }
        if(Player.isToggleLeftPressed()) {
            new MoveLeft().execute(game);
        }
        if(Player.isToggleRightPressed()) {
            new MoveRight().execute(game);
        }
//        List<Command> tmp = new LinkedList<>(this.commandList);
//        this.commandList.stream().forEach(i -> {
//            i.execute(this.game);
//            tmp.add(i);
//        });
//        this.commandList.removeAll(tmp);
//        tmp.clear();

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
}

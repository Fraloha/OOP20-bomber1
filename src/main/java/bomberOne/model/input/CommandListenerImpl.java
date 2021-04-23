package bomberOne.model.input;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import bomberOne.model.GameModel;
import bomberOne.model.input.commands.Command;

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
        if(this.commandList.isEmpty() || this.commandList.get(0).getClass().equals(command.getClass())) {
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

        List<Command> tmp = new LinkedList<>(this.commandList);
        for (var elem : this.commandList) {
            elem.execute(this.game);
            tmp.add(elem);
        }
        this.commandList.removeAll(tmp);
        tmp.clear();

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
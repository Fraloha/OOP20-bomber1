package bomberOne.controllers.game.event;

import java.util.ArrayList;
import java.util.List;

import bomberOne.model.GameModel;

public class WorldEventListenerImpl implements WorldEventListener {

    private GameModel model;
    private List<WorldEvent> eventList = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyEvent(final WorldEvent event) {
        this.eventList.add(event);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<WorldEvent> getEventList() {
        return this.eventList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processEvents() {
        this.eventList.stream().forEach(event -> {
            event.process(model);
        });
        this.eventList.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setGameModel(final GameModel game) {
        this.model = game;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameModel getGameModel() {
        return this.model;
    }

}

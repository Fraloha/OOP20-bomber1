package bomberone.controllers.game.event;

import java.util.ArrayList;
import java.util.List;

import bomberone.model.match.GameMatch;

public class WorldEventListenerImpl implements WorldEventListener {

    private GameMatch model;
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
    public void setGameMatch(final GameMatch game) {
        this.model = game;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameMatch getGameMatch() {
        return this.model;
    }

}

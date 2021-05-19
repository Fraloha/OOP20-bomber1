package bomberone.controllers.match.event;

import java.util.ArrayList;
import java.util.List;

import bomberone.model.match.GameMatch;

/**
 * An implementation of WorldEventListener.
 */
public class WorldEventListenerImpl implements WorldEventListener {

    private GameMatch match;
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
            event.process(match);
        });
        this.eventList.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setGameMatch(final GameMatch match) {
        this.match = match;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameMatch getGameMatch() {
        return this.match;
    }

}

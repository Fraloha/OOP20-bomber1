package bomberone.model.event;

import java.util.ArrayList;
import java.util.List;

import bomberone.model.GameModel;

public final class WorldEventListenerImpl implements WorldEventListener {

    private GameModel model;
    private List<WorldEvent> eventList = new ArrayList<>();

    @Override
    public void notifyEvent(final WorldEvent event) {
        this.eventList.add(event);
    }

    @Override
    public List<WorldEvent> getEventList() {
        return this.eventList;
    }

    @Override
    public void processEvents() {
        this.eventList.stream().forEach(event -> {
            event.process(model);
        });
        this.eventList.clear();
    }

    @Override
    public void setGameModel(final GameModel game) {
        this.model = game;
    }

    @Override
    public GameModel getGameModel() {
        return this.model;
    }

}

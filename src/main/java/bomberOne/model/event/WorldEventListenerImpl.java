package bomberOne.model.event;

import java.util.ArrayList;
import java.util.List;

import bomberOne.model.GameModel;

public class WorldEventListenerImpl implements WorldEventListener {
	
	private GameModel model;
	private List<WorldEvent> eventList = new ArrayList<>();
	
	@Override
	public void notifyEvent(WorldEvent event) {
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
	public void setGameModel(GameModel game) {
		this.model = game;
	}

	@Override
	public GameModel getGameModel() {
		return this.model;
	}

}


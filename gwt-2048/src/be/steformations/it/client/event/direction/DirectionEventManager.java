package be.steformations.it.client.event.direction;

import com.google.gwt.event.shared.EventHandler;

public interface DirectionEventManager extends EventHandler{

	void onDirection(DirectionEvent event);
}

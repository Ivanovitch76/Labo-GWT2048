package be.steformations.it.client.event.load;

import com.google.gwt.event.shared.EventHandler;

public interface LoadEventManager extends EventHandler{

	public void onLoad(LoadEvent event);
}

package be.steformations.it.client.event.save;

import com.google.gwt.event.shared.EventHandler;

public interface SaveEventManager extends EventHandler{

	public void onSave(SaveEvent event);
	
}

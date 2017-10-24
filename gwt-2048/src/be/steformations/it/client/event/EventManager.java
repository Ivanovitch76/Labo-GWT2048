package be.steformations.it.client.event;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;

public class EventManager {

	private static EventManager instance = new EventManager();
	private HandlerManager handlerManger;
	
	public static EventManager getInstance(){
		return instance;
	}
	
	public EventManager() {
		super();
//		GWT.log("EventManager.EventManager()");
		this.handlerManger = new HandlerManager(this);
	}

	public <H extends EventHandler> HandlerRegistration addHandler(Type<H> type, H handler) {
//		GWT.log("EventManager.addHandler()");
		return handlerManger.addHandler(type, handler);
	}

	public void fireEvent(GwtEvent<?> event) {
//		GWT.log("EventManager.fireEvent()");
		handlerManger.fireEvent(event);
	}
	
	
}

package be.steformations.it.client.event.load;

import com.google.gwt.event.shared.GwtEvent;

public class LoadEvent extends GwtEvent<LoadEventManager>{

	public final static GwtEvent.Type<LoadEventManager> type = new GwtEvent.Type<LoadEventManager>();
		
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<LoadEventManager> getAssociatedType() {
		return type;
	}

	@Override
	protected void dispatch(LoadEventManager handler) {
		handler.onLoad(this);
		
	}

}

package be.steformations.it.client.event.save;

import com.google.gwt.event.shared.GwtEvent;

public class SaveEvent extends GwtEvent<SaveEventManager>{

	public final static GwtEvent.Type<SaveEventManager> type = new GwtEvent.Type<SaveEventManager>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SaveEventManager> getAssociatedType() {
		return type;
	}

	@Override
	protected void dispatch(SaveEventManager handler) {
		handler.onSave(this);
		
	}

}

package be.steformations.it.client.event.reset;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.GwtEvent;

public class ResetEvent extends GwtEvent<ResetEventManager>{

	public final static GwtEvent.Type<ResetEventManager> type
		= new GwtEvent.Type<ResetEventManager>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ResetEventManager> getAssociatedType() {
		return type;
	}

	@Override
	protected void dispatch(ResetEventManager handler) {
		GWT.log("ResetEvent.dispatch() => " + handler.getClass().getName());
		handler.onReset(this);
		
	}

}

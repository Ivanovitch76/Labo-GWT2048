package be.steformations.it.client.event.direction;

import com.google.gwt.event.shared.GwtEvent;

public class DirectionEvent extends GwtEvent<DirectionEventManager>{

	public static final GwtEvent.Type<DirectionEventManager> type = new GwtEvent.Type<DirectionEventManager>();
	private String direction;
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<DirectionEventManager> getAssociatedType() {
		return type;
	}

	@Override
	protected void dispatch(DirectionEventManager handler) {
		handler.onDirection(this);		
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	
}

package be.steformations.it.client.event.load;

import com.google.gwt.event.shared.GwtEvent;

public class LoadEvent extends GwtEvent<LoadEventManager>{

	public final static GwtEvent.Type<LoadEventManager> type = new GwtEvent.Type<LoadEventManager>();
	private String id;
	
	public LoadEvent(String id) {
		super();
		this.id = id;
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<LoadEventManager> getAssociatedType() {
		return type;
	}

	@Override
	protected void dispatch(LoadEventManager handler) {
		handler.onLoad(this);
		
	}
	
	public String getId(){
		return id;
	}

}

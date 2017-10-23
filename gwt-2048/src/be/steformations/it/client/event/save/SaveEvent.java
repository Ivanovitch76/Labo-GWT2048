package be.steformations.it.client.event.save;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.GwtEvent;

public class SaveEvent extends GwtEvent<SaveEventManager>{

	public final static GwtEvent.Type<SaveEventManager> type = new GwtEvent.Type<SaveEventManager>();
	private String id;
	private String fusion;

	public SaveEvent(String id) {
		super();
		this.id = id;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SaveEventManager> getAssociatedType() {
		return type;
	}

	@Override
	protected void dispatch(SaveEventManager handler) {
		GWT.log("SaveEvent.dispatch()");
		handler.onSave(this);
		
	}

	public String getId() {
		return id;
	}

	
	public String getFusion() {
		return fusion;
	}

	public void setFusion(String fusion) {
		this.fusion = fusion;
	}		

}

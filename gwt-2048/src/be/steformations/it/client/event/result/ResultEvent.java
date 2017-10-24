package be.steformations.it.client.event.result;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.GwtEvent;

public class ResultEvent extends GwtEvent<ResultEventManager> {
	
	public static final GwtEvent.Type<ResultEventManager> type = new GwtEvent.Type<ResultEventManager>();

	private String grid;
	
	public ResultEvent(String grid) {
		super();
		this.grid = grid;
	}
	
	public String getGrid(){
		return grid;
	}
	
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ResultEventManager> getAssociatedType() {
		return type;
	}

	@Override
	protected void dispatch(ResultEventManager handler) {
		GWT.log("ResultEvent.dispatch()");
		handler.onResult(this);
		
	}

}

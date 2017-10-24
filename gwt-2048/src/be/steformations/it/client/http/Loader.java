package be.steformations.it.client.http;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

import be.steformations.it.client.event.EventManager;
import be.steformations.it.client.event.result.ResultEvent;

public class Loader implements RequestCallback {

	private RequestBuilder requestBuilder;
	private com.github.nmorel.gwtjackson.client.ObjectMapper<Game> mapper;
	
	public Loader() {
		super();
		GWT.log("Loader.Loader()");
		String url = Window.Location.getPath().replaceAll("/index.html", "");
		url += "/json/service";
		this.requestBuilder = new RequestBuilder(RequestBuilder.GET, url);
		mapper = GWT.create(GameMapper.class);
		this.requestBuilder.setCallback(this);
	}
	
	@Override
	public void onResponseReceived(Request request, Response response) {
		GWT.log("Loader.onResponseReceived()");
		String grid = response.getText();
		
		ResultEvent event = new ResultEvent(grid);
		EventManager.getInstance().fireEvent(event);
		
	}

	@Override
	public void onError(Request request, Throwable exception) {
		Window.alert(exception.getMessage());
		GWT.log("Loader.onError()");
		
	}

	public void onTransfert(String id){
		GWT.log("Loader.onTransfert()");
		String url = Window.Location.getPath().replaceAll("/index.html", "");
		url += "/json/service?id=" + id;
		this.requestBuilder = new RequestBuilder(RequestBuilder.GET, url);
		this.requestBuilder.setCallback(this);
		try{
			this.requestBuilder.send();
		} catch(Exception e){
			GWT.log("Loader.alert()");
			Window.alert(e.getMessage());
		}
	}
	
}

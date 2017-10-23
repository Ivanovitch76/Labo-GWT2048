package be.steformations.it.client.http;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Request request, Throwable exception) {
		Window.alert(exception.getMessage());
		GWT.log("Loader.onError()");
		
	}

	public void onTransfert(String id){
		GWT.log("Loader.onTransfert()");
		Game game = new Game();
		game.setId(id);
		String json = this.mapper.write(game);
		this.requestBuilder.setRequestData(json);
		try{
			GWT.log("Loader.requestBuilder.send() => id: " + game.getId());
			this.requestBuilder.send();
		} catch(Exception e){
			GWT.log("Loader.alert()");
			Window.alert(e.getMessage());
		}
	}
	
}

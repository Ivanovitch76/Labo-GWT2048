package be.steformations.it.client.http;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window; 

public class Saver implements RequestCallback{
	
	private RequestBuilder requestBuilder;
	private com.github.nmorel.gwtjackson.client.ObjectMapper<Game> mapper;

	public Saver() {
		super();
		GWT.log("Saver.Saver()");
		String url = Window.Location.getPath().replaceAll("/index.html", "");
		url += "/json/service";
		this.requestBuilder = new RequestBuilder(RequestBuilder.POST, url);
		mapper = GWT.create(GameMapper.class);
		this.requestBuilder.setCallback(this);
		
	}
	
	@Override
	public void onResponseReceived(Request request, Response response) {
//		String json = response.getText();
//		GWT.log("Saver.onResponseReceived()" + json);
//		com.github.nmorel.gwtjackson.client.ObjectMapper<Game>
//			mapper = GWT.create(GameMapper.class);
//		Game result = mapper.read(json);
//		GWT.log(result.toString());
	}

	@Override
	public void onError(Request request, Throwable exception) {
		Window.alert(exception.getMessage());
		GWT.log("Saver.onError()");
	}

	public void onTransfert(String id, String grid){
		GWT.log("Saver.onTransfert()");
		Game game = new Game();
		game.setGrid(grid);
		game.setId(id);
		String json = this.mapper.write(game);
		this.requestBuilder.setRequestData(json);
		try{
			GWT.log("Saver.requestBuilder.send() => id: " + game.getId() + " ,grid: " + game.getGrid());
			this.requestBuilder.send();
		} catch(Exception e){
			GWT.log("Saver.alert()");
			Window.alert(e.getMessage());
		}
	}

}

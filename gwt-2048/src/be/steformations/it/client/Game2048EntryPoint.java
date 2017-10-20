package be.steformations.it.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import be.steformations.it.client.ui.UiPanel;

public class Game2048EntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		GWT.log("Game2048EntryPoint.onModuleLoad()");
		
		UiPanel panel = new UiPanel();
		RootLayoutPanel.get().add(panel);

	}

}

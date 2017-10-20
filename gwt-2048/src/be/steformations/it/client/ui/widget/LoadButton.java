package be.steformations.it.client.ui.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import be.steformations.it.client.event.EventManager;
import be.steformations.it.client.event.load.LoadEvent;
import gwt.material.design.client.ui.MaterialButton;

public class LoadButton extends MaterialButton implements ClickHandler{

	public LoadButton() {
		super();
		this.addClickHandler(this);
	}

	@Override
	public void onClick(ClickEvent event) {
		LoadEvent load = new LoadEvent();
		EventManager.getInstance().fireEvent(load);
		
	}
	
}

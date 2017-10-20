package be.steformations.it.client.ui.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiConstructor;

import be.steformations.it.client.event.EventManager;
import be.steformations.it.client.event.reset.ResetEvent;
import gwt.material.design.client.ui.MaterialButton;

public class NewGameButton extends MaterialButton implements ClickHandler{

	@UiConstructor
	public NewGameButton() {
		super();
		this.addClickHandler(this);
	}

	@Override
	public void onClick(ClickEvent event) {
		ResetEvent reset = new ResetEvent();
		EventManager.getInstance().fireEvent(reset);
		
	}
	
}

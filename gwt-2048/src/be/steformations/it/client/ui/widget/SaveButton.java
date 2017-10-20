package be.steformations.it.client.ui.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import be.steformations.it.client.event.EventManager;
import be.steformations.it.client.event.save.SaveEvent;
import gwt.material.design.client.ui.MaterialButton;

public class SaveButton extends MaterialButton implements ClickHandler{

	public SaveButton() {
		super();
		this.addClickHandler(this);
	}

	@Override
	public void onClick(ClickEvent event) {
		SaveEvent save = new SaveEvent();
		EventManager.getInstance().fireEvent(save);
		
	}
	
}

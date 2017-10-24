package be.steformations.it.client.ui.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import be.steformations.it.client.event.EventManager;
import be.steformations.it.client.event.direction.DirectionEvent;
import gwt.material.design.client.ui.MaterialButton;

public class Controls extends MaterialButton implements ClickHandler{

	private String direction;
	
	public Controls() {
		super();
		this.addClickHandler(this);
	}
	

	public void setDirection(String direction){
		this.direction=direction;

	}
	
	@Override
	public void onClick(ClickEvent event) {
//		GWT.log("Controls.onClick()");
		DirectionEvent directionEvent = new DirectionEvent();
		directionEvent.setDirection(direction);
		EventManager.getInstance().fireEvent(directionEvent);

		
	}



	
}

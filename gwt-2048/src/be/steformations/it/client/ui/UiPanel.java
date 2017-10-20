package be.steformations.it.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import be.steformations.it.client.ui.widget.Controls;
import be.steformations.it.client.ui.widget.Grille;

public class UiPanel extends Composite{

	private static UiPanelUiBinder uiBinder = GWT.create(UiPanelUiBinder.class);

	public Controls controls = new Controls();
	
	interface UiPanelUiBinder extends UiBinder<Widget, UiPanel> {
	}
	
	@UiField Controls up;
	@UiField Controls down;
	@UiField Controls left;
	@UiField Controls right;
	@UiField Grille grille;
	
	public UiPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		up.setDirection("up");
		down.setDirection("down");
		left.setDirection("left");
		right.setDirection("right");
		
	}


}

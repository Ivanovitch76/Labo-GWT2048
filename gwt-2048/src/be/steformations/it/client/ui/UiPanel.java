package be.steformations.it.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import be.steformations.it.client.event.EventManager;
import be.steformations.it.client.event.load.LoadEvent;
import be.steformations.it.client.event.save.SaveEvent;
import be.steformations.it.client.ui.widget.Controls;
import be.steformations.it.client.ui.widget.Grille;
import be.steformations.it.client.ui.widget.IdInput;
import be.steformations.it.client.ui.widget.LoadButton;
import be.steformations.it.client.ui.widget.NewGameButton;
import be.steformations.it.client.ui.widget.SaveButton;
import net.sourceforge.htmlunit.corejs.javascript.ast.NewExpression;

public class UiPanel extends Composite implements ClickHandler{

	private static UiPanelUiBinder uiBinder = GWT.create(UiPanelUiBinder.class);

	public Controls controls = new Controls();
	
	interface UiPanelUiBinder extends UiBinder<Widget, UiPanel> {
	}
	
	@UiField Controls up;
	@UiField Controls down;
	@UiField Controls left;
	@UiField Controls right;
	@UiField Grille grille;
	@UiField LoadButton load;
	@UiField SaveButton save;
	@UiField NewGameButton nouvelle;
	@UiField IdInput id;
	
	
	public UiPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		up.setDirection("up");
		down.setDirection("down");
		left.setDirection("left");
		right.setDirection("right");
		save.addClickHandler(this);
		load.addClickHandler(this);
	}

	@Override
	public void onClick(ClickEvent event) {
		GWT.log("UiPanel.onClick() => id: " + id);
		if (event.getSource().equals(save)){
			GWT.log("UiPanel.onClick() => save");
			SaveEvent save = new SaveEvent(id.getText());
			EventManager.getInstance().fireEvent(save);	
		} else {	
			GWT.log("UiPanel.onClick() => load");			
			LoadEvent load = new LoadEvent(id.getText());
			EventManager.getInstance().fireEvent(load);
		}	
	}

}

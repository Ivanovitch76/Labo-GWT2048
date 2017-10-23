package be.steformations.it.client.ui.widget;

import com.google.gwt.uibinder.client.UiConstructor;

import gwt.material.design.client.ui.MaterialTextBox;

public class IdInput extends MaterialTextBox{

	@UiConstructor
	public IdInput(String label) {
		this.setLabel(label);
	}
	
}

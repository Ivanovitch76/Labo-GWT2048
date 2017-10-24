package be.steformations.it.client.modele;

import com.google.gwt.core.shared.GWT;

import be.steformations.it.client.ui.widget.Case;

public class Up3 {

	private Case[][] tableau;
	private CommonParts common = new CommonParts();

	public Case[][] goUp(Case[][] table) {

		tableau = table;
		int ligne;
		GWT.log("Up3.goUp()");

		for (int i = 0; i < tableau.length; i++) {
			ligne = tableau[0][i].getText().equals("") ? -1 : 0;
			for (int j = 1; j < tableau.length; j++) {
				String val = tableau[j][i].getText();
				tableau[j][i].setText("");
				if (!val.equals("")) {
					if (ligne >= 0 && val.equals(tableau[ligne][i].getText())) {
						tableau[ligne][i].setText(common.valueAddition(val));
						ligne++;
					} else {
						ligne++;
						tableau[ligne][i].setText(val);
					}
				}

			}

		}

		return tableau;
	}

}

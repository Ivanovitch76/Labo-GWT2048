package be.steformations.it.client.modele;

import com.google.gwt.core.client.GWT;

import be.steformations.it.client.ui.widget.Case;

public class Down {

	private Case[][] tableau;
	
	public Case[][] goDown(Case[][] table){ 
		tableau = table;
		GWT.log("Grille.downDirection()");
		CommonParts partie = new CommonParts();
		Right right = new Right();
		Case[][] reverseTable = partie.createWorkTable();

		
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau.length; j++) {
				reverseTable[j][i].setText(tableau[i][j].getText());

			}	

		}
		
		reverseTable=right.goRight(reverseTable);

		
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau.length; j++) {
				tableau[j][i].setText(reverseTable[i][j].getText());
			}		
		}			
		
		return tableau;	
	}
	
}

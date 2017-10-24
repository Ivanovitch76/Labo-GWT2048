package be.steformations.it.client.modele;

import com.google.gwt.core.client.GWT;

import be.steformations.it.client.ui.widget.Case;

public class Up {

	private Case[][] tableau;
	
	public Case[][] goUp(Case[][] table){
		CommonParts partie = new CommonParts();
		Right right = new Right();
		Case[][] reverseTable = partie.createWorkTable();
		tableau=table;
		GWT.log("Up.goUp()");
		
		int l;
		int m = tableau.length-1; 
			
		for (int i = 0; i < tableau.length; i++) {
			l=0;
			for (int j = 0; j < tableau.length; j++) {
				reverseTable[l][m].setText(tableau[i][j].getText());
				l++;
			}	
			m--;
		}

		reverseTable=right.goRight(reverseTable);

		l = 0;	
		for (int i = 0; i < tableau.length; i++) {
			m = tableau.length-1;
			for (int j = 0; j < tableau.length; j++) {
				tableau[m][l].setText(reverseTable[i][j].getText());
				m--;
			}		
			l++;
		}				
		return tableau;	
	}	
}

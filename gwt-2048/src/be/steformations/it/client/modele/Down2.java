package be.steformations.it.client.modele;

import com.google.gwt.core.shared.GWT;

import be.steformations.it.client.ui.widget.Case;

public class Down2 {

	private Case[][] tableau;
	private CommonParts common = new CommonParts();
	
	public Case[][] goDown(Case[][] table){
		
		tableau=table;
		GWT.log("Down2.goDown()");
		//phase 1 : déplacement des cases remplies dans la table		
		tableau=moveDownIntoTable(tableau);
		
		//phase 2 : addition des valeurs similaires contigües 
		GWT.log("Down2.goDown() 2");
		for (int i = 0; i < tableau.length; i++) {
			for (int j = tableau.length-1; j >= 1; j--) {
				Case cellule = tableau[j][i];
				if (cellule.getText().equals(tableau[j-1][i].getText()) && !cellule.getText().equals("")) {
					cellule.setText(common.valueAddition(tableau[j][i]).getText());
					tableau[j-1][i].setText("");	
				}	
			}
		}

		//phase 3 : déplacement des cases remplies dans la table après addition
		GWT.log("Down2.goDown() 3");
		tableau=moveDownIntoTable(tableau);
		
		return tableau;				
	}
	
	private Case[][] moveDownIntoTable(Case[][] table){
		Case[][] tableau = table;
		Case[][] workTable = common.createWorkTable(); 
		
		//phase A : déplacement des cases remplies dans la workTable		
		for (int i = 0; i < tableau.length; i++) {
			for (int j = tableau.length-1; j >= 0; j--) {
				int ligne = tableau.length-1;
				Case cellule = tableau[j][i];	
				if (!cellule.getText().equals("")) {				
					boolean move = false;
					while ((!move) && ligne>=0) {
						if (workTable[ligne][i].getText().equals("")) {							
							workTable[ligne][i].setText(cellule.getText());							
							cellule.setText("");
							ligne--;
							move = true;
						} else {
							ligne--;	
						}
					}
				}
			}

		}
		//phase B : réécriture de la table sur base du contenu de la workTable
		for (int i = 0; i < workTable.length; i++) {
			for (int j = 0; j < workTable.length; j++) {
				tableau[j][i].setText(workTable[j][i].getText());
			}
		}
		return tableau;	
	}	
	
	
}

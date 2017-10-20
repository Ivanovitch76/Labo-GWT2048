package be.steformations.it.client.modele;

import com.google.gwt.core.client.GWT;

import be.steformations.it.client.ui.widget.Case;

public class Right {
	
	private Case[][] tableau;
	private CommonParts common = new CommonParts();
	
	public Case[][] goRight(Case[][] table){
		
		tableau=table;
		//phase 1 : déplacement des cases remplies dans la table		
		tableau=moveRightIntoTable(tableau);
		
		//phase 2 : addition des valeurs similaires contigües 
		for (int i = 0; i < tableau.length; i++) {
			for (int j = tableau.length-1; j >= 1; j--) {
				Case cellule = tableau[i][j];
				if (cellule.getText().equals(tableau[i][j-1].getText()) && !cellule.getText().equals("")) {
					cellule.setText(common.valueAddition(tableau[i][j]).getText());
					tableau[i][j-1].setText("");	
				}	
			}
		}

		//phase 3 : déplacement des cases remplies dans la table après addition
		tableau=moveRightIntoTable(tableau);
		
		return tableau;				
	}
	
	private Case[][] moveRightIntoTable(Case[][] table){
		Case[][] tableau = table;
		Case[][] workTable = common.createWorkTable(); 
		
		//phase A : déplacement des cases remplies dans la workTable		
		for (int i = 0; i < tableau.length; i++) {
			for (int j = tableau.length-1; j >= 0; j--) {
				int col = tableau.length-1;
				Case cellule = tableau[i][j];	
				if (!cellule.getText().equals("")) {				
					boolean move = false;
					while ((!move) && col>=0) {
						if (workTable[i][col].getText().equals("")) {							
							workTable[i][col].setText(cellule.getText());							
							cellule.setText("");
							col--;
							move = true;
						} else {
							col--;	
						}
					}
				}
			}

		}
		//phase B : réécriture de la table sur base du contenu de la workTable
		for (int i = 0; i < workTable.length; i++) {
			for (int j = 0; j < workTable.length; j++) {
				tableau[i][j].setText(workTable[i][j].getText());
			}
		}
		return tableau;	
	}	

}

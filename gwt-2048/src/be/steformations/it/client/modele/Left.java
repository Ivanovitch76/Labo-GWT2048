package be.steformations.it.client.modele;

import com.google.gwt.core.client.GWT;

import be.steformations.it.client.ui.widget.Case;

public class Left {
	
	private Case[][] tableau;
	private CommonParts common = new CommonParts();
	
	public Case[][] goLeft(Case[][] table){

		tableau = table; 

		//phase 1 : d�placement des cases remplies dans la table	
		tableau=moveLeftIntoTable(tableau);
		
		//phase 2 : addition des valeurs similaires contig�es 
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau.length-1; j++) {
				Case cellule = tableau[i][j];
				if (cellule.getText().equals(tableau[i][j+1].getText()) && !cellule.getText().equals("")) {
					cellule.setText(common.valueAddition(tableau[i][j]).getText());
					tableau[i][j+1].setText("");	
				}	
			}
		}
		
		//phase 1 : d�placement des cases remplies dans la table apr�s addition
		tableau=moveLeftIntoTable(tableau);	
		
		return tableau;
				
	}
	
	private Case[][] moveLeftIntoTable(Case[][] table){
		Case[][] tableau = table;
		Case[][] workTable = common.createWorkTable(); 
		//phase A : d�placement des cases remplies dans la workTable		
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau.length; j++) {
				int col = 0;
				Case cellule = tableau[i][j];	
				if (!cellule.getText().equals("")) {				
					boolean move = false;
					while ((!move) && col < tableau.length) {
						if (workTable[i][col].getText().equals("")) {							
							workTable[i][col].setText(cellule.getText());
							
							cellule.setText("");
							col++;
							move = true;
						} else {
							col++;	
						}
					}
				}
			}

		}
		
		//phase B : r��criture de la table sur base du contenu de la workTable
		for (int i = 0; i < workTable.length; i++) {
			for (int j = 0; j < workTable.length; j++) {
				tableau[i][j].setText(workTable[i][j].getText());
			}
		}
		return tableau;	
	}	

}

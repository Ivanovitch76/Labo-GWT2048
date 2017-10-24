package be.steformations.it.client.modele;

import com.google.gwt.core.shared.GWT;

import be.steformations.it.client.ui.widget.Case;

public class Up3 {
//
//	private Case[][] tableau;
//	private CommonParts common = new CommonParts();
//	
//	public Case[][] goUp(Case[][] table){
//		
//		tableau=table;
//		GWT.log("Up2.goUp()");
//		//phase 1 : déplacement des cases remplies dans la table		
//		tableau=moveUpIntoTable(tableau);
//		
//		//phase 2 : addition des valeurs similaires contigües 
//		for (int i = 0; i < tableau.length; i++) {
//			for (int j = 0; j < tableau.length-1; j++) {
//				int ligne = 0;
//				boolean move = false;
//				if (!table[j][i].getText().equals("")){
//					
//				}
//				while (ligne < tableau.length){
//					if (ligne == 0){
//					
//				}
//				
//					
//				}
//				if (tableau[ligne][i].getText().equals("")) 
//				if (tableau[j][i].getText().equals(tableau[j+1][i].getText()) && !cellule.getText().equals("")) {
//					cellule.setText(common.valueAddition(tableau[j][i]).getText());
//					tableau[j+1][i].setText("");	
//				}	
//			}
//		}
//		
//		for (int i = 0; i < tableau.length; i++) {
//			for (int j = 0; j < tableau.length; j++) {
//				int ligne = 0;
//				Case cellule = tableau[j][i];	
//				if (!cellule.getText().equals("")) {				
//					boolean move = false;
//					while ((!move) && ligne < tableau.length) {
//						if (workTable[ligne][i].getText().equals("")) {							
//							workTable[ligne][i].setText(cellule.getText());							
//							cellule.setText("");
//							ligne++;
//							move = true;
//						} else {
//							ligne++;	
//						}
//					}
//				}
//			}
//
//		}
//
//		//phase 3 : déplacement des cases remplies dans la table après addition
//		tableau=moveUpIntoTable(tableau);
//		
//		return tableau;				
//	}
//	
//	private Case[][] moveUpIntoTable(Case[][] table){
//		Case[][] tableau = table;
//		Case[][] workTable = common.createWorkTable(); 
//		
//		//phase A : déplacement des cases remplies dans la workTable		
//
//		//phase B : réécriture de la table sur base du contenu de la workTable
//		for (int i = 0; i < workTable.length; i++) {
//			for (int j = 0; j < workTable.length; j++) {
//				tableau[j][i].setText(workTable[j][i].getText());
//			}
//		}
//		return tableau;	
//} 
	
}

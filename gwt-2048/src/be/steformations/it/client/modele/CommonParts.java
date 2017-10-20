package be.steformations.it.client.modele;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Random;

import be.steformations.it.client.ui.widget.Case;

public class CommonParts {

	private Case[][] table;
	
	public Case[][] addNewRandom(Case[][] table){
		this.table = table;
		boolean alim = false;
		int count = 0;
		for (int l = 0; l < table.length; l++) {
			for (int c = 0; c < table.length; c++) {
				if (!table[l][c].getText().equals("")){
					count++;
				}
			}
		}
		GWT.log("count: " + count);
		if (count < 16){
			while (!alim){
				int r = Random.nextInt(4); 
				int s = Random.nextInt(4); 
				GWT.log("addNewRandom() r=" + r + " ,s=" + s);
				if (table[r][s].getText().equals("")){
					int rng = Random.nextInt(4);
					if (rng==1){
						table[r][s].setText("4");
					} else {
						table [r][s].setText("2");
					}
					alim = true;
				}	
			}
		}
		return this.table;
		
	}
	
	public Case valueAddition(Case cellule) {
		GWT.log("Grille.valueAddition()");
		Case cell = cellule;
		switch (cell.getText()) {
		case "4":
			cell.setText("8");
			break;
		case "8":
			cell.setText("16");
			break;
		case "16":
			cell.setText("32");
			break;
		case "32":
			cell.setText("64");
			break;
		case "64":
			cell.setText("128");
			break;
		case "128":
			cell.setText("256");
			break;
		case "256":
			cell.setText("512");
			break;
		case "512":
			cell.setText("1024");
			break;
		case "1024":
			cell.setText("2048");
			break;
		case "2048":
			cell.setText("4096");
			break;
		default:
			cell.setText("4");
			break;
		}
		return cell;
		
	}
	

	public Case[][] createWorkTable() {
		Case [][]workTable = new Case[4][4];
		for (int i = 0; i < workTable.length; i++) {
			for (int j = 0; j < workTable.length; j++) {
				Case cellule = new Case();
				cellule.setText("");			
				workTable[i][j] = cellule;
			}
		}
		return workTable;		
	}
	
}

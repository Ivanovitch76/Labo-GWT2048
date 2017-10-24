package be.steformations.it.client.ui.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Random;

import be.steformations.it.client.event.EventManager;
import be.steformations.it.client.event.direction.DirectionEvent;
import be.steformations.it.client.event.direction.DirectionEventManager;
import be.steformations.it.client.event.load.LoadEvent;
import be.steformations.it.client.event.load.LoadEventManager;
import be.steformations.it.client.event.reset.ResetEvent;
import be.steformations.it.client.event.reset.ResetEventManager;
import be.steformations.it.client.event.result.ResultEvent;
import be.steformations.it.client.event.result.ResultEventManager;
import be.steformations.it.client.event.save.SaveEvent;
import be.steformations.it.client.event.save.SaveEventManager;
import be.steformations.it.client.http.Loader;
import be.steformations.it.client.http.Saver;
import be.steformations.it.client.modele.CommonParts;
import be.steformations.it.client.modele.Down;
import be.steformations.it.client.modele.Down2;
import be.steformations.it.client.modele.Left;
import be.steformations.it.client.modele.Right;
import be.steformations.it.client.modele.Up;
import be.steformations.it.client.modele.Up2;
import be.steformations.it.client.modele.Up3;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRow;

public class Grille extends MaterialPanel implements DirectionEventManager, ResetEventManager, SaveEventManager, LoadEventManager, ResultEventManager{
	private Case[][] table = new Case[4][4];
	private String fusion = new String();

	public Grille() {
		super();
		GWT.log("Grille.Grille()");
		int r = Random.nextInt(4); 
		int s = Random.nextInt(4); 
		int t = Random.nextInt(4); 
		int u = Random.nextInt(4);
		while (r==t && s==u){
			int v = Random.nextInt(4); 
			int w = Random.nextInt(4);
			t = v;
			u = w;
		}
		
		for (int i = 0; i < table.length; i++) {
			MaterialRow ligne = new MaterialRow();
			for (int j = 0; j < table.length; j++) {
				MaterialColumn colonne = new MaterialColumn();
				Case cellule = new Case();
				colonne.add(cellule);
				ligne.add(colonne);
				if(i==r && j==s){ 
					cellule.setText("2"); 
				} 
				if(i==t && j==u){ 
					cellule.setText("2"); 
				}
				
				table[i][j] = cellule;
			}
			add(ligne);
		}

		fusion=arrayToString(table);

		EventManager.getInstance().addHandler(DirectionEvent.type, this);
		EventManager.getInstance().addHandler(ResetEvent.type, this);
		EventManager.getInstance().addHandler(SaveEvent.type, this);
		EventManager.getInstance().addHandler(LoadEvent.type, this);
		EventManager.getInstance().addHandler(ResultEvent.type, this);
		
	}

	@Override
	public void onDirection(DirectionEvent event) {
		Right right = new Right();
		Left left = new Left();
		Up3 up = new Up3();
		Down2 down = new Down2();
		CommonParts common = new CommonParts();
		String direction = event.getDirection();
		switch (direction) {
		case "up":
			table=up.goUp(table);
			table=common.addNewRandom(table);
			fusion=arrayToString(table);
			break;
		case "down":
			table=down.goDown(table);
			table=common.addNewRandom(table);
			fusion=arrayToString(table);
			break;
		case "right":
			table=right.goRight(table);
			table=common.addNewRandom(table);
			fusion=arrayToString(table);
			break;
		default:
			table=left.goLeft(table);
			table=common.addNewRandom(table);
			fusion=arrayToString(table);
			break;
		}
	}

	@Override
	public void onReset(ResetEvent event) {
		GWT.log("Grille.onReset()");
		int r = Random.nextInt(4); 
		int s = Random.nextInt(4); 
		int t = Random.nextInt(4); 
		int u = Random.nextInt(4);
		while (r==t && s==u){
			int v = Random.nextInt(4); 
			int w = Random.nextInt(4);
			t = v;
			u = w;
		}
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				table[i][j].setText("");
				if(i==r && j==s){ 
					table[i][j].setText("2"); 
				} 
				if(i==t && j==u){ 
					table[i][j].setText("2"); 
				}
			}
		}
		
	}
	
	public String arrayToString(Case[][] a) {
		String fusion = new String();
	    if (a == null)
	        return "null";

	    int iMax = a.length - 1;
	    int jMax = a.length - 1;
	    if (iMax == -1)
	        return "";

	    StringBuilder b = new StringBuilder();
	    for (int i = 0; i < a.length; i++) {
	    	for (int j = 0; j < a.length; j++) {
		        b.append(a[i][j].getText());
		        if (i==iMax && j == jMax){
		        	b.append(",x");
		        } else {
		        	b.append(",");	
		        }	
	    	}    
	    }
	    fusion = b.toString();
	    return fusion;
	}

	@Override
	public void onSave(SaveEvent event) {
		GWT.log("Grille.onSave()");
		Saver saver = new Saver();
		String id = event.getId();

		saver.onTransfert(id, fusion);
		
	}
	
	@Override
	public void onLoad(LoadEvent event) {
		Loader loader = new Loader();
		String id = event.getId();

		loader.onTransfert(id);
		
	}

	@Override
	public void onResult(ResultEvent event) {
		GWT.log("Grille.onResult()");
		table = stringToArray(event.getGrid(), table);
	}

	private Case[][] stringToArray(String grid, Case[][] tab) {
		Case[][] tableau = tab;
		String[] cell = grid.split(",");
		int k = 0;
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau.length; j++) {
				tableau[i][j].setText(cell[k]);	
				k++;
			}
		}
		return tableau;
	}


}

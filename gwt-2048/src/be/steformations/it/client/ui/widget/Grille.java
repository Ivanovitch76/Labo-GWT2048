package be.steformations.it.client.ui.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Random;

import be.steformations.it.client.event.EventManager;
import be.steformations.it.client.event.direction.DirectionEvent;
import be.steformations.it.client.event.direction.DirectionEventManager;
import be.steformations.it.client.event.reset.ResetEvent;
import be.steformations.it.client.event.reset.ResetEventManager;
import be.steformations.it.client.modele.CommonParts;
import be.steformations.it.client.modele.Down;
import be.steformations.it.client.modele.Left;
import be.steformations.it.client.modele.Right;
import be.steformations.it.client.modele.Up;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRow;

public class Grille extends MaterialPanel implements DirectionEventManager, ResetEventManager{
	private Case[][] table = new Case[4][4];

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

		EventManager.getInstance().addHandler(DirectionEvent.type, this);
		EventManager.getInstance().addHandler(ResetEvent.type, this);
		
	}

	@Override
	public void onDirection(DirectionEvent event) {
		GWT.log("Grille.onDirection()");
		Right right = new Right();
		Left left = new Left();
		Up up = new Up();
		Down down = new Down();
		CommonParts common = new CommonParts();
		String direction = event.getDirection();
		switch (direction) {
		case "up":
			table=up.goUp(table);
			table=common.addNewRandom(table);
			break;
		case "down":
			table=down.goDown(table);
			table=common.addNewRandom(table);
			break;
		case "right":
			table=right.goRight(table);
			table=common.addNewRandom(table);
			break;
		default:
			table=left.goLeft(table);
			table=common.addNewRandom(table);
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

}

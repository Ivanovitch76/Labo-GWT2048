package be.steformations.it.server;

import be.steformations.it.client.http.Game;

public class JpaManageGame {

	protected javax.persistence.EntityManager em;
	
	public JpaManageGame() {
		super();
		System.out.println("JpaManageGame.JpaManageGame()");
		this.em = javax.persistence.Persistence.createEntityManagerFactory("postgresql_eclipselink").createEntityManager();
	}
	
	public Game getGameById(String id){
		return this.em.find(Game.class, id);		
	}
	
	public Game addGame(String id, String grid){
		System.out.println("JpaManageGame.addGame()");
		Game game = new Game();
		if (id != null && grid != null){
			System.out.println("ça coule direct");
			game.setId(id);
			game.setGrid(grid);
			if (this.em.isJoinedToTransaction()){
				this.em.persist(game);
			} else {
				this.em.getTransaction().begin();
				this.em.persist(game);
				this.em.getTransaction().commit();
			}			
		}
		return game;
	}
}

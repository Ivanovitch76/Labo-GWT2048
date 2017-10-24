package be.steformations.it.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.steformations.it.client.http.Game;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/json/service")
public class Game2048Service extends HttpServlet{

	private com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
	JpaManageGame manager = new JpaManageGame();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Game2048Service.doPost()");
		Game game = this.mapper.readerFor(Game.class).readValue(req.getInputStream());
		resp.setContentType("text/plain");
		resp.getWriter().write("OK");
		manager.addGame(game.getId(), game.getGrid());
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Game2048Service.doGet()");
		String id = req.getParameter("id");	
		Game game = manager.getGameById(id);
		
		resp.setContentType("text/plain");
		System.out.println("Game2048 => grid: " + game.getGrid());
		resp.getWriter().write(game.getGrid());
	}
	
	
	
	
	
}

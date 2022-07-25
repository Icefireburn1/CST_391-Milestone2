package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.gcu.services.GameDAO;

// Handles our URL directs to our Views
@Controller
public class GameController {
	
	private final GameDAO gameService;
	
	public GameController(GameDAO gameService) {
		this.gameService = gameService;
	}
	
	// Landing page
	@GetMapping("/")
	public String home(Model model) {
		return "home";
	}
	
	// Loads games into list
	@GetMapping("/games")
	public String findGames(Model model) {
		var games = gameService.GetAll();
		
		model.addAttribute("games", games);

		return "games";
	}
}

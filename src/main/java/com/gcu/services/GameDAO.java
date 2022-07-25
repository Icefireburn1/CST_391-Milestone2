package com.gcu.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gcu.repository.GameRepository;
import com.gcu.model.GameModel;

// Handles the logic from our repository
// Simplifies the code when using the GameDAO to access the database
@Service
public class GameDAO {

	private final GameRepository repository;
	
	public GameDAO(GameRepository repository) {
		this.repository = repository;
	}
	
	// Creates game in database
	public GameModel Create(GameModel game) {

		return repository.save(game);
	}

	// Gets all games in database
	public List<GameModel> GetAll() {

		return (List<GameModel>) repository.findAll();
	}

	// Edits an existing game in the database
	public GameModel Update(long id, GameModel game) {
		
		GameModel gameDB = (GameModel) repository.findById(id).get();
		
		// Make sure our object exists then ignore its case
		if (Objects.nonNull(game.getTitle()) && !"".equalsIgnoreCase(game.getTitle())) {
			gameDB.setTitle((game.getTitle()));
		}
		
		if (Objects.nonNull(game.getGenre()) && !"".equalsIgnoreCase(game.getGenre())) {
			gameDB.setGenre((game.getGenre()));
		}

		if (Objects.nonNull(game.getCost())) {
			gameDB.setCost((game.getCost()));
		}
		
		
		return repository.save(gameDB);
	}

	// Delete a game in the database
	public void Delete(long id) {
		repository.deleteById(id);
	}

	// Gets a single game from the database
	public Optional<GameModel> Get(long id) {
		Optional<GameModel> game = repository.findById(id);
		return game;
	}

}

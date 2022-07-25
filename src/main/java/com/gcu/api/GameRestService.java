package com.gcu.api;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.GameDTO;
import com.gcu.model.GameModel;
import com.gcu.services.GameDAO;

// Manages the routes for our REST API
@RestController
@RequestMapping("/service")
public class GameRestService {
	
	@Autowired
	GameDAO service;
	
	@Autowired
	private ModelMapper modelMapper; // Utilizes our DTO
	
	// Read All
	@GetMapping(path="/games")
	public ResponseEntity<?> getGames()
	{
		try
		{
			List<GameModel> games = service.GetAll();
			
			// Convert to DTO
			List<GameDTO> gamesDTO = new ArrayList<GameDTO>();
			for (GameModel game : games) 
			{
				GameDTO item = modelMapper.map(game, GameDTO.class);
				gamesDTO.add(item);
			}
			
			if (games == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(gamesDTO, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Read Single
	@GetMapping(path="/games/{id}")
	public ResponseEntity<?> getGame(@PathVariable("id") long gameID)
	{
		try
		{
			GameModel gameModel = service.Get(gameID).get();
			GameDTO dto = modelMapper.map(gameModel, GameDTO.class); // Convert to DTO
			if (gameModel != null)
			{
				return new ResponseEntity<>(dto, HttpStatus.OK);
			}
			else 
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	// Update
	@PutMapping(path="/games/{id}")
	public ResponseEntity<?> updateGame(@RequestBody GameModel game, @PathVariable("id") long gameID)
	{
		GameModel gameModel = service.Update(gameID, game);
		GameDTO dto = modelMapper.map(gameModel, GameDTO.class); // Convert to DTO
		if (gameModel != null)
		{
			return new ResponseEntity<>(dto, HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Save
	@PostMapping(path="/games", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addGame(@RequestBody GameModel game)
	{
		GameModel gameModel = service.Create(game);
		GameDTO dto = modelMapper.map(gameModel, GameDTO.class); // Convert to DTO
		if (gameModel != null)
		{
			return new ResponseEntity<>(dto, HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Delete
	@DeleteMapping(path="/games/{id}")
	public ResponseEntity<?> deleteGame(@PathVariable("id") long gameID)
	{
		try
		{
			service.Delete(gameID);
			return new ResponseEntity<>("Game deleted", HttpStatus.ACCEPTED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
}

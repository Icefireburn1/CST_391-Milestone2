package com.gcu.interfaces;

import java.util.List;
import java.util.Optional;

import com.gcu.model.GameModel;

public interface DataAccessInterface {
	public GameModel Create(GameModel game);
	public List<GameModel> GetAll();
	public GameModel Update(long id, GameModel game);
	public void Delete(long id);
	public Optional<GameModel> Get(long id);
}

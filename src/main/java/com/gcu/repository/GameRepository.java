package com.gcu.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcu.model.GameModel;

@Repository
public interface GameRepository extends CrudRepository<GameModel, Long> {

}

package com.gcu.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class GameModel {
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public GameModel(int id, String genre, float cost) {
		this.id = id;
		this.genre = genre;
		this.cost = cost;
	}
	
	public GameModel() {};

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String genre;
	private float cost;
}

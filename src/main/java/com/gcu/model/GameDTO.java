package com.gcu.model;

public class GameDTO {
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	private String title;
	private String genre;
	private float cost;

	
	public GameDTO(GameModel gm) {
		this.title = gm.getTitle();
		this.genre = gm.getGenre();
		this.cost = gm.getCost();
	}
	
	public GameDTO() {};
	
	public GameDTO(String title, String genre, float cost) {
		this.title = title;
		this.genre = genre;
		this.cost = cost;
	}
}

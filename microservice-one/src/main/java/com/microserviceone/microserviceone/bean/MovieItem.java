package com.microserviceone.microserviceone.bean;

public class MovieItem {
	
	private String movieId;
	private String movieName;
	
	public MovieItem() {
		
	}
	public MovieItem(String movieId, String movieName) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	
	
	

}

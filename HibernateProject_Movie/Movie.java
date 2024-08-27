package com.jsp.hsl.sample.HibernateProject_movieHQL_SQL.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Movie {
	@Id
	private int movieId;
	private String movieName;
	private String genre;
	private String director;
	private int boxOfficeCollection;
	private String boxOficeVerdict;
	
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getBoxOfficeCollection() {
		return boxOfficeCollection;
	}
	public void setBoxOfficeCollection(int boxOfficeCollection) {
		this.boxOfficeCollection = boxOfficeCollection;
	}
	public String getBoxOficeVerdict() {
		return boxOficeVerdict;
	}
	public void setBoxOficeVerdict(String boxOficeVerdict) {
		this.boxOficeVerdict = boxOficeVerdict;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", genre=" + genre + ", director=" + director
				+ ", boxOfficeCollection=" + boxOfficeCollection + ", boxOficeVerdict=" + boxOficeVerdict + "]";
	}
	
	
}

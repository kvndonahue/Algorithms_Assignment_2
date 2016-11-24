package models;

import java.util.List;

public class Movie {

	int movieId;
	String movieName;
	String releaseDate;
	String URL;
	List<String> genres;
	
	public Movie(int movieID, String movieName, String releaseDate, String URL, List<String> genres) {
		if(movieName == null || movieName.isEmpty())
			throw new IllegalArgumentException();
		this.movieName = movieName;
		if(URL == null || URL.isEmpty())
			throw new IllegalArgumentException();
		this.URL = URL;
		if(releaseDate == null || releaseDate.isEmpty())
			throw new IllegalArgumentException();
		this.releaseDate = releaseDate;
		setMovieId(movieID);
		this.genres = genres;
		
	}

	public List<String> getGenres() {
		return genres;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		if(movieId < 0)
			throw new IllegalArgumentException();
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	@Override
	public String toString() {
		String returnString =  "Movie [movieId=" + movieId + ", movieName=" + movieName + ", releaseDate=" + releaseDate + ", URL="
				+ URL + ", genres=";
		for(String genre : genres)
			returnString+= genre + ", ";
		return returnString+"]";
	}
	
	

}

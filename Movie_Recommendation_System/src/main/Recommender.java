package main;

import java.util.List;

import models.Movie;
import models.Rating;
import models.User;
import util.Load;

public class Recommender implements RecommenderAPI{

	private List<User> users;
	private List<Movie> movies;
	private List<Rating> ratings;
	
	public Recommender()
	{
		Load load = new Load();
		users = load.loadUsers();
		movies = load.loadMovies();
		ratings = load.loadRatings();
		
		/*
		for(User user : users)
			System.out.println(user);
		for(Movie movie : movies)
			System.out.println(movie);
		for(Rating rating : ratings)
			System.out.println(rating);
			*/
	}
	
	public boolean addUser(String firstName, String lastName, int age, String gender, String occupation) {
		int id = users.size()+1;
		User newUser = new User(id,firstName,lastName,age,gender,occupation);
		users.add(newUser);
		return true;
	}

	public boolean removeUser(int userID) {
		users.remove(userID-1);
		return true;
	}

	public boolean addMovie(String title, String year, String url, List<String> genres) {
		int id = movies.size() + 1;
		Movie newMovie = new Movie(id,title,year,url,genres);
		movies.add(newMovie);
		return true;
	}

	public boolean addRating(int userID, int movieID, int rating) {
		
		Rating newRating = new Rating(userID,movieID,rating);
		ratings.add(newRating);
		
		return true;
	}

	public Movie getMovie(int movieID) {
		
		for(Movie movie : movies)
		{
			if(movie.getMovieId() == movieID)
				return movie;
		}
		return null;
	}

	public Rating getUserRatings(int userID) {
		
		for(Rating rating : ratings)
		{
			if(rating.getUserId() == userID)
				return rating;
		}
		return null;
	}

	public List<Movie> getUserRecommendations(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Movie> getTopTenMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	public void load() {
		// TODO Auto-generated method stub
		
	}

	public void write() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getUsers() {
		return users;
	}

	@Override
	public List<Movie> getMovies() {
		return movies;
	}

	@Override
	public List<Rating> getRatings() {
		return ratings;
	}

}

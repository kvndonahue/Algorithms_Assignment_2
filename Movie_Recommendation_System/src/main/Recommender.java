package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import models.Movie;
import models.Rating;
import models.User;
import util.Load;
import util.RatingComparator;
import util.SerializerAPI;

public class Recommender implements RecommenderAPI{

	private List<User> users;
	private List<Movie> movies;
	private List<Rating> ratings;
	private SerializerAPI serializer;
	
	public Recommender(SerializerAPI serializer, boolean hasFile)
	{
		this.serializer = serializer;
		if(hasFile)
		{
			try
			{
				load();
			}catch(Exception e)
			{
				System.err.println("Couldn't load the file items");
			}
		}
		else
		{
			Load load = new Load();
			users = load.loadUsers("data/users.dat");
			movies = load.loadMovies("data/items.dat");
			ratings = load.loadRatings("data/ratings.dat");
		}
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
		
		List<Movie> userRec = new ArrayList<Movie>();
		for(Rating rating : ratings)
		{
			if(rating.getRating()>4)
			{
				if(rating.getUserId() != userID)
				{
					userRec.add(movies.get(rating.getMovieId()+1));
				}
			}
			if(userRec.size() >= 10)
				break;
		}
		return userRec;
	}

	public List<Movie> getTopTenMovies() {
		
		List<Movie> topTen = new ArrayList<Movie>();
		Collections.sort(ratings,new RatingComparator());
		
		for(Rating rating : ratings)
		{
			Movie ratingMovie = movies.get(rating.getMovieId()-1);
			topTen.add(ratingMovie);
			if(topTen.size() >= 10)
				break;
		}
		return topTen;
		
	}

	@SuppressWarnings("unchecked")
	public void load() throws Exception {
		//Reads in the stack from XML
		serializer.read();
	    users = (List<User>) serializer.pop();
	    movies      = (List<Movie>)   serializer.pop();
	    ratings       = (List<Rating>)     serializer.pop();
		
	}

	public void write() throws Exception {
		serializer.push(ratings);
	    serializer.push(movies);
	    serializer.push(users);
	    //Writes the stack to XML
	    serializer.write(); 
		
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

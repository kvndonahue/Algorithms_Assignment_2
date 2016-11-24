package main;

import java.util.List;

import models.Movie;
import models.Rating;
import util.Load;

public class Recommender implements RecommenderAPI{

	public Recommender()
	{
		Load load = new Load();
	}
	
	@Override
	public boolean addUser(String firstName, String lastName, int age, String gender, String occupation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeUser(int userID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addMovie(String title, String year, String url) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addRating(int userID, int movieID, int rating) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Movie getMovie(int movieID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating getUserRatings(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getUserRecommendations(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getTopTenMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}

}

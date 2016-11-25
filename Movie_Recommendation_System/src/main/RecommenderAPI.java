package main;

import java.util.List;

import models.Movie;
import models.Rating;
import models.User;

public interface RecommenderAPI {
	
	/**
	 * Returns all users
	 * @return
	 */
	List<User> getUsers();
	
	/**
	 * Returns all movies
	 * @return
	 */
	List<Movie> getMovies();
	
	/**
	 * Returns all ratings
	 * @return
	 */
	List<Rating> getRatings();
	
	/**
	 * Adds a new User
	 * 
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param gender
	 * @param occupation
	 * @return
	 */
	boolean addUser(String firstName,String lastName,int age,String gender,String occupation);
	
	/**
	 * Removes a user by ID
	 * @param userID
	 * @return
	 */
	boolean removeUser(int userID);
	
	/**
	 * Adds a movie
	 * @param title
	 * @param year
	 * @param url
	 * @return
	 */
	boolean addMovie(String title, String year, String url,List<String> genres);
	
	/**
	 * Adds a rating
	 * @param userID
	 * @param movieID
	 * @param rating
	 * @return
	 */
	boolean addRating(int userID, int movieID, int rating);
	
	/**
	 * Gets a movie by Id
	 * @param movieID
	 * @return
	 */
	Movie getMovie(int movieID);
	
	/**
	 * Gets users rating by Id
	 * @param userID
	 * @return
	 */
	Rating getUserRatings(int userID);
	
	/**
	 * Gets users recommendations
	 * @param userID
	 * @return
	 */
	List<Movie> getUserRecommendations(int userID);
	
	/**
	 * Gets top ten movies
	 * @return
	 */
	List<Movie> getTopTenMovies();
	
	/**
	 * Loads XML save file
	 * @throws Exception 
	 */
	void load() throws Exception;
	
	/**
	 * Saves an XML save file
	 * @throws Exception 
	 */
	void write() throws Exception;
	
}

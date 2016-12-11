package util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.princeton.cs.introcs.In;
import models.Movie;
import models.Rating;
import models.User;

public class Load {
	

	private HashMap<Integer,String> genres = new HashMap<Integer,String>();
	
	public Load(){
		loadGenres();
	}
	
	public List<Rating> loadRatings(String file)
	{
		List<Rating> ratings = new ArrayList<Rating>();
		File ratingsFile = new File(file);
        In inRating = new In(ratingsFile);
          //each field is separated(delimited) by a '|'
        String delims = "[|]";
        while (!inRating.isEmpty()) {
            // get user and rating from data source
            String ratingDetails = inRating.readLine();

            // parse user details string
            String[] ratingTokens = ratingDetails.split(delims);

            // output user data to console.
            if (ratingTokens.length == 4) {
            	ratings.add(new Rating( Integer.parseInt(ratingTokens[0]) , Integer.parseInt(ratingTokens[1]) , Integer.parseInt(ratingTokens[2]) ));
            }else
            {
                try {
					throw new Exception("Invalid member length: "+ratingTokens.length);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
        
        return ratings;
	}
	
	private void loadGenres()
	{
		File genresFile = new File("data/genre.dat");
        In inGenres = new In(genresFile);
          //each field is separated(delimited) by a '|'
        String delims = "[|]";
        while (!inGenres.isEmpty()) {
            // get user and rating from data source
            String genresDetails = inGenres.readLine();

            // parse user details string
            String[] genreTokens = genresDetails.split(delims);

            // output user data to console.
            if (genreTokens.length == 2) {
            	//			This is the key number			This is the String genre value
            	genres.put(Integer.parseInt(genreTokens[1]), genreTokens[0]);
            }else
            {
                try {
					throw new Exception("Invalid member length: "+genreTokens.length);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
	}
	
	public List<User> loadUsers(String file){
		
		List<User> users = new ArrayList<User>();
	     File usersFile = new File(file);
	        In inUsers = new In(usersFile);
	          //each field is separated(delimited) by a '|'
	        String delims = "[|]";
	        while (!inUsers.isEmpty()) {
	            // get user and rating from data source
	            String userDetails = inUsers.readLine();

	            // parse user details string
	            String[] userTokens = userDetails.split(delims);

	            // output user data to console.
	            if (userTokens.length == 7) {
	                users.add(new User(Integer.parseInt(userTokens[0]),userTokens[1],userTokens[2],Integer.parseInt(userTokens[3]),userTokens[4],userTokens[5]));
	            }else
	            {
	                try {
						throw new Exception("Invalid member length: "+userTokens.length);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        }
	        
	        
	        return users;
	}
	
	public List<Movie> loadMovies(String file){
		
		List<Movie> movies = new ArrayList<Movie>();
	     File movieFile = new File(file);
	        In inMovies = new In(movieFile);
	          //each field is separated(delimited) by a '|'
	        String delims = "[|]";
	        while (!inMovies.isEmpty()) {
	            // get user and rating from data source
	            String movieDetails = inMovies.readLine();

	            // parse user details string
	            String[] movieTokens = movieDetails.split(delims);

	            // output user data to console.
	            if (movieTokens.length == 23) {
	            	
	            	//Movie specific genres list which is going to be passed into the newMovie constructor 
	            	List<String> genresList = new ArrayList<String>();
	            	
	            	
	            	
	            	
	            	//Loops over the genre 1's and 0's, which start at index 4
	            	for(int i=4;i<23;i++)
	            	{
	            		//If the genre is 1, then enter, if 0 then ignore
	            		boolean checkGenre = convertIntToBool(Integer.parseInt(movieTokens[i]));
	            		
	            		if(checkGenre)
	            		{
	            			//This pushes the item line back by 4
	            			//Since we start at index 4, and the genres HashMap starts at 0, we subtract 4
	            			int genreKey = i-4;
	            			
	            			//Getting the String genre from the HashMap at genreKey
	            			String genre = genres.get(genreKey);
	            			
	            			//Adds the String genre to our genres List which will go to our movie
	            			genresList.add(genre);
	            		}
	            	}
	            	
	            	
	            	
	            	
	            	//Make a new Movie object, with its own Id, title, date, url and genre List
	            	Movie newMovie;
	            	try
	            	{
	            		newMovie = new Movie(Integer.parseInt(movieTokens[0]),movieTokens[1],movieTokens[2],movieTokens[3],genresList);
	            		//Add the new Movie we made to the movies List
		            	movies.add(newMovie); 
	            	}catch(IllegalArgumentException e)
	            	{
	            		System.out.println("The Movie with ID "+movieTokens[0] + " Could Not Be Loaded Due To Incorrect Data In The File.");
	            	}
	                
	            	
	                
	            }else
	            {
	                try {
						throw new Exception("Invalid member length: "+movieTokens.length);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        }
	        
	        
	        return movies;
	}
	
	private boolean convertIntToBool(int i)
	{
		if(i == 1)
			return true;
		return false;
	}

	
	
}

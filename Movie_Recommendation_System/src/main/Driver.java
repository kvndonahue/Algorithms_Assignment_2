package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Movie;
import models.Rating;
import models.User;
import util.Serializer;
import util.SerializerAPI;

public class Driver {

	private Scanner input;
	private RecommenderAPI recommender;
	
	public static void main(String[] args){
		new Driver();
	}
	
	public Driver(){
		File  datastore = new File("datastore.xml");
		SerializerAPI serializer = new Serializer(datastore);
		recommender = new Recommender(serializer,datastore.isFile());
		input = new Scanner(System.in);
		runMenu();
	}
	
	public int showMenu()
	{
		System.out.println("\nMOVIE RECOMMENDATION SYSTEM:\n");
		System.out.println("1) Show all Users");
		System.out.println("2) Show all Movies");
		System.out.println("3) Show all Ratings");
		System.out.println("4) Add a New User");
		System.out.println("5) Remove a User");
		System.out.println("6) Add a New Movie");
		System.out.println("7) Add a New Rating");
		System.out.println("8) Get a Movie by ID");
		System.out.println("9) Get a User's Ratings");
		System.out.println("10) Get Top Ten Movies");
		System.out.println("0) Exit");
		System.out.print(">> ");
		
		return input.nextInt();
	}
	
	public void runMenu()
	{
		int choice = showMenu();
		while(choice != 0)
		{
			switch(choice)
			{
			case 1:
				showAllUsers();
				break;
			case 2:
				showAllMovies();
				break;
			case 3:
				showAllRatings();
				break;
			case 4:
				addUser();
				break;
			case 5:
				removeUser();
				break;
			case 6:
				addMovie();
				break;
			case 7:
				addRating();
				break;
			case 8:
				getMovieById();
				break;
			case 9:
				getUserRatings();
				break;
			case 10:
				getTopTen();
				break;
			default:
				System.out.println("Error On Input");
				break;
			}
			
			input.nextLine(); //Scanner bug fix
			choice = showMenu();
		}
		
		try {
			recommender.write();
		} catch (Exception e) {
			System.err.println("Couldn't Write The File");
			e.printStackTrace();
		}
		System.out.println("Exiting ... ");
		System.exit(0);
	}

	private void getTopTen() {
		for(Movie movie : recommender.getTopTenMovies())
			System.out.println(movie);
		
	}

	private void showAllUsers() {
		for(User user : recommender.getUsers())
			System.out.println(user);
		
	}

	private void showAllMovies() {
		for(Movie movie : recommender.getMovies())
			System.out.println(movie);
		
	}

	private void showAllRatings() {
		for(Rating rating : recommender.getRatings())
			System.out.println(rating);
		
	}

	private void addUser() {
		
		String firstName, lastName, gender, occupation;
		int age;
		
		System.out.print("Enter User First Name: ");
		firstName = input.next();
		System.out.print("Enter User Last Name: ");
		lastName = input.next();
		System.out.print("Enter User Age: ");
		age = input.nextInt();
		do{
			System.out.print("Enter User Gender: ");
			gender = input.next();
		}while(gender.trim().toUpperCase().charAt(0) != 'M' && gender.trim().toUpperCase().charAt(0) != 'F');
		System.out.print("Enter User Occupation: ");
		occupation = input.next();
		
		recommender.addUser(firstName, lastName, age, gender, occupation);
	}

	private void removeUser() {
		System.out.print("Enter User ID: ");
		int id = input.nextInt();
		recommender.removeUser(id);
		
	}

	private void addMovie() {
		String title, date, url , genre;
		List<String> genres = new ArrayList<String>();
		input.nextLine();//Scanner bug fix
		System.out.print("Enter Movie Title : ");
		title = input.nextLine();
		System.out.print("Enter Movie Date Of Release : ");
		date = input.next();
		System.out.print("Enter Movie IMdB URL : ");
		url = input.next();
		System.out.println("Enter Movie Genres (Press 0 when done):");
		while(true)
		{
			System.out.print("Genre : ");
			genre = input.next();
			if(genre.equals("0"))
				break;
			genres.add(genre);
		}
		
		recommender.addMovie(title, date, url, genres);
	}

	private void addRating() {
		int userId, movieId, rating;
		
		System.out.print("Enter User's ID: ");
		userId = input.nextInt();
		System.out.print("Enter Movie's ID: ");
		movieId = input.nextInt();
		System.out.print("Enter The Rating (Between -5 and 5): ");
		rating = input.nextInt();
		
		recommender.addRating(userId, movieId, rating);
		
	}

	private void getMovieById() {
		System.out.print("Enter Movie's ID: ");
		int movieId = input.nextInt();
		System.out.println(recommender.getMovie(movieId));
	}

	private void getUserRatings() {
		System.out.print("Enter User's ID: ");
		int userId = input.nextInt();
		Rating myRating = recommender.getUserRatings(userId);
		System.out.println("User: "+userId + "		Rated :"+myRating);
	}
	
	
	
	
	
}

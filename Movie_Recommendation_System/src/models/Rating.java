package models;

public class Rating {
	
	private int userId;
	private int movieId;
	private int rating;
	
	public Rating (int userId, int movieId, int rating)
	{
		if(userId < 0)
			throw new IllegalArgumentException();
		this.userId = userId;
		if(movieId < 0)
			throw new IllegalArgumentException();
		this.movieId = movieId;
		if(rating < -5 || rating > 5)
			throw new IllegalArgumentException();
		this.rating = rating;
	}

	public int getUserId() {
		return userId;
	}

	public int getMovieId() {
		return movieId;
	}

	public int getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return "User ID: " + userId + "		Movie ID: " + movieId + "		Rating: " + rating;
	}
}

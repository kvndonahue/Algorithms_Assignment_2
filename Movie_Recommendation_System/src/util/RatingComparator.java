package util;

import java.util.Comparator;

import models.Rating;

public class RatingComparator implements Comparator<Rating>{

	@Override
	public int compare(Rating thisRating, Rating thatRating) {
		return thatRating.getRating() - thisRating.getRating();
	}

}

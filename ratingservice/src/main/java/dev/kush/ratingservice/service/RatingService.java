package dev.kush.ratingservice.service;

import dev.kush.ratingservice.models.Rating;

import java.util.List;

public interface RatingService {

    // save rating
    Rating saveRating(Rating rating);

    // get rating by id
    Rating getRating(String ratingId);

    // get all ratings
    List<Rating> getAllRatings();

    List<String> getAllRatingsIdByUserId(Long userId);

    List<Rating> getAllRatingsByRatingsIds(List<String> ratingsIds);

    // TODO: update rating

    // TODO: delete rating

}

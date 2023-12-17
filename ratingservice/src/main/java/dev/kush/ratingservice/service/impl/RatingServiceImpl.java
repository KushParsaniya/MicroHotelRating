package dev.kush.ratingservice.service.impl;

import dev.kush.ratingservice.exceptions.ResourceNotFoundException;
import dev.kush.ratingservice.models.Rating;
import dev.kush.ratingservice.repositories.RatingRepository;
import dev.kush.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getRating(String ratingId) {
        return findById(ratingId);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<String> getAllRatingsIdByUserId(Long userId) {

        // map all ratings to ratingId
        List<String> ratingIds = ratingRepository.getAllRatingsIdByUserId(userId)
                .stream().map(Rating::getRatingId).toList();

        return ratingIds;
    }

    @Override
    public List<Rating> getAllRatingsByRatingsIds(List<String> ratingsIds) {
        if(ratingsIds.isEmpty()){
            return List.of();
        }

        List<Rating> ratings = ratingsIds.
                stream().map(this::findById).toList();
        return ratings;
    }

    public Rating findById(String ratingId){
        return ratingRepository.findById(ratingId).orElseThrow(
                () -> new ResourceNotFoundException("Rating with id " + ratingId + " not found.")
        );
    }

}

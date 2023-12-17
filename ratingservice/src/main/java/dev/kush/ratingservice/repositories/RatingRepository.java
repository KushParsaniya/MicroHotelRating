package dev.kush.ratingservice.repositories;

import dev.kush.ratingservice.models.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating,String> {
    List<Rating> getAllRatingsIdByUserId(Long userId);
}

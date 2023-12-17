package dev.kush.userservice.feign;

import dev.kush.userservice.models.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("RATING-SERVICE")
public interface RatingFeign {
    @GetMapping("ratings/user/{userId}")
    public List<String> getAllRatingsIdByUserId(@PathVariable Long userId);

    @PostMapping("ratings/ratingIds")
    public List<Rating> getAllRatingsByRatingsIds(@RequestBody List<String> ratingIds);
}

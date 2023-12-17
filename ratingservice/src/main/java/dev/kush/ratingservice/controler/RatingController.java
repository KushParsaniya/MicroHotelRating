package dev.kush.ratingservice.controler;

import dev.kush.ratingservice.models.Rating;
import dev.kush.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ratings")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/save")
    public Rating saveRating(@RequestBody Rating rating) {
        return ratingService.saveRating(rating);
    }

    @GetMapping("/{ratingId}")
    public Rating getRating(@PathVariable String ratingId) {
        return  ratingService.getRating(ratingId);
    }

    @GetMapping
    public List<Rating> getAllRatings(){
        return ratingService.getAllRatings();
    }

    @GetMapping("/user/{userId}")
    public List<String> getAllRatingsIdByUserId(@PathVariable Long userId){
        return ratingService.getAllRatingsIdByUserId(userId);
    }

    @PostMapping("/ratingIds")
    public List<Rating> getAllRatingsByRatingsIds(@RequestBody List<String> ratingIds){
        return ratingService.getAllRatingsByRatingsIds(ratingIds);
    }
}

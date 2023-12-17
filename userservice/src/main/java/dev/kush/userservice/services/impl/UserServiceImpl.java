package dev.kush.userservice.services.impl;

import dev.kush.userservice.exceptions.ResourceNotFoundException;
import dev.kush.userservice.feign.HotelFeign;
import dev.kush.userservice.feign.RatingFeign;
import dev.kush.userservice.models.*;
import dev.kush.userservice.repositories.UserRepository;
import dev.kush.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RatingFeign ratingFeign;
    private final HotelFeign hotelFeign;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RatingFeign ratingFeign,HotelFeign hotelFeign) {
        this.userRepository = userRepository;
        this.ratingFeign = ratingFeign;
        this.hotelFeign = hotelFeign;
    }

    @Override
    @ResponseStatus(code = HttpStatus.OK)
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long userId) {
        return findUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUsersWithDetails(Long userId) {

        User user = findUserById(userId);

        // call rating-service's getAllRatingsIdByUserId which gives all rating id related to userID
        List<String> ratingIds = ratingFeign.getAllRatingsIdByUserId(userId);

        // now call rating-service's getAllRatingsByRatingsIds which gives all
        // rating related to List of ratingsIds
        List<Rating> ratings = ratingFeign.getAllRatingsByRatingsIds(ratingIds);
        // fetch hotel ids from ratings
        List<Long> hotelIds = ratings.stream().map(Rating::hotelId).toList();

//      now get all the hotels form hotel-service
        List<Hotel> hotels = hotelFeign.getHotelsByHotelIds(hotelIds);

        // create userRatings List from hotels and ratings
        List<HotelServiceDao> userRatings = IntStream.range(0, hotels.size())
                .mapToObj(
                        index -> {
                            Rating rating = ratings.get(index);
                            Hotel hotel = hotels.get(index);
                            return new HotelServiceDao(
                                    hotel.hotelId(),
                                    hotel.name(),
                                    hotel.location(),
                                    hotel.description(),
                                    rating.rating(),
                                    rating.comment()
                            );
                        }).toList();


        user.setUserRatings(userRatings);
        return user;
    }

    // Refactored method to avoid repeating code
    private User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User with id " + userId + " not found.")
                );
    }
}

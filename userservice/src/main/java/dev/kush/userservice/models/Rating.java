package dev.kush.userservice.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public record Rating(String ratingId, Long userId, Long hotelId, Integer rating, String comment){
}

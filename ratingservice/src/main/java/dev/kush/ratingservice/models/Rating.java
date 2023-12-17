package dev.kush.ratingservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("ratings")
public class Rating {

    @Id
    private String ratingId;
    private Long userId;
    private Long hotelId;
    private Integer rating;
    private String comment;

    public Rating(Long userId, Long hotelId, Integer rating, String comment) {
        this.userId = userId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.comment = comment;
    }
}

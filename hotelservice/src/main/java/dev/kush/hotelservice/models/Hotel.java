package dev.kush.hotelservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "hotels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long hotelId;

    private String name;
    private String location;
    private String description;

    public Hotel(String name, String location, String description) {
        this.name = name;
        this.location = location;
        this.description = description;
    }
}

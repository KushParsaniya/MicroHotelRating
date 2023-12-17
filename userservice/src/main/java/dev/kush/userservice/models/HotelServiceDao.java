package dev.kush.userservice.models;

public record HotelServiceDao(
        // For hotel
        Long hotelId, String name, String location, String description,
        // For rating
        Integer rating,String comment
) {
}

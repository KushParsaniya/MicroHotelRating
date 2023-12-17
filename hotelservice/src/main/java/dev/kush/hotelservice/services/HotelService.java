package dev.kush.hotelservice.services;

import dev.kush.hotelservice.models.Hotel;

import java.util.List;

public interface HotelService {
    // save hotel
    Hotel saveHotel(Hotel hotel);

    // get hotel by id
    Hotel getHotel(Long hotelId);

    // get all hotels
    List<Hotel> getAllHotels();

    List<Hotel> getHotelsByHotelIds(List<Long> hotelIds);
}

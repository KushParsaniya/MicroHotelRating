package dev.kush.hotelservice.services.impl;

import dev.kush.hotelservice.exceptions.ResourceNotFoundException;
import dev.kush.hotelservice.models.Hotel;
import dev.kush.hotelservice.repositories.HotelRepository;
import dev.kush.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(Long hotelId) {
        return findById(hotelId);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> getHotelsByHotelIds(List<Long> hotelIds) {
        if (hotelIds == null || hotelIds.isEmpty()) {
            return List.of();
        }
        List<Hotel> hotels = hotelIds.stream().map(this::findById).toList();
        return hotels;
    }

    public Hotel findById(Long hotelId) {
        if (hotelId == null){
            throw new IllegalArgumentException("hotelId cannot be null.");
        }

        return hotelRepository.findById(hotelId).orElseThrow(
                () -> new ResourceNotFoundException("Hotel with id " + hotelId + " not found")
        );
    }

    //TODO: update hotel

    //TODO: delete hotel
}

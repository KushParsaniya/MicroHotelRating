package dev.kush.hotelservice.controller;

import dev.kush.hotelservice.models.Hotel;
import dev.kush.hotelservice.models.HotelDao;
import dev.kush.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/save")
    public Hotel saveHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    @GetMapping("/{hotelId}")
    public Hotel getHotel(@PathVariable Long hotelId) {
        return hotelService.getHotel(hotelId);
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @PostMapping("/hotelIds")
    public List<Hotel> getHotelsByHotelIds(@RequestBody HotelDao hotelDao){
        return hotelService.getHotelsByHotelIds(hotelDao.hotelIds());
    }
}

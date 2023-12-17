package dev.kush.userservice.feign;

import dev.kush.userservice.models.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("HOTEL-SERVICE")
public interface HotelFeign {

    @PostMapping("hotels/hotelIds")
    public List<Hotel> getHotelsByHotelIds(@RequestBody List<Long> hotelIds);
}

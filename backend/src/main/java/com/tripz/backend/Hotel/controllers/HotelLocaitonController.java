package com.tripz.backend.Hotel.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripz.backend.Hotel.dto.HotelLocationCreateRequestDTO;
import com.tripz.backend.Hotel.dto.HotelLocationDTO;
import com.tripz.backend.Hotel.services.HotelLocationService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/hotel-locations")
@RequiredArgsConstructor
@Tag(name = "Location(Hotel)")
public class HotelLocaitonController {
    private final HotelLocationService hotelLocationService;

    @GetMapping
    public List<HotelLocationDTO> findAllHotelLocation(){
        return hotelLocationService.getAllHotelLcoation();
    }

    @GetMapping("/hotel-location/{locationname}")
    public HotelLocationDTO findHotelLocationByLocaitonName(@PathVariable String locationName){
        return hotelLocationService.getHotelLocationByLocationName(locationName);
    }

    @PostMapping("/create/")
    public HotelLocationDTO createHotelLocation(@RequestBody HotelLocationCreateRequestDTO request){
        return hotelLocationService.createHotelLocation(request);
    }

    @PutMapping("/update/{id}")
    public HotelLocationDTO updateHotelLocation(@RequestBody HotelLocationCreateRequestDTO request, @PathVariable Integer id){
        return hotelLocationService.updateHotelLocation(request, id);
    }
}

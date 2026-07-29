package com.tripz.backend.Hotel.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripz.backend.Hotel.dto.HotelCreateRequestDTO;
import com.tripz.backend.Hotel.dto.HotelDTO;
import com.tripz.backend.Hotel.services.HotelService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
@Tag(name = "Hotels")
public class HotelController {
    private final HotelService hotelService;

    @GetMapping
    public List<HotelDTO> findAllHotel(){
        return hotelService.getAllHotel();
    }

    @GetMapping("/find/{hotelName}")
    public HotelDTO findHotelByName(@PathVariable String hotelName){
        return hotelService.getHotelByHotelName(hotelName);
    }

    @GetMapping("/find/{locationName}")
    public List<HotelDTO> findHotelByLocationName(@PathVariable String locationName){
        return hotelService.getHotelsByLocationName(locationName);
    } 

    @PostMapping("/create/")
    public HotelDTO createHotel(@RequestBody HotelCreateRequestDTO request){
        return hotelService.createHotel(request);
    }

    @PutMapping("/update/{id}")
    public HotelDTO updateHotel(@RequestBody HotelCreateRequestDTO request, @PathVariable Integer id){
        return hotelService.updateHotel(request, id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Integer id){
        hotelService.deleteHotel(id);
    }
}

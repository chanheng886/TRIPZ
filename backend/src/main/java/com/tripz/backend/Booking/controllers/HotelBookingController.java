package com.tripz.backend.Booking.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripz.backend.Booking.dto.HotelBookingDTO;
import com.tripz.backend.Booking.dto.HotelBookingRequestDTO;
import com.tripz.backend.Booking.services.HotelBookingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotel-booking")
public class HotelBookingController {
    private final HotelBookingService bookingService;

    @GetMapping
    public List<HotelBookingDTO> findAllHotelBooking(){
        return bookingService.getAllHotelBooking();
    }

    // For Customer
    //✅✅ 
    @PostMapping("/create")
    public HotelBookingDTO createBooking(@RequestBody HotelBookingRequestDTO request){
        return bookingService.createHotelBooking(request);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Integer id){
        bookingService.deleteBooking(id);
    }

    
}

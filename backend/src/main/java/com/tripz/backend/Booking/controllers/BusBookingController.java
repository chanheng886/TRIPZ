package com.tripz.backend.Booking.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripz.backend.Booking.dto.BusBookingDTO;
import com.tripz.backend.Booking.dto.BusBookingRequestDTO;
import com.tripz.backend.Booking.services.BusBookingService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bus-booking")
@Tag(name = "Bus Booking")
public class BusBookingController {
    private final BusBookingService busBookingService;

    @GetMapping
    public List<BusBookingDTO> getAllBusBooking(){
        return busBookingService.getAllBusBooking();
    }

    @GetMapping("/search/{fromLocation}/{toLocation}")
    public List<BusBookingDTO> findBusBookingBySchedule(@PathVariable String fromLocation, @PathVariable String toLocation){
        return busBookingService.getBusBookingBySchedule(fromLocation, toLocation);
    }


    // Crreate Booking
    // ✅✅ This Function Is For Customer
    @PostMapping
    public BusBookingDTO createBooking(@RequestBody BusBookingRequestDTO request){
        return busBookingService.createBusBooking(request);
    }
}

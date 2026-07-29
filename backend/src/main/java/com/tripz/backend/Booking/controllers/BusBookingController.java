package com.tripz.backend.Booking.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripz.backend.Booking.dto.BusBookingDTO;
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
}

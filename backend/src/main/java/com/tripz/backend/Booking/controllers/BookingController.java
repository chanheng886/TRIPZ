package com.tripz.backend.Booking.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripz.backend.Booking.dto.BookingDTO;
import com.tripz.backend.Booking.services.BookingService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor
@Tag(name = "Bookings")
public class BookingController {
    private final BookingService bookingService;
    
    @GetMapping
    public List<BookingDTO> findAllBooking(){
        return bookingService.getAllBooking();
    }
}

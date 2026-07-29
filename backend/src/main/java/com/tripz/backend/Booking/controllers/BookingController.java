package com.tripz.backend.Booking.controllers;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripz.backend.Booking.dto.BookingCreateRequestDTO;
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

    @PostMapping("/{id}")
    public BookingDTO createBooking(@RequestBody BookingCreateRequestDTO request, @PathVariable Integer id){
        return bookingService.createBooking(request, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Integer id){
        bookingService.deleteBooking(id);
    }

    @PutMapping("/{id}")
    public BookingDTO updateBooking(@RequestBody BookingCreateRequestDTO request, Integer id){
        return bookingService.updateBooking(request, id);
    }

    // For User Booking ✅✅ (function for user)
    // @PostMapping
    // public BookingDTO createBooking(@RequestBody BookingCreateRequestDTO request, Authentication authentication ){
    //     Integer userId = Integer.parseInt(authentication.);
    //     return bookingService.createBooking(request, userId);
    // }
}

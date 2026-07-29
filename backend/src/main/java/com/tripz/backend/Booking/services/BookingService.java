package com.tripz.backend.Booking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tripz.backend.Booking.dto.BookingDTO;
import com.tripz.backend.Booking.repositories.BookingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    // 1. Method One
    // ✅✅ Get All Bookings
    public List<BookingDTO> getAllBooking(){
        return bookingRepository.findAll().stream().map(
            booking -> BookingDTO.builder()
            .id(booking.getId())
            .customer(booking.getCustomer().getUsername())
            .bookingDate(booking.getBookingDate())
            .totalAmount(booking.getTotalAmount())
            .paymentMethod(booking.getPayment().name())
            .status(booking.getStatus().name()).build()
        ).toList();
    }
}

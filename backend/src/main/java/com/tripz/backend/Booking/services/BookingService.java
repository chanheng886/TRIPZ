package com.tripz.backend.Booking.services;

import org.springframework.stereotype.Service;

import com.tripz.backend.Booking.repositories.BookingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
}

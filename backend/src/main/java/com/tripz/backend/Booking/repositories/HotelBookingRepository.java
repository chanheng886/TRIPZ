package com.tripz.backend.Booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripz.backend.Booking.entities.HotelBooking;

public interface HotelBookingRepository extends JpaRepository<HotelBooking, Integer> {
    
}

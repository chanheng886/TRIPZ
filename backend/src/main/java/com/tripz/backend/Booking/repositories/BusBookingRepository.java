package com.tripz.backend.Booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripz.backend.Booking.entities.BusBooking;

public interface BusBookingRepository extends JpaRepository<BusBooking, Integer> {
    
}

package com.tripz.backend.Booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripz.backend.Booking.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    
}
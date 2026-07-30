package com.tripz.backend.Hotel.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripz.backend.Hotel.entities.Hotels;

public interface HotelRepository extends JpaRepository<Hotels, Integer> {
    Hotels findHotelByHotelName(String hotelName);   
    List<Hotels> findByLocationName(String locationName);
}

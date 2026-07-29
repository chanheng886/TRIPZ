package com.tripz.backend.Hotel.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripz.backend.Hotel.entities.HotelLocation;

public interface HotelLocationRepository extends JpaRepository<HotelLocation, Integer> {
    Optional<HotelLocation> findByLocationName(String locationName);
}

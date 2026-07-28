package com.tripz.backend.Bus.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripz.backend.Bus.entities.BusLocation;

public interface BusLocationRepository extends JpaRepository<BusLocation, Integer> {
    Optional<BusLocation> findByLocationName(String locationName);
}

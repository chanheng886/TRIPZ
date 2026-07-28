package com.tripz.backend.Bus.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tripz.backend.Bus.entities.Route;

public interface RouteRepository extends JpaRepository<Route, Integer> { 
    @Query(""" 
            SELECT r FROM Route r
            WHERE r.fromLocation.locationName = :fromLocation
            AND r.toLocation.locationName = :toLocation
        """)
    Optional<Route> findByRouteFromLocationAndToLocation(
        @Param("fromLocation") String fromLocation,
        @Param("toLocation") String toLocation
    );
}

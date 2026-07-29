package com.tripz.backend.Booking.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tripz.backend.Booking.entities.BusBooking;

public interface BusBookingRepository extends JpaRepository<BusBooking, Integer> { 
    @Query("""
            SELECT bb FROM BusBooking bb
            WHERE bb.busSchedule.route.fromLocation.locationName = :fromLocation
              and bb.busSchedule.route.toLocation.locationName = :toLocation
            """)
    List<BusBooking> findByFromLocationAndToLocation(
        @Param("fromLocation") String fromLocation,
        @Param("toLocation") String toLocation
    );


    @Query("""
        SELECT bb FROM BusBooking bb
        WHERE bb.busSchedule.id = :busScheduleId
        and bb.seatNumber = :seatNumber
    """)
    Optional<BusBooking> findByBusScheduleIdAndSeatNumber(
        @Param("busScheduleId") Integer busScheduleId,
        @Param("seatNumber") String seatNumber
    );
}

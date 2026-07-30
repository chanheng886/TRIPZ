package com.tripz.backend.Hotel.repositories;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tripz.backend.Hotel.entities.HotelSchedule;

public interface HotelScheduleRepository extends JpaRepository<HotelSchedule, Integer> {
@Query(""" 
    SELECT hs FROM HotelSchedule hs
    WHERE hs.checkInDate = :checkInDate
    and hs.checkOutDate = :checkOutDate
    and hs.hotels.locationName.locationName = :locationName
""")

List<HotelSchedule> findByCheckInDateAndCheckOutDateAndLocationName(
    @Param("checkInDate")LocalDate checkInDate,
    @Param("checkOutDate")LocalDate checkOutDate,
    @Param("locationName")String locationName
);
}
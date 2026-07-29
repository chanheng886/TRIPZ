package com.tripz.backend.Hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tripz.backend.Hotel.entities.HotelRoom;

public interface HotelRoomRepository extends JpaRepository<HotelRoom, Integer> {
    @Query("""
            SELECT hr FROM HotelRoom hr
            WHERE hr.hotels.hotelName = :hotelName
            """)
    List<HotelRoom> findByHotelName(
        @Param("hotelName") String hotelName
    );
}

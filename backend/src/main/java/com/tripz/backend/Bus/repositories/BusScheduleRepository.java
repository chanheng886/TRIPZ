package com.tripz.backend.Bus.repositories;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.tripz.backend.Bus.entities.BusSchedule;


public interface BusScheduleRepository extends JpaRepository<BusSchedule, Integer> {
    // List<BusSchedule> findByRoute_FromLocation_LocationNameAndRoute_ToLocation_LocationNameAndTravelDate(String fromLocation, String toLocation, LocalDate travelDate);
    @Query("""
            SELECT bs FROM BusSchedule bs
            WHERE bs.route.fromLocation.locationName = :fromLocation
              and bs.route.toLocation.locationName = :toLocation
              and bs.travelDate = :travelDate
            """)
    List<BusSchedule> findByFromLocationAndToLocationAndTravelDate(
        @Param("fromLocation") String fromLocation,
        @Param("toLocation") String toLocation,
        @Param("travelDate") LocalDate travelDate
    );
}
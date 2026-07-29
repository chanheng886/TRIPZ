package com.tripz.backend.Booking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tripz.backend.Booking.dto.BusBookingDTO;
import com.tripz.backend.Booking.repositories.BusBookingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusBookingService {
        private final BusBookingRepository bookingRepository;

        public List<BusBookingDTO> getAllBusBooking(){
            return bookingRepository.findAll().stream().map(busbooking ->
                BusBookingDTO.builder()
                .id(busbooking.getId())
                .booking(busbooking.getBooking().getCustomer().getUsername())
                .busSchedule(busbooking.getBusSchedule().getRoute().getFromLocation().getLocationName() + " - "  + busbooking.getBusSchedule().getRoute().getToLocation().getLocationName())
                .passangerName(busbooking.getPassenger_name())
                .seatNumber(busbooking.getSeatNumber())
                .price(busbooking.getPrice()).build()
            ).toList();
        }
}

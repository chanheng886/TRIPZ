package com.tripz.backend.Booking.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tripz.backend.Booking.dto.BusBookingDTO;
import com.tripz.backend.Booking.dto.BusBookingRequestDTO;
import com.tripz.backend.Booking.entities.Booking;
import com.tripz.backend.Booking.entities.BusBooking;
import com.tripz.backend.Booking.enums.Status;
import com.tripz.backend.Booking.repositories.BookingRepository;
import com.tripz.backend.Booking.repositories.BusBookingRepository;
import com.tripz.backend.Bus.entities.BusSchedule;
import com.tripz.backend.Bus.repositories.BusScheduleRepository;
import com.tripz.backend.User.entities.User;
import com.tripz.backend.User.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusBookingService {
        private final BusBookingRepository busBookingRepository;
        private final BookingRepository bookingRepository;
        private final UserRepository userRepository;
        private final BusScheduleRepository busScheduleRepository;

        // 1. Method One
        // ✅✅ Get All Bus Booking
        public List<BusBookingDTO> getAllBusBooking(){
            return busBookingRepository.findAll().stream().map(busbooking ->
                BusBookingDTO.builder()
                .id(busbooking.getId())
                .bookingId(busbooking.getBooking().getId())
                .busSchedule(busbooking.getBusSchedule().getRoute().getFromLocation().getLocationName() + " - "  + busbooking.getBusSchedule().getRoute().getToLocation().getLocationName())
                .passangerName(busbooking.getPassengerName  ())
                .seatNumber(busbooking.getSeatNumber())
                .price(busbooking.getPrice()).build()
            ).toList();
        }

        // 2 . Method Two
        // ✅✅ Get Bus Booking By Bus Schedule
        public List<BusBookingDTO> getBusBookingBySchedule(String fromLocation, String toLocation){
            return busBookingRepository.findByFromLocationAndToLocation(fromLocation, toLocation).stream().map(bookingschedule ->
                BusBookingDTO.builder()
                .id(bookingschedule.getId())
                .bookingId(bookingschedule.getBooking().getId())
                .busSchedule(bookingschedule.getBusSchedule().getRoute().getFromLocation().getLocationName() + " - " + bookingschedule.getBusSchedule().getRoute().getToLocation().getLocationName())
                .passangerName(bookingschedule.getPassengerName())
                .seatNumber(bookingschedule.getSeatNumber())
                .price(bookingschedule.getPrice())
                .build()
            ).toList();
        }

        // 3. Method Three
        // ✅✅ Create Bus Booking For Customer
        @Transactional
        public BusBookingDTO createBusBooking(BusBookingRequestDTO request){
            User customer = userRepository.findById((request.getCustomerId())).orElseThrow(() -> new RuntimeException("Customer Not Found"));
            BusSchedule schedule = busScheduleRepository.findById(request.getBusScheduleId()).orElseThrow(() -> new RuntimeException("Bus Schedule Not Found!!"));

            busBookingRepository.findByBusScheduleIdAndSeatNumber(request.getBusScheduleId(), request.getSeatNumber()).ifPresent(existing ->
                {throw new RuntimeException("Seat " + request.getSeatNumber() + "is already booked");}
            );

            Booking booking = Booking.builder()
            .customer(customer)
            .bookingDate(LocalDate.now())
            .totalAmount(request.getPrice())
            .paymentMethod(request.getPaymentMethod())
            .status(Status.Pending)
            .build();
            Booking savedBooking = bookingRepository.save(booking);
            
            
            
            BusBooking busBooking = BusBooking.builder()
            .booking(savedBooking)
            .busSchedule(schedule)
            .passengerName(request.getPassengerName())
            .seatNumber(request.getSeatNumber())
            .price(request.getPrice())
            .build();
            BusBooking saved = busBookingRepository.save(busBooking);

            return BusBookingDTO.builder()
            .id(saved.getId())
            .bookingId(savedBooking.getId())
            .busSchedule(saved.getBusSchedule().getRoute().getFromLocation().getLocationName() 
                        + " - " 
                        +saved.getBusSchedule().getRoute().getToLocation().getLocationName())
            .passangerName(saved.getPassengerName())
            .seatNumber(saved.getSeatNumber())
            .price(saved.getPrice()).build();
        }
}

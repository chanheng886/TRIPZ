package com.tripz.backend.Booking.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tripz.backend.Booking.dto.HotelBookingDTO;
import com.tripz.backend.Booking.dto.HotelBookingRequestDTO;
import com.tripz.backend.Booking.entities.Booking;
import com.tripz.backend.Booking.entities.HotelBooking;
import com.tripz.backend.Booking.enums.Status;
import com.tripz.backend.Booking.repositories.BookingRepository;
import com.tripz.backend.Booking.repositories.HotelBookingRepository;
import com.tripz.backend.Hotel.entities.HotelSchedule;
import com.tripz.backend.Hotel.repositories.HotelScheduleRepository;
import com.tripz.backend.User.entities.User;
import com.tripz.backend.User.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelBookingService {
    private final HotelBookingRepository hotelBookingRepository;
    private final BookingRepository bookingRepository;
    private final HotelScheduleRepository hotelScheduleRepository;
    private final UserRepository userRepository;
        
    // 1 Method one
    //✅✅
    public List<HotelBookingDTO> getAllHotelBooking(){
        return hotelBookingRepository.findAll().stream().map(
            hotelbooking ->
            HotelBookingDTO.builder()
            .id(hotelbooking.getId())
            .booking(hotelbooking.getBooking().getId())
            .hotelSchedule(hotelbooking.getHotelSchedule().getCheckInDate() + " - " 
            + hotelbooking.getHotelSchedule().getCheckOutDate() + " - "
            + hotelbooking.getHotelSchedule().getHotels().getHotelName())
            .guestCount(hotelbooking.getGuestCount()).build()
        ).toList();
    }

    // 2. Method Three
        // ✅✅ Create Hotel Booking For Customer
    @Transactional
    public HotelBookingDTO createHotelBooking(HotelBookingRequestDTO request){
         User customer = userRepository.findById(request.getCustomerId())
            .orElseThrow(() -> new RuntimeException("Customer Not Found"));

    HotelSchedule schedule = hotelScheduleRepository.findById(request.getHotelScheduleId())
            .orElseThrow(() -> new RuntimeException("Hotel Schedule Not Found"));

    Booking booking = Booking.builder()
            .customer(customer)
            .bookingDate(LocalDate.now())
            .totalAmount(request.getTotalAmount())
            .paymentMethod(request.getPaymentMethod())
            .status(Status.Pending)
            .build();
    Booking savedBooking = bookingRepository.save(booking);

    HotelBooking hotelBooking = HotelBooking.builder()
            .booking(savedBooking)
            .hotelSchedule(schedule)
            .guestCount(request.getGuestCount())
            .build();
    HotelBooking saved = hotelBookingRepository.save(hotelBooking);

    return HotelBookingDTO.builder()
            .id(saved.getId())
            .booking(saved.getBooking().getId())
            .hotelSchedule(saved.getHotelSchedule().getCheckInDate() + " - "
                    + saved.getHotelSchedule().getCheckOutDate() + " - "
                    + saved.getHotelSchedule().getHotels().getHotelName())
            .guestCount(saved.getGuestCount())
            .build();
    }

    public void deleteBooking(Integer id){
        hotelBookingRepository.deleteById(id);
    }

}

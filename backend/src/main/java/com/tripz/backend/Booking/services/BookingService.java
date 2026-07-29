package com.tripz.backend.Booking.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tripz.backend.Booking.dto.BookingCreateRequestDTO;
import com.tripz.backend.Booking.dto.BookingDTO;
import com.tripz.backend.Booking.entities.Booking;
import com.tripz.backend.Booking.repositories.BookingRepository;
import com.tripz.backend.User.entities.User;
import com.tripz.backend.User.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    // 1. Method One
    // ✅✅ Get All Bookings
    public List<BookingDTO> getAllBooking(){
        return bookingRepository.findAll().stream().map(
            booking -> BookingDTO.builder()
            .id(booking.getId())
            .customer(booking.getCustomer().getUsername())
            .bookingDate(booking.getBookingDate())
            .totalAmount(booking.getTotalAmount())
            .paymentMethod(booking.getPaymentMethod().name())
            .status(booking.getStatus().name()).build()
        ).toList();
    }

    // 2 . Method Two
    // ✅✅ Create Booking
    public BookingDTO createBooking(BookingCreateRequestDTO request, Integer id){
        User customer = userRepository.findById(id).orElseThrow(() -> new RuntimeException("No User Found!!"));
        
        Booking booking = Booking.builder()
        .customer(customer)
        .bookingDate(LocalDate.now())
        .paymentMethod(request.getPaymentMethod())
        .totalAmount(request.getPrice())
        .status(request.getStatus())
        .build();
        
        Booking saved = bookingRepository.save(booking);

        return BookingDTO.builder()
        .id(saved.getId())
        .customer(saved.getCustomer().getUsername())
        .bookingDate(saved.getBookingDate())
        .paymentMethod(saved.getPaymentMethod().name())
        .status(saved.getStatus().name())
        .build();
    }

    // 3 . Method three
    // ✅✅ Delete Booking
    public void deleteBooking(Integer id){
        bookingRepository.deleteById(id);
    }

    // 4 . Method Four
    // ✅✅ Update Booking
    public BookingDTO updateBooking(BookingCreateRequestDTO request, Integer id){
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking Not Found"));
        
        booking.setTotalAmount(request.getPrice());
        booking.setPaymentMethod(request.getPaymentMethod());
        booking.setStatus(request.getStatus());

        Booking saved = bookingRepository.save(booking);

        BookingDTO dto = new BookingDTO();

        dto.setId(saved.getId());
        dto.setCustomer(saved.getCustomer().getUsername());
        dto.setPaymentMethod(saved.getPaymentMethod().name());
        dto.setStatus(saved.getStatus().name());

        return dto;
    }
}

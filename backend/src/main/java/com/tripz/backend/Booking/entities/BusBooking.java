package com.tripz.backend.Booking.entities;

import java.math.BigDecimal;

import com.tripz.backend.Bus.entities.BusSchedule;
import com.tripz.backend.User.entities.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_bus_booking")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BusBooking {
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_schedule_id", nullable = false)
    private BusSchedule busSchedule;

    @Column(name = "passenger_name", length = 255)
    private String passenger_name;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(name = "price")
    private BigDecimal price;
}

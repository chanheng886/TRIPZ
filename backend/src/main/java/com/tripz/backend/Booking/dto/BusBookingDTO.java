package com.tripz.backend.Booking.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusBookingDTO {
    private Integer id;
    private String booking;
    private String busSchedule;
    private String passangerName;
    private String seatNumber;
    private BigDecimal price;
}

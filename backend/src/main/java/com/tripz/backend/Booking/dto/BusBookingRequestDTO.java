package com.tripz.backend.Booking.dto;

import java.math.BigDecimal;

import com.tripz.backend.Booking.enums.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusBookingRequestDTO {
    private Integer customerId;
    private Integer busScheduleId;
    private String passengerName;
    private String seatNumber;
    private BigDecimal price;
    private PaymentMethod paymentMethod;
}

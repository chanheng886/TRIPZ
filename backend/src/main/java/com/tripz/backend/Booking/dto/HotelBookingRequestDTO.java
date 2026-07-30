package com.tripz.backend.Booking.dto;

import java.math.BigDecimal;

import com.tripz.backend.Booking.enums.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelBookingRequestDTO {
      private Integer customerId;
    private Integer hotelScheduleId;
    private Integer guestCount;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
}

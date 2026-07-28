package com.tripz.backend.Booking.dto;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingCreateRequestDTO {    
    private String customer;
    private LocalDate bookingDate;
    private BigDecimal totalAmount;
    private String paymentMethod;
    private String status;
}

package com.tripz.backend.Booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelBookingDTO {
    private Integer id;
    private Integer booking;
    private String hotelSchedule;
    private Integer guestCount;
}

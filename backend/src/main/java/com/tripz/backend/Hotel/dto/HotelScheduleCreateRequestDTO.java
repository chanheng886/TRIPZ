package com.tripz.backend.Hotel.dto;
import java.time.LocalDate;

import com.tripz.backend.Hotel.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelScheduleCreateRequestDTO {
    private String hotels;
    private String roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Status status;
}
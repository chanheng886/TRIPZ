package com.tripz.backend.Hotel.dto;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelScheduleDTO {
    private Integer id;
    private String hotels;
    private String roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String status;
}
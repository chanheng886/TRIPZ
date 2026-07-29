package com.tripz.backend.Hotel.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelRoomDTO {
    private Integer id;
    private String hotels;
    private String roomType;
    private Integer roomCount;
    private BigDecimal price;
}

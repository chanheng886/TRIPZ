package com.tripz.backend.Hotel.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelRoomCreateRequestDTO {
    private String hotels;
    private String roomType;
    private Integer roomCount;
    private BigDecimal price;    
}

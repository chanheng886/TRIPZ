package com.tripz.backend.Hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDTO {
    private Integer id;
    private String hotelName;
    private String locationName;
    private Integer totalRoom;
}

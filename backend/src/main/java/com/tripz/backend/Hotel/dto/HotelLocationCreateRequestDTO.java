package com.tripz.backend.Hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelLocationCreateRequestDTO {
    private String locationName;
    private String imageUrl;
}

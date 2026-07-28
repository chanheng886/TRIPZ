package com.tripz.backend.Bus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusDTO {
    private Integer id;
    private String companyName;
    private String busType;
    private Integer seatCapacity;
    private String plateNumber;
    private String imageUrl;
}

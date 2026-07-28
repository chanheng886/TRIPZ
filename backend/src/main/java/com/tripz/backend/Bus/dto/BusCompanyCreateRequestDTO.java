package com.tripz.backend.Bus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusCompanyCreateRequestDTO {
    private String companyName;
    private String imageUrl;
}

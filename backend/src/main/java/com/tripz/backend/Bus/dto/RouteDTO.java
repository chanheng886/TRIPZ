package com.tripz.backend.Bus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RouteDTO {
    private Integer id;
    private String fromLocation;
    private String toLocation;
}

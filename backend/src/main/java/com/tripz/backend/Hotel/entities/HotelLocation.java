package com.tripz.backend.Hotel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_hotel_location")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HotelLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "location_name", nullable = false, unique = true, length = 100)
    private String locationName;

    @Column(name = "image_url", nullable = false, length = 255)
    private String imageUrl;
}

package com.tripz.backend.Bus.entities;

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
@Table(name = "tb_location")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BusLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    

    @Column(name = "location_name", nullable = false, length = 100)
    private String locationName;

    @Column(name = "images_url", length = 255)
    private String imageUrl;
}

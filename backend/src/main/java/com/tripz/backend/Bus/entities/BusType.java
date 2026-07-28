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
@Table(name = "tb_bus_type")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BusType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bus_type", nullable = false, length = 50)
    private String busType;

    @Column(name = "image_url", length = 255)
    private String imageUrl;
}

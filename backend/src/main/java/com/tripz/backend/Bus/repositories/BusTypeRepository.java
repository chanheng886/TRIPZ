package com.tripz.backend.Bus.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripz.backend.Bus.entities.BusType;

/**
 * BusTypeRepository
 */
public interface BusTypeRepository extends JpaRepository<BusType, Integer> {
    Optional<BusType> getByBusType(String busType);
}
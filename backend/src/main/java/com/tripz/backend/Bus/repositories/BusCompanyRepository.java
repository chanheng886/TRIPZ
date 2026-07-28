package com.tripz.backend.Bus.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripz.backend.Bus.entities.BusCompany;

/**
 * BusCompanyRepository
 */
public interface BusCompanyRepository extends JpaRepository<BusCompany, Integer> {
    Optional<BusCompany> getBusByCompanyName(String companyName);
}
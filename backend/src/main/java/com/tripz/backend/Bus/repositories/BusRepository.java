package com.tripz.backend.Bus.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tripz.backend.Bus.entities.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer> {
    List<Bus> findByCompany_CompanyName(String companyName);
    Optional<Bus> findBusByPlateNumber(String plateNumber);
}
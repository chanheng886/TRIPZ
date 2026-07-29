package com.tripz.backend.Hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripz.backend.Hotel.entities.RoomType;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {
    
}

package com.tripz.backend.Hotel.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripz.backend.Hotel.dto.HotelScheduleCreateRequestDTO;
import com.tripz.backend.Hotel.dto.HotelScheduleDTO;
import com.tripz.backend.Hotel.services.HotelScheduleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/hotel-schedule")
@RequiredArgsConstructor
public class HotelScheduleController {
    private final HotelScheduleService hotelScheduleService;
    
    @GetMapping
    public List<HotelScheduleDTO> findAllHotelSchedule(){
        return hotelScheduleService.getAllHotelSchedule();
    }

    @GetMapping("/find-schedule/{checkInDate}/{checkOutDate}/{locationName}")
    public List<HotelScheduleDTO> findHotelScheduleByCheckInDateAndCheckOutDateAndLocationName(@PathVariable LocalDate checkInDate, @PathVariable LocalDate checkOutDate, @PathVariable String locationName){
        return hotelScheduleService.getHotelScheduleByCheckInDateAndCheckOutDateAndLocationName(checkInDate, checkOutDate, locationName);
    }

    @PostMapping("/create")
    public HotelScheduleDTO createHotelSchedule(@RequestBody HotelScheduleCreateRequestDTO Request){
        return hotelScheduleService.createHotelSchedule(Request);
    }

    @PutMapping("/update/{id}")
    public HotelScheduleDTO updateHotelSchedule(@RequestBody HotelScheduleCreateRequestDTO request,@PathVariable Integer id){
        return hotelScheduleService.updateHotelSchedule(request, id);
    }

    @DeleteMapping("/{id}")
    public void deleteHotelSchedule(@PathVariable Integer id){
        hotelScheduleService.deleteHotelSchedule(id);
    }
}

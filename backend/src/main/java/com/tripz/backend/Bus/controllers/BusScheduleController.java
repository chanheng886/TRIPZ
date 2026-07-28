package com.tripz.backend.Bus.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripz.backend.Bus.dto.BusScheduleCreateRequestDTO;
import com.tripz.backend.Bus.dto.BusScheduleDTO;
import com.tripz.backend.Bus.services.BusScheduleService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/bus-schedule")
@RequiredArgsConstructor
@Tag(name = "Bus Schedule")
public class BusScheduleController {
    private final BusScheduleService busScheduleService;
    @GetMapping("fromlocation/{fromLocation}/toLocation/{toLocation}/travelDate/{travelDate}")
    public List<BusScheduleDTO> findBusByFromLocationAndToLocationAndTravelDate(
        @PathVariable String fromLocation, String toLocation, LocalDate travelDate
    ){
     
        return busScheduleService.findBusByLocation_fromLocationName_toLocationName_travelDate(fromLocation, toLocation, travelDate);
    }

    @GetMapping
    public List<BusScheduleDTO> findAllBusSchedule(){
        return busScheduleService.findAllBusSchedule();
    }

    @PostMapping
    public BusScheduleDTO createBusSchedule(@RequestBody BusScheduleCreateRequestDTO request){
        return busScheduleService.createBusSchedule(request);
    }

    @DeleteMapping("/{id}")
    public void deleteBusSchedule(@PathVariable Integer id){
        deleteBusSchedule(id);
    }
}

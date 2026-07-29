package com.tripz.backend.Bus.controllers;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tripz.backend.Bus.dto.BusLocationCreateRequestDTO;
import com.tripz.backend.Bus.dto.BusLocationDTO;
import com.tripz.backend.Bus.services.BusLocationService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/locations")
@RequiredArgsConstructor
@Tag(name = "Location(Bus)")
public class BusLocationController {
    private final BusLocationService busLocationService;
    @GetMapping
    public List<BusLocationDTO> getAllBusLocation(){
        return busLocationService.getAllBusLocation();
    }

    @GetMapping("/locationname/{locationName}")
    public BusLocationDTO getBusLocationByLocationName(@PathVariable String locationName){
        return busLocationService.getLocationByLocationName(locationName);
    }

    @PostMapping
    public BusLocationDTO createBusLocationName(@RequestBody BusLocationCreateRequestDTO request){
        return busLocationService.createBusLocation(request);
    }

    @DeleteMapping("/{id}")
    public BusLocationDTO deleteBusLocation(@PathVariable Integer id){
        return busLocationService.deleteBusLocation(id);
    }

    @PutMapping("/{id}")
    public BusLocationDTO updateBusLocation(@PathVariable Integer id,@RequestBody BusLocationCreateRequestDTO request){
        return busLocationService.updateBusLocation(id, request);
    } 
}
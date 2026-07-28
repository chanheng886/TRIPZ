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

import com.tripz.backend.Bus.dto.BusCreateRequestDTO;
import com.tripz.backend.Bus.dto.BusDTO;
import com.tripz.backend.Bus.services.BusService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/buses")
@RequiredArgsConstructor
@Tag(name = "Bus")
public class BusController {
    private final BusService busService;
  
    //✅✅ Get All Bus
    @GetMapping
    public List<BusDTO> findAllBus(){
        return busService.getAllBus();
    }

    //✅✅ Get All Bus By Company Name
    @GetMapping("/company/{companyName}")
    public List<BusDTO> findAllBusByCompanyName(String companyName){
        return busService.getBusByCompanyName(companyName);
    }
    //✅✅ Get Bus By Plate Number
    @GetMapping("/platenumber/{plateNumber}")
    public BusDTO findBusByPlateNumber(String plateNumber){
        return busService.getBusByPlateNumber(plateNumber);
    }

    //✅✅
    @PostMapping
    public BusDTO createBus(@RequestBody BusCreateRequestDTO request){
        return busService.createBus(request);
    }

    //✅✅
    @DeleteMapping
    public void deleteBus(@PathVariable Integer id){
        busService.deleteBus(id);
    }

    @PutMapping("update/{id}")
    public BusDTO updateBus(@PathVariable Integer id,@RequestBody BusCreateRequestDTO request){
        return busService.updateBus(id, request);
    }
}

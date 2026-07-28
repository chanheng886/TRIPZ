package com.tripz.backend.Bus.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripz.backend.Bus.dto.BusCompanyCreateRequestDTO;
import com.tripz.backend.Bus.dto.BusCompanyDTO;
import com.tripz.backend.Bus.services.BusCompanyService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/busCompany")
@Tag(name = "Bus Company")
@RequiredArgsConstructor
public class BusCompanyController {
    private final BusCompanyService busCompanyService;

    @GetMapping
    public List<BusCompanyDTO> findAllBusCompany(){
        return busCompanyService.getAllBusCompany();
    }
    @PostMapping
    public BusCompanyDTO createCompany(BusCompanyCreateRequestDTO request){
        return busCompanyService.createBusCompany(request);
    }
    @DeleteMapping
    public void deleteBusCompany(@PathVariable Integer id){
        busCompanyService.deleteBusComapny(id);
    }
}

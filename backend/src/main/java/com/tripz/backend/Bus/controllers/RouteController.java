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

import com.tripz.backend.Bus.dto.RouteCreateRequestDTO;
import com.tripz.backend.Bus.dto.RouteDTO;
import com.tripz.backend.Bus.services.RouteService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/route")
@RequiredArgsConstructor
@Tag(name = "Route")
public class RouteController {
    private final RouteService routeService;

    @GetMapping
    public List<RouteDTO> findAllRoute(){
        return routeService.getAllRoute();
    }

    @PostMapping
    public RouteDTO createRoute(@RequestBody RouteCreateRequestDTO request){
        return routeService.createRoute(request);
    }

    @DeleteMapping("/{id}")
    public void deleteRoute(@PathVariable Integer id){
         routeService.deleteRoute(id);
    }

    @PutMapping("/{id}")
    public RouteDTO updateRoute(@PathVariable Integer id,@RequestBody RouteCreateRequestDTO request){
        return routeService.updateRoute(id, request);
    }
}

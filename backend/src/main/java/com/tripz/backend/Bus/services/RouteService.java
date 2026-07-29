package com.tripz.backend.Bus.services;
import java.util.List;
import org.springframework.stereotype.Service;

import com.tripz.backend.Bus.dto.RouteCreateRequestDTO;
import com.tripz.backend.Bus.dto.RouteDTO;
import com.tripz.backend.Bus.entities.BusLocation;
import com.tripz.backend.Bus.entities.Route;
import com.tripz.backend.Bus.repositories.BusLocationRepository;
import com.tripz.backend.Bus.repositories.RouteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RouteService {
    private final RouteRepository routeRepository;
    private final BusLocationRepository busLocationRepository;

    // 1. Method One
    // ✅✅ Get All Route
    public List<RouteDTO> getAllRoute(){
        return routeRepository.findAll().stream().map(route ->{
            RouteDTO dto = new RouteDTO();
            dto.setId(route.getId());
            dto.setFromLocation(route.getFromLocation().getLocationName());
            dto.setToLocation(route.getToLocation().getLocationName());  
            return dto;
        }).toList();
    }

    // 2. Method Two
    // ✅✅ Create Route
    public RouteDTO createRoute(RouteCreateRequestDTO request){
        BusLocation fromLocation = busLocationRepository.findByLocationName(request.getFromLocation()).orElseThrow(() -> new RuntimeException("From Location Not Found!"));
        BusLocation toLocation = busLocationRepository.findByLocationName(request.getToLocation()).orElseThrow(() -> new RuntimeException("to Location Not Found!"));

        Route route = new Route();

        route.setFromLocation(fromLocation);
        route.setToLocation(toLocation);

        Route savedRoute = routeRepository.save(route);

        RouteDTO dto = new RouteDTO();
        dto.setFromLocation(savedRoute.getFromLocation().getLocationName());
        dto.setToLocation(savedRoute.getToLocation().getLocationName());

        return dto;
    }
    // 3. Method Three
    //✅✅ Delete Route
    public void deleteRoute(Integer id){
        if(id == null){
            throw new RuntimeException("Route Not Found!");
        }
         routeRepository.deleteById(id);
    }

    // 4 . Method Five
    //✅✅ Update Route Method
    public RouteDTO updateRoute(Integer id, RouteCreateRequestDTO request){
       Route route = routeRepository.findById(id).orElseThrow(() -> new RuntimeException("Route Not Found!"));
       BusLocation fromLocation = busLocationRepository.findByLocationName(request.getFromLocation()).orElseThrow(() -> new RuntimeException("from Location Not Found!"));
       BusLocation toLocation = busLocationRepository.findByLocationName(request.getToLocation()).orElseThrow(() -> new RuntimeException("to Location Not Found!"));

       route.setFromLocation(fromLocation);
       route.setToLocation(toLocation);

       Route savedRoute = routeRepository.save(route);

       RouteDTO dto = new RouteDTO();
       dto.setFromLocation(savedRoute.getFromLocation().getLocationName());
       dto.setToLocation(savedRoute.getToLocation().getLocationName());

       return dto;
    }
}

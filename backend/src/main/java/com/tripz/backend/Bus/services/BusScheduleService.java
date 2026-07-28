package com.tripz.backend.Bus.services;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

import com.tripz.backend.Bus.dto.BusScheduleCreateRequestDTO;
import com.tripz.backend.Bus.dto.BusScheduleDTO;
import com.tripz.backend.Bus.entities.Bus;
import com.tripz.backend.Bus.entities.BusSchedule;
import com.tripz.backend.Bus.entities.Route;
import com.tripz.backend.Bus.repositories.BusRepository;
import com.tripz.backend.Bus.repositories.BusScheduleRepository;
import com.tripz.backend.Bus.repositories.RouteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusScheduleService {
    private final BusScheduleRepository busScheduleRepository;
    private final BusRepository busRepository;
    private final RouteRepository routeRepository;
    
    // 1. Method One
    //✅✅ Find Bus Schdeule by from locaiton & to lcoation & travel date
    public List<BusScheduleDTO> findBusByLocation_fromLocationName_toLocationName_travelDate(String fromLocation, String toLocation, LocalDate travelDate){
        List<BusSchedule> schedules = busScheduleRepository.findByFromLocationAndToLocationAndTravelDate(fromLocation, toLocation, travelDate);

        return schedules.stream().map(schedule -> BusScheduleDTO.builder()
            .id(schedule.getId())
            .bus(schedule.getBus().getPlateNumber())
            .route(schedule.getRoute().getFromLocation().getLocationName() + " -> " + schedule.getRoute().getToLocation().getLocationName())
            .travelDate(schedule.getTravelDate())
            .departureTime(schedule.getDepartureTime())
            .arrivalTime(schedule.getArrivalTime())
            .availableSeat(schedule.getAvailableSeat()).build()).toList();
    }

    // 2. Method Two
    //✅✅ Get All Bus Schedules
    public List<BusScheduleDTO> findAllBusSchedule(){
        return busScheduleRepository.findAll().stream().map(schedule ->{
            BusScheduleDTO dto = new BusScheduleDTO();

            dto.setId(schedule.getId());
            dto.setBus(schedule.getBus().getPlateNumber() + " - " + schedule.getBus().getCompany().getCompanyName());
            dto.setRoute(schedule.getRoute().getFromLocation().getLocationName() + " - " + schedule.getRoute().getToLocation().getLocationName());
            dto.setTravelDate(schedule.getTravelDate());
            dto.setDepartureTime(schedule.getDepartureTime());
            dto.setArrivalTime(schedule.getArrivalTime());
            dto.setAvailableSeat(schedule.getAvailableSeat());

            return dto;
        }).toList();
    }

    // 3 . Method Three
    //✅✅ Create Bus Schedule 
    public BusScheduleDTO createBusSchedule(BusScheduleCreateRequestDTO request){
        Bus bus = busRepository.findById(request.getBusId()).orElseThrow(() -> new RuntimeException("No Bus Found"));
        String[] locations = request.getRoute().split(" - ");

        if(locations.length != 2){
            throw new RuntimeException("Route Not Found");
        }

        Route route = routeRepository.findByRouteFromLocationAndToLocation(locations[0].trim(), locations[1].trim()).orElseThrow(() -> new RuntimeException("Route Not Found"));

        BusSchedule schedule = BusSchedule.builder()
        .bus(bus)
        .route(route)
        .travelDate(request.getTravelDate())
        .departureTime(request.getDepartureTime())
        .arrivalTime(request.getArrivalTime())
        .availableSeat(request.getAvailableSeat()).build();

        BusSchedule saved = busScheduleRepository.save(schedule);

        return BusScheduleDTO.builder()
        .id(saved.getId())
        .bus(saved.getBus().getPlateNumber() + " - " + saved.getBus().getCompany())
        .route(saved.getRoute().getFromLocation().getLocationName() + " - " + saved.getRoute().getToLocation().getLocationName())
        .travelDate(saved.getTravelDate())
        .departureTime(saved.getDepartureTime())
        .arrivalTime(saved.getArrivalTime()).build();
    }

    // 4 . Method 4
    //✅✅ Delete Bus Schedule Method
    void deleteBusSchedule(Integer id){
        busScheduleRepository.deleteById(id);
    }

    // 5 . Method 5 
    //✅✅ Update Bus Schedule Method
    

}
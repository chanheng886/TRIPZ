package com.tripz.backend.Bus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tripz.backend.Bus.dto.BusLocationCreateRequestDTO;
import com.tripz.backend.Bus.dto.BusLocationDTO;
import com.tripz.backend.Bus.entities.BusLocation;
import com.tripz.backend.Bus.repositories.BusLocationRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusLocationService {
    private final BusLocationRepository busLocationRepository;
    
    // 1. First Method
    // ✅✅ Get All Bus Departure place & arrival place location
    public List<BusLocationDTO> getAllBusLocation(){
        return busLocationRepository.findAll().stream().map(location ->{
            BusLocationDTO dto = new BusLocationDTO();
            dto.setId(location.getId());
            dto.setLocationName(location.getLocationName());
            dto.setImageUrl(location.getImageUrl());
            return dto;
        }).toList();
    }

    // 2. Second Method
    // ✅✅ Get Bus Departure place & arrival place location By Name
    public BusLocationDTO getLocationByLocationName(String locationName){
        BusLocation location = busLocationRepository.findByLocationName(locationName).orElseThrow(() -> new RuntimeException("Location Not Found!"));
        BusLocationDTO dto = new BusLocationDTO();
        dto.setId(location.getId());
        dto.setLocationName(location.getLocationName());
        dto.setImageUrl(location.getImageUrl());

        return dto;   
    }
    // 3. Third Method
    //✅✅ Create Location Name
    public BusLocationDTO createBusLocation(BusLocationCreateRequestDTO request){
        BusLocation location = new BusLocation();

        location.setLocationName(request.getLocationName());
        location.setImageUrl(request.getImageUrl());

        BusLocation savedLocation = busLocationRepository.save(location);

        BusLocationDTO dto = new BusLocationDTO();

        dto.setId(savedLocation.getId());
        dto.setLocationName(savedLocation.getLocationName());
        dto.setImageUrl(savedLocation.getImageUrl());

        return dto;
    }
    

    // 4. Fourth Method
    //✅✅ Delete Location Name By Id
    public BusLocationDTO deleteBusLocation(Integer id){
         BusLocation location = busLocationRepository.findById(id).orElseThrow(() -> new RuntimeException("Location Not Found"));

         busLocationRepository.delete(location);
         
         BusLocationDTO dto = new BusLocationDTO();
         dto.setId(location.getId());
         dto.setLocationName(location.getLocationName());
         dto.setImageUrl(location.getImageUrl());
         
         return dto;
    }

    // 5. Method five
    // ✅✅ Update Locatin
    public BusLocationDTO updateBusLocation(Integer id, BusLocationCreateRequestDTO request){
        BusLocation location = busLocationRepository.findById(id).orElseThrow(() -> new RuntimeException("No Location Found"));

        location.setLocationName(request.getLocationName());
        location.setImageUrl(request.getImageUrl());

        BusLocation savedLocation = busLocationRepository.save(location);

        BusLocationDTO dto = new BusLocationDTO();

        dto.setId(savedLocation.getId());
        dto.setLocationName(savedLocation.getLocationName());
        dto.setImageUrl(savedLocation.getImageUrl());

        return dto;
    }
}

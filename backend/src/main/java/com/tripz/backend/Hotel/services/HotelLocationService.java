package com.tripz.backend.Hotel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tripz.backend.Hotel.dto.HotelLocationCreateRequestDTO;
import com.tripz.backend.Hotel.dto.HotelLocationDTO;
import com.tripz.backend.Hotel.entities.HotelLocation;
import com.tripz.backend.Hotel.repositories.HotelLocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelLocationService {
    private final HotelLocationRepository hotelLocationRepository;

    

    // 1. Method One
    // ✅✅ Get All Hotel Locaiton
    public List<HotelLocationDTO> getAllHotelLcoation(){
        return hotelLocationRepository.findAll().stream().map(
            hotelLocation -> HotelLocationDTO.builder()
            .id(hotelLocation.getId())
            .locationName(hotelLocation.getLocationName())
            .imageUrl(hotelLocation.getImageUrl())
            .build()
        ).toList();
    }

    // 2. Method Two
    //✅✅ HotelLocation By Location Name
    public HotelLocationDTO getHotelLocationByLocationName(String locationName){
        HotelLocation hotelLocation = hotelLocationRepository.findByLocationName(locationName).orElseThrow(() -> new RuntimeException("Location Not Found!!"));

        return HotelLocationDTO.builder()
        .id(hotelLocation.getId())
        .locationName(hotelLocation.getLocationName())
        .imageUrl(hotelLocation.getImageUrl()).build();
        
    }


    // 3 . Method Two
    // ✅✅ Create Hotel Location
    public HotelLocationDTO createHotelLocation(HotelLocationCreateRequestDTO request){
        HotelLocation location = HotelLocation.builder()
        .locationName(request.getLocationName())
        .imageUrl(request.getImageUrl()).build();

        HotelLocation saved = hotelLocationRepository.save(location);

        return HotelLocationDTO.builder()
        .id(saved.getId())
        .locationName(saved.getLocationName())
        .imageUrl(saved.getImageUrl()).build();
    }

    // 4 . Method Four
    // ✅✅ Update Hotel Lcoation
    public HotelLocationDTO updateHotelLocation(HotelLocationCreateRequestDTO request, Integer id){
        HotelLocation hotelLocation = hotelLocationRepository.findById(id).orElseThrow(() -> new RuntimeException("Location Not Found!!"));

        hotelLocation.setLocationName(request.getLocationName());
        hotelLocation.setImageUrl(request.getImageUrl());

        HotelLocation saved = hotelLocationRepository.save(hotelLocation);

        return HotelLocationDTO.builder()
            .id(saved.getId())
            .locationName(saved.getLocationName())
            .imageUrl(saved.getImageUrl())
            .build();
    }

    // 5 . Method Five
    // ✅✅ Delete Hotel Locaiton
    public void deleteHotelLocation(Integer id){
        hotelLocationRepository.deleteById(id);
    }
}

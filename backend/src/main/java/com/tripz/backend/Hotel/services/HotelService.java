package com.tripz.backend.Hotel.services;
import java.util.List;
import org.springframework.stereotype.Service;

import com.tripz.backend.Hotel.dto.HotelCreateRequestDTO;
import com.tripz.backend.Hotel.dto.HotelDTO;
import com.tripz.backend.Hotel.entities.HotelLocation;
import com.tripz.backend.Hotel.entities.Hotels;
import com.tripz.backend.Hotel.repositories.HotelLocationRepository;
import com.tripz.backend.Hotel.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;
    private final HotelLocationRepository hotelLocationRepository;

    // 1 . Method one
    // ✅✅ Get All Hotels
    public List<HotelDTO> getAllHotel(){
        List<Hotels> hotels = hotelRepository.findAll();
        if(hotels.isEmpty()){
            throw new RuntimeException("Hotel Not Found!");
        }
        return hotels.stream().map(
            hotel ->
            HotelDTO.builder()
            .id(hotel.getId())
            .hotelName(hotel.getHotelName())
            .locationName(hotel.getLocationName().getLocationName())
            .totalRoom(hotel.getTotalRoom()).build()
        ).toList();
    }

    // 2. Method two
    // ✅✅ Get Hotel By Hotel Name
    public HotelDTO getHotelByHotelName(String hotelName){
        Hotels hotel = hotelRepository.findHotelByHotelName(hotelName);
        if(hotel == null){
            throw new RuntimeException("Hotel Not Found");
        }
        return HotelDTO.builder()
        .id(hotel.getId())
        .hotelName(hotel.getHotelName())
        .locationName(hotel.getLocationName().getLocationName())
        .totalRoom(hotel.getTotalRoom()).build();
    }

    // 3 . Method Three
    // ✅✅ Get All Hotels By Locaiton Name
    public List<HotelDTO> getHotelsByLocationName(String locationName){
        List<Hotels> hotels = hotelRepository.findByLocationName(locationName);
        if(hotels.isEmpty()){
            throw new RuntimeException("No Hotel Found");
        }
        return hotels.stream().map(hotel ->
            HotelDTO.builder()
            .id(hotel.getId())
            .hotelName(hotel.getHotelName())
            .locationName(hotel.getLocationName().getLocationName())
            .totalRoom(hotel.getTotalRoom())
            .build()
        ).toList();
    }


    // 4 . Method Four
    // ✅✅ Create || Add Hotels
    public HotelDTO createHotel(HotelCreateRequestDTO request){
        HotelLocation location = hotelLocationRepository.findByLocationName(request.getLocationName()).orElseThrow(() -> new RuntimeException("Location Not Found!"));

        Hotels hotels = new Hotels();
        hotels.setHotelName(request.getHotelName());
        hotels.setLocationName(location);
        hotels.setTotalRoom(request.getTotalRoom());

        Hotels saved = hotelRepository.save(hotels);
        return HotelDTO.builder()
        .id(saved.getId())
        .hotelName(saved.getHotelName())
        .locationName(saved.getLocationName().getLocationName())
        .totalRoom(saved.getTotalRoom())
        .build();
    }

    // 5 . Method 5
    // ✅✅ Update Hotels
    public HotelDTO updateHotel(HotelCreateRequestDTO request, Integer id){
        Hotels hotel = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel Not Found"));
        HotelLocation location = hotelLocationRepository.findByLocationName(request.getLocationName()).orElseThrow(() -> new RuntimeException("Location Not Found!"));

        hotel.setHotelName(request.getHotelName());
        hotel.setLocationName(location);
        hotel.setTotalRoom(request.getTotalRoom());

        Hotels saved = hotelRepository.save(hotel);

        return HotelDTO.builder()
        .id(saved.getId())
        .hotelName(saved.getHotelName())
        .locationName(saved.getLocationName().getLocationName())
        .totalRoom(saved.getTotalRoom())
        .build();
    }

    // 6 Method 6
    // ✅✅ Delete Method
    public void deleteHotel(Integer id){
        hotelRepository.deleteById(id);
    }
}
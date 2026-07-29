package com.tripz.backend.Hotel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tripz.backend.Hotel.dto.HotelRoomDTO;
import com.tripz.backend.Hotel.entities.HotelRoom;
import com.tripz.backend.Hotel.repositories.HotelRoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelRoomService {
    private final HotelRoomRepository hotelRoomRepository;

    // 1. Method one
    // ✅✅ Get All Hotel Room
    public List<HotelRoomDTO> getAllHotelRoom(){
        List<HotelRoom> hotels = hotelRoomRepository.findAll();
        if(hotels.isEmpty()){
            throw new RuntimeException("No Hotel Found!!");
        }
        return hotels.stream().map(hotelRoom ->
            HotelRoomDTO.builder()
            .id(hotelRoom.getId())
            .hotels(hotelRoom.getHotels().getId() + " - " + hotelRoom.getHotels().getHotelName())
            .roomType(hotelRoom.getRoomType().getId() + " - " + hotelRoom.getRoomType().getRoomType())
            .roomCount(hotelRoom.getRoomCount())
            .price(hotelRoom.getPrice())
            .build()
        ).toList();
    }

    // 2 . Method Two
    // ✅✅ Get hotel Room By Hotel Name || Id
    public List<HotelRoomDTO> getAllHotelByHotelName(String hotelName){
        List<HotelRoom> rooms = hotelRoomRepository.findByHotelName(hotelName);
        if(rooms.isEmpty()){
            throw new RuntimeException("No Hotel Found");
        }

        return rooms.stream().map(hotelRoom ->
            HotelRoomDTO.builder()
            .id(hotelRoom.getId())
            .hotels(hotelRoom.getHotels().getId() + " - " + hotelRoom.getHotels().getHotelName())
            .roomType(hotelRoom.getRoomType().getId() + " - " + hotelRoom.getRoomType().getRoomType())
            .roomCount(hotelRoom.getRoomCount())
            .price(hotelRoom.getPrice())
            .build()
        ).toList();
    }

    // 3 . Method Three
    // ✅✅ Create RoomType Of Hotel
}

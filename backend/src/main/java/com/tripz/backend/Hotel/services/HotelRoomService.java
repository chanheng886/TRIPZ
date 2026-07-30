package com.tripz.backend.Hotel.services;
import java.util.List;
import org.springframework.stereotype.Service;
import com.tripz.backend.Hotel.dto.HotelRoomCreateRequestDTO;
import com.tripz.backend.Hotel.dto.HotelRoomDTO;
import com.tripz.backend.Hotel.entities.HotelRoom;
import com.tripz.backend.Hotel.entities.Hotels;
import com.tripz.backend.Hotel.entities.RoomType;
import com.tripz.backend.Hotel.repositories.HotelRepository;
import com.tripz.backend.Hotel.repositories.HotelRoomRepository;
import com.tripz.backend.Hotel.repositories.RoomTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelRoomService {
    private final HotelRoomRepository hotelRoomRepository;
    private final HotelRepository hotelRepository;
    private final RoomTypeRepository roomTypeRepository;

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
    public HotelRoomDTO createHotelRoom(HotelRoomCreateRequestDTO request){
        Hotels hotel = hotelRepository.findHotelByHotelName(request.getHotels());
        if(hotel == null){
            throw new RuntimeException("Hotel Not Found!");
        }
        RoomType roomType  = roomTypeRepository.findByRoomType(request.getRoomType()).orElseThrow(() -> new RuntimeException("Room Type Not Found!"));

        HotelRoom hotelRooom= HotelRoom.builder()
        .hotels(hotel)
        .roomType(roomType)
        .roomCount(request.getRoomCount())
        .price(request.getPrice()).build();        

        HotelRoom saved = hotelRoomRepository.save(hotelRooom);

        return HotelRoomDTO.builder()
        .id(saved.getId())
        .hotels(saved.getHotels().getHotelName() + " - " + saved.getHotels().getLocationName().getLocationName())
        .roomType(saved.getRoomType().getRoomType())
        .roomCount(saved.getRoomCount())
        .price(saved.getPrice()).build();
    }

    // Method Four
    //✅✅ Update Hotel Room
    public HotelRoomDTO updateHotelRoom(HotelRoomCreateRequestDTO request, Integer id){
        HotelRoom hotelRoom = hotelRoomRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel Room Not Found"));

        Hotels hotels = hotelRepository.findHotelByHotelName(request.getHotels());
        if(hotels==null){
            throw new RuntimeException("Hotel Not Found");
        }
        RoomType roomType = roomTypeRepository.findByRoomType(request.getRoomType()).orElseThrow(() -> new RuntimeException("Room Type Not Found!!"));

        hotelRoom.setHotels(hotels);
        hotelRoom.setRoomType(roomType);
        hotelRoom.setRoomCount(request.getRoomCount());
        hotelRoom.setPrice(request.getPrice());

        HotelRoom saved = hotelRoomRepository.save(hotelRoom);


        return HotelRoomDTO.builder()
        .id(saved.getId())
         .hotels(saved.getHotels().getHotelName() + " - " + saved.getHotels().getLocationName().getLocationName())
        .roomType(saved.getRoomType().getRoomType())
        .roomCount(saved.getRoomCount())
        .price(saved.getPrice()).build();
    }

    // 5 . Method Five
    //✅✅ Delete Method
    public void deleteHotelRoom(Integer id){
        hotelRoomRepository.deleteById(id);
    }

}

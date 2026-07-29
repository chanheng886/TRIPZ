package com.tripz.backend.Hotel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tripz.backend.Hotel.dto.RoomCreateRequestDTO;
import com.tripz.backend.Hotel.dto.RoomDTO;
import com.tripz.backend.Hotel.entities.RoomType;
import com.tripz.backend.Hotel.repositories.RoomTypeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomTypeService {
    private final RoomTypeRepository roomTypeRepository;

    // 1 . Method One
    // ✅✅ Get All Room Type
    public List<RoomDTO> getAllRoomType(){
        return roomTypeRepository.findAll().stream().map(room ->
            RoomDTO.builder()
            .id(room.getId())
            .roomType(room.getRoomType()).build()
        ).toList();
    } 

    // 2 . Method Two
    // ✅✅ Create Room Type
    public RoomDTO createRoomType(RoomCreateRequestDTO request){
        RoomType room = new RoomType();
        
        room.setRoomType(request.getRoomType());

        RoomType saved = roomTypeRepository.save(room);

        return RoomDTO.builder()
        .id(saved.getId())
        .roomType(saved.getRoomType()).build();
    }    

    // 3 . Method Three
    // ✅✅ Update Room Type
    public RoomDTO updateRoomType(RoomCreateRequestDTO request, Integer id){
        RoomType room = roomTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Room Not Found"));

        room.setRoomType(request.getRoomType());
        RoomType savedRoom = roomTypeRepository.save(room);

        return RoomDTO.builder()
        .id(savedRoom.getId())
        .roomType(savedRoom.getRoomType())
        .build();
    }

    // 4 . Method Four
    //✅✅ Delete Method

    public void deleteRoomType(Integer id){
        roomTypeRepository.deleteById(id);
    }
}

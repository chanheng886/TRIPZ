package com.tripz.backend.Hotel.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripz.backend.Hotel.dto.HotelRoomCreateRequestDTO;
import com.tripz.backend.Hotel.dto.HotelRoomDTO;
import com.tripz.backend.Hotel.services.HotelRoomService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotel-room")
@Tag(name = "Hotel Room")
public class HotelRoomController {
    private final HotelRoomService hotelRoomService;

    @GetMapping
    public List<HotelRoomDTO> findAllHotelRoom(){
        return hotelRoomService.getAllHotelRoom();
    }

    @GetMapping("hotel-name/{hotelName}")
    public List<HotelRoomDTO> findHotelRoomByHotelName(@PathVariable String hotelName){
        return hotelRoomService.getAllHotelByHotelName(hotelName);
    }

    @PostMapping("/create")
    public HotelRoomDTO createHotelRoom(@RequestBody HotelRoomCreateRequestDTO request){
        return hotelRoomService.createHotelRoom(request);
    }

    @PutMapping("/update/{id}")
    public HotelRoomDTO updateHotelRoom(@RequestBody HotelRoomCreateRequestDTO request,@PathVariable Integer id){
        return hotelRoomService.updateHotelRoom(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHotelRoom(@PathVariable Integer id){
        hotelRoomService.deleteHotelRoom(id);
    }
}

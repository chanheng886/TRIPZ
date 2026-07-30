package com.tripz.backend.Hotel.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tripz.backend.Hotel.dto.HotelScheduleCreateRequestDTO;
import com.tripz.backend.Hotel.dto.HotelScheduleDTO;
import com.tripz.backend.Hotel.entities.HotelSchedule;
import com.tripz.backend.Hotel.entities.Hotels;
import com.tripz.backend.Hotel.entities.RoomType;
import com.tripz.backend.Hotel.enums.Status;
import com.tripz.backend.Hotel.repositories.HotelRepository;
import com.tripz.backend.Hotel.repositories.HotelScheduleRepository;
import com.tripz.backend.Hotel.repositories.RoomTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelScheduleService {
    private final HotelScheduleRepository hotelScheduleRepository;
    private final HotelRepository hotelRepository;
    private final RoomTypeRepository roomTypeRepository;

    // 1 Method One
    // ✅✅ Get All Hotel Schedule
    public List<HotelScheduleDTO> getAllHotelSchedule(){
        return hotelScheduleRepository.findAll().stream().map(
            hotelSchedule -> HotelScheduleDTO.builder()
            .id(hotelSchedule.getId())
            .hotels(hotelSchedule.getHotels().getId() + " - " + hotelSchedule.getHotels().getHotelName())
            .roomType(hotelSchedule.getRoomType().getRoomType())
            .checkInDate(hotelSchedule.getCheckInDate())
            .checkOutDate(hotelSchedule.getCheckOutDate()).build()
        ).toList();
    }

    // 2 Method Two
    //✅✅ Get Hotel Schedule By Checkin Date and Checkout Date and LocationName
    public List<HotelScheduleDTO> getHotelScheduleByCheckInDateAndCheckOutDateAndLocationName(@PathVariable LocalDate checkInDate,@PathVariable LocalDate checkOutDate,@PathVariable String locationName){
        return hotelScheduleRepository.findByCheckInDateAndCheckOutDateAndLocationName(checkInDate, checkOutDate,locationName
        ).stream().map(
            hotelSchedule ->
            HotelScheduleDTO.builder()
            .id(hotelSchedule.getId())
            .hotels(hotelSchedule.getHotels().getId() + " - " + hotelSchedule.getHotels().getHotelName())
            .roomType(hotelSchedule.getRoomType().getRoomType())
            .checkInDate(hotelSchedule.getCheckInDate())
            .checkOutDate(hotelSchedule.getCheckOutDate()).build()
        ).toList();
    }

    // 3 Method Three
    // ✅✅ Create Hotel Schedule
    public HotelScheduleDTO createHotelSchedule(HotelScheduleCreateRequestDTO request){
        Hotels hotels = hotelRepository.findHotelByHotelName(request.getHotels());
        if(hotels == null){
            throw new RuntimeException("Hotel Not Found");
        }
        RoomType roomType = roomTypeRepository.findByRoomType(request.getRoomType()).orElseThrow(() -> new RuntimeException("Room Type Not Found"));

        HotelSchedule hotelSchedule = new HotelSchedule();
        hotelSchedule.setHotels(hotels);
        hotelSchedule.setRoomType(roomType);
        hotelSchedule.setCheckInDate(request.getCheckInDate());
        hotelSchedule.setCheckOutDate(request.getCheckOutDate());
        hotelSchedule.setStatus(Status.Available);

        HotelSchedule saved = hotelScheduleRepository.save(hotelSchedule);

        return HotelScheduleDTO.builder()
        .id(saved.getId())
        .hotels(saved.getHotels().getId() + " - " + saved.getHotels().getHotelName() + " - " + saved.getHotels().getLocationName().getLocationName())
        .roomType(saved.getRoomType().getRoomType())
        .checkInDate(saved.getCheckInDate())
        .checkOutDate(saved.getCheckOutDate()).build();
    }

    // 4 Method Fout
    // ✅✅ Update Hotel Schedule
    public HotelScheduleDTO updateHotelSchedule(HotelScheduleCreateRequestDTO request, Integer id){
        HotelSchedule hotelSchedule = hotelScheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel Schedule Not Found!!"));
        Hotels hotels = hotelRepository.findHotelByHotelName(request.getHotels());
        if(hotels == null){
            throw new RuntimeException("Hotel Not Found");
        }
        RoomType roomType = roomTypeRepository.findByRoomType(request.getRoomType()).orElseThrow(() -> new RuntimeException("Room Type Not Found"));

        hotelSchedule.setHotels(hotels);
        hotelSchedule.setRoomType(roomType);
        hotelSchedule.setCheckInDate(request.getCheckInDate());
        hotelSchedule.setCheckOutDate(request.getCheckOutDate());
        hotelSchedule.setStatus(request.getStatus());

        HotelSchedule saved = hotelScheduleRepository.save(hotelSchedule);

        return HotelScheduleDTO.builder()
        .id(saved.getId())
        .hotels(saved.getHotels().getId() + " - " + saved.getHotels().getHotelName() + " - " + saved.getHotels().getLocationName().getLocationName())
        .roomType(saved.getRoomType().getRoomType())
        .checkInDate(saved.getCheckInDate())
        .checkOutDate(saved.getCheckOutDate()).build();
    }

    // 5 Method Five
    //✅✅ Delete Hotel Schedule
    public void deleteHotelSchedule(@PathVariable Integer id){
        hotelScheduleRepository.deleteById(id);
    }
}

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
import com.tripz.backend.Hotel.dto.RoomCreateRequestDTO;
import com.tripz.backend.Hotel.dto.RoomDTO;
import com.tripz.backend.Hotel.services.RoomTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/room-type")
@RequiredArgsConstructor
@Tag(name = "Room Type")
public class RoomTypeController {
    private final RoomTypeService roomTypeService;

    @GetMapping
    public List<RoomDTO> getAllRoomType(){
        return roomTypeService.getAllRoomType();
    }

    @PostMapping("/create/")
    public RoomDTO createRoomType(@RequestBody RoomCreateRequestDTO request){
        return roomTypeService.createRoomType(request);
    }

    @PutMapping("/update/{id}/")
    public RoomDTO updateRoomType(@RequestBody RoomCreateRequestDTO request,@PathVariable Integer id){
        return roomTypeService.updateRoomType(request, id);
    }

    @DeleteMapping("/{id}/")
    public void deleteRoomType(@PathVariable Integer id){
        roomTypeService.deleteRoomType(id);
    }
}

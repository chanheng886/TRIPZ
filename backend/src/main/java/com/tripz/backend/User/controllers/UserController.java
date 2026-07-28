package com.tripz.backend.User.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripz.backend.User.dto.UserCreateRequestDTO;
import com.tripz.backend.User.dto.UserDTO;
import com.tripz.backend.User.enums.Gender;
import com.tripz.backend.User.enums.Roles;
import com.tripz.backend.User.services.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("role/{role}")
    public List<UserDTO> getAllUserByRole(@PathVariable Roles role){
        return userService.getUserByRole(role);
    }

    @PostMapping("role-create/{role}/{gender}")
    public UserDTO createUser(@RequestBody UserCreateRequestDTO request,@PathVariable Roles role,@PathVariable Gender gender ){
        return userService.createUser(request, role, gender);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

    @PutMapping("role-update/{id}/{role}/{gender}")
    public UserDTO updateUser(@RequestBody UserCreateRequestDTO request,@PathVariable Integer id,@PathVariable  Roles role,@PathVariable Gender gender){
        return userService.updateUser(request, role, gender, id);
    }
}

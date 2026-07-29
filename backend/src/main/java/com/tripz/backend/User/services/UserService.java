package com.tripz.backend.User.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tripz.backend.User.dto.UserCreateRequestDTO;
import com.tripz.backend.User.dto.UserDTO;
import com.tripz.backend.User.entities.User;
import com.tripz.backend.User.enums.Gender;
import com.tripz.backend.User.enums.Roles;
import com.tripz.backend.User.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 1. Method One
    // ✅✅ Get All Users Function
    public List<UserDTO> getAllUser(){
        return userRepository.findAll().stream().map(user -> 
            UserDTO.builder()
            .id(user.getId())
            .roles(user.getRole().name())
            .username(user.getUsername())
            .gender(user.getGender().name())
            .email(user.getEmail())
            .phone(user.getPhone())
            .build()
        ).toList();
    }
    // 2 . Method two
    // ✅✅ Get User By Role
    public List<UserDTO> getUserByRole(Roles role){
        List<User> users = userRepository.findByRole(role);
        
        return users.stream()
        .map(user -> 
            UserDTO.builder()
            .id(user.getId())
            .username(user.getUsername())
            .roles(user.getRole().name())
            .gender(user.getGender().name())
            .email(user.getEmail())
            .phone(user.getPhone()).build()
        ).toList();
    }

    // 3. Method Three
    // ✅✅ Create User
    public UserDTO createUser(UserCreateRequestDTO request, Roles role, Gender gender){
        
        User users = User.builder()
        .username(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(role)
        .gender(gender)
        .email(request.getEmail())
        .phone(request.getPhone()).build();
        
        User saved = userRepository.save(users);

        return UserDTO.builder()
        .id(saved.getId())
        .roles(saved.getRole().name())
        .gender(saved.getGender().name())
        .email(saved.getEmail())
        .phone(saved.getPhone()).build();
    }

    // 4 Method Four
    // ✅✅ Delete User 
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    // 5 Method Five
    // ✅✅ Update User
    public UserDTO updateUser(UserCreateRequestDTO request, Roles role, Gender gender, Integer id){
        User users = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));

        users.setUsername(request.getUsername());
        users.setRole(role);
        users.setGender(gender);
        users.setEmail(request.getEmail());
        users.setPhone(request.getPhone());

        User saved = userRepository.save(users);

        return UserDTO.builder()
        .id(saved.getId())
        .roles(saved.getRole().name())
        .gender(saved.getGender().name())
        .username(saved.getUsername())
        .email(saved.getEmail())
        .phone(saved.getPhone()).build();
    }
}
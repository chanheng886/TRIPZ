package com.tripz.backend.User.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequestDTO {
    private String roles;
    private String username;
    private String gender;
    private String email;
    private String phone;
}

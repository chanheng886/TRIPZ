package com.tripz.backend.User.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tripz.backend.User.entities.User;
import com.tripz.backend.User.enums.Roles;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRole(Roles role);
}

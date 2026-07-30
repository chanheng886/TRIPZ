package com.tripz.backend.User.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tripz.backend.User.entities.User;
import com.tripz.backend.User.enums.Roles;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRole(Roles role);
    Optional<User> findByUsername(String username);
}

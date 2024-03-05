package com.kpi.bank.repository;

import com.kpi.bank.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}

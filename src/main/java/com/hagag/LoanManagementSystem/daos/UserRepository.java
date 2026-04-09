package com.hagag.LoanManagementSystem.daos;

import com.hagag.LoanManagementSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

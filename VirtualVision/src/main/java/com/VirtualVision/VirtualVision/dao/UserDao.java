package com.VirtualVision.VirtualVision.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.VirtualVision.VirtualVision.domain.User;
@Repository
public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.email LIKE '%@gmail.com'")
    ArrayList<User> findByEmail();
}
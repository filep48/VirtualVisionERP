package com.VirtualVision.VirtualVision.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.VirtualVision.VirtualVision.domain.Chat;


public interface IChatDao extends JpaRepository<Chat, Long> {
    @Query("SELECT c.name FROM Chat c JOIN c.users u WHERE u.id = ?1")
    List<String> findAllChatNamesByUserId(Long userId);
}


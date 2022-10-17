package com.example.Reto3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reto3.entities.Message;

public interface MessageRepository  extends JpaRepository<Message, Integer>{
}

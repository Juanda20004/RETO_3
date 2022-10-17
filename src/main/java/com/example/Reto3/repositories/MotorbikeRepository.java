package com.example.Reto3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reto3.entities.Motorbike;

public interface MotorbikeRepository  extends JpaRepository<Motorbike, Integer>{
}

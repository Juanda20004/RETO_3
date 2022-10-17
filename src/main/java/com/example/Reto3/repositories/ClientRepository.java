package com.example.Reto3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reto3.entities.Client;



public interface ClientRepository  extends JpaRepository<Client, Integer>{
}

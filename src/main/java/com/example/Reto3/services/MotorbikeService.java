package com.example.Reto3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto3.entities.Motorbike;
import com.example.Reto3.repositories.MotorbikeRepository;


@Service
public class MotorbikeService {
    
        @Autowired
        private MotorbikeRepository motorbikeRepository;

        public MotorbikeService(MotorbikeRepository motorbikeRepository) {
            this.motorbikeRepository = motorbikeRepository;
        }

        public List<Motorbike> getListMotorbikes(){
            return this.motorbikeRepository.findAll();
        }

        public Motorbike getMotorbike(int id){
            if(!this.motorbikeRepository.findById(id).isEmpty()){
                return this.motorbikeRepository.findById(id).get();
            }else{
                return null;
            }
        }

        public Motorbike crearMotorbike(Motorbike motorbike){
            System.out.println("service OK *************");
            return this.motorbikeRepository.save(motorbike);
        }

        public void eliminarMotorbike(int id){
            if(!this.motorbikeRepository.findById(id).isEmpty()){
                this.motorbikeRepository.deleteById(id);
            }
        }

        public void actualizarMotorbike(int id, Motorbike motorbike){
            if(!this.motorbikeRepository.findById(id).isEmpty()){
                Motorbike motorbikeDB = this.motorbikeRepository.findById(id).get();
                if(motorbike.getName() != null){
                    motorbikeDB.setName(motorbike.getName());
                }
                if(motorbike.getBrand() != null){
                    motorbikeDB.setBrand(motorbike.getBrand());
                }
                if(motorbike.getDescription() != null){
                    motorbikeDB.setDescription(motorbike.getDescription());
                }
                if(motorbike.getYear() != null){
                    motorbikeDB.setYear(motorbike.getYear());
                }

                this.motorbikeRepository.save(motorbikeDB);
            }
        }
}
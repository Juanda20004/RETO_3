package com.example.Reto3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto3.entities.Motorbike;
import com.example.Reto3.services.MotorbikeService;

@Service
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/Motorbike")
public class MotorbikeController {    

    @Autowired
    MotorbikeService motorbikeService;

    public MotorbikeController(MotorbikeService motorbikeService) {
        this.motorbikeService = motorbikeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Motorbike>> getMotorbikes(){
        return new ResponseEntity<List<Motorbike>>(this.motorbikeService.getListMotorbikes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motorbike> getMotorbike(@PathVariable("id") int id){
        return new ResponseEntity<Motorbike>(this.motorbikeService.getMotorbike(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> crearMotorbike(@RequestBody Motorbike motorbike){
        System.out.println("Controller OK *************");
        this.motorbikeService.crearMotorbike(motorbike);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  eliminarMotorbike(@PathVariable("id") int id){
        this.motorbikeService.eliminarMotorbike(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void>  actualizarMotorbike(@RequestBody Motorbike motorbike){
        this.motorbikeService.actualizarMotorbike(motorbike.getId(), motorbike);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}

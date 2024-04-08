package com.creating.code.jadso.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.creating.code.jadso.models.Car;
import com.creating.code.jadso.services.CarService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/jadso")
public class CarController {
    
    private final CarService carService;
    
    public CarController(CarService carService){
        this.carService = carService;
    } 
    
    @GetMapping(value="/cars")
    public ResponseEntity<Object> get(){ 
        Map<String, Object> map = new HashMap<>();
        try {
            List<Car> list = carService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } 
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }
    
    @GetMapping(value="/cars/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){ 
        try {
            Car car = carService.findById(id);
            return new ResponseEntity<>(car, HttpStatus.OK);
        } 
        catch (Exception e) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }

    @PostMapping(value="/cars")
    public ResponseEntity<Object> create(@RequestBody Car car){ 
        Map<String, Object> map = new HashMap<>();
        try {
            Car newCar = carService.save(car);  
            return new ResponseEntity<>(newCar, HttpStatus.OK);
        } 
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }
    
    @PutMapping("/cars/{id}")
    public ResponseEntity<Object> update(@RequestBody Car car, @PathVariable Long id){ 
        Map<String, Object> map = new HashMap<>();
        try {
            Car existingCar = carService.findById(id);

            existingCar.setMarca(car.getMarca());
            existingCar.setModelo(car.getModelo());
            existingCar.setPrecio(car.getPrecio()); 
            existingCar.setAno(car.getAno()); 
            existingCar.setColor(car.getColor()); 
            existingCar.setMatricula(car.getMatricula()); 
            
            Car updatedCar = carService.save(car);
            
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        } 
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Map<String, Object> map = new HashMap<>();
        try {
            Car existingCar = carService.findById(id);
            carService.delete(existingCar);
            map.put("deleted", true);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}

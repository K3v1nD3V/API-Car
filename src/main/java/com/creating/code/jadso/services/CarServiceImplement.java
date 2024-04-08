package com.creating.code.jadso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creating.code.jadso.models.Car;
import com.creating.code.jadso.interfaces.CarRepository;

@Service
public class CarServiceImplement implements CarService {
    
    @Autowired
    private final CarRepository carRepository;

    public CarServiceImplement(CarRepository carRepository){
        this.carRepository = carRepository;
    }
    
    public List<Car> findAll() {
        return (List<Car>) carRepository.findAll();
    }

    @SuppressWarnings("null")
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @SuppressWarnings("null")
    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public void delete(Car car) {
        carRepository.delete(car);
    }
}

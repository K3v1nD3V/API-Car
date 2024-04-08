package com.creating.code.jadso.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.creating.code.jadso.models.Car;

@Service
public interface CarService {

	public List<Car> findAll();
	
	public Car save(Car car);
	
	public Car findById(Long id);
	
	public void delete(Car car);

}

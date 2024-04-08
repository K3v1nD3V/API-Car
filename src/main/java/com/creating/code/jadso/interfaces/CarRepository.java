package com.creating.code.jadso.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creating.code.jadso.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}

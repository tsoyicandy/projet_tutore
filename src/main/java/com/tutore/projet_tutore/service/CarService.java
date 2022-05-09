package com.tutore.projet_tutore.service;


import com.tutore.projet_tutore.models.Entities.Car;
import com.tutore.projet_tutore.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> listeCar(){
        return carRepository.findAll();
    }

}

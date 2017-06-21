package com.dh.project.project.service;

import com.dh.project.project.domain.Car;
import com.dh.project.project.repository.CarRepository;
import com.dh.project.project.web.CarController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 19/06/2017.
 */
@Service
public class CarService {
    @Autowired
    CarRepository cardRepository;

    public List<Car> getAllCars(){return cardRepository.findAll();}
    public void addCar(CarController.CardRequestDTO car){
        Car res = new Car();
        res.setModel(car.getModel());
        res.setBrand(car.getBrand());
        res.setColor(car.getColor());
        res.setYear(car.getYear());
        res.setImage(car.getImage());
        cardRepository.save(res);
    }
    public void deleteCar(Long idCar){
        cardRepository.delete(idCar);
    }

    public void updateCar(CarController.CardRequestDTO car, Long id){
        Car car1 = cardRepository.findOne(id);
        car1.setModel(car.getModel());
        car1.setBrand(car.getBrand());
        car1.setColor(car.getColor());
        car1.setYear(car.getYear());
        car1.setImage(car.getImage());
        cardRepository.save(car1);
    }


}

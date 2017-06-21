package com.dh.project.project.service;

import com.dh.project.project.domain.Car;
import com.dh.project.project.domain.CardRegistry;
import com.dh.project.project.domain.RegistryCarSold;
import com.dh.project.project.repository.CarRegistryRepository;
import com.dh.project.project.repository.CarRepository;
import com.dh.project.project.repository.RegistryCarSoldRepository;
import com.dh.project.project.web.CarRegistryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 20/06/2017.
 */
@Service
public class CarRegistryService {
    @Autowired
    private CarRegistryRepository carRegistryRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RegistryCarSoldRepository registryCarSoldRepository;

    public List<CardRegistry> getAllCarRegistry () {
        return carRegistryRepository.findAll();
    }

    public void addCardRegistry(CarRegistryController.CarRegistryRequestDTO cardRegistry){
        Car car = carRepository.findOne(cardRegistry.getIdCar());
        RegistryCarSold registryCarSold = registryCarSoldRepository.findOne(cardRegistry.getIdRegistry());
        CardRegistry res = new CardRegistry();
        res.setCar(car);
        res.setRegistryCarSold(registryCarSold);
        carRegistryRepository.save(res);
    }
}

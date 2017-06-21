package com.dh.project.project.web;

import com.dh.project.project.domain.Car;
import com.dh.project.project.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DELL on 20/06/2017.
 */
@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarService cardService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getAllCars(){
        return cardService.getAllCars();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCar(@RequestBody CardRequestDTO car ){
        cardService.addCar(car);
    }

    @RequestMapping(value = "/deleteCar/{id}",method = RequestMethod.DELETE)
    public void deleteCard (@PathVariable Long id){
        cardService.deleteCar(id);
    }

    @RequestMapping(value = "/updateCar/{id}",method = RequestMethod.PUT)
    public void updateCar(@RequestBody CardRequestDTO car, @PathVariable Long id){
        cardService.updateCar(car,id);
    }


    public static class CardRequestDTO{
        private String model;
        private String year;
        private String brand;
        private String color;
        private String image;

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}

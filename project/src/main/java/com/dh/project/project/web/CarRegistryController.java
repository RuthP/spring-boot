package com.dh.project.project.web;

import com.dh.project.project.domain.CardRegistry;
import com.dh.project.project.service.CarRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by DELL on 20/06/2017.
 */
@RestController
@RequestMapping("/carRegistries")
public class CarRegistryController {
    @Autowired
    private CarRegistryService carRegistryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<CardRegistry> getAllCarRegistry (){
        return carRegistryService.getAllCarRegistry();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCarRegistry (@RequestBody CarRegistryRequestDTO carRegistryRequestDTO){
        carRegistryService.addCardRegistry(carRegistryRequestDTO);
    }

    public static class CarRegistryRequestDTO{
        private Long idCar;
        private Long idRegistry;

        public Long getIdCar() {
            return idCar;
        }

        public void setIdCar(Long idCar) {
            this.idCar = idCar;
        }

        public Long getIdRegistry() {
            return idRegistry;
        }

        public void setIdRegistry(Long idRegistry) {
            this.idRegistry = idRegistry;
        }
    }
}

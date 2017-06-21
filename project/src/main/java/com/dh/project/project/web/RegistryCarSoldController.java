package com.dh.project.project.web;

import com.dh.project.project.domain.RegistryCarSold;
import com.dh.project.project.service.RegistryCarSoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by DELL on 20/06/2017.
 */
@RestController
@RequestMapping("/registries")
public class RegistryCarSoldController {
    @Autowired
    private RegistryCarSoldService registryCarSoldService;

    @RequestMapping(method = RequestMethod.GET)
    public List<RegistryCarSold> getAllRegistries (){
        return registryCarSoldService.getAllRegistries();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addRegistry (@RequestBody RegistryRequestDTO registry){
            registryCarSoldService.addRegistry(registry);
    }

    @RequestMapping(value = "/deleteRegistry/{id}",method = RequestMethod.DELETE)
    public void deleteRegistry (@PathVariable Long id){
        registryCarSoldService.deleteRegistry(id);
    }

    @RequestMapping(value = "/registries/carsSoldBySeller/{idSeller}",method = RequestMethod.GET)
    public SellerCardSoldRequestDTO carsSoldBySeller (@PathVariable Long idSeller){
        return registryCarSoldService.carsSoldBySeller(idSeller);
    }

    @RequestMapping(value = "updateRegistry/{id}",method = RequestMethod.PUT)
    public void updateRegistry (@RequestBody RegistryRequestDTO registryRequestDTO,@PathVariable Long id){
        registryCarSoldService.updateRegistry(registryRequestDTO,id);
    }


    public static class RegistryRequestDTO{
        private Date dateOfShell;
        private Long idSeller;
        private Long idClient;

        public Date getDateOfShell() {
            return dateOfShell;
        }

        public void setDateOfShell(Date dateOfShell) {
            this.dateOfShell = dateOfShell;
        }

        public Long getIdSeller() {
            return idSeller;
        }

        public void setIdSeller(Long idSeller) {
            this.idSeller = idSeller;
        }

        public Long getIdClient() {
            return idClient;
        }

        public void setIdClient(Long idClient) {
            this.idClient = idClient;
        }
    }

    public static class SellerCardSoldRequestDTO{
        private String name;
        private String lastName;
        private int numCarsSold;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getNumCarsSold() {
            return numCarsSold;
        }

        public void setNumCarsSold(int numCarsSold) {
            this.numCarsSold = numCarsSold;
        }
    }



}

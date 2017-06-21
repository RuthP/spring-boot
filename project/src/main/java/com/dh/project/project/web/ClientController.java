package com.dh.project.project.web;

import com.dh.project.project.domain.Client;
import com.dh.project.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DELL on 20/06/2017.
 */
@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Client> getAllClients () {
        return clientService.getAllClients();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addClient(@RequestBody ClientRequestDTO client ){
        clientService.addClient(client);
    }

    @RequestMapping(value = "/deleteClient/{id}",method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }

    @RequestMapping(value = "/updateClient/{id}",method = RequestMethod.PUT)
    public void updateCar(@RequestBody ClientRequestDTO client, @PathVariable Long id){
        clientService.updateClient(client,id);
    }

    public static class ClientRequestDTO{
        private String name;
        private String lastName;
        private String ci;
        private String profession;
        private int cellphone;

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

        public String getCi() {
            return ci;
        }

        public void setCi(String ci) {
            this.ci = ci;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public int getCellphone() {
            return cellphone;
        }

        public void setCellphone(int cellphone) {
            this.cellphone = cellphone;
        }
    }
}

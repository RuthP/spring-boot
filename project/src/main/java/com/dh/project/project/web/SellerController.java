package com.dh.project.project.web;

import com.dh.project.project.domain.Seller;
import com.dh.project.project.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DELL on 20/06/2017.
 */
@RestController
@RequestMapping("/sellers")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Seller> getAllSellers (){
        return sellerService.getAllSellers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addSeller(@RequestBody SellerRequestDTO seller){
        sellerService.addSeller(seller);
    }

    @RequestMapping(value = "/deleteSeller/{id}",method = RequestMethod.DELETE)
    public void deleteSeller(@PathVariable Long id){
        sellerService.deleteSeller(id);
    }

    @RequestMapping(value = "/updateSeller/{id}",method = RequestMethod.PUT)
    public void updateSeller(@RequestBody SellerRequestDTO seller, @PathVariable Long id){
        sellerService.updateSeller(seller,id);
    }


    public static class SellerRequestDTO{
        private String name;
        private String lastName;
        private int age;
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

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getNumCarsSold() {
            return numCarsSold;
        }

        public void setNumCarsSold(int numCarsSold) {
            this.numCarsSold = numCarsSold;
        }
    }
}

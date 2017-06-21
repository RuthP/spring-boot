package com.dh.project.project.service;

import com.dh.project.project.domain.Seller;
import com.dh.project.project.repository.SellerRepository;
import com.dh.project.project.web.SellerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 20/06/2017.
 */
@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;

    public List<Seller> getAllSellers(){
        return sellerRepository.findAll();
    }

    public void addSeller(SellerController.SellerRequestDTO seller){
        Seller res = new Seller();
        res.setName(seller.getName());
        res.setLastName(seller.getLastName());
        res.setAge(seller.getAge());
        res.setNumCarsSold(0);
        sellerRepository.save(res);
    }

    public void deleteSeller(Long id){
        sellerRepository.delete(id);
    }

    public void updateSeller(SellerController.SellerRequestDTO seller, Long id){
        Seller seller1 = sellerRepository.findOne(id);
        seller1.setName(seller.getName());
        seller1.setLastName(seller.getLastName());
        seller1.setAge(seller.getAge());
        sellerRepository.save(seller1);
    }
}

package com.dh.project.project.service;

import com.dh.project.project.domain.Client;
import com.dh.project.project.domain.RegistryCarSold;
import com.dh.project.project.domain.Seller;
import com.dh.project.project.repository.ClientRepository;
import com.dh.project.project.repository.RegistryCarSoldRepository;
import com.dh.project.project.repository.SellerRepository;
import com.dh.project.project.web.RegistryCarSoldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 20/06/2017.
 */
@Service
public class RegistryCarSoldService {
    @Autowired
    private RegistryCarSoldRepository registryCarSoldRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ClientRepository clientRepository;


    public List<RegistryCarSold> getAllRegistries(){
        return registryCarSoldRepository.findAll();
    }

    public void addRegistry (RegistryCarSoldController.RegistryRequestDTO registryCarSold){

        Seller seller = sellerRepository.findOne(registryCarSold.getIdSeller());
        seller.setNumCarsSold(seller.getNumCarsSold()+1);
        Client client = clientRepository.findOne(registryCarSold.getIdClient());
        RegistryCarSold registryCarSold1 = new RegistryCarSold();
        registryCarSold1.setDateOfShell(registryCarSold.getDateOfShell());
        registryCarSold1.setSeller(seller);
        registryCarSold1.setClient(client);
        registryCarSoldRepository.save(registryCarSold1);
    }

    public void deleteRegistry (Long id){
        registryCarSoldRepository.delete(id);
    }

    public RegistryCarSoldController.SellerCardSoldRequestDTO carsSoldBySeller (Long idSeller){
        Seller seller = sellerRepository.findOne(idSeller);
        RegistryCarSoldController.SellerCardSoldRequestDTO res = new RegistryCarSoldController.SellerCardSoldRequestDTO();
        //Seller res = new Seller();
        res.setName(seller.getName());
        res.setLastName(seller.getLastName());
        res.setNumCarsSold(seller.getNumCarsSold());
        return res;
    }

    public void updateRegistry (RegistryCarSoldController.RegistryRequestDTO registryCarSold, Long id){
        Client client = clientRepository.findOne(registryCarSold.getIdClient());
        Seller seller = sellerRepository.findOne(registryCarSold.getIdSeller());
        RegistryCarSold registryCarSold1 = new RegistryCarSold();
        registryCarSold1.setClient(client);
        registryCarSold1.setSeller(seller);
        registryCarSold1.setDateOfShell(registryCarSold.getDateOfShell());
        registryCarSoldRepository.save(registryCarSold1);

    }
}

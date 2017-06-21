package com.dh.project.project.service;

import com.dh.project.project.domain.Client;
import com.dh.project.project.repository.ClientRepository;
import com.dh.project.project.web.ClientController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 20/06/2017.
 */
@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public void addClient(ClientController.ClientRequestDTO client){
        Client res = new Client();
        res.setName(client.getName());
        res.setCellphone(client.getCellphone());
        res.setCi(client.getCi());
        res.setLastName(client.getLastName());
        res.setProfession(client.getProfession());
        clientRepository.save(res);
    }

    public void deleteClient(Long id){
        clientRepository.delete(id);
    }

    public void updateClient(ClientController.ClientRequestDTO client, Long id){
        Client client1 = clientRepository.findOne(id);
        client1.setName(client.getName());
        client1.setLastName(client.getLastName());
        client1.setProfession(client.getProfession());
        client1.setCi(client.getCi());
        client1.setCellphone(client.getCellphone());
        clientRepository.save(client1);
    }
}

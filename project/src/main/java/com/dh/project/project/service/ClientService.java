package com.dh.project.project.service;

import com.dh.project.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DELL on 20/06/2017.
 */
@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
}

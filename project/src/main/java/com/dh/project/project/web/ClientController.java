package com.dh.project.project.web;

import com.dh.project.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DELL on 20/06/2017.
 */
@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;
}
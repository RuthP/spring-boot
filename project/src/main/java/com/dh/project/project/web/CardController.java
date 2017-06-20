package com.dh.project.project.web;

import com.dh.project.project.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DELL on 20/06/2017.
 */
@RestController
@RequestMapping("/cars")
public class CardController {
    @Autowired
    CardService cardService;
}

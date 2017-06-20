package com.dh.project.project.service;

import com.dh.project.project.repository.CardRepository;
import com.dh.project.project.web.CardController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DELL on 19/06/2017.
 */
@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;
}

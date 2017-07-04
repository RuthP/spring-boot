package com.dh.demo.demo.demo.service;

import com.dh.demo.demo.demo.domain.DestinationMessage;
import com.dh.demo.demo.demo.domain.Message;
import com.dh.demo.demo.demo.domain.User;
import com.dh.demo.demo.demo.repository.DestinationMessageRepository;
import com.dh.demo.demo.demo.repository.MessageRepository;
import com.dh.demo.demo.demo.repository.UserRepository;
import com.dh.demo.demo.demo.web.DestinationMessageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 29/06/2017.
 */
@Service
public class DestinationMessageService {
    @Autowired
    DestinationMessageRepository destinationMessageRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    public List<DestinationMessage> getAllDestinationMessages(){
       return destinationMessageRepository.findAll();
    }

    public void addDestinationMessage(DestinationMessageController.DestinationMessageRequestDTO destination){
        Message message = new Message();
        User user = new User();
        DestinationMessage res = new DestinationMessage();
        message.setId(destination.getIdMessage());
        user.setId(destination.getIdUser());
        res.setMessage(message);
        res.setUser(user);
        destinationMessageRepository.save(res);
    }
}

package com.dh.demo.demo.demo.service;

import com.dh.demo.demo.demo.domain.Message;
import com.dh.demo.demo.demo.domain.Status;
import com.dh.demo.demo.demo.domain.User;
import com.dh.demo.demo.demo.repository.MessageRepository;
import com.dh.demo.demo.demo.repository.StatusRepository;
import com.dh.demo.demo.demo.repository.UserRepository;
import com.dh.demo.demo.demo.web.MessageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 29/06/2017.
 */
@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    UserRepository userRepository;

    public List<Message> getAllMessages (){
        return messageRepository.findAll();
    }

    public void addMessage(MessageController.MessageRequestDTO message){
        Message res = new Message();
        Status status = new Status();
        User user = new User();
        status.setId(message.getIdStatus());
        user.setId(message.getIdUser());
        res.setContent(message.getContent());
        res.setCreation_date(message.getCreation_date());
        res.setStatus(status);
        res.setUserMessage(user);
        messageRepository.save(res);
    }

    public void deleteMessage (Long id){
        messageRepository.delete(id);
    }

    public  Message updateMessage(Long id, MessageController.MessageRequestDTO message){
        Message message1 = new Message();
        Status status = new Status();
        User user = new User();
        message1.setContent(message.getContent());
        Message res = messageRepository.save(message1);
        return res;



    }
}

package com.dh.demo.demo.demo.web;

import com.dh.demo.demo.demo.modelws.Greeting;
import com.dh.demo.demo.demo.modelws.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * Created by DELL on 17/06/2017.
 */
@Controller
public class CreateMessageWSController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    //fullName
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("" + message.getName());
    }
}


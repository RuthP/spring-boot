package com.dh.demo.demo.demo.web;

import com.dh.demo.demo.demo.domain.Message;
import com.dh.demo.demo.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by DELL on 29/06/2017.
 */
@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addMessage(@RequestBody MessageRequestDTO message){
        messageService.addMessage(message);
    }

    @RequestMapping(value = "/deleteMessage/{id}",method = RequestMethod.DELETE)
    public void deleteMessage (@RequestParam Long id){
        messageService.deleteMessage(id);
    }

    @RequestMapping(value = "/updateMessage/{id}",method = RequestMethod.PUT)
    public Message updateMessage(@RequestParam Long id, @RequestBody MessageRequestDTO message){
       return messageService.updateMessage(id, message);
    }

    public static class MessageRequestDTO{
        private String content;
        private Long idStatus;
        private Date creation_date;
        private Long idUser;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Long getIdStatus() {
            return idStatus;
        }

        public void setIdStatus(Long idStatus) {
            this.idStatus = idStatus;
        }

        public Date getCreation_date() {
            return creation_date;
        }

        public void setCreation_date(Date creation_date) {
            this.creation_date = creation_date;
        }

        public Long getIdUser() {
            return idUser;
        }

        public void setIdUser(Long idUser) {
            this.idUser = idUser;
        }
    }

}

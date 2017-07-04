package com.dh.demo.demo.demo.web;

import com.dh.demo.demo.demo.domain.DestinationMessage;
import com.dh.demo.demo.demo.service.DestinationMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by DELL on 29/06/2017.
 */
@RestController
@RequestMapping("/destinations")
public class DestinationMessageController {

    @Autowired
    DestinationMessageService destinationMessageService;

    @RequestMapping(method = RequestMethod.GET)
    public List<DestinationMessage> getAllDestinationMesagges (){
        return destinationMessageService.getAllDestinationMessages();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addDestinationMessage(@RequestBody DestinationMessageRequestDTO destinationMessageRequestDTO){
        destinationMessageService.addDestinationMessage(destinationMessageRequestDTO);
    }

    public static class DestinationMessageRequestDTO{
        private Long idMessage;
        private Long idUser;

        public Long getIdMessage() {
            return idMessage;
        }

        public void setIdMessage(Long idMessage) {
            this.idMessage = idMessage;
        }

        public Long getIdUser() {
            return idUser;
        }

        public void setIdUser(Long idUser) {
            this.idUser = idUser;
        }
    }
}

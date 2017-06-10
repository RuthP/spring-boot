package com.dh.demo.service;

import com.dh.demo.domain.Room;
import com.dh.demo.repository.RoomRepository;
import com.dh.demo.web.RoomController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 10/06/2017.
 */
@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms (){
        return roomRepository.findAll();
    }

    public void addNewRoom (RoomController.roomRequestDTO roomDTO){
        Room room = new Room();
        room.setCapacity(roomDTO.getCapacity());
        roomRepository.save(room);
    }
}

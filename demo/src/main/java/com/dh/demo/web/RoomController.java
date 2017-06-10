package com.dh.demo.web;

import com.dh.demo.domain.Room;
import com.dh.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by DELL on 10/06/2017.
 */
@RequestMapping("/rooms")
@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Room> getAllRooms (){
        return roomService.getAllRooms();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addNewRoom (@RequestBody roomRequestDTO room){
        roomService.addNewRoom(room);

    }

    public static class roomRequestDTO{
        private int capacity;

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }
    }
}

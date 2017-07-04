package com.dh.demo.demo.demo.web;

import com.dh.demo.demo.demo.domain.Status;
import com.dh.demo.demo.demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DELL on 29/06/2017.
 */
@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    StatusService statusService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Status> getAllStatus(){
        return statusService.getAllStatus();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addStatus (@RequestBody StatusRequestDOT status){
        statusService.addStatus(status);
    }

    @RequestMapping(value = "/deleteStatus/{id}",method = RequestMethod.DELETE)
    public void deleteStatus(@RequestParam Long id){
        statusService.deleteStatus(id);
    }

    @RequestMapping(value = "/updateStatus/{id}",method = RequestMethod.PUT)
    public Status updateStatus(@RequestParam Long id, @RequestBody StatusRequestDOT status) {
        return statusService.updateStatus(id, status);
    }

    public static class StatusRequestDOT{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

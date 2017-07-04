package com.dh.demo.demo.demo.service;

import com.dh.demo.demo.demo.domain.Status;
import com.dh.demo.demo.demo.repository.StatusRepository;
import com.dh.demo.demo.demo.web.StatusController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by DELL on 29/06/2017.
 */
@Service
public class StatusService {
    @Autowired
    StatusRepository statusRepository;

    public List<Status> getAllStatus(){
       return statusRepository.findAll();
    }

    public void addStatus(StatusController.StatusRequestDOT status) {
        Status res = new Status();
        res.setName(status.getName());
        statusRepository.save(res);
    }

    public void deleteStatus(Long id){
        statusRepository.delete(id);
    }

    public  Status updateStatus (Long id, StatusController.StatusRequestDOT status){
        Status status1 = statusRepository.findOne(id);
        status1.setName(status.getName());
        Status res = statusRepository.save(status1);
        return res;
    }

}

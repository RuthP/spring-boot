package com.dh.demo.demo.demo.service;

import com.dh.demo.demo.demo.domain.User;
import com.dh.demo.demo.demo.repository.UserRepository;
import com.dh.demo.demo.demo.web.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 17/06/2017.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Query("SELECT * FROM User WHERE status<>'Remove")
    public List<User> getAllUsers(){

        return userRepository.findAll();
    }

    public void  addUser(UserController.UserRequestDTO user){
        User res = new User();
        res.setFirstName(user.getFirstName());
        res.setLastName(user.getLastName());
        res.setEmail(user.getEmail());
        res.setPassword(user.getPassword());
        res.setUserName(user.getUserName());
        res.setStatus(user.getStatus());
        userRepository.save(res);
    }

    public void deleteUser (Long id){
        User res = userRepository.findOne(id);
        res.setStatus("remove");
        //userRepository.delete(id);
    }

    public User updateUser(Long id, UserController.UserRequestDTO user){
        User user1 = userRepository.findOne(id);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setStatus(user.getStatus());
        user1.setUserName(user.getUserName());
        user1.setPassword(user.getPassword());
        User res = userRepository.save(user1);
        return res;
    }
}

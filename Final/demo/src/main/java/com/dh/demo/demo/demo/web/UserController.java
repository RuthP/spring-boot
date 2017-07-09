package com.dh.demo.demo.demo.web;

import com.dh.demo.demo.demo.domain.User;
import com.dh.demo.demo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DELL on 17/06/2017.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody UserRequestDTO user){
        userService.addUser(user);
    }
    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.DELETE)
    public void deleteUser (@PathVariable Long id){
        userService.deleteUser(id);
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
    public User updateUser (@PathVariable Long id,@RequestBody UserRequestDTO user ){
        return userService.updateUser(id,user);
    }

    public static class  UserRequestDTO{

        private String firstName,lastName,email,userName,password,status;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}

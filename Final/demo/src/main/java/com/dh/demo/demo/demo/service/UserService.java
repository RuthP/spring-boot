package com.dh.demo.demo.demo.service;

import com.dh.demo.demo.demo.domain.User;
import com.dh.demo.demo.demo.repository.UserRepository;
import com.dh.demo.demo.demo.web.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by DELL on 17/06/2017.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @PersistenceContext()
    private EntityManager entityManager;

    public List<User> getAllUsers(){
        //Query query = entityManager.createQuery("select * from User u where u.status='Active'");
        //List<Object[]> result = query.getResultList();
        return userRepository.findAll();
    }

    public List<User> getMaxId (){
        String hql="select max(u.id) from User u";
        List<User>users= entityManager.createQuery(hql).getResultList();
        return users;
    }

    public List<User> getAllUsersActive(){
        String hql="select u from User u where u.status='Active'";
        List<User>users=entityManager.createQuery(hql).getResultList();
        return users;
    }

    public List<User> getUsersByGroup(Long id){
        String hql="select u from Group g , User u, GroupUser gu where g.id=gu.group and u.id=gu.user " +
                "and g.id =  "+id+" and u.status='Active'";
        List<User>users=entityManager.createQuery(hql).getResultList();
        return users;
    }

    public void  addUser(UserController.UserRequestDTO user){
        User res = new User();
        res.setFirstname(user.getFirstName());
        res.setLastname(user.getLastName());
        res.setEmail(user.getEmail());
        res.setPassword(user.getPassword());
        res.setUsername(user.getUserName());
        res.setStatus(user.getStatus());
        userRepository.save(res);
    }

    public User deleteUser(Long id, UserController.UserRequestDTO user){
        String status = "Remove";
        User user1 = userRepository.findOne(id);
        user1.setFirstname(user.getFirstName());
        user1.setLastname(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setStatus(status);
        user1.setUsername(user.getUserName());
        user1.setPassword(user.getPassword());
        User res = userRepository.save(user1);
        return res;
    }

    public User updateUser(Long id, UserController.UserRequestDTO user){
        User user1 = userRepository.findOne(id);
        user1.setFirstname(user.getFirstName());
        user1.setLastname(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setStatus(user.getStatus());
        user1.setUsername(user.getUserName());
        user1.setPassword(user.getPassword());
        User res = userRepository.save(user1);
        return res;
    }

    public User getUser(Long id){
        User user = userRepository.findOne(id);
        return user;
    }
}

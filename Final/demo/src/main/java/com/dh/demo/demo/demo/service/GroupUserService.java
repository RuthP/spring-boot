package com.dh.demo.demo.demo.service;

import com.dh.demo.demo.demo.domain.Group;
import com.dh.demo.demo.demo.domain.GroupUser;
import com.dh.demo.demo.demo.domain.User;
import com.dh.demo.demo.demo.repository.GroupRepository;
import com.dh.demo.demo.demo.repository.GroupUserRepository;
import com.dh.demo.demo.demo.repository.UserRepository;
import com.dh.demo.demo.demo.web.GroupUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 17/06/2017.
 */
@Service
public class GroupUserService {
    @Autowired
    private GroupUserRepository groupUserRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    public List<GroupUser> getAllGroupUser(){
        return groupUserRepository.findAll();
    }

    public void deleteGroupUser (Long id){
        groupRepository.delete(id);
    }

    public void addGroupUser (GroupUserController.GroupUserRequestDTO groupUser){
        User user = userRepository.findOne(groupUser.getUserId());
        Group group = groupRepository.findOne(groupUser.getGroupId());
        GroupUser res = new GroupUser();
        res.setGroup(group);
        res.setUser(user);
        groupUserRepository.save(res);
    }
}

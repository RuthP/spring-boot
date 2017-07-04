package com.dh.demo.demo.demo.service;

import com.dh.demo.demo.demo.domain.Group;
import com.dh.demo.demo.demo.domain.User;
import com.dh.demo.demo.demo.repository.GroupRepository;
import com.dh.demo.demo.demo.repository.UserRepository;
import com.dh.demo.demo.demo.web.GroupController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 17/06/2017.
 */
@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }

    public void addGroup (GroupController.GroupRequestDTO group){
        User user = userRepository.findOne(group.getOwnerId());
        Group res = new Group();
        res.setName(group.getName());
        res.setCreate_date(group.getCreate_date());
        res.setLogo(group.getLogo());
        res.setOwner(user);
        groupRepository.save(res);
    }

    public void deleteGroup (Long id){
        groupRepository.delete(id);
    }

    public Group updateGroup(Long id, GroupController.GroupRequestDTO group){
        Group group1 = new Group();
        User user = userRepository.findOne(group.getOwnerId());
        group1.setLogo(group.getLogo());
        group1.setCreate_date(group.getCreate_date());
        group1.setName(group.getName());
        group1.setOwner(user);
        return group1;
    }
}
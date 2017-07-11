package com.dh.demo.demo.demo.service;

import com.dh.demo.demo.demo.domain.Group;
import com.dh.demo.demo.demo.domain.GroupUser;
import com.dh.demo.demo.demo.domain.User;
import com.dh.demo.demo.demo.repository.GroupRepository;
import com.dh.demo.demo.demo.repository.GroupUserRepository;
import com.dh.demo.demo.demo.repository.UserRepository;
import com.dh.demo.demo.demo.web.GroupController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @Autowired
    private GroupUserRepository groupUserRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public  List<Group> getGroupByUser (Long id){
        //String hql="select g from Group g where  g.owner =  "+id+"";
        String hql="select g from Group g , User u, GroupUser gu where g.id=gu.group and u.id=gu.user " +
                "and (u.id =  "+id+")";
        List<Group>groups=entityManager.createQuery(hql).getResultList();
        return groups;
    }

    public List<Group> getGroupByOwner (Long id){
        String hql="select g from Group g where  g.owner =  "+id+"";
        List<Group>groups=entityManager.createQuery(hql).getResultList();
        return groups;
    }
    //SELECT u.* FROM GROUPS g, GROUP_USER  gu, USER u WHERE g.ID =gu.GROUPID  AND u.ID = gu.USERID  AND g.ID =1

    public Boolean isOwner (Long id){
        String hql="select g from Group g where  g.owner =  "+id+"";
        List<Group>groups=entityManager.createQuery(hql).getResultList();
        if(groups.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public Group getGroup (Long id){
        Group group = groupRepository.findOne(id);
        return group;
    }

    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }

    public void addGroup (GroupController.GroupRequestDTO group){
        User user = userRepository.findOne(group.getOwnerId());
        Group res = new Group();
        res.setName(group.getName());
        res.setCreatedate(group.getCreate_date());
        res.setLogo(group.getLogo());
        res.setOwner(user);
        groupRepository.save(res);
    }

    public void deleteGroup (Long id){
        String hql="delete from GroupUser gu where  gu.group =  "+id+"";
        List<GroupUser>delete=entityManager.createQuery(hql).getResultList();
        groupRepository.delete(id);
    }

    public void makeOwner (Long idUser, Long idGroup){
        User newOwner = userRepository.findOne(idUser);
        Group group = groupRepository.findOne(idGroup);
        group.setOwner(newOwner);
    }

    public Group updateGroup(Long id, GroupController.GroupRequestDTO group){
        Group group1 = groupRepository.findOne(id);
        User user = userRepository.findOne(group.getOwnerId());
        group1.setLogo(group.getLogo());
        group1.setCreatedate(group.getCreate_date());
        group1.setName(group.getName());
        group1.setOwner(user);
        Group res = groupRepository.save(group1);
        return res ;
    }
}

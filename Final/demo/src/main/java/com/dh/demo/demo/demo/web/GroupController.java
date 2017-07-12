package com.dh.demo.demo.demo.web;

import com.dh.demo.demo.demo.domain.Group;
import com.dh.demo.demo.demo.domain.User;
import com.dh.demo.demo.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by DELL on 17/06/2017.
 */
@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Group> getAllGroups (){
        return groupService.getAllGroups();
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public List<Group> getGroupByUser (@PathVariable Long id){
        return groupService.getGroupByUser(id);
    }

    @RequestMapping(value = "/owner/{id}",method = RequestMethod.GET)
    public List<Group> getGroupByOwner (@PathVariable Long id){
        return groupService.getGroupByOwner(id);
    }

    @RequestMapping(value = "/isOwner/{id}",method = RequestMethod.GET)
    public Boolean isOwner (@PathVariable long id){
        return groupService.isOwner(id);
    }

    @RequestMapping(value = "/makeOwner/{idUser}/{idGroup}",method = RequestMethod.GET)
    public Group makeOwner (@PathVariable long idUser,@PathVariable long idGroup,@RequestBody GroupRequestDTO group){
        return groupService.makeOwner(idUser,group,idGroup);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public Group getGroup (@PathVariable Long id){
        return groupService.getGroup(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addGroup(@RequestBody GroupRequestDTO group){
        groupService.addGroup(group);
    }

    @RequestMapping(value = "/deleteGroup/{id}",method = RequestMethod.DELETE)
    public void deleteGroup (@PathVariable Long id){
        groupService.deleteGroup(id);
    }

    @RequestMapping(value = "/updateGroup/{id}",method = RequestMethod.PUT)
    public Group updateGroup (@PathVariable Long id, @RequestBody GroupRequestDTO group){
        return groupService.updateGroup(id, group);
    }

    public static class GroupRequestDTO{
        private Long ownerId;
        private String logo;
        private String name;
        private Date create_date;

        public Long getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(Long ownerId) {
            this.ownerId = ownerId;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getCreate_date() {
            return create_date;
        }

        public void setCreate_date(Date create_date) {
            this.create_date = create_date;
        }
    }


}

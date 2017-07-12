package com.dh.demo.demo.demo.web;

import com.dh.demo.demo.demo.domain.Group;
import com.dh.demo.demo.demo.domain.GroupUser;
import com.dh.demo.demo.demo.domain.User;
import com.dh.demo.demo.demo.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created by DELL on 17/06/2017.
 */
@RestController
@RequestMapping("/groupUsers")
public class GroupUserController {
    @Autowired
    private GroupUserService groupUserService;

    @RequestMapping(method = RequestMethod.GET)
    public List<GroupUser> getAllGroupUsers (){
        return groupUserService.getAllGroupUser();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addGroupUser (@RequestBody GroupUserRequestDTO groupUserRequestDTO){
        groupUserService.addGroupUser(groupUserRequestDTO);
    }

    @RequestMapping(value = "/deleteGroupUser/{id}",method = RequestMethod.DELETE)
    public void deleteGroupUser(@PathVariable Long id){
        groupUserService.deleteGroupUser(id);
    }

    public static class GroupUserRequestDTO{
        private Long groupId;
        private Long userId;

        public Long getGroupId() {
            return groupId;
        }

        public void setGroupId(Long groupId) {
            this.groupId = groupId;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }
}

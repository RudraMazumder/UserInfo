package com.wipro.userinfo.controller;

import com.wipro.userinfo.entity.UserInfo;
import com.wipro.userinfo.repo.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoRepository userInfoRepository;


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Iterable<UserInfo> getAllUserInfo(){
        return userInfoRepository.findAll();
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public UserInfo getUserInfo(@PathVariable int id){
        return userInfoRepository.findOne(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(@RequestParam String name,@RequestParam String email){
        UserInfo user=new UserInfo();
        user.setName(name);
        user.setEmailId(email);
        userInfoRepository.save(user);

    }
    @RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
    public void updateUser(@RequestBody UserInfo user, @PathVariable("id") int id){
        userInfoRepository.save(user);

    }
    @RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") int id){
        userInfoRepository.delete(id);
    }


}


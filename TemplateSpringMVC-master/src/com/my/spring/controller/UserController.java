package com.my.spring.controller;

import com.my.spring.service.UserService;
import com.my.spring.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.my.spring.model.*;
import java.util.List;
/**
 * Created by Administrator on 2016/6/22.
 */
@Controller
@RequestMapping(value="api/user")
public class UserController {
    @Autowired
    UserService userService;

 /*   @RequestMapping(value="addUser", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> addUser(
            @ModelAttribute UserEntity user,
            @RequestParam(value = "token",required = false) String token){
        //System.out.println("sasdhaskjfhdkjsah");
        return userService.addUser(user);
    }*/


    /*@RequestMapping(value="getUserList")
    @ResponseBody
    public DataWrapper<List<UserEntity>> getUserList(
            @RequestParam(value = "token",required = false) String token){


       // return userService.getUserList();
        return  userService.getUserList();
    }*/


    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> verifyUser(@RequestParam(value = "studentid",required = false) Long studentid,
                        @RequestParam(value = "password",required = false) String password){
       studentid= Long.valueOf(1321112);
        password="123456";
        return userService.login(studentid,password);
    }

    @RequestMapping(value="register")
    @ResponseBody
    public DataWrapper<Void> register(
            @ModelAttribute UserEntity userEntity)
    {

        return userService.register(userEntity);
    }
    @RequestMapping(value="delete")
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "userId",required = false) Long userId,
            @RequestParam(value = "token",required = false) String token){
       // userId= Long.valueOf(2);
        return userService.delete(userId);
    }

    @RequestMapping(value="update",method= RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> update(
            @ModelAttribute UserEntity user,
            @RequestParam(value = "token",required = false) String token){

        return userService.update(user);
    }
    @RequestMapping(value="getbyid")
    @ResponseBody
    public DataWrapper<UserEntity> getbyid(
            @RequestParam(value = "userId",required = false) Long userId,
            @RequestParam(value = "token",required = false) String token){

        return userService.getUserById(userId);
    }

    @RequestMapping(value="changePwd")
    @ResponseBody
    public DataWrapper<Void> changePwd(
            @RequestParam(value = "password",required = false) String password,
            @RequestParam(value = "userId",required = false) Long userId,
            @RequestParam(value = "token",required = false) String token){

        return userService.changePwd(password,userId);
    }
    @RequestMapping(value="changeType")
    @ResponseBody
    public DataWrapper<Void> changeType(
            @RequestParam(value = "userType",required = false) Integer userType,
            @RequestParam(value = "userId",required = false) Long userId,
            @RequestParam(value = "token",required = false) String token){
       userType=0;
        userId= Long.valueOf(1);
        return userService.changeType(userType,userId);
    }

    @RequestMapping(value="getUserList",method= RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<UserEntity>> getUserList(
            @RequestParam(value = "numPerPage",required = false) String numPerPage,
            @RequestParam(value = "pageNum",required = false) String pageNum,
            @RequestParam(value = "userName",required = false) String userName,
            @RequestParam(value = "studentId",required = false) Long studentId,
            @RequestParam(value = "department",required = false) String department,
            @RequestParam(value = "major",required = false) String major,
            @RequestParam(value = "userType",required = false) Integer userType,
            @RequestParam(value = "telephone",required = false) String telephone,
            @RequestParam(value = "token",required = false) String token){

        return userService.getUserList(numPerPage,pageNum,userName,studentId,department,major,userType,telephone);
    }
}

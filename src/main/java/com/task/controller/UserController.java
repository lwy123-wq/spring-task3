package com.task.controller;

import com.alibaba.fastjson.JSON;
import com.task.config.MapConfig;
import com.task.entity.User;
import com.task.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    //注册
    @RequestMapping(value = "registry",method = RequestMethod.GET)
    public String registry(){
        return "registry";
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public String register(String username,String password){
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        if(userService.AddInsert(user)==true){
            return "success";
        }
        return "error";
    }

    //登陆
    @RequestMapping(value = "login1",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String login(String username,String password){
        Boolean test=userService.validatePassword(password);
        if(test==true) {
            User user = userService.findByNameAndPassword(username, DigestUtils.md5Hex(password));
            if (user == null || user.getUsername() == null) {

                return  "用户不存在或用户名密码错误";
            }

            return  "welcome";
        }else {

            return "请输入正确字符";
        }
        //return "hello"+user.getUsername();
    }
}

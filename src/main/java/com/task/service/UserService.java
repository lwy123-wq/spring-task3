package com.task.service;

import com.task.dao.UserDao;
import com.task.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public boolean AddInsert(User user){
        User userByName = userDao.findByName(user.getUsername());
        if (userByName != null && userByName.getUsername() != null && userByName.getUsername().equals(user.getUsername())) {
            return false;
        }

        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        userDao.add(user);
        return  true;

    }

    public User findByName(String name){
        return userDao.findByName(name);
    }

    public User findByNameAndPassword(String name,String password){
        return userDao.findByNameAndPassword(name,password);
    }

    public boolean validatePassword(String password){
        if (password.matches("[x00-x7f]*")){
            return true;
        }
        return false;
    }

}

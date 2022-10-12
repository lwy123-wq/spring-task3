package com.task.service;

import com.task.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    public int AddRole(String userId,String role){
        return roleDao.AddRole(userId, role);
    }
    public String getFloatValue(BigDecimal value){
        return roleDao.getFloatValue(value);
    }
    public BigDecimal myDecimal(float value){
        return roleDao.myDecimal(value);
    }
}

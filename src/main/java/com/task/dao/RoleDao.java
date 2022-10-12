package com.task.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Repository
public class RoleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int AddRole(String userId,String role){
        String sql="insert into role(userId,role) values(?,?)";
        return jdbcTemplate.update(sql,userId,role);
    }



    public  String getFloatValue(BigDecimal value) {
        DecimalFormat df =  new DecimalFormat("0%");
        String myvalue=String.valueOf(value);
        String[] value1=myvalue.split("\\.");
        String v1=value1[1];
        if (v1.charAt(1)=='0'){
            return df.format(value1[0]+"."+v1.charAt(0));
        }else {
            return df.format(value1[0]+"."+v1.charAt(0)+v1.charAt(1));
        }


        /*Float f = Float.valueOf(value);
        int itemp = Math.round((f - f.intValue()) * 100);
        if (itemp % 100 == 0) {
            value = String.format("%.0f", f);
        } else if (itemp % 10 == 0) {
            value = String.format("%.1f", f);
        } else {
            value = String.format("%.2f", f);
        }*/

    }
    public BigDecimal myDecimal(float value){
        return BigDecimal.valueOf(value);
    }
}

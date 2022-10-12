package com.task.dao;

import com.task.entity.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@ComponentScan("com.task")
public class UserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public int add(User user){
        String sql1 = "insert into test(username,password) values(?,?);";
        Object[] args = {user.getUsername(),user.getPassword()};
        int result = jdbcTemplate.update(sql1,args);
        System.out.println(result);
        return result;
    }

    public User findByName(String name) {
        final User user = new User();
        String sql = "SELECT username FROM test WHERE username=?";
        jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUsername(resultSet.getString(1));
            }
        });
        return user;
    }

    public User findByNameAndPassword(String username, String password) {
        final User user = new User();
        String sql = "SELECT * FROM test WHERE username=? AND password=?";
        jdbcTemplate.query(sql, new Object[]{username, password}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }
        });
        return user;
    }

    public double num(){
        double value1=4.015*100;
        return value1;
    }
    public void insert(double num){
        String sql="insert into user(num) values(?)";
        jdbcTemplate.update(sql,num);
    }
}

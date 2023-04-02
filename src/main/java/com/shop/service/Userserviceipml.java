package com.shop.service;

import com.shop.mapper.UserMapper;
import com.shop.pojo.User;
import com.shop.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userserviceipml implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user){
        userMapper.insert(user);
    }

    @Override
    public List<User> login(String username, String userpassword){
        UserExample ue = new UserExample();
        UserExample.Criteria criteria = ue.createCriteria();

        criteria.andUsernameEqualTo(username);
        criteria.andUserpasswordEqualTo(userpassword);
        List<User> users = userMapper.selectByExample(ue);
        return users;
    }
}

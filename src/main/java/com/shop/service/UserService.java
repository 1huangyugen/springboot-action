package com.shop.service;

import com.shop.pojo.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> login(String username, String userpassword);
}

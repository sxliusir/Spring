package com.sxliusir.spring.mvc.dao;

import com.sxliusir.spring.mvc.entity.User;

public interface UserDao {
    public User getUserByName(String name);
}

package com.sxliusir.spring.mvc.dao.impl;

import com.sxliusir.spring.mvc.dao.UserDao;
import com.sxliusir.spring.mvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("daoMysql")
public class UserDaoMysqlImpl implements UserDao {

    @Autowired
    User user;
    public User getUserByName(String name) {
        System.out.println("用户查找中...");
        return user;
    }
}

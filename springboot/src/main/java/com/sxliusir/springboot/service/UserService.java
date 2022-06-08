package com.sxliusir.springboot.service;

import com.sxliusir.springboot.mapper.User;
import com.sxliusir.springboot.mapper.UserExample;
import com.sxliusir.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public List<User> findAll() {
        UserExample userExample = new UserExample();
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    public void reg(User user) {
        int insert = userMapper.insert(user);
        if (insert > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }

    }

    public void remove(Integer id) {
        int i = userMapper.deleteByPrimaryKey(id);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    public User getOne(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public void save(User user) {
        User userinfo = userMapper.selectByPrimaryKey(user.getId());
        user.setPassword(userinfo.getPassword());
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i > 0) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }

    }
}

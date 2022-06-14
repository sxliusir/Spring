package com.sxliusir.SpringBootOA.service;

import com.sxliusir.SpringBootOA.mapper.User;
import com.sxliusir.SpringBootOA.mapper.UserExample;
import com.sxliusir.SpringBootOA.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 用户登录
     * @param user
     * @return
     */
    public String login(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginNameEqualTo(user.getLoginName()).andPasswordEqualTo(user.getPassword());
        if(user.getLoginName().equals(null) || user.getLoginName().length() == 0 || user.getPassword().equals(null) ||
                user.getPassword().length() == 0) {
            return "fail";
        }
        int size = userMapper.selectByExample(userExample).size();
        if (size > 0) {
            return "success";
        } else {
            return "fail";
        }
    }
}

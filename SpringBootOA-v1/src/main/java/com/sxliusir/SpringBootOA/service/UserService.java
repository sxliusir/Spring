package com.sxliusir.SpringBootOA.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxliusir.SpringBootOA.entity.Sys;
import com.sxliusir.SpringBootOA.mapper.User;
import com.sxliusir.SpringBootOA.mapper.UserExample;
import com.sxliusir.SpringBootOA.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    private HttpServletRequest request;

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

        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0) {
            HttpSession sessoin = request.getSession();
            sessoin.setAttribute("userId", users.get(0).getId());
            sessoin.setAttribute("userName", users.get(0).getLoginName());
            return "success";
        } else {
            return "fail";
        }
    }

    public User findOne(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public String save(Map<String, String> map) {
//        UserExample userExample = new UserExample();
        User user = new User();
        user.setId(Integer.parseInt(map.get("id")));
        user.setNickName(map.get("nickname"));
        user.setEmail(map.get("email"));
        user.setRemark(map.get("remark"));

        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    public List<User> findAll() {
        UserExample userExample = new UserExample();
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    public PageInfo<User> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        UserExample userExample = new UserExample();
        userExample.createCriteria();
        List<User> list = userMapper.selectByExample(userExample);
        return new PageInfo<>(list,5);
    }



}

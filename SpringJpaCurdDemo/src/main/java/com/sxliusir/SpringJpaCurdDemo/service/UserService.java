package com.sxliusir.SpringJpaCurdDemo.service;

import com.sxliusir.SpringJpaCurdDemo.dao.UserRepository;
import com.sxliusir.SpringJpaCurdDemo.entity.User;
import com.sxliusir.SpringJpaCurdDemo.util.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public String reg(User user) {
        if (user.getPassword() != null) {
            user.setPassword(getMd5(user.getPassword()));
        }
        User save = userRepository.save(user);
        if (save != null) {
            return "success";
        } else {
            return "fail";
        }
    }

    public static String getMd5(String input)
    {
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Integer id) {
        userRepository.deleteById(id);
    }

    public User getOne(Integer id) {
        return userRepository.getReferenceById(id);
    }

    public void save(User user) {
        Optional<User> selectData = userRepository.findById(user.getId());
        if (selectData.isPresent()) {
            String[] Field = {"loginName", "nickName", "age", "address"};  //更新 Field指定允许字段
            JpaUtil.copyNotNullPropertiesAllow(user, selectData.get(), Field);
            userRepository.save(selectData.get());
        } else {
            userRepository.save(user); //新增
        }
    }
}

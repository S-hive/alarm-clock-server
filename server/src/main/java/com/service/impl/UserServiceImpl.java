package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dto.UserDTO;
import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUser(UserDTO userDTO) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phone", userDTO.getPhone())
                .eq("password", userDTO.getPassword());
        return userMapper.selectOne(userQueryWrapper);
    }

    @Override
    public Integer addUser(UserDTO userDTO) {
        return userMapper.insert(new User(userDTO.getPhone(), userDTO.getPassword()));
    }
}

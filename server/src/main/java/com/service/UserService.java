package com.service;

import com.dto.UserDTO;
import com.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 查找用户
     * @param userDTO
     * @return
     */
    User selectUser(UserDTO userDTO);

    /**
     *增加用户
     * @param userDTO
     * @return
     */
    Integer addUser(UserDTO userDTO);
}

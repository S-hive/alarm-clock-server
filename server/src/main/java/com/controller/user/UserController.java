package com.controller.user;

import com.dto.UserDTO;
import com.entity.User;
import com.result.Result;
import com.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.constant.MessageConstant.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param userDTO
     * @return
     */
    @PostMapping("/login")
    public Result userLogin(@RequestBody UserDTO userDTO) {
        User user = userService.selectUser(userDTO);
        if (user == null) {
            log.info(LOGIN_ERROR);
            return Result.error(LOGIN_ERROR);
        }
        return Result.success();
    }

    /**
     * 用户登录
     * @param userDTO
     * @return
     */
    @RequestMapping("/signUp")
    public Result userSignUp(@RequestBody UserDTO userDTO) {
        //查找用户是否已经登录过
        User user = userService.selectUser(userDTO);
        if (user != null) {
            log.info(ALREADY_EXITSTS);
            return Result.error(ALREADY_EXITSTS);
        }
        //注册用户
        Integer change = userService.addUser(userDTO);
        if (change == 0) {
            return Result.error(SIGNUP_ERROR);
        }
        //只有未注册用户显示成功
        return Result.success();
    }

}

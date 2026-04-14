package com.service;

import com.dto.TodoListDTO;
import com.vo.TodoListVO;
import org.springframework.stereotype.Service;

@Service
public interface TodoListService {

    /**
     * 通过电话号码查询所有定时任务
     * @param phone
     * @return
     */
    public TodoListVO selectTodoListByPbone(String phone);

    /**
     * 创建定时列表
     * @param todoListDTO
     * @return
     */
    public Integer createTodoListByPhone(TodoListDTO todoListDTO);
}

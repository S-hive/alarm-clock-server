package com.service;

import com.dto.TodoListDTO;
import com.result.PageResult;
import org.springframework.stereotype.Service;

@Service
public interface TodoListService {

    /**
     * 通过电话号码查询所有定时任务
     *
     * @param phone
     * @param page
     * @return
     */
    PageResult selectTodoListByPbone(String phone, Integer page);

    /**
     * 创建定时列表
     * @param todoListDTO
     * @return
     */
    public Integer createTodoListByPhone(TodoListDTO todoListDTO);

    /**
     * 修改定时列表
     * @param todoListDTO
     * @return
     */
    public Integer updateTodoListById(TodoListDTO todoListDTO);
}

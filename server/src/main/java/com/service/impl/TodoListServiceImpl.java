package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dto.TodoListDTO;
import com.entity.TodoList;
import com.mapper.TodoListMapper;
import com.service.TodoListService;
import com.vo.TodoListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoListServiceImpl implements TodoListService {

    @Autowired
    TodoListMapper todoListMapper;

    @Override
    public TodoListVO selectTodoListByPbone(String phone) {
        QueryWrapper<TodoList> todoListQueryWrapper = new QueryWrapper<>();
        todoListQueryWrapper.eq("phone", phone)
                .orderByDesc("update_time");
        List<TodoList> todoLists = todoListMapper.selectList(todoListQueryWrapper);
        return new TodoListVO(todoLists);

    }

    @Override
    public Integer createTodoListByPhone(TodoListDTO todoListDTO) {
        TodoList todoList = TodoList.builder()
                .name(todoListDTO.getName())
                .type(todoListDTO.getType())
                .phone(todoListDTO.getPhone())
                .time(todoListDTO.getTime())
                .updateTime(LocalDateTime.now()).build();
        int insert = todoListMapper.insert(todoList);
        return insert;
    }

    /**
     * 修改定时列表
     * @param todoListDTO
     * @return
     */
    @Override
    public Integer updateTodoListById(TodoListDTO todoListDTO) {
        TodoList todoList = TodoList.builder().id(todoListDTO.getId())
                .name(todoListDTO.getName())
                .time(todoListDTO.getTime())
                .type(todoListDTO.getType()).build();
        //创建条件构造器，设置更新条件：id = DTO中的id
        LambdaQueryWrapper<TodoList> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(TodoList::getId, todoListDTO.getId());
        //更新
        int update = todoListMapper.update(todoList, lambdaQueryWrapper);
        return update;
    }
}

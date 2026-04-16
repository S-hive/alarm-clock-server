package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dto.TodoListDTO;
import com.entity.TodoList;
import com.mapper.TodoListMapper;
import com.result.PageResult;
import com.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoListServiceImpl implements TodoListService {

    @Autowired
    TodoListMapper todoListMapper;

    @Override
    public PageResult selectTodoListByPbone(String phone, Integer page) {
        QueryWrapper<TodoList> todoListQueryWrapper = new QueryWrapper<>();
        todoListQueryWrapper.eq("phone", phone)
                .orderByDesc("update_time");             /*当前页码, 10页一组, 开启查询总数*/
        Page<TodoList> todoListPage = todoListMapper.selectPage(new Page<>(page, 10, true), todoListQueryWrapper);
        return new PageResult( todoListPage.getTotal(), todoListPage.getPages(), todoListPage.getRecords());

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

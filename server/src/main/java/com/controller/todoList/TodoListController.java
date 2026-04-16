package com.controller.todoList;

import com.constant.MessageConstant;
import com.dto.TodoListDTO;
import com.result.PageResult;
import com.result.Result;
import com.service.TodoListService;
import com.vo.TodoListVO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/TodoList")
@Data
public class TodoListController {

    @Autowired
    TodoListService todoListService;

    @GetMapping("/select")
    public Result<PageResult> selectTodoListByPhone(String phone, @RequestParam(defaultValue = "1") Integer page) {
        PageResult pageResult = todoListService.selectTodoListByPbone(phone, page);
        if (pageResult.getRecordes().isEmpty()) {
            return Result.error(MessageConstant.TODOLIST_MISSING);
        }
        return Result.success(pageResult);
    }

    @PostMapping("/create")
    public Result<TodoListVO> createTodoListByPhone(@RequestBody TodoListDTO todoListDTO) {
        Integer todoListByPhone = todoListService.createTodoListByPhone(todoListDTO);
        if (todoListByPhone > 0) {
            return Result.success();
        }
        return Result.error(MessageConstant.CREATE_TODOLIST_BY_PHONE_ERROR);
    }

    @PutMapping("/update")
    public Result updateTodoListById(@RequestBody TodoListDTO todoListDTO) {
        Integer updated = todoListService.updateTodoListById(todoListDTO);
        if (updated == 0) {
            return Result.error(MessageConstant.UPDATE_TODOLIST_BY_ID_ERROR);
        }
        return Result.success();
    }
}

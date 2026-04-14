package com.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoList {
    @TableId /*主键*/
    private Integer id;
    private String phone;
    private String name;
    private LocalDateTime updateTime;
    private Integer time;
    private String type;
}

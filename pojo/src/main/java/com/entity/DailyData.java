package com.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DailyData {
    @TableId
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private float focusDuration;
    private Integer wordCount;
/*    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;*/
    private String phone;

}

package com.vo;

import com.entity.DailyData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyDataListVO implements Serializable {
    private List<DailyData> records; //数据集合
}

package com.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyDataLoginVO implements Serializable {
    private float focusDuration;
    private Integer wordCount;
}

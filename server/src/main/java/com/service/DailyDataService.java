package com.service;

import com.dto.DailyDataDTO;
import com.entity.DailyData;
import com.vo.DailyDataListVO;
import com.vo.DailyDataLoginVO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface DailyDataService {

    DailyData seleteDailyDataByDateAndPhone(String phone, LocalDate date);

    Integer insertDailyDataByPhone(DailyDataDTO dailyDataDTO);

    Integer updateDailyData(DailyDataDTO dailyDataDTO);

    DailyDataLoginVO loginDailyData(LocalDate date, String phone);

    DailyDataListVO DailyDataList(String phone);
}

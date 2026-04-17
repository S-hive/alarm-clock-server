package com.service;

import com.dto.DailyDataDTO;
import com.entity.DailyData;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface DailyDataService {

    DailyData seleteDailyDataByDateAndPhone(String phone, LocalDate date);

    Integer insertDailyDataByPhone(DailyDataDTO dailyDataDTO);

    Integer updateDailyData(DailyDataDTO dailyDataDTO);

    void loginDailyData(LocalDate date, String phone);
}

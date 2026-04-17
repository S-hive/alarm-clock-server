package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dto.DailyDataDTO;
import com.entity.DailyData;
import com.mapper.DailyDataMapper;
import com.service.DailyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DailyDataServiceImpl implements DailyDataService {

    @Autowired
    DailyDataMapper dailyDataMapper;

    /**
     * 查询
     * @param phone
     * @param date
     * @return
     */
    @Override
    public DailyData seleteDailyDataByDateAndPhone(String phone, LocalDate date) {
        QueryWrapper<DailyData> dataQueryWrapper = new QueryWrapper<>();
        dataQueryWrapper.eq("phone", phone)
                .eq("date", date);
        return dailyDataMapper.selectOne(dataQueryWrapper);
    }

    /**
     * 插入
     * @param dailyDataDTO
     * @return
     */
    @Override
    public Integer insertDailyDataByPhone(DailyDataDTO dailyDataDTO) {
        DailyData dailyData = DailyData.builder().date(LocalDate.now())
                .focusDuration(dailyDataDTO.getFocusDuration())
                .wordCount(dailyDataDTO.getWordCount())
                .phone(dailyDataDTO.getPhone()).build();
        return dailyDataMapper.insert(dailyData);
    }

    /**
     * 更新
     * @param dailyDataDTO phone,date找到指定数据 focus_duration,word_count用于更新数据
     * @return
     */
    @Override
    public Integer updateDailyData(DailyDataDTO dailyDataDTO) {
        /*要更新的字段*/
        DailyData dailyData = DailyData.builder()
                .focusDuration(dailyDataDTO.getFocusDuration())
                .wordCount(dailyDataDTO.getWordCount())
                .build();
        /*更新条件*/
        UpdateWrapper<DailyData> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("phone", dailyDataDTO.getPhone())
                .eq("date", LocalDate.now());
        return dailyDataMapper.update(dailyData, updateWrapper);
    }

    /**
     * 登录时每日数据操作
     *
     * @param date
     * @param phone
     */
    @Override
    public void loginDailyData(LocalDate date, String phone) {
        QueryWrapper<DailyData> wrapper = new QueryWrapper<>();
        wrapper.eq("date", date).eq("phone", phone);
        DailyData dailyData = dailyDataMapper.selectOne(wrapper);
        if (dailyData == null) {
            DailyData nweDailyData = DailyData.builder().date(date)
                    .phone(phone)
                    .focusDuration(0)
                    .wordCount(0).build();
            dailyDataMapper.insert(nweDailyData);
        }
    }
}

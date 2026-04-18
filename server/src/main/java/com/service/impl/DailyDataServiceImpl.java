package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dto.DailyDataDTO;
import com.entity.DailyData;
import com.mapper.DailyDataMapper;
import com.service.DailyDataService;
import com.vo.DailyDataListVO;
import com.vo.DailyDataLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
     * @return
     */
    @Override
    public DailyDataLoginVO loginDailyData(LocalDate date, String phone) {
        QueryWrapper<DailyData> wrapper = new QueryWrapper<>();
        wrapper.eq("date", date).eq("phone", phone);
        DailyData dailyData = dailyDataMapper.selectOne(wrapper);
        if (dailyData == null) {
            DailyData nweDailyData = DailyData.builder().date(date)
                    .phone(phone)
                    .focusDuration(0)
                    .wordCount(0).build();
            dailyDataMapper.insert(nweDailyData);
            return new DailyDataLoginVO(0,0);
        } else {
            return new DailyDataLoginVO(dailyData.getFocusDuration(), dailyData.getWordCount());
        }
    }

    /**
     * 查询今天前3个月内的日期数据
     * @param phone
     * @return
     */
    @Override
    public DailyDataListVO DailyDataList(String phone) {
        LocalDate start = LocalDate.now().minusMonths(3);
        LocalDate end = LocalDate.now();

        LambdaQueryWrapper<DailyData> wrapper = new LambdaQueryWrapper<>();
        wrapper.between(DailyData::getDate, start, end)
                .orderByAsc(DailyData::getDate);

        List<DailyData> result = dailyDataMapper.selectList(wrapper);
        return new DailyDataListVO(result);
    }
}

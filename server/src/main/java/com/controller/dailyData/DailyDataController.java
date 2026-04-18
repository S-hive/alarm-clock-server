package com.controller.dailyData;

import com.constant.MessageConstant;
import com.dto.DailyDataDTO;
import com.entity.DailyData;
import com.result.Result;
import com.service.DailyDataService;
import com.vo.DailyDataListVO;
import com.vo.DailyDataLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@Slf4j
@RequestMapping("/dailyData")
public class DailyDataController {

    @Autowired
    DailyDataService dailyDataService;

    /**
     * 查询数据
     * @param phone
     * @param date
     * @return
     */
    @GetMapping("/select")
    public Result<DailyData> seleteDailyDataByDateAndPhone(String phone, LocalDate date) {
        DailyData dailyData = dailyDataService.seleteDailyDataByDateAndPhone(phone, date);
        if (dailyData == null) {
            return Result.error(MessageConstant.DAILYDATA_MISSING);
        }
        return Result.success(dailyData);

    }

    /**
     * 插入数据
     * @param dailyDataDTO
     * @return
     */
    @PutMapping("/create")
    public Result insertDailyDataByPhone(@RequestBody DailyDataDTO dailyDataDTO) {
        Integer inster = dailyDataService.insertDailyDataByPhone(dailyDataDTO);
        if (inster > 0) {
            return Result.success();
        }
        return Result.error(MessageConstant.CREATE_DAILYDATE_ERROR);
    }

    /**
     * 更新数据
     * @param dailyDataDTO
     * @return
     */
    @PostMapping("/update")
    public Result updateDailyData(@RequestBody DailyDataDTO dailyDataDTO) {
        Integer update = dailyDataService.updateDailyData(dailyDataDTO);
        if (update > 0) {
            return Result.success();
        }
        return Result.error(MessageConstant.UPDATE_DAILYDATE_ERROR);
    }

    /**
     * 登录时每日数据操作
     *
     * @param dailyDataDTO
     * @return
     */
    @PutMapping("/login")
    public Result<DailyDataLoginVO> loginDailyData(@RequestBody DailyDataDTO dailyDataDTO) {
        DailyDataLoginVO result = dailyDataService.loginDailyData(LocalDate.now(), dailyDataDTO.getPhone());
        return Result.success(result);
    }

    /**
     * 查询今天前3个月内的日期数据
     * @param phone
     * @return
     */
    @GetMapping("/selectAll")
    public Result<DailyDataListVO> DailyDataList(String phone) {
        DailyDataListVO result = dailyDataService.DailyDataList(phone);
        return  Result.success(result);
    }


}

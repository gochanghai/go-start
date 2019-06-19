package com.gochanghai.springboot.util;

import java.util.Date;

public class DateUtil {

    /**
     * 计算时间差
     * @param startDate
     * @param endDate
     * @return
     */
    public static String getDatePoor(Date startDate, Date endDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;

        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;

        String result = "";
        if(day > 0){
            result += day + " 天";
        }
        if(hour > 0){
            result += hour + " 小时";
        }
        if(min > 0){
            result += min + " 分钟";
        }
        result += sec + " 秒";
        return result;
    }
}

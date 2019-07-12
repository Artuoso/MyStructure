package com.uni.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
* @Description 日期工具类
*
* @author Created by zc on 2019/7/3
*/
public class DateUtil {

    /**
     * 获取当前日期指定格式的字符串
     *
     * @author Created by zc on 2019/06/21
     */
    public static String getCurrentDateStr(String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(new Date());
    }

    /**
     * 字符串转时间
     *
     * @return Date
     * @author Created by zc on 2019/7/4
     */
    public static Date parseStrToDate(String dateStr, String pattern) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.parse(dateStr);
    }

    /**
     * 判断某日期是否在两个指定日期的区间内（Date类型参数）。如果指定日期等于开始或结束日期视为true
     *
     * Created by zc on 2019/06/21
     */
    public static boolean isBetweenTwoDate(Date targetDate, Date beginDate, Date endDate) {
        boolean isEqual = targetDate.getTime() == beginDate.getTime() ||
                targetDate.getTime() == endDate.getTime();
        if (isEqual) {
            return true;
        }
        Calendar targetCalendar = Calendar.getInstance();
        targetCalendar.setTime(targetDate);

        Calendar beforeCalendar = Calendar.getInstance();
        beforeCalendar.setTime(beginDate);

        Calendar afterCalendar = Calendar.getInstance();
        afterCalendar.setTime(endDate);

        return targetCalendar.after(beforeCalendar) && targetCalendar.before(afterCalendar);
    }

    /**
     * 判断某日期是否在两个指定日期的区间内(字符串类型参数)
     *
     * @author Created by zc on 2019/6/25
     */
    public static boolean isBetweenTwoDate(String targetDateStr, String beginDateStr, String endDateStr, String pattern)
            throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return isBetweenTwoDate(dateFormat.parse(targetDateStr), dateFormat.parse(beginDateStr),
                dateFormat.parse(endDateStr));
    }

}

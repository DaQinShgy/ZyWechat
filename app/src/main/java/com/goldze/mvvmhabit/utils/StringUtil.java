package com.goldze.mvvmhabit.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import me.goldze.mvvmhabit.utils.StringUtils;

/**
 * Author: zy
 * Date: 2019/10/9 17:44
 * Description:
 */
public class StringUtil {

    public static String getAfterMonth(String inputDate, int number) {
        if (StringUtils.isEmpty(inputDate))
            return "";
        Calendar c = Calendar.getInstance();//获得一个日历的实例
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM月dd日");
        Date date = null;
        try {
            date = sdf.parse(inputDate);//初始日期
        } catch (Exception ignored) {

        }
        c.setTime(date);//设置日历时间
        c.add(Calendar.MONTH, number);//在日历的月份上增加6个月
        String strDate = sdf1.format(c.getTime());//的到你想要得6个月后的日期
        return strDate;
    }

    public static String getAfterMonthForDialog(String inputDate, int number) {
        Calendar c = Calendar.getInstance();//获得一个日历的实例
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年\nMM月dd日");
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM月dd日");
        Date date = null;
        try {
            date = sdf.parse(inputDate);//初始日期
        } catch (Exception ignored) {

        }
        c.setTime(date);//设置日历时间
        c.add(Calendar.MONTH, number);//在日历的月份上增加6个月
        String strDate;
        if (c.get(Calendar.MONTH) == Calendar.JANUARY)
            strDate = sdf1.format(c.getTime());//的到你想要得6个月后的日期
        else
            strDate = sdf2.format(c.getTime());//的到你想要得6个月后的日期
        return strDate;
    }

    public static String getAfterMonthWithYear(String inputDate, int number) {
        if (StringUtils.isEmpty(inputDate))
            return "";
        Calendar c = Calendar.getInstance();//获得一个日历的实例
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = sdf.parse(inputDate);//初始日期
        } catch (Exception ignored) {

        }
        c.setTime(date);//设置日历时间
        c.add(Calendar.MONTH, number);//在日历的月份上增加6个月
        String strDate = sdf1.format(c.getTime());//的到你想要得6个月后的日期
        return strDate;
    }

    public static String getAfterMonthOnlyDay(String inputDate, int number) {
        if (StringUtils.isEmpty(inputDate))
            return "";
        Calendar c = Calendar.getInstance();//获得一个日历的实例
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
        Date date = null;
        try {
            date = sdf.parse(inputDate);//初始日期
        } catch (Exception ignored) {

        }
        c.setTime(date);//设置日历时间
        c.add(Calendar.MONTH, number);//在日历的月份上增加6个月
        String strDate = sdf1.format(c.getTime());//的到你想要得6个月后的日期
        return strDate;
    }

}

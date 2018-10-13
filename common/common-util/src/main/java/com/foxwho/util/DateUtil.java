package com.foxwho.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

/**
 * 日期处理
 * <p>
 * 来自
 * https://www.cnblogs.com/qiuyu-blog/p/4551792.html
 * https://www.cnblogs.com/fulitaiblogs/p/3763155.html
 * https://blog.csdn.net/al_assad/article/details/58630763
 */
public class DateUtil {
    public static final String YYMMDD = "yyMMdd";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_DATETIME_M = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_DATE = "yyyy-MM-dd";
    public static final String PATTERN_MONTH = "yyyy-MM";
    public static final String YEAR = "yyyy";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
            "yyyy-MM-dd hh:mm:ss");

    /**
     * 字符串格式时间 转换时间格式
     *
     * @param dateTime
     * @return
     */
    public static DateTime toDateTime(String dateTime) {
        if (StringUtils.isBlank(dateTime)) {
            return null;
        }
        return DateTimeFormat.forPattern(PATTERN_DATETIME).parseDateTime(dateTime);
    }

    /**
     * 字符串格式日期 转换日期格式
     *
     * @param dateTime
     * @return
     */
    public static DateTime strToDateTime(String dateTime) {
        if (StringUtils.isBlank(dateTime)) {
            return null;
        }
        return DateTimeFormat.forPattern(PATTERN_DATE).parseDateTime(dateTime);
    }

    /**
     * 转换为字符串
     *
     * @param dateTime
     * @return
     */
    public static String toString(DateTime dateTime) {
        return dateTime.toString(PATTERN_DATETIME);
    }

    /**
     * 转换为字符串
     *
     * @param dateTime
     * @return
     */
    public static String dateToString(DateTime dateTime) {
        return dateTime.toString(YEAR);
    }

    /**
     * 转换为字符串
     *
     * @param dateTime
     * @return
     */
    public static String dateTimeToString(DateTime dateTime) {
        return dateTime.toString(PATTERN_DATE);
    }

    /**
     * 规定格式，转换为字符串
     *
     * @param dateTime
     * @param pattern
     * @return
     */
    public static String toString(String dateTime, String pattern) {
        return new DateTime(dateTime).toString(pattern);
    }

    /**
     * 本地日期转换为字符串
     *
     * @param localDate
     * @param pattern
     * @return
     */
    public static String toString(LocalDate localDate, String pattern) {
        if (localDate == null) {
            return null;
        }
        return localDate.toString(pattern);
    }

    /**
     * 年月日
     *
     * @return
     */
    public static String todayToString() {
        return new LocalDate().toString(YYMMDD);
    }

    /**
     * 今年
     *
     * @return
     */
    public static String todayToStringYear() {
        return new LocalDate().toString(YEAR);
    }

    /**
     * 年月日
     *
     * @return
     */
    public static String todayToString2() {
        return new LocalDate().toString(YYYYMMDD);
    }

    /**
     * 年-月-日
     *
     * @return
     */
    public static String todayToYYYYMMDDStr() {
        return new LocalDate().toString(PATTERN_DATE);
    }

    /**
     * 当前时间
     * 年-月-日 时:分:秒
     *
     * @return
     */
    public static String now() {
        return new LocalDate().toString(PATTERN_DATETIME);
    }

    /**
     * 年月日时分
     *
     * @return
     */
    public static String todayToChinaStr() {
        Calendar calendar = Calendar.getInstance();
        StringBuffer sb = new StringBuffer();
        sb.append(calendar.get(Calendar.YEAR)).append("年")
                .append(calendar.get(Calendar.MONTH) + 1).append("月")
                .append(calendar.get(Calendar.DAY_OF_MONTH)).append("日")
                .append(calendar.get(Calendar.HOUR)).append("时")
                .append(calendar.get(Calendar.MINUTE)).append("分");

        return sb.toString();
    }

    /**
     * 将微信消息中的CreateTime转换成标准格式的时间（yyyy-MM-dd HH:mm:ss）
     *
     * @param createTime
     * @return
     */
    public static String getNormalDateFromWebChat(String createTime) {
        Long msgCreateTime = Long.parseLong(createTime) * 1000;
        return DATE_FORMAT.format(new Date(msgCreateTime));
    }

    /**
     * 将long型时间格式转换为字符格式
     *
     * @return 返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String long2LongString(long date) {
        if (date == -99) {
            return "-";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATETIME);
        return sdf.format(new Date(date));
    }

    /**
     * 将long型时间格式转换为字符格式
     *
     * @param date
     * @param pattern 指定格式
     * @return
     */
    public static String long2DateString(Long date, String pattern) {
        if (date == null || date.longValue() == 0) {
            return "-";
        }
        if (date.longValue() == -99) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date(date));
    }

    /**
     * 将long型时间格式转换为字符格式
     *
     * @return 返回字符串格式 yyyy-MM-dd HH:mm
     */
    public static String long2DatemString(long date) {
        if (date == -99) {
            return "-";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATETIME_M);
        return sdf.format(new Date(date));
    }

    /**
     * 将long型时间格式转换为字符格式
     *
     * @param date
     * @return 返回字符串格式 yyyy-MM-dd
     */
    public static String long2String(Long date) {
        if (null == date || date == -99 || date == 0) {
            return "-";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATE);
        return sdf.format(new Date(date));
    }

    /***
     * YYYY-MM-DD
     * @param dateTime
     * @return
     */
    public static long str2Long(String dateTime) {
        if (StringUtils.isBlank(dateTime)) {
            return 0l;
        }
        Date date = string2Date(dateTime);

        return date.getTime();
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     *
     * @param dateTime
     * @return
     */
    public static long strSLong(String dateTime) {
        if (StringUtils.isBlank(dateTime)) {
            return 0l;
        }
        Date date = string2Datetime(dateTime);

        return date.getTime();
    }

    /**
     * 将DateTime型时间格式转换为long
     *
     * @param date
     * @return
     */
    public static long date2Long(DateTime dateTime) {
        if (dateTime == null) {
            return 0l;
        }
        String date1 = dateTimeToString(dateTime);
        Date date = string2Date(date1);
        return date.getTime();
    }


    /**
     * 获得精确到秒的日期类型
     * yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static Date string2Datetime(String date) {
        Date retValue = null;
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATETIME);
        try {
            retValue = sdf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retValue;
    }

    /**
     * 获得日期类型
     *
     * @param date
     * @return
     */
    public static Date string2Date(String date) {
        Date retValue = null;
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATE);
        try {
            retValue = sdf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retValue;
    }

    /**
     * 日期转换为Long
     *
     * @param dateTime
     * @return
     */
    public static long str2MonthLong(String dateTime) {
        if (StringUtils.isEmpty(dateTime)) {
            return 0l;
        }
        Date date = string2MonthDate(dateTime);

        return date != null ? date.getTime() : 0l;
    }

    /**
     * 获得月份类型
     *
     * @param date
     * @return
     */
    public static Date string2MonthDate(String date) {
        Date retValue = null;
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_MONTH);
        try {
            retValue = sdf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retValue;
    }

    /***
     * YYYY-MM-DD
     * @param date
     * @return
     */
    public static int getDayOfWeek(String date) {
        String[] dateArr = date.split("-");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
        Calendar calendar = Calendar.getInstance();//获得一个日历
        calendar.set(year, month - 1, day);//设置当前时间,月份是从0月开始计算
        int number = calendar.get(Calendar.DAY_OF_WEEK);//星期表示1-7，是从星期日开始，
        return number;
    }

    /**
     * 获取指定日期一年前时间
     *
     * @return 返回long格式
     */
    public static long getChainYear(long date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(date));
        cal.add(Calendar.YEAR, -1);
        return cal.getTime().getTime();
    }

    /***
     * 时间差，分钟
     * @param startTime
     * @param endTime
     * @return
     */
    public static String timeDifference(long startTime, long endTime) {
        long timeDifferenceSecond = endTime - startTime;
        double dmin = ((double) timeDifferenceSecond / (60 * 1000));
        BigDecimal bd = BigDecimal.valueOf(dmin);
        DecimalFormat df = new DecimalFormat("0");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(bd);
    }

    public static Date getTimesWeekMoningDate(int h, int m, int s) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int monday = cal.get(Calendar.MONDAY);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        cal.set(year, monday, dayOfMonth, h, m, s);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     * 本周开始时间 yyyy-MM-dd HH:mm:ss 0点
     *
     * @return
     */
    public static String getTimesWeekMorning() {
        SimpleDateFormat formatter = new SimpleDateFormat(PATTERN_DATETIME);
        String dateString = formatter.format(getTimesWeekMoningDate(0, 0, 0));
        return dateString;
    }

    /**
     * 本周结束时间 yyyy-MM-dd HH:mm:ss 24点
     *
     * @return
     */
    public static String getTimesWeekNight() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getTimesWeekMoningDate(0, 0, 0));
        cal.add(Calendar.DAY_OF_WEEK, 7);
        SimpleDateFormat formatter = new SimpleDateFormat(PATTERN_DATETIME);
        String dateString = formatter.format(cal.getTime());
        return dateString;
    }


    /***
     * 本月开始时间0点
     * @return
     */
    public static String getTimesMonthMorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat formatter = new SimpleDateFormat(PATTERN_DATETIME);
        String dateString = formatter.format(cal.getTime());
        return dateString;
    }

    /***
     * 本月结束时间24点
     * @return
     */
    public static String getTimesMonthNight() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int monday = cal.get(Calendar.MONDAY);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        cal.set(year, monday, dayOfMonth, 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        SimpleDateFormat formatter = new SimpleDateFormat(PATTERN_DATETIME);
        String dateString = formatter.format(cal.getTime());
        return dateString;
    }

    /**
     * 给定一个年份判断该年份是否为闰年
     */

    public static boolean isLeapYear(int year) {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.isLeapYear(year);
    }

    /**
     * 当前日期的字符串表示形式 格式：2009-5-05
     * 利用SimpleDateFormat获取当前日期的字符串表示形式 格式：2009-5-05
     */
    public static String getCurrentDate() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        return dateFormat.format(System.currentTimeMillis());
        return todayToYYYYMMDDStr();
    }

    /**
     * 给出任意一个年月日得到该天是星期几
     */
    public static int getWeek(String date) {
        // 注意参数的大小写格式
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE);
        Calendar c = Calendar.getInstance();
        try {
            Date d = dateFormat.parse(date);
            c.setTime(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return c.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 今天周几
     *
     * @param dayOfWeek
     * @return
     */
    public static String getDayInWeek(int dayOfWeek) {
        if (dayOfWeek < 1 || dayOfWeek > 7) {
            throw new RuntimeException(dayOfWeek + " : 没有对应的星期！");
        }
        String[] week = {"", "星期日", "星期一", "星期二 ", "星期三", "星期四", "星期五 ", "星期六"};
        return week[dayOfWeek];
    }

    /**
     * 获得距离今天n天的那一天的日期
     */
    public static String getDistanceDay(int day) {
        Calendar calen = Calendar.getInstance();
        calen.add(Calendar.DAY_OF_MONTH, day);
        Date date = calen.getTime();
        // 这里也个用SimpleDateFormat的format（）进行格式化，然后以字符串形式返回格式化后的date
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE);
        return dateFormat.format(date);
    }

    /**
     * 获得距离指定日期n天的那一天的日期
     */
    public static String getDistanceDay(String date, int day) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(YYYYMMDD);
        Date d;
        Calendar c =Calendar.getInstance();
        try {
            d = dateFormat.parse(date);
            c.setTime(d);
            c.add(Calendar.DATE, day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(c.getTime());
    }

    /**
     * 获得给定两个日期相差的天数
     *
     */
    public static long getGapDays(String date1, String date2) {
        String[] d1 = date1.split("-");
        String[] d2 = date2.split("-");
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(d1[0]), Integer.parseInt(d1[1]), Integer
                .parseInt(d1[2]), 0, 0, 0);
        long l1 = c.getTimeInMillis();
        c.set(Integer.parseInt(d2[0]), Integer.parseInt(d2[1]), Integer
                .parseInt(d2[2]), 0, 0, 0);
        long l2 = c.getTimeInMillis();
        return (Math.abs(l1 - l2) / (24 * 60 * 60 * 1000));
    }


}

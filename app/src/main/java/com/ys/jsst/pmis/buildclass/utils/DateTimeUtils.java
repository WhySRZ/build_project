package com.ys.jsst.pmis.buildclass.utils;

import android.util.Log;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 主要用来进行时间的读取设置
 *
 * @author shaobing
 * @version V1.0
 * 时间操作包装函数
 */
public class DateTimeUtils
{
    /**
     * 进行实践差的计算，设置为时间差的初始值
     */
    private static long sStartTime=0;
    private static final int YEAR = 365 * 24 * 60 * 60;// 年
    private static final int MONTH = 30 * 24 * 60 * 60;// 月
    private static final int DAY = 24 * 60 * 60;// 天
    private static final int HOUR = 60 * 60;// 小时
    private static final int MINUTE = 60;// 分钟

    /**
     * 得到毫秒级的时间
     * @return
     */
    public static long getMillis()
    {
        Date      date = new Date();
        Timestamp dt   = new Timestamp(System.currentTimeMillis());
       LogUtil.i("  " + dt.getTime() + "  " + System.currentTimeMillis());
        return dt.getTime();
    }

    /**
     * 获取年的时间
     * @return
     */
    public static String getYear()
    {
        Timestamp        dt    = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sy    =new SimpleDateFormat("yyyy");
        String           syear =sy.format(dt);

        LogUtil.i("  " + syear + "  " + syear);
        return syear;
    }

    /**
     * 获取年的时间
     * @return
     */
    public static String getMonth()
    {
        Timestamp        dt   = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sm   =new SimpleDateFormat("MM");
        String           smon =sm.format(dt);

        LogUtil.i("  " + smon + "  " + smon);
        return smon;
    }
    public static String getWeek()
    {
        Timestamp        dt   = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sd   =new SimpleDateFormat("E");
        String           sday =sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }

    /**
     * 获取天的时间
     * @return
     */
    public static String getDay()
    {
        Timestamp        dt   = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sd   =new SimpleDateFormat("dd");
        String           sday =sd.format(dt);

       LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }

    /**
     *获取时分秒
     *可以用来存储到数据库进行时间的比较
     * @return
     */
    public static String getHourMinute()
    {
        Timestamp        dt   = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sd   =new SimpleDateFormat("HH:mm:ss");
        String           sday =sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }

    /**
     *获取年月日时分秒
     *可以用来存储到数据库进行时间的比较
     * @return
     */
    public static String getDate()
    {
        Timestamp        dt   = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sd   =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String           sday =sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }


    /**
     * 获取分秒
     * @param time
     * @return
     */
    public static String getMinuteSecond(long time)
    {
        Timestamp        dt   = new Timestamp(time);
        SimpleDateFormat sd   =new SimpleDateFormat("mm:ss");
        String           sday =sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }

    /**
     *获取年月日时分秒
     *可以用来存储到数据库进行时间的比较
     * @return
     */
    public static String getDate2(float addTime)
    {
        Timestamp        dt   = new Timestamp(System.currentTimeMillis()+(long) addTime*1000);
        SimpleDateFormat sd   =new SimpleDateFormat("yyyy年MM月dd日");
        String           sday =sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }
    /**
     *获取年月日时分秒
     *可以用来存储到数据库进行时间的比较
     * @return
     */
    public static long getDiffTime(String time1, String time2)
    {
        long diff=0;
        long days = 0;
        try
        {
            DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
            Date       d1 = df.parse(time1);
            Date       d2 = df.parse(time2);
            diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
            days = diff / (1000 * 60 * 60 * 24);

        }
        catch (Exception e)
        {
            LogUtil.e("dateTimeUtile :"+e.fillInStackTrace());
        }
        LogUtil.i("  " + days);
        return days;
    }

    /**
     *获取年月日时分秒
     *可以用来存储到数据库进行时间的比较
     * @return
     */
    public static String getDateByDay()
    {
        Timestamp        dt   = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sd   =new SimpleDateFormat("yyyy-MM-dd");
        String           sday =sd.format(dt);
        return sday;
    }

    public static String getDateMillis()
    {
        Timestamp        dt   = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sd   =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String           sday =sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }


    /**
     * 命名
     * @return
     */
    public static String getDateName()
    {
        Timestamp        dt   = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sd   =new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS");
        String           sday =sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }

    /**
     * 设置时间差计算的起始数值
     */
    public static  void setTimeDifferenceStart()
    {
        sStartTime = System.currentTimeMillis();
    }

    /**
     * 计算实践差
     * @param endTime   时间差的最后的数值
     * @return  返回一秒为单位的时间差数据
     */
    public static String getTimeDifference(Long endTime)
    {
        Timestamp        dt    = new Timestamp(endTime-sStartTime);
        SimpleDateFormat sd    =new SimpleDateFormat("ss");
        String           sTime =sd.format(dt);
        return sTime;
    }

    /**
     * 根据时间戳获取描述性时间，如3分钟前，1天前
     *
     * @param timestamp 时间戳 单位为毫秒
     * @return 时间字符串
     */
    public static String getDescriptionTimeFromTimestamp(long timestamp) {
        long   currentTime = System.currentTimeMillis();
        long   timeGap = (currentTime - timestamp) / 1000;// 与现在时间相差秒数
        String timeStr;
        if (timeGap > YEAR) {
            timeStr = timeGap / YEAR + "年前";
        } else if (timeGap > MONTH) {
            timeStr = timeGap / MONTH + "个月前";
        } else if (timeGap > DAY) {// 1天以上
            timeStr = timeGap / DAY + "天前";
        } else if (timeGap > HOUR) {// 1小时-24小时
            timeStr = timeGap / HOUR + "小时前";
        } else if (timeGap > MINUTE) {// 1分钟-59分钟
            timeStr = timeGap / MINUTE + "分钟前";
        } else {// 1秒钟-59秒钟
            timeStr = "刚刚";
        }
        return timeStr;
    }

    /**
     * 根据时间判断该时间是否在现在之前
     *
     * @param answerPublishTime 时间戳 ,格式 ，2017-03-02 23:59:00.0
     * @return 时间字符串
     */
    public static Boolean isBeforeNow(String answerPublishTime){
        Date             now =new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
        try {
            Date    d    = sdf.parse(answerPublishTime);
            boolean flag = d.before(now);
            if(flag)
                return true;
            else
                return false;
        }catch(Exception e){
            Log.e("isBeforeNow", e.getMessage());
            return false;
        }
    }

    /**
     * @param date 日期格式为yyyy-MM-dd
     */
    public static String transformToChinaDate(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        return simpleDateFormat.format(date);
    }

    /**
     * @param date 日期格式为yyyy年MM月dd日
     * */
    public static String transformToNormDate(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    /**
     * 转成MM/dd格式
     * */
    public static String transformTodayData(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd");
        return simpleDateFormat.format(new Date());
    }
}

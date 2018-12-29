package cn.luozc.utils.date;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 10:55 2018/12/29/029
 */
public class DateUtils {

    /**
     * 获取当日起始时间
     * @return
     */
    public static Date getSameDayStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 获取当日结束时间
     * @return
     */
    public static Date getSameDayEndTime() {
        Calendar c = Calendar.getInstance();
        c.setTime(getSameDayStartTime());
        c.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天
        return c.getTime();
    }

    public static void main(String[] args) {
        System.out.println( getSameDayEndTime().getTime());
    }
}

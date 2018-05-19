package aOften.bMathStringBufferDemo;

import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {
        //创建日历对象
        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar.getTimeInMillis());//获取毫秒数
        // 转换为Date对象
        System.out.println(calendar.getTime());
        // 获取年，月，日， 时，分，秒，毫秒
        System.out.println(calendar.get(Calendar.YEAR));
        // 月是从0开始
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
        System.out.println(calendar.get(Calendar.MILLISECOND));
        // 使用set方法
        calendar.set(Calendar.YEAR, 200);
        calendar.set(Calendar.MONTH, 2);
        System.out.println(calendar);
        //////////////////// 设置这个年2月1日
        // 2018 是否是瑞年
        calendar.set(Calendar.YEAR, 2016);
        calendar.set(Calendar.MONTH, 1);
        System.out.println(calendar.getTime());
        // 查看这个月有多少天
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        // 使用add方法
        calendar.add(Calendar.MONTH, -3);
        System.out.println(calendar.getTime());
        System.out.println("-----------------------");
        // 比较日期 compareTo
        Calendar cl1 = Calendar.getInstance();
        cl1.add(Calendar.MONTH, -1);
        Calendar cl2 = Calendar.getInstance();
        //  return (thisTime > t) ? 1 : (thisTime == t) ? 0 : -1;
        long time = cl1.compareTo(cl2);
        System.out.println(time);
    }
}

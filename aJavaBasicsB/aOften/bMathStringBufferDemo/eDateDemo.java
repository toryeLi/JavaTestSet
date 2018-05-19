package aOften.bMathStringBufferDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class eDateDemo {
    public static void main(String[] args) {
        // 创建一个日期对象
        Date date = new Date();
        System.out.println(date);
        // 把日期对象转换为毫秒值
        System.out.println(date.getTime());
        // 把一个毫秒值转换为一个时间
        System.out.println(new Date(10100101010L));
        /**
         * 字母  日期或时间元素  表示  示例
         G  Era 标志符  Text  AD
         y  年  Year  1996; 96
         M  年中的月份  Month  July; Jul; 07
         w  年中的周数  Number  27
         W  月份中的周数  Number  2
         D  年中的天数  Number  189
         d  月份中的天数  Number  10
         F  月份中的星期  Number  2
         E  星期中的天数  Text  Tuesday; Tue
         a  Am/pm 标记  Text  PM
         H  一天中的小时数（0-23）  Number  0
         k  一天中的小时数（1-24）  Number  24
         K  am/pm 中的小时数（0-11）  Number  0
         h  am/pm 中的小时数（1-12）  Number  12
         m  小时中的分钟数  Number  30
         s  分钟中的秒数  Number  55
         S  毫秒数  Number  978
         z  时区  General time zone  Pacific Standard Time; PST; GMT-08:00
         Z  时区  RFC 822 time zone  -0800
         */
        // 年-月-日 转换时间的格式
        SimpleDateFormat sdf = new SimpleDateFormat();
        // 设置时间格式
        sdf.applyPattern("yyyy年M月");
        // 把一个Date对象转换为一个指定格式的字符串
        System.out.println(sdf.format(date));

        // 把一个时间字符串转换为一个日期对象
        sdf.applyPattern("yyyy-M-dd");
       // Date date2 = sdf.parse("2019-2-30");

        try {
            Date date2=sdf.parse("2015-02-30");
            System.out.println(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // System.out.println(date2);

    }
}

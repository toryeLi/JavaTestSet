package aOften.bMathStringBufferDemo;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 */
public class MathDemo {
    public static void main(String[] args) {
        System.out.println(Math.abs(-20));//取绝对值
        System.out.println(Math.ceil(33.3));//向上取整
        System.out.println(Math.floor(33.1));//向下取整
        System.out.println(Math.round(3.6));//四舍五入
        System.out.println(Math.random());//[0,1]随机小数
        System.out.println(Math.ceil(Math.random()*100000));
        Random rd=new Random();//[0,1]
        System.out.println(rd.nextInt(33)+1);//1-33
        System.out.println(UUID.randomUUID());//产生一个随机的字符串
        ThreadLocalRandom trand=ThreadLocalRandom.current();//jdk7 版本引入新对象（线程安全的随机）
        int val=trand.nextInt(1,2);
        System.out.println(val);
        System.out.println(Math.pow(2,3));//取一个数的多次幂
        System.out.println(Math.sqrt(3));//取某个数的平方根
    }
}


package cMyORM.dJdbcUtilSelect.test;

import cMyORM.dJdbcUtilSelect.config.PropertiesConfiguration;
import cMyORM.dJdbcUtilSelect.config.PropertiesPlaceHolder3;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * 单例测试，加载资源文件使用单例模式
 */
public class TestSingleto {
    public static void main(String[] args)  {
        //单线程测试（保证使用时是同一个实例）
//        System.out.println(PropertiesConfiguration.getInstance());
//        System.out.println(PropertiesConfiguration.getInstance());
//        System.out.println(PropertiesConfiguration.getInstance());
//        System.out.println(PropertiesConfiguration.getInstance());
//        System.out.println(PropertiesConfiguration.getInstance());
//        System.out.println(PropertiesConfiguration.getInstance());
        //多线程测试（保证使用时是同一个实例）
        //创建一个Set集合，因为Set集合不包含重复元素的collection,
        // 如果Set集合总数是1，则证明是单例，否则不是
        Set<Object> sets= Collections.synchronizedSet(new HashSet<>());
        List<Object> objList=new ArrayList();//这个是线程非安全的,会引起数据混乱
        //List<Object> objList=Collections.synchronizedList(new ArrayList<>());  //这里是线程安全的，内部都使用了同步块
        //由于最后要拿到结果，要阻塞它，所以用 发令枪，
        // 发令枪是并发编程里的内容，
        //定义发令枪
        int count=6000;//定义了50个线程
        CountDownLatch latch=new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                PropertiesPlaceHolder3 instance = PropertiesConfiguration.getInstance();
                sets.add(instance);
                objList.add(instance);
                //每次减1,当latch为0的时候放开阻塞
                latch.countDown();
            }
        }).start();
        }
        try {
            latch.await();//当latch为0的时候，阻塞会放开,线程开始执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sets.size="+sets.size());
        System.out.println("ArrayList="+objList.size());
    }
}

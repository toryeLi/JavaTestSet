package aOften.dInnerClassException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ExceptionDemo {
public static void main(String[] args){
    ////////////// RuntimeException子类 /////////////////
    // 程序运行时才能出现的异常，不需要显示处理它
    // java.lang.ArithmeticException
    // int i = 1/0; // 0不能作为除数
    // System.out.println(i);
    // java.lang.NullPointerException
    // String str = null; // null对象不能调用方法
    // System.out.println(str.trim());

    // java.lang.ArrayIndexOutOfBoundsException
    // String[] strs = {};
    // System.out.println(strs[1]);
    // java.lang.NumberFormatException(数组格式化异常)
    // Integer.parseInt("aaa");
    // java.lang.ClassCastException(类的强制异常信息)
    //Object obj2 = new ExceptionDemo();
    // String obj = (String) obj2;


    /////////////// Exception子类 /////////////////
    // 必须显示处理异常
    // try {} catch(Exception e) {}
    // throw new XxxException(); 通过throws关键字抛出
    try {
        InputStream in = new FileInputStream(new File("D:/aaa.txt"));
    } catch (FileNotFoundException e) {
        System.out.println("-----操作的aaa.txt文件出存在-----");
        e.printStackTrace();
    }

    System.out.println("=============================");
    //3 在控制层捕获业务异常信息，并呈现到界面
    try{
    new ExceptionDemo().add();}catch (Exception e){
        System.err.println(e.getMessage());
    }
}
// 2 在业务类中方法调用中先捕获数据访问层出现的异常，让在catch中显示抛出一个业务异常
public  void add(){
    try {
        new DAO().add();
    } catch (Exception e) {
        //手动抛出一个业务异常
      throw  new BusinessException("添加失败");
    }
}

}
class  DAO{
    //1 在数据访问层抛出一个异常信息
    public void add() throws Exception{
        throw new Exception();
        //System.out.println("dao-->methoad");
    }
}


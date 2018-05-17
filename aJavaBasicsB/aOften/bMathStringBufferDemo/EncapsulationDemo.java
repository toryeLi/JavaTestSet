package aOften.bMathStringBufferDemo;

public class EncapsulationDemo {
    public static void main(String[] args) {
        //byte    short    char       int      long    float     double  boolean
        //Byte    Short    Character  Integer  Long    Float     Double  Boolean
        int number=20;
        Integer integer=new Integer(number);
        Integer integer1=20;//boxing  装箱（new Integer(number);）

        Long ln=Long.valueOf(30L);
        //把一个包装类转换为一个基本数据类型
        Short size=new Short((short) 20);
        //把一个包装类型拆箱为一个基本数据类型
        short size1=size.shortValue();
        int num=integer1.intValue();

        //强制转换
        //每一个包装类都有强制转换的方法
        }
}

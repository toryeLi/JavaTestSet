package aOften.cReflectEnum.aReflectTest;

import TestModel.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class TestStudent {
    static Class clazz ;
    public static void main(String[] args){
      //  setAndGetField();
        try {
            clazz = Class.forName("TestModel.Student");
//            testGetClassForField();
            methodShow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *获取Class对象中所有方法及信息
     */
    public static void methodShow() throws IllegalAccessException, InstantiationException {
       Method[] methods= clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("======================");
        StringBuilder sb=new StringBuilder();
        for (Method method : methods) {
            sb.append("方法的访问修饰符："+Modifier.toString(method.getModifiers()));
            sb.append(";方法的返回类型："+method.getReturnType().getSimpleName());
            sb.append(";方法名称："+method.getName());
            sb.append(";参数类型数组"+ Arrays.toString( method.getParameterTypes()));
            sb.append(";参数的个数："+method.getParameterCount());
            sb.append(";参数数组"+Arrays.toString( method.getParameters()));
            System.out.println(sb.toString());
            sb.delete(0,sb.length());
        }
        Object o = clazz.newInstance();
        try {
            Method setName = clazz.getDeclaredMethod("setName", String.class);
            //开启任何方法的访问权限
            setName.setAccessible(true);
            Object setNa= setName.invoke(o,"aaa");
            System.out.println("setName="+setNa);
            Method getName=clazz.getDeclaredMethod("getName");
            System.out.println("getName="+getName.invoke(o));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取Class方法
     */
    public static void testGetClass() {
        System.out.println("----------获取对应类的Class对象");
        //1 通过类本身Class属性获取
        System.out.println("TestStudent 0" + Student.class);
        //2 通过类对应实例获取
      //  Student student = new Student(10);
      //s  System.out.println("TestStudent 1" + student.getClass());
        //3 通过Class类中提供静态forName方法获取
        try {
            Class clazz = Class.forName("TestModel.Student");
            System.out.println("TestStudent 2" + clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    /**
     * 获取Class对象中的成员变量
     */
    public static void testGetClassForField() {
        System.out.println("------获取一个Class对象中的成员变量------");
        try {
            //获取该类下的public修饰的成员变量
            Field[] fields = clazz.getFields();
            System.out.println("class.getFields获取的是public修饰的成员变量");
            for (Field field : fields) {
                System.out.println("字段名：" + field.getName() + " 该字段类型为：" + field.getGenericType());
            }
            //获取该类下所有的成员变量
            System.out.println("class.getDeclaredFields获取的是该类所有的成员变量");
            fields = clazz.getDeclaredFields();
            StringBuilder sb = new StringBuilder();
            for (Field field : fields) {
                sb.append("字段类型：" + field.getType().getTypeName());
                sb.append(";"+field.getModifiers()+":访问修饰符：" + Modifier.toString(field.getModifiers()));
                sb.append(";字段类型简单名称" + field.getType().getSimpleName());
                sb.append(";字段的名称" + field.getName());
                System.out.println(sb.toString());
                sb.delete(0,sb.length());
            }
            //通过class对象创建类实例
           Object obj=clazz.newInstance();
            //getDeclaredField 可以单独获取一个字段,私有的也可以获取
            Field fieldName=clazz.getDeclaredField("Name");
            //Field fieldName=clazz.getField("Name");//私有的获取失败
            fieldName.setAccessible(true);//设置字段值
            fieldName.set(obj,"Torey");//获取字段值
            System.out.println(fieldName.get(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

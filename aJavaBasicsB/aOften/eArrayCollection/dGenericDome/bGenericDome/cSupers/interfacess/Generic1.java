package aOften.eArrayCollection.dGenericDome.bGenericDome.cSupers.interfacess;

import aOften.eArrayCollection.dGenericDome.aListDemo.entity.Student;

/**
 * 测试绑定接口
 */
public class Generic1 {
    public static void main(String[] args){
        print(new UserDAO());
        print(new BookDAO());
        print(new StudentDAO());
        Student student = new Student();
        //print(new Student());Student 不是IBaseDao的实现类
    }
    //<T extends IBaseDAO>  T泛型类绑定了一个范围
    public static  <T extends IBaseDAO> void print(T t){
        System.out.println(t);
    }

    /**
     * 可变参数数组
     * @param t
     * @param <T>
     */
    public static  <T extends IBaseDAO> void print(T... t){
        System.out.println(t);
    }
}

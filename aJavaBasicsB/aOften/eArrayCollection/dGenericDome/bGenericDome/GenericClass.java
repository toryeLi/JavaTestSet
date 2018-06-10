package aOften.eArrayCollection.dGenericDome.bGenericDome;

import aOften.eArrayCollection.cMapAndSetDemo.aSetDemo.entity.Person;
import aOften.eArrayCollection.dGenericDome.aListDemo.entity.Student;

/**
 * 自定义泛型类
 */
public class GenericClass implements GenericInterface<Student> {
public static void main(String[] args){
    BaseDAO1<String> stringBaseDAO1 = new BaseDAO1<>();
    stringBaseDAO1.add("sss");
    BaseDAO1<Book1> book1BaseDAO1 = new BaseDAO1<>();
    book1BaseDAO1.add(new Book1());
    System.out.println("===========");
    String aaa = stringBaseDAO1.get(12, "aaa");
    Integer ddd = stringBaseDAO1.get1("ddd", 12, new Person());
    String ddd1 = stringBaseDAO1.<Double, String, Student>get1(2.2D, "ddd", new Student());

}

    @Override
    public void add(Student student) {

    }
}

/**
 *
 * @param <T>  对象
 * @param <E>  元素
 * @param <V>  value
 * @param <K>   key
 */
class BaseDAO<T,E,V,K>{
    void add(T t){
        System.out.println("我添加了：" + t);
    }
}

class BaseDAO1<T>{
    void add(T t){
        System.out.println("我添加了：" + t);
    }
    /**
     * 泛型方法
     * @param e
     * @param <E> 声明泛型类型
     * @return
     */
    public <E,X,K> X get1(E e,X x,K k){
        System.out.println(e + ";" + x + ";" + k);
        return  x;
    }
    public <E,X,K> X get(E e,X x){
        System.out.println(e + "----" + x);
        return x;
    }
}
class Student1{}
class Teacher{}
class Book1{}

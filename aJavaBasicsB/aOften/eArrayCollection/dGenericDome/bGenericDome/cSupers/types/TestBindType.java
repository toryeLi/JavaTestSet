package aOften.eArrayCollection.dGenericDome.bGenericDome.cSupers.types;

import java.io.Serializable;

/**
 * 泛型绑定类的测试
 */
public class TestBindType {
public static void main(String[] args){
    print(new Animal());
    print(new Lion());
    print(new Cat());
    print2(new Cat());
    print2(new Toger());
 //   print(new Grass()); //因为Grass不是Animal的子类
}
//绑定了类型：绑定类必须为Animal及其子类
public static <T extends Animal > void print(T t){
    System.out.println(t);
}
    //绑定了多个类型：绑定类必须为Animal及其子类,还必须实现Serializable
    public static <T extends Animal&Serializable> void print2(T t){
        System.out.println(t);
    }
}

package aOften.eArrayCollection.bLinkedDome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TestDemo {
    public static void main(String[] args){
        bbb();
    }
    public static void aaa(){
        Collection c1=new ArrayList();
        c1.add("AAA");
        c1.add(1.4D);
        c1.add(3.0D);
        //如果是整数，默认为int整型，如果是小数默认为double
        c1.add(3);
        //2 删除元素
        c1.remove(3);
        System.out.println(c1);
        c1.remove(3.0);
        System.out.println(c1);
        //3 清理集合中元素的方法
        //c1.clear();
        //4 判断是否包含某个元素
        System.out.println(c1.contains("AAA"));
        //5 求2个集合中相同元素组成一个新的集合

    }
    public static void bbb(){
        Collection cl3=new ArrayList();
        Collection cl1=Arrays.asList("bbb",1.4,"AAA");
        Collection cl2=Arrays.asList("bbb","ccc");
        ((ArrayList) cl3).addAll(cl2);
        System.out.println(cl3);
        cl3.retainAll(cl1);
        System.out.println(cl3);
    }
}

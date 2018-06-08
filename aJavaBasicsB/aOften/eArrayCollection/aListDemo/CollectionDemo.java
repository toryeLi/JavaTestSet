package aOften.eArrayCollection.aListDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * 数组：存储同一类型的运算组成的集合，固定长度，数组中元可以是基本数据，也可以是对象
 * 集合：存储不同类型对象的容器，长度可变，集合中的元素必须是Object的子类，不能是基本数据类型
 * 首字母大写的都是对象，不成文的规定
 */
public class CollectionDemo {
    /**
     * Collection集合常用方法：
     * 增加、删除、大小、包含、为空、清空、迭代、并交；
     * boolean add(E o);
     * boolean remove(Object o);
     * int size();
     * boolean contains(Object o);
     * boolean isEmpty();
     * void clear();
     * Iterator<E> iterator();
     * boolean addAll(Collection c);
     * boolean retainAll(Collection c);
     *  boolean removeAll(Collection c);
     */
    public static void main(String[] args){
        Collection collection= new ArrayList();
        collection.add("AAA");
        collection.add("AAA");
        ((ArrayList) collection).add(new Object());
        collection.add(1);//自动装箱 new Integer(1)
        System.out.println(collection.toString());
        //获取集合元素个数
        System.out.println(collection.size());
        //遍历集合，使用迭代器
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
        System.out.println("=======================");
        for (Object o : collection) {
            System.out.print(o+" ");
        }
        //判断是否存在某个对象
        boolean flag = collection.contains("AAA");
        System.out.println(flag?"存在":"不存在");
        //首次查找到的对象会被移除
        collection.remove("AAA");
        //清空集合中的元素
       // collection.clear();
        //collection=null;
        //判断集合是否为空,isEmpty()没有关心对象的本身是null,判断size==0,一般会重写该方法
        System.out.println(collection.isEmpty()?"为空":"不为空");
        //批量添加一个集合到一个集合中,Arrays 和 Collections 是一个工具类
        //Arrays 数组操作的工具类，asList把一个数组转换为一个集合
        Collection c1 = Arrays.asList("aaa", "BBB", 12);
        ((ArrayList) collection).addAll(c1);
        ((ArrayList) collection).add(c1);
        System.out.println(collection);
        //批量删除
        Collection cl1= Arrays.asList(new Double(1.1),"AAA","BBB");
        collection.removeAll(cl1);
        System.out.println(collection);
        //获取2个集合直接交集
        collection.retainAll(Arrays.asList("BBB","DDD"));
        System.out.println(collection);

    }
}

package aOften.eArrayCollection.cMapAndSetDemo.aSetDemo;

import aOften.eArrayCollection.cMapAndSetDemo.aSetDemo.entity.Person;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set集合接口是无序的，不重复
 * Set集合添加元素的时候判断集合中是否有相同的hashcode值，如果有相同的触发equals
 * 比较对象中各个属性完全一致认为是同一个对象，如果有个属性不同，认为不是同一个对象
 * 可以重写 对象的 hashcode 和 equals 方法，自己定义 两个对象是否相同
 */
public class SetDemo2 {
    public static void main(String[] args){
        Set set = new HashSet();
        //先判断对象的hashCode是否相同，如果
        set.add(new Person(1001,"张三"));
        set.add(new Person(1001,"张三"));
        set.add(new Person(1002,"张三"));
        set.add(new Person(1003,"张三"));
        System.out.println("============");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("======================");


        // System.out.println(set);

    }
}

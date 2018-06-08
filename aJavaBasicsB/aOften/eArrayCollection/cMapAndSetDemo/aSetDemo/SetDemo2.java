package aOften.eArrayCollection.cMapAndSetDemo.aSetDemo;

import aOften.eArrayCollection.cMapAndSetDemo.aSetDemo.entity.Person;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set集合接口是无序的，不重复
 */
public class SetDemo2 {
    public static void main(String[] args){
        Set set = new HashSet();
        set.add(new Person(1001,"张三"));
        set.add(new Person(1001,"张三"));
        set.add(new Person(1001,"张三"));
        set.add(new Person(1001,"张三"));
        set.add(new Person(1002,"张三"));
        set.add(new Person(1003,"张三"));
        System.out.println("============");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
       // System.out.println(set);

    }
}

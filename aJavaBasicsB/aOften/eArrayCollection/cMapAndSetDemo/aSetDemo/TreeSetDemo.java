package aOften.eArrayCollection.cMapAndSetDemo.aSetDemo;

import aOften.eArrayCollection.cMapAndSetDemo.aSetDemo.entity.Person;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 排序实现类
 */
public class TreeSetDemo {
 public static void main(String[] args){
     //必须让其排序的类实现排序算法
     TreeSet treeSet = new TreeSet();
     treeSet.add(new Person(1001,"AA"));
     treeSet.add(new Person(1001,"AA"));
     treeSet.add(new Person(1010,"AA"));
     treeSet.add(new Person(1005,"AA"));
     treeSet.add(new Person(1015,"AA"));
     Iterator iterator = treeSet.iterator();
     System.out.println("===============");
     while (iterator.hasNext()) {
         System.out.println(iterator.next());
     }

 }
}

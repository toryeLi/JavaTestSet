package aOften.eArrayCollection.cMapAndSetDemo.aSetDemo;

import aOften.eArrayCollection.cMapAndSetDemo.aSetDemo.entity.Person;

import java.util.*;

public class DulipulteDemo {
    public static void main(String[] args){
        //List集合
        List personList = new ArrayList();
        personList.add(new Person(1003,"A3"));
        personList.add(new Person(1004,"A4"));
        personList.add(new Person(1005,"A5"));
        personList.add(new Person(1001,"A1"));
        personList.add(new Person(1002,"A2"));
        personList.add(new Person(1005,"A5"));
        personList.add(new Person(1005,"A5"));
        personList.add(new Person(1005,"A5"));
        personList.add(new Person(1005,"A5"));
        personList.add(new Person(1005,"A5"));
        personList.add(new Person(1005,"A5"));
        personList.add(new Person(1005,"A5"));
        personList.add(new Person(1005,"A5"));
        Iterator iterator = personList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        getNewList(personList);
        System.out.println("=====================");
        Iterator iterator1 = personList.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }

    /**
     * 定义去重集合对象的方法
     */
    private static void getNewList(List PersonList) {
      //  LinkedHashSet set=new LinkedHashSet();//不排序
        Set set=new TreeSet();//排序
        set.addAll(PersonList);
        PersonList.clear();
         PersonList.addAll(set);
    }
}

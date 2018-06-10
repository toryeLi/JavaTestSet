package aOften.eArrayCollection.dGenericDome.aListDemo;

import aOften.eArrayCollection.dGenericDome.aListDemo.entity.Student;

import java.lang.reflect.Method;
import java.util.*;

/**
 * 数组：基本数据类型和对象类型都是可以存储的
 * 集合：只可以存储对象类型
 * 泛型检测是编译阶段（类型 擦除）
 */
public class ListDemo {
    public static void main(String[] args){
        //泛型的检测在编译阶段（存在类型擦除）
        List<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("B");
        list.add("C");
        //可以利用反射绕过检测
        Class<?> clazz = list.getClass();
        try {
            Method add = clazz.getDeclaredMethod("add", Object.class);
            add.invoke(list,123);
            System.out.println(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<Student> studentsSet=new HashSet<Student>();
        studentsSet.add(new Student());
        studentsSet.add(new Student());
        System.out.println(studentsSet);
        ///////////////////////////Map////////////
        Map<String,Student> stuMap=new HashMap<String, Student>();

        stuMap.put("1001",new Student());
        stuMap.put("1002",new Student());
        stuMap.put("1003",new Student());
        stuMap.put("1004",new Student());
        for (Map.Entry<String, Student> entry : stuMap.entrySet()) {
            String key = entry.getKey();
            Student value = entry.getValue();
            System.out.println(key + "---------" + value);

        }
        System.out.println("--------------------");
        treeMapComparatorTest();
        System.out.println("--------------------");
        treeMapComparatorTest2();

    }

    /**
     * TreeMap 只能对key进行排序，不能对value进行排序， 重写 Comparator比较器
     */
    public static void treeMapComparatorTest(){
        //排序，使用局部的匿名内部类实现排序算法
        TreeMap<String, Student> stringStudentTreeMap = new TreeMap<>(new Comparator<String>() {
            /**
             * 重写排序算法，这里是对TreeMap的key进行排序，如果不传Comparator,TreeMap也会有默认的排序算法
             * @param o1
             * @param o2
             * @return
             */
            @Override
            public int compare(String o1, String o2) {
                return o1.hashCode()-o2.hashCode();
            }
        });
        stringStudentTreeMap.put("1002",new Student());
        stringStudentTreeMap.put("1003",new Student());
        stringStudentTreeMap.put("1001",new Student());
        stringStudentTreeMap.put("1004",new Student());
        for (Map.Entry<String, Student> entry : stringStudentTreeMap.entrySet()) {
            String key = entry.getKey();
            Student value = entry.getValue();
            System.out.println(key + "---------" + value);
        }
    }

    /**
     * TreeMap 只能对key进行排序，不能对value进行排序，有默认的 Comparator比较器
     */
    public static void treeMapComparatorTest2(){
        //排序，使用局部的匿名内部类实现排序算法
        TreeMap<String, Student> stringStudentTreeMap = new TreeMap<>();
        stringStudentTreeMap.put("1002",new Student());
        stringStudentTreeMap.put("1003",new Student());
        stringStudentTreeMap.put("1001",new Student());
        stringStudentTreeMap.put("1004",new Student());
        for (Map.Entry<String, Student> entry : stringStudentTreeMap.entrySet()) {
            String key = entry.getKey();
            Student value = entry.getValue();
            System.out.println(key + "---------" + value);
        }
    }

    /**
     * TreeMap 只能对key进行排序，不能对value进行排序， 使用内部类实现Comparator比较器
     */
    private static void treeMapComparatorTest3(){
        /**
         * 局部内部类的用法
         */
        class MyComparator implements Comparator<String>{
            @Override
            public int compare(String o1, String o2) {
                return o1.hashCode()-o2.hashCode();
            }
        }
        //排序，使用局部的匿名内部类实现排序算法
        TreeMap<String, Student> stringStudentTreeMap = new TreeMap<>(new MyComparator());

        stringStudentTreeMap.put("1002",new Student());
        stringStudentTreeMap.put("1003",new Student());
        stringStudentTreeMap.put("1001",new Student());
        stringStudentTreeMap.put("1004",new Student());
        for (Map.Entry<String, Student> entry : stringStudentTreeMap.entrySet()) {
            String key = entry.getKey();
            Student value = entry.getValue();
            System.out.println(key + "---------" + value);
        }
    }
}

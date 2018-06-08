package aOften.eArrayCollection.aListDemo.list;

import java.util.*;

/**
 * List接口：
 * ArrayList特点：元素是有序，可以包含重复元素，基于数组实现
 * 因为有下标，所有查询（定位）速度是非常快的，插入和删除速度不高
 */
public class ArrayListDemo {
    public static void main(String[] args){
        List list=new ArrayList();
        list.add("AAA");
        list.add("BBB");
        list.add(1,"CCC");//插入单个元素
        list.addAll(Arrays.asList(1,1.1D,1.1F));//批量添加集合
        list.addAll(2,Arrays.asList("vvc","dda"));
                //删除元素
        list.remove(0);//通过对象的下标移除
        list.remove(new Integer(1));//通过对象移除
        list.retainAll(Arrays.asList("vvc","dda"));//批量移除
        System.out.println(list);
        //判断元素是否存在
        boolean flag = list.contains("AAA");
        System.out.println(flag ? "存在" : "不存在");
        //批量判断是否存在，如果有一个不存在，则不存在
        flag = list.containsAll(Arrays.asList(1, 1.1D, 1.1F));
        //判断集合元素个数是否为0
        System.out.println(list.isEmpty());
        //获取单个指定下标元素
        System.out.println(list.get(3));
        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
        System.out.println("\r\n");
        //使用迭代器遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
        System.out.println("\r\n");
        //使用迭代器遍历
        Iterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next());
        }
        System.out.println("\r\n");
        //反向迭代，必须把游标移动到末尾
        ListIterator listIterator1 = list.listIterator(list.size());
        while (listIterator1.hasPrevious()) {
            System.out.print(listIterator1.previous() + " ");
        }
        System.out.println("\r\n");
        System.out.println("====================");
        //增强for循环
        for (Object o : list) {
            System.out.print(o + " ");
        }


    }

}

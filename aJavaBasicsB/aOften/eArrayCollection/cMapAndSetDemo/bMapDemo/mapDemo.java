package aOften.eArrayCollection.cMapAndSetDemo.bMapDemo;

import java.util.*;

/**
 * map 是以键值对的形式存储的,key不能重复，值可以重复
 * HashMap中key和value都可以为null
 */
public class mapDemo {
    public static void main(String[] args){
        //Map集合是以键作为获取value依据
        Map map= new  HashMap();
        map.put("a1","aaa1");
        map.put("a2","aaa2");
        map.put("a3","aaa3");
        System.out.println(map.get("a2"));
        System.out.println(map);
        System.out.println(map.keySet());//key==Set 不能包含重复
        System.out.println(map.values());//value==List 可以包含重复
        System.out.println("====================");
        //可以通过key遍历Map集合
        for (Object obj : map.keySet()) {
            Object key=obj;
            Object value = map.get(obj);
            System.out.println("key=" + key + "--------value=" + value);
        }
        //HashMap和HashTable区别
        //1 HashMap的键值都可以为null,而HashTable的键和值都不能为null.
        //2 HashMap是线程非安全的，而HashTable是线程安全的
        //3 HashTable的性能要比HashMap性能低
        //=====================================
        //创建线程安全的HashMap集合
        Map map2 = Collections.synchronizedMap(new HashMap());
        Hashtable hashtable=new Hashtable();
        //hashtable.put("AAA",null);
        System.out.println("======================");
        SortedMap sortedMap=new TreeMap();//可以排序，自然排序
        sortedMap.put("BBB","AAAA");
        sortedMap.put("AAA","AAAA");
        sortedMap.put("2","AAAA2");
        sortedMap.put("1","AAAA1");
        System.out.println(sortedMap);

    }
}

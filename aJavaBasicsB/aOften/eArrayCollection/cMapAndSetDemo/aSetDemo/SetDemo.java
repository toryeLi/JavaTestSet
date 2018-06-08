package aOften.eArrayCollection.cMapAndSetDemo.aSetDemo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 父接口Collection
 * Set接口特点：无序，并且不能包含重复元素
 */
public class SetDemo {
    public static void main(String[] args){
        /*
		boolean add(E o);
		boolean addAll(Collection c);

		int size();
		boolean contains(Object o);
		boolean isEmpty();
		void clear();
		Iterator<E> iterator();

		boolean remove(Object o);
		boolean removeAll(Collection c);

		boolean retainAll(Collection c);
		*/
        Set hashSet = new HashSet();
        hashSet.add("A1");
        hashSet.add("B2");
        hashSet.add("B2");
        hashSet.add("C3");
        hashSet.add("D4");
        hashSet.add(new Object());
        hashSet.add(new Object());
        hashSet.addAll(Arrays.asList("15","B6","C7"));
        System.out.println(hashSet.contains("B6"));
        System.out.println("个数："+hashSet.size());
        System.out.println(hashSet);
        //清空集合的元素
//        hashSet.clear();
        //判断集合是否含有元素
        System.out.println(hashSet.isEmpty());
        System.out.println(hashSet);
        //使用迭代器输出这个集合中的每一个元素,使用迭代器速度是最快的，比增强for循环还要快
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
        System.out.println("\n\r");
        //移除指定的元素
        hashSet.remove("A1");
        System.out.println(hashSet);
        //移除指定集合中的所有元素
        hashSet.removeAll(Arrays.asList("D4","B6","f1"));
        System.out.println(hashSet);

    }
}

package aOften.eArrayCollection.cMapAndSetDemo.aSetDemo;

import aOften.eArrayCollection.cMapAndSetDemo.aSetDemo.entity.Cat;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeSet;

/**
 * 比较三种set集合子类性能
 * HashSet
 * TreeSet
 * LinkedHashSet   这个速度是最快的，以后如果涉及到去除的操作，建议都使用LinkedHashSet
 */
public class LinkecHashSetDemo {
    public static void main(String[] args){
        Random rd=new Random();
        testHashSet(rd);
        testTreeSet(rd);
        testLinkedHashSet(rd);
    }

    private static void testLinkedHashSet(Random rd) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int size = rd.nextInt(1000) + 1;
            linkedHashSet.add(new Cat(size));
        }
        long endTime = System.nanoTime();
        System.out.println("LinkedHashSet用时：" + (endTime - startTime));
    }

    private static void testTreeSet(Random rd) {
        TreeSet treeSet = new TreeSet();
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int size = rd.nextInt(1000) + 1;
            treeSet.add(new Cat(size));
        }
        long endTime = System.nanoTime();
        System.out.println("TreeSet用时：" + (endTime - startTime));
    }

    private static void testHashSet(Random rd) {
        HashSet hashSet = new HashSet();
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int size = rd.nextInt(1000) + 1;
            hashSet.add(new Cat(size));
        }
        long endTime = System.nanoTime();
        System.out.println("HashSet用时：" + (endTime - startTime));
    }


}

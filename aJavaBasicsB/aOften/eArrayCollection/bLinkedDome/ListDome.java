package aOften.eArrayCollection.bLinkedDome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListDome {
    public static void main(String[] args){
        List list=new ArrayList();
        list.addAll(Arrays.asList("a","b","c"));
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next()+" ");
        }
        System.out.println("\n");
        ListIterator listIterator1 = list.listIterator(list.size());
        while (listIterator1.hasPrevious()) {
            System.out.print(listIterator1.previous()+" ");
        }
    }

}

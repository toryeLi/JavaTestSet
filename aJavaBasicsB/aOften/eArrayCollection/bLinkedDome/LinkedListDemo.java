package aOften.eArrayCollection.bLinkedDome;

import java.util.LinkedList;

public class LinkedListDemo {
  public static void main(String[] args){
      /**
       * 栈是：先进后出
       */
      LinkedList linkedList = new LinkedList();
      //模拟栈  压栈
      linkedList.addFirst("A");
      linkedList.addFirst("B");
      linkedList.addFirst("C");
      linkedList.addFirst("D");
      // 弹栈
      System.out.println(linkedList.removeFirst());
      //获取栈顶元素
      System.out.println(linkedList.getFirst());
      System.out.println(linkedList);
      System.out.println("----------------------");
      /**
       * 模拟队列，先进先出
       */
      LinkedList linkedList1 = new LinkedList();
      linkedList1.addLast("A");
      linkedList1.addLast("B");
      linkedList1.addLast("C");
      linkedList1.addLast("D");
      // 弹栈
      System.out.println(linkedList1.removeFirst());
      //获取栈顶元素
      System.out.println(linkedList1.getFirst());
      System.out.println(linkedList1);
  }

}

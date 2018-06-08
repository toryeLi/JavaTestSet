package aOften.eArrayCollection.bLinkedDome;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列：先进先出
 * 双向队列
 */
public class QueueDemo {
    public static void main(String[] args){
        Queue queue=new LinkedList();
        //入列
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        //队列头出元素，队列尾进元素
        //出列
        System.out.println(queue.poll());
        System.out.println(queue);
        //获取列头
        System.out.println(queue.peek());
        System.out.println(queue);

    }
}

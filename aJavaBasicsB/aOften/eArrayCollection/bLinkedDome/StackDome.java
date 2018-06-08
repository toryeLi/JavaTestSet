package aOften.eArrayCollection.bLinkedDome;

import java.util.Stack;

/**
 * 栈Stack:先进后出
 * 栈的效率要比 堆的高的多
 */
public class StackDome {
    public static void main(String[] args){
        //先进后出
        Stack stack = new Stack();
        //压栈
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        //弹栈（从栈中移除该元素）
        System.out.println(stack.pop());
        //获取栈顶元素（获取栈上面最先出来的元素）
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}

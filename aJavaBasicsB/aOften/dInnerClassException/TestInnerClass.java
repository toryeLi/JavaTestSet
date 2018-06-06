package aOften.dInnerClassException;

/**
 * 定义测试内部类的实现过程
 * 1 一般内部类
 * 2 嵌套内部类   使用static修饰的内部类
 * 3 匿名内部类   一般使用抽象类来定义
 * 4 局部内部类
 * 注：
 * 1 内部类应用场景：事件驱动编程、接口、抽象类、
 * 2 非静态内部类不能定义静态变量
 * 3 匿名内部类可以屏蔽反射
 * 4 静态内部类可以被继承，非静态内部类不可以被继承
 */
public class TestInnerClass {
    public static void main(String[] args) {
        //创建外部类
        Outer outer = new Outer();
        //
        Outer.Inner inner1 = outer.new Inner();
        //直接创建
        Outer.Inner inner = new Outer().new Inner();
        inner.print();
        ///////////静态内部类//////////////
        Outer1.Inner inner2 = new Outer1.Inner();
        Outer1.Inner inner3 = new Outer1.Inner();
        System.out.println(inner2.i);
        inner2.print();
        System.out.println(inner2 + "----" + inner3);
        ///////////////匿名内部类/////////////////
        new Outer2() {
            @Override
            void run() {
                System.out.println("匿名类中的方法实现了");
            }
        }.run();
        new IFunction() {
            @Override
            public void test() {
                System.out.println("接口中的匿名方法，不能通过反射去操作");
            }
        }.test();
        ///////////////局部内部类/////////////////
        Outer3 outer3 = new Outer3();
        outer3.test();
        ///////////////测试内部类继承/////////////////
        System.out.println("测试内部类继承");
        Child child = new Child();
        child.print();
    }
}

// 局部内部类
class Outer3{
    void test(){
        class Inner3{
            void print(){
                System.out.println("局部内部类的方法");
            }
        }
        new Inner3().print();;
    }

}
//3 匿名内部类
abstract class Outer2 {
    abstract void run();
}
interface IFunction{
    void test();
}
//静态内部类才能被外部继承
class Child extends  Outer1.Inner{}
//2 嵌套内部类--静态内部类
class Outer1 {

    static class Inner {
        static int i = 2;
Inner(){
    System.out.println("Outer1.Inner被构造了");
}
        void print() {
            System.out.println("静态内部类中的方法");
        }
    }
}

///1 一般内部类
//闭包：自给自足,提高变量生命周期
//外部类不能使用static修饰
class Outer {

    private void outerPrint() {
        //可以通过内部类的对象调用外部类的私有方法
        //new Inner().print();s
        System.out.println("外部类的方法");
    }

    int i = 20;
    int a = 21;

    class Inner {
        int i = 100;

        public Inner() {
            System.out.println("内部类实例化了");
        }

        void print() {
            outerPrint();//调用外部类的私有方法
            System.out.println("Inner 内部类的变量" + this.i);
            System.out.println("Outer外部类的变量 " + Outer.this.i);
            System.out.println("Outer " + a);
        }
    }
}

package aOften.aObjectStringDemo;

/**
 * 学习Objecgt类 native本地栈方法，方法使用使用c语言中实现的方法 hashcode就是一个对象在内存中地址
 *
 * @author Torey 静态方法中不能使用this关键字
 */
public class ObjectTest extends Object implements Cloneable {

    public static void main(String[] args) {
        // 创建一个对象
        ObjectTest obj = new ObjectTest();
        // 使用System.out.println打印一个对象的时候会自动调用该对象的toString()方法
        System.out.println(obj);
        System.out.println(obj.toString());
        // 使用hashcode方法
        System.out.println(Integer.toHexString(obj.hashCode()));
         Object obj1=obj.cloneObject();
         System.out.println(obj1);
         Object obj3=obj;
         //equals方法（==）比较2个对象的引用（内存地址）是否相同
        System.out.println(obj==obj1);
        System.out.println(obj3==obj1);
        System.out.println(obj.equals(obj1));
        System.out.println(obj3.equals(obj));
        obj1=null;
        System.gc();
    }

    public Object cloneObject() {
        Object obj = null;
        try {
            //必须实现Cloneable接口
            obj = this.clone();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return obj;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("==对象销毁==");
            super.finalize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

package aOften.eArrayCollection.dGenericDome;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 功能：泛型的使用，解释为什么使用泛型
 */
public class GenericTest {
    public static void main(String[] args){
         genericDome();
       // genericDome2();
    }

    /**
     * 没有使用泛型
     */
    private static void genericDome() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("ddd");
        //上面添加的字符串，下面添加的是int,迭代是肯定会报类型转换异常
        arrayList.add(4);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            //需要强制类型转换
            //此处在运行时会报类型转换异常：ClassCastException
            //在编译时不会报异常
            String s=(String) iterator.next();//1
            System.out.println(s + ":" + s.length());
        }
    }

    /**
     * 当我们将一个对象放入集合中，集合不会记住此对象的类型，当再次从集合取出此对象时，该对象的编译类型变化了
     * Object类型
     * 但其运行时类型仍然为其本身类型；
     * 因此,//1 处取出集合元素时需要人为的强制类型转化到具体的目标类型，且很容易出现“java.lang.ClassCastException”异常
     * */
    //JDK1.5之后使用泛型
    //解决安全问题
    private static void genericDome2() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("quw");
        //编译时下面这条语句报错
        //strings.add(4);

        // 迭代器也通过泛型指定类型
        // 后续就不需要强制类型转换了
        Iterator<String> it = strings.iterator();
        while(it.hasNext())
        {
            String s = it.next();
            System.out.println(s + ":" + s.length());
        }
    }
}

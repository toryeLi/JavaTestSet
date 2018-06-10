package aOften.eArrayCollection.dGenericDome.bGenericDome.cSupers.common;

/**
 * 通配符
 * ？ 无边界
 * ？ extends 上边界
 * ？ super  下边界（用的非常少）
 * 通配符？总结
 * ？ extends 和 ？ super 通配符的特征：
 * 如果你想从一个数据类型里获取数据，使用？ extends通配符（能取不能存）
 * 如果你想把对象写入有一个数据结构里，使用？ super通配符
 * 如果你既想存，又想取，那就别用通配符
 */
public class TestCommon {
public static void main(String[] args){
    //? 问号通配
    Point<?> point = new Point<Integer>(222,333);
    point=new Point<Double>(33D,22D);
    point=new Point<String>("SSSS");
    // ? extends限定,能读，不能写（不能存）
    Point<? extends Number> p=new Point<Long>(11L,33L);
     p=new Point<Integer>(1,33);
    System.out.println(p.getX());
    //  p=new Point<String>("","");

}
}
class Point<X>{
    private X x;

    public Point(X x) {
        this.x = x;
    }
    public Point(X x,X y) {
        this.x = x;
    }
    public X getX() {

        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public Point() {
    }
}

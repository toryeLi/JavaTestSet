package aOften.aObjectStringDemo;

public class StringTest {
public static void main(String[] args) {
	String name="张飞A";
	String name1=new String();//创建字符串对象
	String name2=new String("张飞A");
	//equals 比较2个对象值是否相同
	System.out.println(name.equals(name2));
	//==比较2个对象的内存地址是否相同
	System.out.println(name==name2);
	System.out.println(new Object() instanceof String);
}
}

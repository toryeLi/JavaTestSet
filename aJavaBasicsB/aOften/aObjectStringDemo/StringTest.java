package aOften.aObjectStringDemo;

import java.util.Arrays;

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
	//把所有字符串中字母转换为小写toLowerCase 
	System.out.println("ADBDadeSSA".toLowerCase());
	//把所有字符串中字母转换为大写toLowerCase
	System.out.println("ADBDadeSSA".toUpperCase());
	//equalsIgnoreCase忽略字母大小写比较2个字符串的值是否相同
	System.out.println("aaB".equalsIgnoreCase("AAb"));
	String str="你好吗?xueW";
	//charAt 根据下标获取某个字符
	System.out.println(str.charAt(3));
	//让其str倒序输出
	for (int i = str.length()-1; i >=0;i--) {
		System.out.println(str.charAt(i));
	}
	System.out.println("======================");
	System.out.println("123456789ABCDEF".substring(3, 5));//截取一个范围内字符串，从0开始
	String url="http://192.168.10.1/index.html";
	String url1="ftp://192.168.10.1/ff/dd/aa/index.html";
	String ip=url1.substring(7,18);
	System.out.println("ip="+ip);
	//indexof,lastIndexof查找某个字符串位置
	int startIndex=url1.indexOf("//")+2;
	//从startIndex开始查找"/"首次出现的位置
	int endIndex=url1.indexOf("/",startIndex);
	System.out.println("正则表达式验证："+url1.substring(startIndex,endIndex));//正则表达式验证
	//replace方法替换方法
	System.out.println("aaee abd dddss".replace("a", "1"));//不能使用正则表达式
	System.out.println("aaee abd dddss".replaceAll("a", "1"));//不能使用正则表达式
	//split把一个特殊字符串切割为一个数组
	String personString="张三_10_男";
	String[] person=personString.split("_");
	//使用对象循环
	for (String info : person) {
		System.out.println(info);
	}
	System.out.println(Arrays.toString(person));
	String str1="张三_10_男，李四_20_女";
	String[] strings=str1.split("[_,]");
	System.out.println(Arrays.toString(strings));
	//concat 连接字符串
	String concat=name.concat("abCDEF");
	System.out.println(concat);
}
}

package aOften.bMathStringBufferDemo;

/**
 *
 */
public class bStringBuffer {

    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = sb1.append("AAbAA");
        System.out.println(sb1 == sb2);//比较2个对象内存地址是否相同
        System.out.println(sb1.equals(sb2));
        System.out.println(sb1.toString());//获取StringBuffer对象的值
        System.out.println("存储");
        //1 存储
        sb1.append("bbbb");//将指定数据作为参数添加到已有数据结尾处
        System.out.println(sb2.toString());//
        sb1.insert(4,"CCC");//指定插入值得偏移量
        System.out.println(sb1.toString());

        // 删除
        sb1.delete(3,7);
        System.out.println(sb1);
        String sql ="INSERT INTO T_TB VALUES(字段1，字段2，字段3，";
        StringBuffer sqlSb=new StringBuffer();
        sqlSb.deleteCharAt(sql.length()-1);
        System.out.println(sqlSb);

        //修改
        sqlSb.replace(0,11,"UPDATE");//选定区域更换为新的字符串
        System.out.println(sqlSb);
        sqlSb.setCharAt(1,'A');//替换指定索引某个字符
        System.out.println(sqlSb);
        //反转（倒序输出）
        StringBuffer sb3=new StringBuffer("FFFDKEFDSDFSD");
        sb3.reverse();
        System.out.println(sb3);
    }

}















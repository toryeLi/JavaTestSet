package JdbcTest.JDBCDemo;

import java.sql.*;

public class JDBCDemo1 {
    private final static String URL="jdbc:mysql://localhost:3306/test?useSSL=true&useUnicode=true";
    private final static String USERNAME="root";
    private final static String PASSWOED="torey123";
    public static void main(String[] args){
        try{
            //加载数据库驱动
         Class.forName("com.mysql.jdbc.Driver");//创建Driver.class的类对象
//通过DriverManager类getConnection方法获取连接对象
            /**
             *第一个参数代表连接数据库的指定路径（死记）
             * jdbc:mysql://数据库服务器的IP地址/主机名称：端口号/数据库名称？参数配置
             * jdbc:oracle:thin:@ip地址/主机名称：端口号：数据库名称
             * 第二个参数代表是连接数据库的用户名
             * 第三个参数代表是连接数据库的密码
             */
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWOED);
            //通过连接对象创建编译对象
            Statement statement = connection.createStatement();
            //定义一条SQL语句
            String querySql = "select * from tb_emp limit 10";
            //通过编译对象执行SQL语句，并接收返回结果
            ResultSet resultSet =  statement.executeQuery(querySql);
            //判断对象是否为空
            if (resultSet != null) {
                //提取数据
                //注意：当通过结果集提取数据的时候，连接不能断开
                while (resultSet.next()) {
                    //获取当前提取行的数据
                    //通过列索引,注：列索引是从1开始的
                    int anInt = resultSet.getInt(1);
                    Object object = resultSet.getObject(3);
                    String string = resultSet.getString(6);
                    //通过列名获取
                    Object emp_name = resultSet.getObject("emp_name");
                    System.out.println(anInt + "-----------" + emp_name + "----------" + object + "-----------"+string);
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
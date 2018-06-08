package JdbcTest.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo2 {
    private final static String URL = "jdbc:mysql://localhost:3306/test?useSSL=true&useunicode=true";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "torey123";

    public static void main(String[] args) {
        try {
            //加载mysql直连驱动
            Class.forName("com.mysql.jdbc.Driver");
            insertTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insertTest(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate("INSERT INTO `tb_emp` VALUES (11,'aa1','男',2,855,'aa@qq.com')");
            System.out.println(row > 0 ? "成功" : "失败");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
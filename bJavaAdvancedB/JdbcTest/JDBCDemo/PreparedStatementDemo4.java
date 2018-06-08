package JdbcTest.JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementDemo4 {
    private final static String URL = "jdbc:mysql://localhost:3306/test?useSSL=true&useunicode=true";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "torey123";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
String account = "admin'#";
     //   String account = "admin";
        String password = "1234";
        try{
            conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String sql= "select login_id from t_login "
                    + "where login_account=? and login_pass=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,account);
            pst.setString(2,password);
            rs=pst.executeQuery();
            System.out.println(rs != null && rs.next() ? "登录成功" : "登陆失败");
        }catch (Exception ex){
ex.printStackTrace();
        }finally {
            try {
                rs.close();
                pst.close();
                if (!conn.isClosed()) {
                    conn.close();
                    conn=null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}

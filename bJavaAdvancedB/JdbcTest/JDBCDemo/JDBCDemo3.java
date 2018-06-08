package JdbcTest.JDBCDemo;

import java.sql.*;

/**
 * sql注入问题的演示
 */
public class JDBCDemo3 {
    private final static String URL = "jdbc:mysql://localhost:3306/test?useSSL=true&useunicode=true";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "torey123";
static {
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
    public static void main(String[] args) {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        String account2 = "admin'#";
        //String account = "admin'#";
        String password="123456";
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st=conn.createStatement();
            String sql="select * from t_login where login_account='" + account2 + "' and login_pass='" + password + "'";
            System.out.println(sql);
            rs = st.executeQuery(sql);

            System.out.println(rs != null && rs.next() ? "登录成功" : "登录失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            //释放操作资源
            try {
                rs.close();
                st.close();
                if(!conn.isClosed()){
                    conn.close();
                    conn=null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}

package cMyORM.bJdbcUtil;

import cMyORM.bJdbcUtil.enums.DriverInfoEnum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * 封装DML操作思路：insert,update,delete 操作都是用executeUpdate方法，并且返回操作受影响的行数
 * 把DML操作的语句提取为一个方法来实现public static int executeUpdate(String sql,Object...
 * parameters){//获取连接 //定义执行DML语句 //创建预编译对象 //设置参数 //需要通过编译对象执行SQL语句//释放资源}
 * 1 获取连接数据不确定？(MySql,Oracle...)
 */
public class JDBCUtils {
    static {//加载驱动操作
        try {
            Class.forName(DriverInfoEnum.DRIVER_CLASS.getInfo());
        } catch (Exception ex) {
        }
    }

    /**
     * 定义获取数据库连接的方法
     */
    private final static Connection getConnection() {
        Connection conn = null;
        try {
            //通过DriverManager获取连接对象
            System.out.println(DriverInfoEnum.URL.getInfo());
            System.out.println(DriverInfoEnum.USERNAME.getInfo());
            System.out.println(DriverInfoEnum.PASSWORD.getInfo());
            conn = DriverManager.getConnection(DriverInfoEnum.URL.getInfo(), DriverInfoEnum.USERNAME.getInfo(), DriverInfoEnum.PASSWORD.getInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 定义根据占位符的SQL语句定义设置编译对象参数的方法
     *
     * @param pst
     * @param paramters
     */
    private final static void setParameters(PreparedStatement pst, Object... paramters) {
        try {
            if (paramters.length > 0) {
                for (int i = 0; i < paramters.length; i++) {
                    pst.setObject(i + 1, paramters[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行简单SQL的DML(INSERT,UPDATE,DELETE)操作
     * @param sql 传入的DML语句
     * @param parametes DML语句中占位符对应参数列表
     * @return  返回受影响的行数
     */
    public final static int executeUpdate(String sql, Object... parametes) {
        int row = 0;
        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql);) {
            System.out.println("JDBCUtils_parametes,Set前: "+parametes);
            System.out.println("JDBCUtils_sql语句为：" + sql);
            setParameters(preparedStatement, parametes);
            row = preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }
}

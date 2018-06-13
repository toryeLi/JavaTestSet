package cMyORM.cJdbcUtilAnnotion;

import cMyORM.cJdbcUtilAnnotion.exception.MyOrmException;
import com.enums.DriverInfoEnum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public final class JDBCUtils  {
    public static Connection getConnection() throws Exception{
        Connection conn=null;
        try {

            conn=  DriverManager.getConnection(DriverInfoEnum.URL.getInfo(),DriverInfoEnum.USERNAME.getInfo(),DriverInfoEnum.PASSWORD.getInfo());
        } catch (Exception e) {
            new MyOrmException("获取连接时报错，错误信息是："+e.getMessage());
        }
        return conn;
    }
    /**
     * 定义根据占位符的SQL语句定义设置编译对象参数的方法
     * @param preparedStatement
     * @param prope
     */
    public static void setPrepareMete(PreparedStatement preparedStatement ,Object... prope) throws Exception{
        try{
        if (prope.length>0) {
            for (int i = 0; i < prope.length; i++) {
                preparedStatement.setObject(i+1,prope[i]);
            }
        }}catch (Exception ex){
         new MyOrmException("setPrepareMete报错，错误信息"+ex.getMessage());
        }
    }
    public static Integer executeUpdate1(String sql,Object... prope){
        int row=0;
        try{
            Connection conn=getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            setPrepareMete(preparedStatement,prope);
            row = preparedStatement.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return row;
    }
}

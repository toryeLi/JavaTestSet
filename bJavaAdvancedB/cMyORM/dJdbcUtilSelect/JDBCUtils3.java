package cMyORM.dJdbcUtilSelect;

import com.constant.DriverInfoEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装DML操作思路： insert,update,delete 操作都是用executeUpdate方法，并且返回操作受影响下行数
  * 把DML操作的语句提取为一个方法来实现 public static int executeUpdate(String sql, Object...
  * parameters) { // 获取连接 // 定义执行DML语句 // 创建预编译对象 // 设置参数 // 需要通过编译对象执行SQL语句 //
  * 释放资源 }
  *
  * @author Administrator 1、获取连接数据不确定? (MySql, Oracle,.....)->
  *         把数据连接想过信息配置一个properties文件中
 */
public class JDBCUtils3 {
    static {
        try{//加载驱动操作
            Class.forName(DriverInfoEnum.DRIVER_CLASS.getInfo());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 定义一个获取数据库连接的方法
     * @return
     */
    public final static Connection getConnection(){
        Connection conn=null;
        try{
            conn=DriverManager.getConnection(DriverInfoEnum.URL.getInfo(),DriverInfoEnum.USERNAME.getInfo(),DriverInfoEnum.PASSWORD.getInfo());
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 定义根据占位符的SQL语句定义设置编译对象参数的方法
     */
    private final static void setParameters(PreparedStatement pst, Object...parameters) {
        try {
            if (parameters.length > 0 ) {
                for (int i = 0; i< parameters.length; i++) {
                    System.out.println("JDBCUtils3_setParmeters:"+parameters[i]);
                    pst.setObject(i + 1, parameters[i]);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 执行简单SQL的DML(INSERT,UPDATE,DELETE)操作
     *
     * @param sql
     *            调用处传入的DML语句
     * @param parameters
     *            DML语句中占位符对应参数列表
     * @return 返回操作受影响行数
     */
    public final static int executeUpdate(String sql, Object... parameters) {
        // 定义操作数据受影响行数
        int row = 0;
        try (
                Connection conn = getConnection();
                PreparedStatement pst = conn.prepareStatement(sql);
        ) {
            System.out.println("SQL="+sql);
            // 设置参数
            setParameters(pst, parameters);
            // 通过编译对象执行SQL命令
            row = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    /**
     * 构建查询的通用方法
     * @param sql
     * @param parameters
     * @return 把表中没条数据提取出，把每行数据装map集合中
     */
    public final static List<Map<String,Object>> executeQuery(String sql, Object... parameters){
        List<Map<String,Object>> table=new ArrayList<>();
        try(Connection conn=getConnection();
        PreparedStatement pst=conn.prepareStatement(sql);
        ){
          //设置参数
          setParameters(pst,parameters);
          try(ResultSet rs= pst.executeQuery();){
              if (rs != null) {
                  //获取当前查询表中的元数据
                  ResultSetMetaData rsd = rs.getMetaData();
                  //获取总的列数
                  int columnCount = rsd.getColumnCount();
                  //循环提取每一行的数据
                  while (rs.next()) {
                      //创建存储行的map集合
                      Map<String, Object> row = new HashMap<>(columnCount);
                      //提取每一行中每一个列中的数据
                      //key为当前遍历列对应列名称，value为当前列对应值
                      for (int i = 0; i < columnCount; i++) {
                          //获取当前遍历列的列名称
                          String columnName = rsd.getColumnName(i + 1);
                          //获取当前列的值
                          Object columnValue = rs.getObject(columnName);
                          //保存到列的集合
                          row.put(columnName,columnValue);
                      }
                      //把构建行存储到table集合中
                      table.add(row);
                  }
              }
          }catch (Exception ex){
              ex.printStackTrace();
          }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return table;

    }
}

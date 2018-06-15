package cMyORM.dJdbcUtilSelect.jdbc;

import cMyORM.dJdbcUtilSelect.jdbc.datasource.AbstractDataSourcePooled;
import cMyORM.dJdbcUtilSelect.jdbc.datasource.DataSourcePooled;
import cMyORM.dJdbcUtilSelect.jdbc.datasource.PooledConnection;

import java.sql.*;
import java.util.*;

public class JDBCUtils {
    private static final AbstractDataSourcePooled pooled=new DataSourcePooled();
    public final static PooledConnection getConnection(){
        return pooled.getConnection();
    }
    /**
     * 定义根据占位符的SQL语句定义设置编译对象参数的方法
     */
    private final static void setParameters(PreparedStatement pst, Object...parameters) {
        try {
            if (parameters != null) {
                if (parameters.length > 0 ) {
                    for (int i = 0; i< parameters.length; i++) {
                        pst.setObject(i + 1, parameters[i]);
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新，新增，删除操作
     * @param sql
     * @param parameters
     * @return
     */
    public final static int executeUpdate(String sql,Object... parameters){
        PooledConnection pool=null;
        PreparedStatement pst=null;
        //定义操作数据受影响行数
        int row=0;
        try{
            pool = getConnection();
            Connection connection = pool.getConnection();
            pst = connection.prepareStatement(sql);
            setParameters(pst,parameters);
            row = pst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (pst != null) {
                    pst.close();
                }
                if (pool != null) {
                    pool.close();
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return row;
    }

    /**
     * 传入查询语句，返回查询结果
     * @param sql SQL查询语句
     * @param parameters 参数
     * @return List行，Map列
     */
    public final static List<Map<String,Object>> executeQuery(String sql, Object... parameters){
        List<Map<String,Object>> tableData=new ArrayList<>();
        PooledConnection pool=null;
        PreparedStatement pst=null;
        //try{}catch (Exception ex){}
        pool=getConnection();
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            setParameters(preparedStatement,parameters);
            try(            ResultSet resultSet = preparedStatement.executeQuery();
            ){
                if (resultSet != null) {
                    //获取当前查询表中的元数据
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    //获取总的列数
                    int columnCount = metaData.getColumnCount();
                    //循环提取每一行的数据
                    while (resultSet.next()) {
                        //创建行的Map集合，key为当前遍历对应列名称，value为当前列对应的值
                        Map<String,Object> rowData=new HashMap<>(columnCount);
                        //循环列，提取每一行每一个列的值
                        for (int i = 0; i < columnCount; i++) {
                            String columnName = metaData.getColumnName(i + 1);
                            Object value = resultSet.getObject(columnName);
                            rowData.put(columnName,value);
                        }
                        //把构建行存储到table集合中
                        tableData.add(rowData);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
            if (pool != null) {
                pool.close();
            }
            if (pst != null) {
                pst.close();
            }}catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return tableData;
    }
}

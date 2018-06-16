package cMyORM.dJdbcUtilSelect.jdbc;

import cMyORM.dJdbcUtilSelect.exception.MyOrmException;
import cMyORM.dJdbcUtilSelect.jdbc.datasource.DataSourcePooledManager;
import cMyORM.dJdbcUtilSelect.jdbc.datasource.PooledConnection;
import cMyORM.dJdbcUtilSelect.transaction.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 包含事务代码的JDBCUtils类
 */
public class JDBCUtils5 implements Transaction {
    /**
     * AbstractDataSourcePooled pooled  这个是类的共享变量，
     * 共享变量会出现事务的资源竞争，会出现线程不安全的问题
     *
     */
    //private static final AbstractDataSourcePooled pooled=new DataSourcePooled();
    /**
     *ThreadLocal线程安全的原因是：内部使用map集合，map集合将当前线程为key.
     * 事务要保证在同一个线程中，所以将当前线程作为key绑定到map集合中
     */
    private static final ThreadLocal<PooledConnection> threadLocal=new ThreadLocal<>();
    public final static PooledConnection getConnection2(){
        return DataSourcePooledManager.getInstance().getConnection();  //单例，多线程安全
        //return pooled.getConnection();//多线程不安全
    }

    /**
     * 将连接对象用threadLocal绑定，保证事务是同一个线程
     * @return
     */
    public final static PooledConnection getConnection(){
        PooledConnection connection=threadLocal.get();
        if (connection == null) {
            connection=DataSourcePooledManager.getInstance().getConnection();
            //把连接池中获取的连接对象绑定到当前线程上面
            threadLocal.set(connection);
        }
        return connection;
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
            pst = pool.getConnection().prepareStatement(sql);
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
        try {
            pool=getConnection();
            Connection connection = pool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            setParameters(preparedStatement,parameters);
            try(ResultSet resultSet = preparedStatement.executeQuery();
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

    /**
     *  开启事务
     */
    @Override
    public void begin() {
        PooledConnection conn=threadLocal.get();
        if (conn != null) {
            try {
                //如果setAutoCommit(false)没有设置为false,那么每次DML操作语句都是一个事务
                //开启事务，设置jdbc中原本自动提交事务改为手动提交
                conn.getConnection().setAutoCommit(false);
                System.out.println("事务开启");
            } catch (SQLException e) {
               throw new MyOrmException("事务开启失败，失败原因是"+e.getMessage());
            }
        }else {
            System.out.println("连接对象为空，事务开启失败");
        }
    }

    /**
     * 提交事务
     */
    @Override
    public void commit() {
        PooledConnection conn=threadLocal.get();

        if (conn != null) {
            try {
                //动手提交事务
                conn.getConnection().commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                // 解除当前线程与连接对象的绑定
                threadLocal.remove();
            }
        }else {
            System.out.println("事务提交失败，连接为null");
        }
    }

    /**
     * 回滚事务
     */
    @Override
    public void rollback() {
        PooledConnection conn=threadLocal.get();
        System.out.println("回滚事务的连接对象为："+conn);
        if (conn != null) {
            try {
                //回滚事务
                conn.getConnection().rollback();
                System.out.println("回滚事务");
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                // 解除当前线程与连接对象的绑定
                threadLocal.remove();
            }
        }else {
            System.out.println("连接为nulll,事务回滚失败");
        }
    }
}

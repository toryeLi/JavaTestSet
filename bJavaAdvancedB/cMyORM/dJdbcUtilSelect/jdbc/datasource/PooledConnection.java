package cMyORM.dJdbcUtilSelect.jdbc.datasource;

import java.sql.Connection;

/**
 * 封装的连接池中连接对象
 */
public class PooledConnection {
    private Connection connection;//连接对象
    private boolean isBusy; //连接的状态 true=繁忙  false= 空闲
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public boolean isBusy() {
        return isBusy;
    }
    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public PooledConnection(Connection connection, boolean isBusy) {
        this.connection = connection;
        this.isBusy = isBusy;
    }

    /**
     * 归还连接的方法
     */
    public synchronized void close(){
        System.out.println("释放连接...");
        isBusy=false;
    }
}

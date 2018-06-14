package cMyORM.dJdbcUtilSelect.jdbc.datasource;

/**
 * 数据源的连接池处理抽象类
 * 抽象类和接口
 * 接口所有的方法都是public的方法
 * 抽象类中定义方法可以是非public的方法
 */
public abstract class AbstractDataSourcePooled {
    /**
     * 定义获取连接池中连接的方法
     * @return
     */
  public abstract PooledConnection getConnection();

    /**
     * 创建连接池中连接对象的方法
     * @param count
     */
  protected abstract void createConnection(int count);
}

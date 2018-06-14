package cMyORM.dJdbcUtilSelect.jdbc.datasource;

/**
 * 数据源连接池类
 */
public class DataSourcePooled extends AbstractDataSourcePooled {
    //////////连接池的默认属性////////////
    private int initialSize=3;//初始化连接数
    private int increaseSize=5;//连接增长数
    private int maxSize=30;//最大连接数
    private int timeOut=1000;//超时时间
    @Override
    public PooledConnection getConnection() {
        return null;
    }

    @Override
    protected void createConnection(int count) {

    }
}

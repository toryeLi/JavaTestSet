package cMyORM.dJdbcUtilSelect.jdbc.datasource;

import cMyORM.dJdbcUtilSelect.exception.MyOrmException;
import com.constant.DriverInfoEnum;
import com.constant.PoolEnum;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * 数据源连接池类
 */
public class DataSourcePooled extends AbstractDataSourcePooled {
    private int i;//用这个来测试是否有数据混乱，也就是线程安全的情况发生
    //////////连接池的默认属性////////////
    private int initialSize = 3;//初始化连接数
    private int increaseSize = 5;//连接增长数
    private int maxSize = 30;//最大连接数
    private int timeOut = 1000;//超时时间
    private Object lock = new Object();
    //线程安全的集合
    public static Vector<PooledConnection> pooledList = new Vector<>();

    /**
     * 初始化连接中连接信息的方法
     *
     * @throws MyOrmException
     */
    private void initial() throws MyOrmException {
        try{
        //读取初始化信息
        initialSize = PoolEnum.INITIAL_SIZE.getInfo() == null ? initialSize
                : Integer.parseInt(PoolEnum.INITIAL_SIZE.getInfo());
        increaseSize = PoolEnum.INCREASE_SIZE.getInfo() == null ? increaseSize
                : Integer.parseInt(PoolEnum.INCREASE_SIZE.getInfo());
        maxSize = PoolEnum.MAX_SIZE.getInfo() == null ? maxSize : Integer.parseInt(PoolEnum.MAX_SIZE.getInfo());
            timeOut = PoolEnum.TIMEOUT.getInfo() == null ? timeOut : Integer.parseInt(PoolEnum.TIMEOUT.getInfo());
        if (initialSize < 0) {
            throw new MyOrmException("初始化连接数必须大于0");
        }

        if (increaseSize < 0) {
            throw new MyOrmException("连接数增长数必须大于0");
        }

        if (maxSize < 0) {
            throw new MyOrmException("最大连接数必须大于0");
        }

        if (timeOut < 0) {
            throw new MyOrmException("连接超时时间必须大于0");
        }}catch (Exception ex){
            throw new MyOrmException("连接池初始化时失败，失败信息："+ex.getMessage());
        }
        try {
            //获取注册的驱动
            Driver driver = (Driver) Class.forName(DriverInfoEnum.DRIVER_CLASS.getInfo()).newInstance();
            //注册驱动到DriverManager对象中
            DriverManager.registerDriver(driver);
        } catch (Exception e) {
            throw new MyOrmException("加载数据库的驱动失败，信息为：" + e.getMessage());
        }
    }

    public DataSourcePooled() {
        initial();
    }
    /**
     * 是否没有被占用 且是否有效
     *
     * @return
     */
    @Override
    public PooledConnection getConnection() {
        //审核：是否没有被占用 且是否有效
        PooledConnection connection = null;
      synchronized (lock) {

            if (pooledList.size() == 0) {
                System.out.println("获取连接中连接失败，没有任何连接对象"+pooledList.size()+"开始创建连接：");
                //初始化创建连接
                createConnection(initialSize);
            }
            //审核：是否没有被占用 且是否有效
            connection = getRealConnection();
            //连接池没有空闲连接情况下，尝试30秒之后重新获取连接池中的连接
            while (connection == null) {
                //连接池内的连接没有空闲，增加连接池的连接数
                createConnection(increaseSize);
                connection = getRealConnection();
                try {
                    if (connection != null) {
                        Thread.sleep(30);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("尝试获取连接...");
            }
        }
        return connection;
    }

    /**
     * 是否没有被占用 且是否有效
     *
     * @return
     */
    private synchronized PooledConnection getRealConnection () {
        i++;
        for (PooledConnection conn : pooledList) {
            //判断池中是否有空闲的连接对象
            if (!conn.isBusy()) {
                Connection connection = conn.getConnection();
                try {
                    //发送一个指令给数据库 看是否收到回应
                    if (!connection.isValid(timeOut)) {
                        //连接失败了
                        connection = DriverManager.getConnection(DriverInfoEnum.URL.getInfo(),
                                DriverInfoEnum.USERNAME.getInfo(), DriverInfoEnum.PASSWORD.getInfo());
                        //把失败的连接补回来
                        conn.setConnection(connection);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //已经被占用了
                conn.setBusy(true);
                System.out.println("===========================" + i+"===这个数字有混乱，就证明存在线程安全的问题");
                return conn;
            }
        }
        return null;
    }
        @Override
        protected void createConnection ( int count){
            //池中的连接数+新增连接数 不能大于连接池中最大的连接数
            if (pooledList.size() + count <= maxSize) {
                for (int i = 0; i < count; i++) {
                    try {
                        Connection connection = DriverManager.getConnection(
                                DriverInfoEnum.URL.getInfo(),
                                DriverInfoEnum.USERNAME.getInfo(),
                                DriverInfoEnum.PASSWORD.getInfo());
                        PooledConnection pooledConnection = new PooledConnection(connection, false);
                        pooledList.add(pooledConnection);
                       // System.out.println("初始化" + (i + 1) + "个连接");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("createConnection_连接池内的连接数为："+pooledList.size());
            } else {
                System.out.println("创建失败，连接池中连接对象已经满了！");
            }
        }

    /**
     * GC DataSourcePooled 对象被GC回收的时候销毁其中连接池中的对象
     * @throws Throwable
     */
    protected void finalize()throws Throwable{
            pooledList.capacity();
            pooledList=null;
            super.finalize();
        }
    }

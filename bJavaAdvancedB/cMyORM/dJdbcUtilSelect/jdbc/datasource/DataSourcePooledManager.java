package cMyORM.dJdbcUtilSelect.jdbc.datasource;

/**
 * 线程池单例类，多线程百分百安全
 */
public class DataSourcePooledManager {
    private static class DataSourcePoolGet{
        public static final AbstractDataSourcePooled instance=new DataSourcePooled();
    }
    public static AbstractDataSourcePooled getInstance(){
        return DataSourcePoolGet.instance;
    }
}

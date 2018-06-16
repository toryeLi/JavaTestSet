package cMyORM.dJdbcUtilSelect.config;

/**
 * 读取属性配置文件的单例实现
 */
public class PropertiesConfiguration {
    private static class Configuration{
        private static final PropertiesPlaceHolder3 CONFIG=new PropertiesPlaceHolder3();
    }
    public static PropertiesPlaceHolder3 getInstance(){
        return Configuration.CONFIG;
    }
}

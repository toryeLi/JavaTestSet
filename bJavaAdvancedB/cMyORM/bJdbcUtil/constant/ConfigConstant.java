package cMyORM.bJdbcUtil.constant;

/**
 * 使用枚举定义常量
 */
public enum ConfigConstant {
    PROPERTIES_CONFIG_PATH("dataSource.properties");

    private final String path;

    ConfigConstant(String path) {
            this.path=path;
    }
    public String getPath(){
        return this.path;
    }
}

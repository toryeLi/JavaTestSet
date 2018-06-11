package cMyORM.aJdbcUtil.constant;

/**
 * 使用枚举定义常量
 */
public enum ConfigConstant {
    PROPERTIES_CONFIG_PATH("dataSource.properties");
private String paht;
    private ConfigConstant(String path) {
        this.paht=path;
    }
    public String getPath(){
        return this.paht;
    }
}

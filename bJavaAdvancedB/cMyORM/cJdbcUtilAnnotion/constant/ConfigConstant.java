package cMyORM.cJdbcUtilAnnotion.constant;

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

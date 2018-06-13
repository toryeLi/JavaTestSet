package cMyORM.bJdbcUtil.constant;

/**
 * 在拼接SQL是，用于排除实体类某些不需要的字段
 */
public enum  SqlConstant {
    //用于判断某个实体类是否有序列化Id
SERIALVERSION_UID("serialVersionUID");

    private final String value;

    SqlConstant(String value) {
        this.value=value;
    }
    public String getValue(){
        return this.value;
    }
}

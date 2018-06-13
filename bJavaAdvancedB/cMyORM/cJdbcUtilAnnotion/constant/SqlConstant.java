package cMyORM.cJdbcUtilAnnotion.constant;

public enum SqlConstant {
    SERIALVERSION_UID("serialVersionUID");

    private final String value;

    SqlConstant(String value) {
        this.value=value;
    }
    public String getValue(){
        return  this.value;
    }
}

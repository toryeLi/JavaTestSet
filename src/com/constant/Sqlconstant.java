package com.constant;

public enum Sqlconstant {
    SERIALVERSION_UID("serialVersionUID");

    private final String value;

    Sqlconstant(String value) {
        this.value=value;
    }
    public String getValue(){
        return this.value;
    }
}

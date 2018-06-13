package com.annotantion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表列注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Colum {
    String value();
    DataBaseType type() default DataBaseType.MYSQL;
    public enum DataBaseType{
        MYSQL,
        ORACLE
    }
}

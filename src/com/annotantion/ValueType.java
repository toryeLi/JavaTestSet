package com.annotantion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 指示该值类型属性是否参与 条件的查询，
 * 因为值类型有默认值，反射拼接sql时，只判断了！=null,但是值类型不会为null,
 * 就算用户没有给属性赋值，也会将默认值作为条件，所以用 这个注解来标注
 * 值类型是否 参与条件的运算
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValueType {
    /**
     *
     * @return true 参与运算，false  不参与运算
     */
    boolean isValue();
}

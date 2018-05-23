package aOften.cReflectEnum.bAnnotaionDemo;

import java.lang.annotation.*;

/**
 * 注解@Inteface标识
 */
@Retention(RetentionPolicy.RUNTIME)//指定作用域
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD,ElementType.PARAMETER})//指定标注的位置
public @interface MyAnnotation {
    String value() default "";//在属性上面赋值，也可称为方法的声明，如果是单个属性值可以不用写

    double version() default 1.0;//版本号
}

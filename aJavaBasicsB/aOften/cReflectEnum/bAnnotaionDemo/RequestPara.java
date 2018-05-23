package aOften.cReflectEnum.bAnnotaionDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//指定作用域
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})//指定标注的位置
public @interface RequestPara {

    String value() default "";//在属性上面赋值，也可称为方法的声明，如果是单个属性值可以不用写
    double version() default 1.0;//版本号
}

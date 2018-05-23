package aOften.cReflectEnum.bAnnotaionDemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MyAnnotation(value = "我的类", version = 1.1)
public class MyClass {
    /**
     * nama
     */
    @MyAnnotation(value = "我的字段", version = 1.2)
    public String name;
    @MyAnnotation(value = "我的方法", version = 1.3)
    public void setName(@RequestPara(value = "repeatable我的参数", version = 1.35) @MyAnnotation(value = "我的参数", version = 3.2) String name) {

    }
    public static void main(String[] args) {
        //获取类上面的注解
        System.out.println("=========获取类上的注解=========");
        //注意必须结合反射使用
        Class<?> c1 = MyClass.class;
        //获取到类上面的注解
        Annotation myAnnotation = c1.getAnnotation(MyAnnotation.class);
        System.out.println(((MyAnnotation) myAnnotation).value());
        System.out.println(((MyAnnotation) myAnnotation).version());
        System.out.println("=========获取字段上的注解=========");
        try {
            //获取字段上的注解
            Field nameField = c1.getDeclaredField("name");//"name"是字段名
            if (nameField.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation myAnnotation2 = nameField.getAnnotation(MyAnnotation.class);
                System.out.println(myAnnotation2.value());
                System.out.println(myAnnotation2.version());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println("=========获取方法上的注解=========");
        try {
            //获取一个方法
            Method nameMethod = c1.getDeclaredMethod("setName",String.class);
            MyAnnotation annotation = nameMethod.getAnnotation(MyAnnotation.class);
            //判断是否有MyAnnotation方法
            if (annotation != null) {
                System.out.println(annotation.value());
                System.out.println(annotation.version());
            }
            System.out.println("=========获取方法参数上的注解=========");
            Annotation[][] paramterArr= nameMethod.getParameterAnnotations();
            for (Annotation[] paramterAnn : paramterArr) {
                for (Annotation annotation1 : paramterAnn) {
                    if(annotation1 instanceof  MyAnnotation){
                      MyAnnotation paramterAnnotation=(MyAnnotation)annotation1;
                        System.out.println(paramterAnnotation.value());
                        System.out.println(paramterAnnotation.version());
                    }
                    if(annotation1 instanceof  RequestPara){
                        RequestPara requestPara=(RequestPara)annotation1;
                        System.out.println(requestPara.value());
                        System.out.println(requestPara.version());
                    }
                }

            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}

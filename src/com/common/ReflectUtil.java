package com.common;

import com.annotantion.Colum;
import com.annotantion.Table;
import com.constant.Sqlconstant;

import java.lang.reflect.Field;

public class ReflectUtil {
    /**
     * 获取映射的表名称
     * @param clazz
     * @return
     */
    public static String getClassMappingName(Class<?> clazz) {
        // 表名称默认为类名称
        String tableName = clazz.getSimpleName().toUpperCase();

        // 判断该类上面是否存在@Table注解
        Table table = clazz.getAnnotation(Table.class);

        if (table != null) {
            // 获取到映射表名称
            tableName = table.value().trim().toUpperCase();
        }

        return tableName;
    }

    /**
     * 获取属性映射字段名称
     */
    public static String getFieldMappingName(Field field) {
        // 获取所有的字段名称默认就是属性名称
        String fieldName = field.getName().toUpperCase();

        // 判断是否存在Column注解配置
        Colum column = field.getAnnotation(Colum.class);

        if (column != null) {
            fieldName = column.value().trim().toUpperCase();
        }

        return fieldName;
    }

    /**
     * 排序序列号UID
     */
    public static boolean excludeUID(String columnName) {
        return Sqlconstant.SERIALVERSION_UID.getValue().equalsIgnoreCase(columnName);
    }
}

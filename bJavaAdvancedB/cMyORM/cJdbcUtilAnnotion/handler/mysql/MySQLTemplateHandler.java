package cMyORM.cJdbcUtilAnnotion.handler.mysql;

import cMyORM.cJdbcUtilAnnotion.JDBCUtils;
import cMyORM.cJdbcUtilAnnotion.common.ArrayUtils;
import cMyORM.cJdbcUtilAnnotion.constant.SqlConstant;
import cMyORM.cJdbcUtilAnnotion.exception.MyOrmException;
import cMyORM.cJdbcUtilAnnotion.handler.HandlerTemplate;
import com.annotantion.Colum;
import com.annotantion.PK;
import com.annotantion.Table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MySQLTemplateHandler extends HandlerTemplate {
    @Override
    public <T> void save(T entity) throws MyOrmException {
        // 构建一个与SQL语句占位符对应参数列表
        List<Object> parameterList=null;
        StringBuffer stringBuffer = new StringBuffer();
        Class<?> aClass = entity.getClass();
        String tableName=ReflectUtil.getClassMappingName(aClass);
        //拼接SQL语句
        stringBuffer.append("INSERT INTO ").append(tableName).append("(");
        Field[] fields = aClass.getDeclaredFields();
        if (fields != null&&fields.length>0) {
            parameterList=new ArrayList<Object>();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                String fieldName = field.getName();
                if (SqlConstant.SERIALVERSION_UID.getValue().equalsIgnoreCase(fieldName)) {
                    continue;
                }
                PK pk = field.getAnnotation(PK.class);
                if (pk != null) {
                    continue;
                }
                //开启私有字段访问权限
                field.setAccessible(true);
                try{
                    Object value = field.get(entity);
                    if (value != null) {
                        fieldName= ReflectUtil.getColumnMapingName(field);
                        stringBuffer.append(fieldName).append(",");
                        parameterList.add(value);
                    }
                }catch (Exception ex){
                    throw new MyOrmException("获取到持久对象的字段值的时候出现" +
                            "异常，信息为："+ex.getMessage());
               }
            }
            stringBuffer.deleteCharAt(stringBuffer.length()-1).append(") VALUES (");
            for (int i = 0; i < parameterList.size(); i++) {
                stringBuffer.append("?,");
            }
            stringBuffer.deleteCharAt(stringBuffer.length()-1).append(")");
            System.out.println(stringBuffer);
            JDBCUtils.executeUpdate1(stringBuffer.toString(),parameterList.toArray());
        }
    }



    /**
     * 实现对象的删除操作
     * delete from 表名 where 主键=？
     * @param entity
     * @param <T>
     * @return
     * @throws MyOrmException
     */
    @Override
    public <T> int delete(T entity) throws MyOrmException {
        try{
        Class<?> aClass = entity.getClass();
        Field[] fields = aClass.getDeclaredFields();
        if (ArrayUtils.isNotEmpty(fields)) {
            StringBuilder stringBuilder = new StringBuilder();
            String tableName=ReflectUtil.getClassMappingName(aClass);
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                PK pk = fields[i].getAnnotation(PK.class);
                if (pk != null) {
                    Object value = fields[i].get(entity);
                    if (value != null) {
                        String pkColumName=ReflectUtil.getColumnMapingName(fields[i]);
                        stringBuilder.append("DELETE FROM ").append(tableName)
                                .append(" WHERE ").append(pkColumName).append("=?");
                        Integer integer = JDBCUtils.executeUpdate1(stringBuilder.toString(), value);
                        System.out.println(integer > 0 ? "删除成功" : "删除失败");
                        break;
                    }
                }
            }
        }}catch (Exception ex){
            new MyOrmException("删除时出现异常，异常信息为："+ex.getMessage());
        }
        return 0;
    }

    private static class ReflectUtil{
        /**
         * 获取映射的表名称
         * @param clazz
         * @return
         */
       public static String getClassMappingName(Class<?> clazz){
           String tableName = clazz.getSimpleName();
           Table table = clazz.getAnnotation(Table.class);
           if (table != null) {
               tableName=table.value();
           }
           return tableName;
       }

        /**
         * 获取映射的属性名称
         * @param field
         * @return
         */
       public static String getColumnMapingName(Field field){
           String fieldName = field.getName().toUpperCase();
           Colum annotation = field.getAnnotation(Colum.class);
           if (annotation != null) {
               fieldName=annotation.value().trim().toUpperCase();
           }
           return fieldName;
       }
    }
}

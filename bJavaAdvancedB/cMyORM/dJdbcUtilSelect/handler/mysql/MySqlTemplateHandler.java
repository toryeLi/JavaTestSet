package cMyORM.dJdbcUtilSelect.handler.mysql;

import cMyORM.dJdbcUtilSelect.builder.SqlBuilder;
import cMyORM.dJdbcUtilSelect.exception.MyOrmException;
import cMyORM.dJdbcUtilSelect.handler.HandlerTemplate;
import cMyORM.dJdbcUtilSelect.jdbc.JDBCUtils;
import com.annotantion.Colum;
import com.annotantion.PK;
import com.annotantion.Table;
import com.common.ArrayUtils;
import com.constant.ConfigConstant;
import com.constant.Sqlconstant;
import com.enums.SearchMode;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;


/**
 * mysql 数据操作实现类
 */
public class MySqlTemplateHandler extends HandlerTemplate {
    @Override
    public <T> void save(T entity) throws MyOrmException {
        //构建一个与SQL语句占位符对应参数列表
        List<Object> parameterList = null;
        StringBuffer sqlBuilder = new StringBuffer();
        Class<?> aClass = entity.getClass();
        String tableName = aClass.getSimpleName().toUpperCase();
        Table table = aClass.getAnnotation(Table.class);
        if (table != null) {
            tableName = table.value().trim().toUpperCase();
        }
        //拼接SQL语句
        sqlBuilder.append("INSERT INTO ").append(tableName).append("(");
        Field[] fields = aClass.getDeclaredFields();

        if (fields != null && fields.length > 0) {
            // 实例化用于保存参数列表的集合
            parameterList = new ArrayList<Object>();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                // 获取所有的字段名称默认就是属性名称
                String fieldName = field.getName().toUpperCase();

                if ("serialVersionUID".equalsIgnoreCase(fieldName)) {
                    continue;
                }
                // 判断是否存在Column注解配置
                Colum column = field.getAnnotation(Colum.class);

                if (column != null) {
                    fieldName = column.value().trim().toUpperCase();
                }
                // 判断是否为序列化名称
                if (ConfigConstant.PROPERTIES_CONFIG_PATH.getPath().equals(fieldName)) {
                    continue;
                }
                // 开启私有字段访问权限
                field.setAccessible(true);
                try {
                    //通过反射 获取当前字段对应值
                    Object value = field.get(entity);
                    // 判断value是否为空
                    if (null != value) {
                        // 追加SQL需要字段
                        sqlBuilder.append(fieldName).append(",");
                        // 添加当前字段对应值到集合
                        parameterList.add(value);
                    }
                } catch (Exception e) {
                    throw new MyOrmException("获取到持久对象的字段值的时候出现异常,信息为:" + e.getMessage());
                }
            }
            // 出掉最后一个逗号
            sqlBuilder.deleteCharAt(sqlBuilder.length() - 1)
                    .append(")").append(" VALUES").append(" (");

            // 拼接问号
            for (int i = 0; i < parameterList.size(); i++) {
                sqlBuilder.append("?").append(",");
            }

            sqlBuilder.deleteCharAt(sqlBuilder.length() - 1).append(")");

        }
        // 调用执行数据库数据持久化的工具方法
        JDBCUtils.executeUpdate(sqlBuilder.toString(), parameterList.toArray());

    }

    /**
     * 根据主键删除
     *
     * @param entity
     * @param <T>
     * @return
     * @throws MyOrmException
     */
    @Override
    public <T> int delete(T entity) throws MyOrmException {
        // 定义存储主键值得对象
        Object pkValue = null;
        // 创建构建SQL语句的StringBuffer对象
        StringBuffer sqlBuilder = new StringBuffer();

        Class<?> clazz = entity.getClass();
        // 获取表名
        String tableName = ReflectUtil.getClassMappingName(clazz);
        sqlBuilder.append("DELETE FROM ").append(tableName);
        // 获取类中所有定义的字段
        Field[] fields = clazz.getDeclaredFields();
        try {
            if (ArrayUtils.isNotEmpty(fields)) {
                // 获取属性映射的字段名称
                String fieldName = null;
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];

                    PK pk = field.getAnnotation(PK.class);
                    // 判断是否是主键
                    if (pk != null) {
                        // 获取属性映射的字段名称
                        fieldName = ReflectUtil.getFieldMappingName(field);
                        // 追加条件
                        sqlBuilder.append(" WHERE ").append(fieldName).append("=?");
                        // 获取这个字段对应值
                        field.setAccessible(true);
                        pkValue = field.get(entity);
                        break;
                    }
                }
                if (fieldName == null) {
                    throw new MyOrmException("操作的对象未指定主键字段");
                }
                if (pkValue == null) {
                    throw new MyOrmException("操作的对象未指定主键字段的值");
                }
            }
        } catch (Exception e) {
            throw new MyOrmException("通过主键删除对象的时候出现异常,信息为:" + e.getMessage());
        }
        return JDBCUtils.executeUpdate(sqlBuilder.toString(), pkValue);
    }

    /**
     * 根据用户指定的添加删除信息
     * DELETE FROM 表名 WHERE 条件[条件1 and 条件2 and 条件3... ]
     *
     * @param clazz     删除对象对应的Class对象
     * @param condition 删除的条件
     * @param <T>
     * @return
     * @throws MyOrmException
     */
    @Override
    public <T> int delete(Class<T> clazz, T condition) throws MyOrmException {
        // 创建构建SQL语句的StringBuffer对象
        StringBuffer sqlBuilder = new StringBuffer();
        //创建一个集合用于接收问号占位符对应值
        List<Object> parameters = null;
        //接收接受处理好的SQL语句
        String sql = null;
        //获取表名称
        String classMappingName = ReflectUtil.getClassMappingName(clazz);
        sqlBuilder.append("DELETE FROM ").append(classMappingName);
        //处理条件
        try {
            if (condition != null) {
                parameters = new ArrayList<Object>();
                sqlBuilder.append(" WHERE ");
                Field[] fields = clazz.getDeclaredFields();
                if (ArrayUtils.isNotEmpty(fields)) {
                    for (int i = 0; i < fields.length; i++) {
                        Field field = fields[i];
                        String columName = ReflectUtil.getFieldMappingName(field);
                        if (Sqlconstant.SERIALVERSION_UID.getValue().equalsIgnoreCase(columName)) {
                            continue;
                        }
                        //设置访问权限
                        field.setAccessible(true);
                        //获取字段的值
                        Object value = field.get(condition);
                        if (value != null) {
                            sqlBuilder.append(columName).append("=? AND ");
                            parameters.add(value);
                        }
                    }
                    sql = sqlBuilder.substring(0, sqlBuilder.lastIndexOf(" AND"));
                }

            }
        } catch (Exception e) {
            throw new MyOrmException("添加删除添加的时候出现异常，异常信息为：" + e.getMessage(), e);
        }
        return JDBCUtils.executeUpdate(sql, parameters.toArray());
    }

    /**
     * 根据主键修改字段
     * update 表  set 字段1 = ?,字段 = ？,............ where 主键
     *
     * @param entity
     * @param <T>
     * @return
     * @throws MyOrmException
     */
    @Override
    public <T> int update(T entity) throws MyOrmException {
        try {
            List<Object> parameters = new ArrayList<>();
            Class<?> aClass = entity.getClass();
            String tableName = ReflectUtil.getClassMappingName(aClass);
            Field[] fields = aClass.getDeclaredFields();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("UPDATE ").append(tableName).append(" SET ");
            String pkName = null;
            Object pkValue = null;
            boolean bo = false;
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                PK pk = field.getAnnotation(PK.class);
                field.setAccessible(true);
                Object value = field.get(entity);
                if (value != null) {
                    if (pk != null) {
                        pkValue = value;
                        pkName = ReflectUtil.getFieldMappingName(field);
                        bo = true;
                    }
                    stringBuffer.append(ReflectUtil.getFieldMappingName(field)).append("=?,");
                    parameters.add(value);
                }
            }
            if (bo) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1).append(" WHERE ").append(pkName).append("=?");
                parameters.add(pkValue);
                String sqlStr = stringBuffer.toString();
                return JDBCUtils.executeUpdate(sqlStr, parameters.toArray());
            } else {
                System.out.println("主键值为null,没有更新任何数据");
            }
        } catch (Exception ex) {
            new MyOrmException("更新数据方法报错,报错信息为：" + ex.getMessage());
        }
        return 0;
    }

    /**
     * 根据用户指定条件修改指定字段
     * update 表  set 字段1 = ?,字段 = ？,............ where 条件1 and 条件2 and 条件
     *
     * @param entity    要修改的的字段，也就是 set 字段1 = ?,字段 = ？
     * @param condition 修改的条件，也就是  where 条件1 and 条件2 and 条件
     * @param <T>       实体类型
     * @return 0更新失败，>0更新成功
     * @throws MyOrmException
     */
    @Override
    public <T> int update(T entity, T condition) throws MyOrmException {
        StringBuilder sqlBuilder = new StringBuilder();
        //创建一个集合用于接受问号占位符对应值
        List<Object> parmeters = new ArrayList<>();
        try{
        hanlderUpdateField(entity,parmeters,sqlBuilder);
        hanlderWhere(condition,parmeters,sqlBuilder);
           // SqlBuilder.proccessQuerySQLForCondition(entity.getClass(),);
        }catch (Exception ex){
            throw new MyOrmException("添加更新条件的时候出现异常，异常信息为："+ex.getMessage());
        }

        return JDBCUtils.executeUpdate(sqlBuilder.toString(),parmeters.toArray());
    }

    /**
     * 返回UPDATE语句，不带条件
     *update 表  set 字段1 = ?,字段 = ？
     * @param entity 更新的实体值
     * @param parameters 返回更新的值（parameters)
     * @param sqlBuilder 返回UPDATE语句，不带条件
     * @param <T>
     */
    private <T> void hanlderUpdateField(T entity, List<Object> parameters, StringBuilder sqlBuilder) {
        try {
            Class<?> aClass = entity.getClass();
            String tableName = ReflectUtil.getClassMappingName(aClass);
            Field[] fields = aClass.getDeclaredFields();
            sqlBuilder.append("UPDATE ").append(tableName).append(" SET ");
            String pkName = null;
            Object pkValue = null;
            boolean bo = false;
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                PK pk = field.getAnnotation(PK.class);
                if (pk != null) {
                    continue;
                }
                if (ReflectUtil.excludeUID(field.getName())) {
                    continue;
                }
                field.setAccessible(true);
                Object value = field.get(entity);
                if (value != null) {
                    sqlBuilder.append(ReflectUtil.getFieldMappingName(field)).append("=?,");
                    parameters.add(value);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        sqlBuilder.deleteCharAt(sqlBuilder.length()-1);
    }

    /**
     *  处理条件的SQL语句
     *  where 条件1 and 条件2 and 条件
     * @param entity 条件实体
     * @param parameters 条件的值
     * @param sqlWhere 拼接的where条件语句
     * @param <T>
     */
    private <T> void hanlderWhere(T entity, List<Object> parameters, StringBuilder sqlWhere) {
        try {
            Class<?> aClass = entity.getClass();
            Field[] fields = aClass.getDeclaredFields();
            sqlWhere.append(" WHERE ");
            if (ArrayUtils.isNotEmpty(fields)) {
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    String fileName = ReflectUtil.getFieldMappingName(field);
                    if(ReflectUtil.excludeUID(fileName)){
                        continue;
                    }
                    //主键字段不设为条件
                    PK pk = field.getAnnotation(PK.class);
                    if (pk != null) {
                        continue;
                    }
                    field.setAccessible(true);
                    Object value = field.get(entity);
                    if (value != null) {
                        sqlWhere.append(ReflectUtil.getFieldMappingName(field)).append("=? AND ");
                        parameters.add(value);
                    }
                }
                sqlWhere.delete(sqlWhere.lastIndexOf(" AND ")+1,sqlWhere.length()-1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * 查询表中所有字段信息
     * @param clazz 要查询的表
     * @param <T>
     * @return
     * @throws MyOrmException
     */
    public <T> List<T> queryForList(Class<T> clazz)throws MyOrmException{
        List<T> list = new ArrayList<>();
        String sql=SqlBuilder.proccesQuerySQL(clazz);
        //调用查询方法
        List<Map<String, Object>> query = JDBCUtils.executeQuery(sql);
        //判断是否为空
        if (ArrayUtils.isNotEmpty(query.toArray())) {
            for (int i = 0; i < query.size(); i++) {
                T instance=null;
                try{
                    //创建一个对象的实例
                    instance=clazz.newInstance();
                }catch (Exception e){
                    throw new MyOrmException(clazz.getSimpleName()+"实例化对" +
                            "象失败，实例化类中未提供空的构造函数");
                }
                //获取一个集合，一行可以看出一个对象实例
                Map<String, Object> row = query.get(i);
                //获取到所有的key值
                Set<String> keySet = row.keySet();
                //获取类中所有的字段
                Field[] fields = clazz.getDeclaredFields();
                if (ArrayUtils.isNotEmpty(fields)) {
                    for (int j = 0; j < fields.length; j++) {
                        Field field=fields[j];
                        String columnName = ReflectUtil.getFieldMappingName(field);
                        for (String key : keySet) {
                            //判断map中的key是否与当前操作的列名称匹配
                            if (key.equalsIgnoreCase(columnName)) {
                                Object columnValue = row.get(key);
                                //开启字段访问权限
                                field.setAccessible(true);
                                try{
                               // Class<?> fieldTypeClass = field.getType();
//                                if (fieldTypeClass==Double.class) {
//                                    BigDecimal value=(BigDecimal) columnValue;
//                                    field.set(instance,value.doubleValue());
//                                    break;
//                                }
                                //设置字段的值
                                    field.set(instance,columnValue);
                                }catch (Exception ex){
                                    throw  new MyOrmException("字段："+field.getName()+";类型为："+field.getType()+";需要装入的值为："+columnValue+"字段设置值得时候出现异常信息为:"+ex.getMessage());
                                }
                            }
                        }
                    }
                }
                //把处理好的对象存储到集合中
                list.add(instance);
            }
        }
        return list;
    }
    @Override
    public <T> List<T> queryForList(Class<T> clazz, T condition, SearchMode mode) throws MyOrmException {
        // 定义返回封装的对象集合
        List<T> list = new ArrayList<T>();

        // 定义一个存储参数的集合对象
        List<Object> parameters = new ArrayList<Object>();

        String sql = SqlBuilder.proccessQuerySQLForCondition(clazz, condition, parameters, mode);
        // 调用查询方法
        List<Map<String, Object>> query = JDBCUtils.executeQuery(sql, parameters.toArray());
        //判断是否为空
        if (ArrayUtils.isNotEmpty(query.toArray())) {
            for (int i = 0; i < query.size(); i++) {
                T instance = null;
                try {
                    // 创建一个对象的实例
                    instance = clazz.newInstance();
                } catch (Exception e) {
                    throw new MyOrmException(clazz.getSimpleName()+"实例化对象失败，实例化类中为提供空构造函数");
                }
                // 获取一行集合
                Map<String, Object> row = query.get(i);
                // 获取到所有的key值
                Set<String> keySet = row.keySet();
                // 获取类中所的字段
                Field[] fields = clazz.getDeclaredFields();
                if (ArrayUtils.isNotEmpty(fields)) {
                    for (int j = 0; j< fields.length; j++) {
                        Field field = fields[j];
                        String columnName = ReflectUtil.getFieldMappingName(field);
                        for (String key : keySet) {
                            // 判断map中的key是否与当前操作的列名称匹配
                            if (key.equalsIgnoreCase(columnName)) {
                                Object columnValue = row.get(key);
                                // 开字段访问权限
                                field.setAccessible(true);
                                try {
                                    // 判断字段类型
                                    Class<?> fieldTypeClass = field.getType();
                                    if (fieldTypeClass == Double.class) {
                                        BigDecimal value = (BigDecimal) columnValue;
                                        field.set(instance, value.doubleValue());
                                        break;
                                    }
                                    // 设置字段的值
                                    field.set(instance, columnValue);
                                } catch (Exception e) {
                                    throw new MyOrmException(field.getName()+"字段设置值得时候出现异常信息为:"+e.getMessage());
                                }
                                break;
                            }
                        }
                    }
                }
                // 把处理好的对象存储到集合中
                list.add(instance);
            }
        }

        return list;
    }
    @Override
    public <T> List<T> queryForList(Class<T> clazz, T entity) throws MyOrmException {
        return queryForList(clazz, entity, SearchMode.EQ);
    }
    private static class ReflectUtil {
        /**
         * 获取映射的表名称
         *
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
        static String getFieldMappingName(Field field) {
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

}

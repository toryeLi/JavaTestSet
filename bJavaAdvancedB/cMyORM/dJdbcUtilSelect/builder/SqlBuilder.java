package cMyORM.dJdbcUtilSelect.builder;

import cMyORM.dJdbcUtilSelect.exception.MyOrmException;
import com.common.ArrayUtils;
import com.common.ReflectUtil;
import com.constant.SearchMode;

import java.lang.reflect.Field;
import java.util.List;

public class SqlBuilder {
    /**
     * 构建查询表中所有字段的SQL语句
     * @param clazz
     * @return
     */
    public static String proccesQuerySQL(Class<?> clazz){
        StringBuffer sqlBuilder = new StringBuffer();
        // 获取表名
        String tableName = ReflectUtil.getClassMappingName(clazz);
        sqlBuilder.append("SELECT ");
        Field[] fields = clazz.getDeclaredFields();
        if (ArrayUtils.isNotEmpty(fields)) {
            for (int i = 0; i< fields.length; i++) {
                Field field = fields[i];
                String columnName = ReflectUtil.getFieldMappingName(field);
                // 排除序列化字段
                if (ReflectUtil.excludeUID(columnName)) {
                    continue;
                }
                sqlBuilder.append(columnName).append(",");
            }

            sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
        }
        sqlBuilder.append(" FROM ").append(tableName);

       // System.out.println(sqlBuilder);
        return sqlBuilder.toString();
    }

    /**
     * 构建一条带条件的SQL语句,注意：1 排除主键 为条件  2 如果属性为值类型，请给该属性
     * @param clazz
     * @param condition
     * @param parameters
     * @param mode
     * @param <T>
     * @return
     * @throws MyOrmException
     */
    public static <T> String proccessQuerySQLForCondition(
            Class<T> clazz,
            T condition,
            List<Object> parameters,
            SearchMode mode
    )throws MyOrmException {
        StringBuilder sqlBuilder=new StringBuilder();
        sqlBuilder.append(proccesQuerySQL(clazz));
        //获取条件对象的Class对象
        Class<?> conditionClass = condition.getClass();
        //获取所有的字段
        Field[] fields = conditionClass.getDeclaredFields();
        if (ArrayUtils.isNotEmpty(fields)) {
            //追加WHERE条件
            sqlBuilder.append(" WHERE ");
            for (int i = 0; i < fields.length; i++) {
                Field field=fields[i];
                String columnName = ReflectUtil.getFieldMappingName(field);
                if (ReflectUtil.excludeUID(columnName)) {
                    continue;
                }
                field.setAccessible(true);
                try{
                    //获取字段的值
                    Object value = field.get(condition);
                    if (value != null) {
                        //追加字段
                        sqlBuilder.append(columnName).append(patternMode(mode)).
                                append("?").append(" AND ");
                        //添加参数
                        parameters.add(value);
                    }
                }catch (Exception ex){
                    throw new MyOrmException("获取"+field.getName()+"的值出现异常，异常信息："+ex.getMessage());
                }
            }
            sqlBuilder.delete(sqlBuilder.lastIndexOf(" AND "),sqlBuilder.length()-1);
        }
        System.out.println(SqlBuilder.class.getName()+":" +sqlBuilder.toString());
        return sqlBuilder.toString().trim();
    }
public static <T> String proccessQuerySQLForPK(Class<T> tClass){
        return null;
}
    private static String patternMode(SearchMode mode){
        String patternChar=null;
        switch (mode){
            case EQ:patternChar=" = ";break;
            case NE:patternChar=" != ";break;
            case LT:patternChar=" < ";break;
            case GT:patternChar=" > ";break;
            case LE:patternChar=" <= ";break;
            case GE:patternChar=" >= ";break;
            case LIKE:patternChar=" LIKE ";break;
        }
        return patternChar;
    }
}


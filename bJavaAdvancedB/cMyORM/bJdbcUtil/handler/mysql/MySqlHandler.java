package cMyORM.bJdbcUtil.handler.mysql;

import cMyORM.bJdbcUtil.JDBCUtils;
import cMyORM.bJdbcUtil.constant.SqlConstant;
import cMyORM.bJdbcUtil.handler.HandlerTemplate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MySqlHandler extends HandlerTemplate {

    @Override
    public <T> void save(T entiey) {
        //构建一个与SQL语句占位符对应参数列表
        List<Object> parameterList=null;
        //创建可变字符串对象
        StringBuffer sqlStringBuffer = new StringBuffer();
        //获取操作对象的Class对象
        Class<?> aClass = entiey.getClass();
        //表名称默认为类名称
        String tableName = aClass.getSimpleName();
        //拼接SQL语句
        sqlStringBuffer.append("INSERT INTO ").append(tableName).append("(");
        //获取类中所有定义的字段
        Field[] declaredFields = aClass.getDeclaredFields();
        if (declaredFields!=null&&declaredFields.length>0) {
            //实例化用于保存参数列表的集合
            parameterList=new ArrayList<Object>();
            for (int i = 0; i < declaredFields.length; i++) {
                Field field = declaredFields[i];
                //获取所有的字段名称默认就是属性名称
                String fieldName = field.getName();
                //判断是否为序列化名称
                if (fieldName.equals(SqlConstant.SERIALVERSION_UID.getValue())) {
                    continue;
                }
                //开启私有字段访问权限
                field.setAccessible(true);
                try {
                    //通过反射获取当前字段的值
                    Object value = field.get(entiey);
                    if (value != null) {
                        //追加SQL需要的字段
                        sqlStringBuffer.append(fieldName).append(",");
                        //添加当前字段对应值到集合
                        parameterList.add(value);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //去掉最后一个逗号
            sqlStringBuffer.deleteCharAt(sqlStringBuffer.length()-1).append(")")
                    .append(" VALUES").append(" (");
            // 拼接问号
            for (int i = 0; i < parameterList.size(); i++) {
                sqlStringBuffer.append("?,");
            }
            sqlStringBuffer.deleteCharAt(sqlStringBuffer.length()-1).append(")");
            //调用执行数据库数据持久化的工具方法
            int i = JDBCUtils.executeUpdate(sqlStringBuffer.toString(), parameterList.toArray());
            System.out.println(i > 0 ? "成功" : "失败");
        }
    }
}

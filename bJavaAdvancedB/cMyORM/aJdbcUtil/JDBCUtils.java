package cMyORM.aJdbcUtil;

import cMyORM.aJdbcUtil.enums.DriverInfoEnum;

/**
 * 封装DML操作思路：
 * insert,update,delete操作都是用executeUpdate方法，并且返回操作受影响的行数
 * 把DML操作的语句提取为一个方法来实现
 * public static int executeUpdate(String sql,Object... parameteer){
 *     //获取连接
 *    //定义执行DML语句
 *    //常见预编译对象
 *    //设置参数
 *    //需要通过编译对象执行SQL语句
 *    //释放资源
 * }
 *
 */
public class JDBCUtils {
    public static void main(String[] args){
        System.out.println(DriverInfoEnum.DRIVER_CLASS.getInfo());
    }
}

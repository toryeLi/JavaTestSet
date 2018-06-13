package cMyORM.cJdbcUtilAnnotion.common;

/**
 *  判断一个数组不能为空
 */
public class ArrayUtils {
    public static boolean isNotEmpty(Object[] obj){
        return obj!=null&&obj.length>0;
    }
}

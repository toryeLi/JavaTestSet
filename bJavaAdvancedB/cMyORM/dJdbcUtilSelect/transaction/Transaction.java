package cMyORM.dJdbcUtilSelect.transaction;

/**
 * 事务接口
 */
public interface Transaction {
     void begin();//开启事务
     void commit();//提交事务
    void rollback();//回滚
}

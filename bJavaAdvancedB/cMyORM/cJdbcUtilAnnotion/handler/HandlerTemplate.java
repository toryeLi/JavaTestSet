package cMyORM.cJdbcUtilAnnotion.handler;

import cMyORM.cJdbcUtilAnnotion.exception.MyOrmException;

public abstract class HandlerTemplate {
    /**
     * 定义处理对象持久化的方法
     * @param entity
     * @param <T>
     */
    public abstract <T> void save(T entity) throws MyOrmException;

    /**
     * 定义根据编号删除对象信息的方法
     * @param entity
     * @param <T>
     * @return
     * @throws MyOrmException
     */
    public abstract <T> int delete(T entity) throws MyOrmException;
}

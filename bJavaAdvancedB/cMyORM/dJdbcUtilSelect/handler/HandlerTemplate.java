package cMyORM.dJdbcUtilSelect.handler;

import cMyORM.dJdbcUtilSelect.exception.MyOrmException;
import com.enums.SearchMode;

import java.util.List;

/**
 * 考虑到数据库不同可操作不一致，提供模板
 */
public abstract class HandlerTemplate {
/**
 * 定义事务提交方法
 */
/**
 * 定义事务回滚方法
 */
/**
 * 定义处理对象持久化的方法
 */
public abstract <T> void save(T entity) throws MyOrmException;
/**
 * 定义根据主键删除对象信息的方法
 */
public abstract <T> int delete(T entity) throws MyOrmException;
/**
 * 定义根据删除的条件删除指定对象
 */
public abstract <T> int delete(Class<T> clazz,T condition)throws MyOrmException;
/**
 * 定义根据主键修改对象信息的方法
 */
public abstract <T> int update(T entity) throws MyOrmException;
/**
 * 定义根据用户指定条件修改表中指定的字段
 */
public abstract <T> int update(T entity,T condition)throws MyOrmException;

    /**
     * 查询表中所有字段信息
     * @param clazz
     * @param <T>
     * @return
     * @throws MyOrmException
     */
    public abstract <T> List<T> queryForList(Class<T> clazz)throws MyOrmException;
    public abstract <T> List<T> queryForList(Class<T> clazz, T entity) throws MyOrmException;

    /**
     * 定义根据条件查询表中所有信息的方法
     */
    public abstract <T> List<T> queryForList(Class<T> clazz, T entity,SearchMode mode) throws MyOrmException;

}

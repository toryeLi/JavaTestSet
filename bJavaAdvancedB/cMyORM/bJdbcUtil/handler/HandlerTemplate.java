package cMyORM.bJdbcUtil.handler;

/**
 * 考虑到数据库不同可以操作不一致，提供模板
 */
public abstract class HandlerTemplate {
    /**
     * 定义处理对象持久化的方法
     * @param entiey
     * @param <T>
     */
  public abstract <T> void save(T entiey);
}

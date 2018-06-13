package cMyORM.cJdbcUtilAnnotion.handler.oracle;

import cMyORM.cJdbcUtilAnnotion.exception.MyOrmException;
import cMyORM.cJdbcUtilAnnotion.handler.HandlerTemplate;

public class OracleTemplateHandler extends HandlerTemplate
{
    @Override
    public <T> void save(T entity) throws MyOrmException {

    }

    @Override
    public <T> int delete(T entity) throws MyOrmException {
        return 0;
    }
}

package cMyORM.cJdbcUtilAnnotion.demo.login.impl;

import cMyORM.cJdbcUtilAnnotion.demo.login.LoginDAO;
import cMyORM.cJdbcUtilAnnotion.handler.HandlerTemplate;
import cMyORM.cJdbcUtilAnnotion.handler.mysql.MySQLTemplateHandler;

public class LoginDAOImpl implements LoginDAO {
    private HandlerTemplate template = new MySQLTemplateHandler();

    @Override
    public void addLogin(com.entity.LoginInfo info) {

    }

    @Override
    public void setTempalate(HandlerTemplate tempalate) {

    }

    @Override
    public void deleteLogin(com.entity.LoginInfo loginInfo) {

    }
}

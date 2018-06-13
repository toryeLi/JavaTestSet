package cMyORM.cJdbcUtilAnnotion.demo.login.impl;

import cMyORM.cJdbcUtilAnnotion.demo.login.LoginDAO;
import cMyORM.cJdbcUtilAnnotion.handler.HandlerTemplate;
import cMyORM.cJdbcUtilAnnotion.handler.mysql.MySQLTemplateHandler;
import com.demo.entity.LoginInfo;

public class LoginDAOImpl implements LoginDAO {
    private HandlerTemplate template = new MySQLTemplateHandler();

    @Override
    public void addLogin(LoginInfo info) {
        template.save(info);
    }

    @Override
    public void setTempalate(HandlerTemplate tempalate) {
        this.template = tempalate;
    }

    @Override
    public void deleteLogin(LoginInfo loginInfo) {
        template.delete(loginInfo);
    }
}

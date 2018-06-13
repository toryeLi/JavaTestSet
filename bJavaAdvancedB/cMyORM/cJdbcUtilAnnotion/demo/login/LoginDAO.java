package cMyORM.cJdbcUtilAnnotion.demo.login;

import cMyORM.cJdbcUtilAnnotion.handler.HandlerTemplate;

public interface LoginDAO {
    void addLogin(com.demo.entity.LoginInfo info);
    void setTempalate(HandlerTemplate tempalate);
    void deleteLogin(com.demo.entity.LoginInfo loginInfo);
}

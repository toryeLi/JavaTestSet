package cMyORM.cJdbcUtilAnnotion.demo.login;

import cMyORM.cJdbcUtilAnnotion.handler.HandlerTemplate;

public interface LoginDAO {
    void addLogin(com.entity.LoginInfo info);
    void setTempalate(HandlerTemplate tempalate);
    void deleteLogin(com.entity.LoginInfo loginInfo);
}

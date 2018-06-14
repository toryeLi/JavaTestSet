package cMyORM.dJdbcUtilSelect.demo.login.impl;

import cMyORM.dJdbcUtilSelect.handler.HandlerTemplate;
import cMyORM.dJdbcUtilSelect.demo.login.LoginDAO3;
import cMyORM.dJdbcUtilSelect.handler.mysql.MySqlTemplateHandler;
import com.entity.LoginInfo;

import java.util.List;

public class LoginDAOImpl3 implements LoginDAO3 {
    HandlerTemplate handlerTemplate = new MySqlTemplateHandler();


    @Override
    public void save(LoginInfo loginInfo) {

    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public void delete(LoginInfo loginInfo) {


    }

    @Override
    public void update(LoginInfo loginInfo) {
        int update = handlerTemplate.update(loginInfo);
        System.out.println(update > 0 ? "更新成功" : "更新失败");
    }

    @Override
    public void update(LoginInfo loginInfo, LoginInfo condition) {

    }

    @Override
    public List<LoginInfo> getBookInfos() {
        return null;
    }

    @Override
    public List<LoginInfo> getBookInfos(LoginInfo condition) {
        return null;
    }
}

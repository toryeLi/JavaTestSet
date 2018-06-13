package cMyORM.bJdbcUtil.test;

import cMyORM.bJdbcUtil.handler.HandlerTemplate;
import cMyORM.bJdbcUtil.handler.mysql.MySqlHandler;
import com.demo.entity.T_login;

public class TestJdbcUtil {
    public static void main(String[] args){
        T_login t_login = new T_login();
        t_login.setLogin_account("torey2");
        t_login.setLogin_pass("t1235");
        HandlerTemplate handler = new MySqlHandler();
        handler.save(t_login);
    }
}

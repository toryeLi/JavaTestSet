package cMyORM.cJdbcUtilAnnotion.test;

import cMyORM.cJdbcUtilAnnotion.demo.login.LoginDAO;
import cMyORM.cJdbcUtilAnnotion.demo.login.impl.LoginDAOImpl;
import com.demo.entity.LoginInfo;

public class JdbcUtil2 {
    public static void main(String[] args){
//        HandlerTemplate mySQLTemplateHandler = new MySQLTemplateHandler();
//        LoginInfo loginInfo = new LoginInfo();
//        loginInfo.setLoginId(2);
//        mySQLTemplateHandler.delete(loginInfo);
        LoginDAO loginDAO = new LoginDAOImpl();
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setLoginId(3);
        loginInfo.setLoginAccount("Vitisoo");
        loginInfo.setLoginPass("123");
        //loginDAO.deleteLogin(loginInfo);
        loginDAO.addLogin(loginInfo);
    }
}

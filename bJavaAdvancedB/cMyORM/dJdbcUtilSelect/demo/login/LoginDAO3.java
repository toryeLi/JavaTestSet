package cMyORM.dJdbcUtilSelect.demo.login;

import com.entity.LoginInfo;

import java.util.List;

public interface LoginDAO3 {
    void save(LoginInfo loginInfo);
    void delete(Integer id);
    void delete(LoginInfo loginInfo);
    void update(LoginInfo loginInfo);
    void update(LoginInfo loginInfo, LoginInfo condition);
    List<LoginInfo> getBookInfos();
    List<LoginInfo> getBookInfos(LoginInfo condition);
}

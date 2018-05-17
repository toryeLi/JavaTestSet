package bSocket.aTcp;

import java.io.Serializable;
public class UserInfo implements Serializable {
    //快速生成serialVersionUID方法：
    //1、setting->Inspections->Serialization issues，将serialzable class without "serialVersionUID"打上勾
    //2、将光标放到类名上，按atl＋enter键，就会提示生成serialVersionUID了
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

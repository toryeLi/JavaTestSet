package com.entity;

import com.annotantion.Colum;
import com.annotantion.PK;
import com.annotantion.Table;

@Table("T_login")
public class LoginInfo {
    @PK
    @Colum(value = "login_id")
    private Integer loginId;
    @Colum(value = "login_account")
    private String loginAccount;
    @Colum(value = "login_pass")
    private String loginPass;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

}

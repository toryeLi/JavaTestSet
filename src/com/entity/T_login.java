package com.demo.entity;

import com.annotantion.PK;

import java.io.Serializable;

public class T_login implements Serializable {
    @PK
  private Integer login_id;
  private String login_account;
  private String login_pass;
    private static final long serialVersionUID = 1L;
    public Integer getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Integer login_id) {
        this.login_id = login_id;
    }

    public String getLogin_account() {
        return login_account;
    }

    public void setLogin_account(String login_account) {
        this.login_account = login_account;
    }

    public String getLogin_pass() {
        return login_pass;
    }

    public void setLogin_pass(String login_pass) {
        this.login_pass = login_pass;
    }
}

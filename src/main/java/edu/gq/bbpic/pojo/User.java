package edu.gq.bbpic.pojo;

import java.util.Date;

public class User {
    private Integer userId;

    private String account;

    private String password;

    private String email;

    private String name;

    private String avatar;

    private Integer role;

    private Integer enable;

    private Date creationTime;

    public User(Integer userId, String account, String password, String email, String name, String avatar, Integer role, Integer enable, Date creationTime) {
        this.userId = userId;
        this.account = account;
        this.password = password;
        this.email = email;
        this.name = name;
        this.avatar = avatar;
        this.role = role;
        this.enable = enable;
        this.creationTime = creationTime;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
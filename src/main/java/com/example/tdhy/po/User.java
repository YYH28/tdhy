package com.example.tdhy.po;

public class User {
    private Integer id;

    private String ueseName;

    private String uesrTele;

    private String userPassword;

    private String userEmail;

    private Integer userStatus;

    private String userCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUeseName() {
        return ueseName;
    }

    public void setUeseName(String ueseName) {
        this.ueseName = ueseName == null ? null : ueseName.trim();
    }

    public String getUesrTele() {
        return uesrTele;
    }

    public void setUesrTele(String uesrTele) {
        this.uesrTele = uesrTele == null ? null : uesrTele.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }
}
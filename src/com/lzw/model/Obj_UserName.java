package com.lzw.model;

public class Obj_UserName implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 6049690151828744478L;
    private String userid;
    private String username;
    private String password;
    private String passconf;
    
    public Obj_UserName() {
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setPassconf(String passwordconf) {
        this.passconf = passwordconf;
    }
    
    public String getUserid() {
        return userid;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getPassconf() {
        return passconf;
    }
}

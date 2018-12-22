package com.lzw.model;

import java.sql.Date;

public class Obj_BuyDetaile implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -4242090889986037609L;
    private String rklsh;
    private String rkdjh;
    private String ypbh;
    private int rksl;
    private float rkdj;
    private float rkje;
    private Date rkrq;
    private int kcsl;
    private String kcsts;
    
    public String getRklsh() {
        return this.rklsh;
    }
    
    public void setRklsh(String rklsh) {
        this.rklsh = rklsh;
    }
    
    public String getRkdjh() {
        return this.rkdjh;
    }
    
    public void setRkdjh(String rkdjh) {
        this.rkdjh = rkdjh;
    }
    
    public String getYpbh() {
        return this.ypbh;
    }
    
    public void setYpbh(String ypbh) {
        this.ypbh = ypbh;
    }
    
    public int getRksl() {
        return this.rksl;
    }
    
    public void setRksl(int rksl) {
        this.rksl = rksl;
    }
    
    public float getRkdj() {
        return this.rkdj;
    }
    
    public void setRkdj(float rkdj) {
        this.rkdj = rkdj;
    }
    
    public float getRkje() {
        return this.rkje;
    }
    
    public void setRkje(float rkje) {
        this.rkje = rkje;
    }
    
    public Date getRkrq() {
        return this.rkrq;
    }
    
    public void setRkrq(Date rkrq) {
        this.rkrq = rkrq;
    }
    
    public int getKcsl() {
        return this.kcsl;
    }
    
    public void setKcsl(int kcsl) {
        this.kcsl = kcsl;
    }
    
    public String getKcsts() {
        return this.kcsts;
    }
    
    public void setKcsts(String kcsts) {
        this.kcsts = kcsts;
    }
    
    public Obj_BuyDetaile() {
    }
}

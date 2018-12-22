package com.lzw.model;

import java.sql.Date;

public class Obj_BuyMain implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 2944095707837773463L;
    private String rkdjh;
    private int pzs;
    private int rksl;
    private float rkje;
    private Date rkrq;
    private String jbr;
    private String sts;
    private String gysbh;
    
    public Obj_BuyMain() {
    }
    
    // Property accessors
    
    public String getRkdjh() {
        return this.rkdjh;
    }
    
    public void setRkdjh(String rkdjh) {
        this.rkdjh = rkdjh;
    }
    
    public int getPzs() {
        return this.pzs;
    }
    
    public void setPzs(int pzs) {
        this.pzs = pzs;
    }
    
    public int getRksl() {
        return this.rksl;
    }
    
    public void setRksl(int rksl) {
        this.rksl = rksl;
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
    
    public String getJbr() {
        return this.jbr;
    }
    
    public void setJbr(String jbr) {
        this.jbr = jbr;
    }
    
    public String getSts() {
        return this.sts;
    }
    
    public void setSts(String sts) {
        this.sts = sts;
    }
    
    public String getGysbh() {
        return this.gysbh;
    }
    
    public void setGysbh(String gysbh) {
        this.gysbh = gysbh;
    }
    
}

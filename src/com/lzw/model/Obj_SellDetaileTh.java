package com.lzw.model;

import java.sql.Date;

public class Obj_SellDetaileTh implements java.io.Serializable {
    // Fields
    
    /**
     * 
     */
    private static final long serialVersionUID = 7330094199843538L;
    private String xslsh;
    private String ypbh;
    private Date thrq;
    private float thje;
    private String jbr;
    private obj_medicine medicine;
    private Obj_SellDetaile selldetaile;
    private int thsl;
    
    // Property accessors
    
    public String getXslsh() {
        return this.xslsh;
    }
    
    public void setXslsh(String xslsh) {
        this.xslsh = xslsh;
    }
    
    public String getYpbh() {
        return this.ypbh;
    }
    
    public void setYpbh(String ypbh) {
        this.ypbh = ypbh;
    }
    
    public Date getThrq() {
        return this.thrq;
    }
    
    public void setThrq(Date thrq) {
        this.thrq = thrq;
    }
    
    public float getThje() {
        return this.thje;
    }
    
    public void setThje(float thje) {
        this.thje = thje;
    }
    
    public String getJbr() {
        return this.jbr;
    }
    
    public obj_medicine getMedicine() {
        return medicine;
    }
    
    public Obj_SellDetaile getSelldetaile() {
        return selldetaile;
    }
    
    public int getThsl() {
        return thsl;
    }
    
    public void setJbr(String jbr) {
        this.jbr = jbr;
    }
    
    public void setMedicine(obj_medicine medicine) {
        this.medicine = medicine;
    }
    
    public void setSelldetaile(Obj_SellDetaile selldetaile) {
        this.selldetaile = selldetaile;
    }
    
    public void setThsl(int thsl) {
        this.thsl = thsl;
    }
    
}

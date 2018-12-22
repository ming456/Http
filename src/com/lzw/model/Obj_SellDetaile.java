package com.lzw.model;

import java.sql.Date;

public class Obj_SellDetaile implements java.io.Serializable {
    // Fields
    
    /**
     * 
     */
    private static final long serialVersionUID = -7937721971382939371L;
    private String xslsh;
    private String ypbh;
    private String xsdjh;
    private int xssl;
    private float xsdj;
    private float xsje;
    private Date xsrq;
    private obj_medicine medicine;
    private String thsts;
    
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
    
    public String getXsdjh() {
        return this.xsdjh;
    }
    
    public void setXsdjh(String xsdjh) {
        this.xsdjh = xsdjh;
    }
    
    public int getXssl() {
        return this.xssl;
    }
    
    public void setXssl(int xssl) {
        this.xssl = xssl;
    }
    
    public float getXsdj() {
        return this.xsdj;
    }
    
    public void setXsdj(float xsdj) {
        this.xsdj = xsdj;
    }
    
    public float getXsje() {
        return this.xsje;
    }
    
    public void setXsje(float xsje) {
        this.xsje = xsje;
    }
    
    public Date getXsrq() {
        return this.xsrq;
    }
    
    public obj_medicine getMedicine() {
        return medicine;
    }
    
    public String getThsts() {
        return thsts;
    }
    
    public void setXsrq(Date xsrq) {
        this.xsrq = xsrq;
    }
    
    public void setMedicine(obj_medicine medicine) {
        this.medicine = medicine;
    }
    
    public void setThsts(String thsts) {
        this.thsts = thsts;
    }
    
    public Obj_SellDetaile() {
    }
}

package com.lzw.model;

import java.sql.Date;

public class Obj_Stock implements java.io.Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -6810794502056868928L;
    private String ypbh;
    private int rksl;
    private int xssl;
    private int kcsl;
    private int pdsl;
    private Date pdrq;
    private obj_medicine objmedicine;
    
    public Obj_Stock() {
    }
    
    // Property accessors
    
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
    
    public int getXssl() {
        return this.xssl;
    }
    
    public void setXssl(int xssl) {
        this.xssl = xssl;
    }
    
    public int getKcsl() {
        return this.kcsl;
    }
    
    public void setKcsl(int kcsl) {
        this.kcsl = kcsl;
    }
    
    public int getPdsl() {
        return this.pdsl;
    }
    
    public void setPdsl(int pdsl) {
        this.pdsl = pdsl;
    }
    
    public Date getPdrq() {
        return this.pdrq;
    }
    
    public obj_medicine getObjmedicine() {
        return objmedicine;
    }
    
    public void setPdrq(Date pdrq) {
        this.pdrq = pdrq;
    }
    
    public void setObjmedicine(obj_medicine objmedicine) {
        this.objmedicine = objmedicine;
    }
    
}

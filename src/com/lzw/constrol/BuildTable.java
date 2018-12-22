package com.lzw.constrol;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.lzw.dao.AdapterDao;
import com.lzw.model.Obj_client;
import com.lzw.model.Obj_gys;
import com.lzw.model.obj_medicine;

public class BuildTable {
    private String[] Tname = null;
    private List ObjList = null;
    
    public DefaultTableModel getGysTableModel(String queryStr) {
        String[] Tname = { "供应商编号", "供应商名称", "拼音码", "供应商地址", "所属地区", "邮政编码", "联系电话", "联系人", "开户银行", "开户账号" };
        DefaultTableModel tableModel = null;
        Vector<Object> vname = new Vector<Object>();
        for (int i = 0; i < Tname.length; i++) {
            vname.addElement(Tname[i]);
        }
        tableModel = new DefaultTableModel(vname, 0);
        ObjList = AdapterDao.QueryObject(queryStr);
        if (!ObjList.isEmpty()) {
            Iterator iterator = ObjList.iterator();
            while (iterator.hasNext()) {
                Vector<Object> vdata = new Vector<Object>();
                Obj_gys objgys = (Obj_gys) iterator.next();
                vdata.addElement(objgys.getGysbh());
                vdata.addElement(objgys.getGysmc());
                vdata.addElement(objgys.getPym());
                vdata.addElement(objgys.getGysdz());
                vdata.addElement(objgys.getSsdq());
                vdata.addElement(objgys.getYzbm());
                vdata.addElement(objgys.getTel());
                vdata.addElement(objgys.getLxr());
                vdata.addElement(objgys.getKhyh());
                vdata.addElement(objgys.getKhzh());
                
                tableModel.addRow(vdata);
            }
        }
        return tableModel;
    }
    
    public DefaultTableModel getmedicineTableModel(String queryStr) {
        String[] Tname = { "药品编码", "名称", "药品条码", "通用名", "拼音码", "单位", "规格", "剂型", "产地", "包装数", "有效期", "质量标准", "经营方式", "批号", "零售价格", "进货价格", "批发价格", "药品类名",
                "医疗编号" };
        DefaultTableModel tableModel = null;
        Vector<Object> vname = new Vector<Object>();
        for (int i = 0; i < Tname.length; i++) {
            vname.addElement(Tname[i]);
        }
        tableModel = new DefaultTableModel(vname, 0);
        ObjList = AdapterDao.QueryObject(queryStr);
        if (!ObjList.isEmpty()) {
            Iterator iterator = ObjList.iterator();
            while (iterator.hasNext()) {
                Vector<Object> vdata = new Vector<Object>();
                /*
                 * "药品编码","名称","药品条码","通用名","拼音码","单位","规格","剂型"
                 * ,"产地","包装数","有效期","质量标准","经营方式","批号","零售价格","进货价格"
                 * ,"批发价格","药品类名","医疗编号","供应商编号"};
                 */

                obj_medicine object = (obj_medicine) iterator.next();
                vdata.addElement(object.getYpbh());
                vdata.addElement(object.getYpmc());
                vdata.addElement(object.getYptm());
                vdata.addElement(object.getTym());
                vdata.addElement(object.getPym());
                vdata.addElement(object.getDw());
                vdata.addElement(object.getGg());
                vdata.addElement(object.getJx());
                vdata.addElement(object.getCd());
                vdata.addElement(String.valueOf(object.getBzsl()));
                vdata.addElement(object.getYxq());
                vdata.addElement(object.getZlbz());
                vdata.addElement(object.getJyfs());
                vdata.addElement(object.getPh());
                vdata.addElement(object.getLsjg());
                vdata.addElement(object.getJhjg());
                vdata.addElement(object.getPfjg());
                vdata.addElement(object.getYplb());
                vdata.addElement(object.getYlbh());
                
                tableModel.addRow(vdata);
            }
        }
        return tableModel;
    }
    
    public DefaultTableModel getClientTableModel(String queryStr) {
        String[] Tname = { "客户编号", "客户名称", "拼音码", "客户地址", "所属地区", "邮政编码", "联系电话", "联系人", "开户银行", "开户账号" };
        DefaultTableModel tableModel = null;
        Vector<Object> vname = new Vector<Object>();
        for (int i = 0; i < Tname.length; i++) {
            vname.addElement(Tname[i]);
        }
        tableModel = new DefaultTableModel(vname, 0);
        ObjList = AdapterDao.QueryObject(queryStr);
        if (!ObjList.isEmpty()) {
            Iterator iterator = ObjList.iterator();
            while (iterator.hasNext()) {
                Vector<Object> vdata = new Vector<Object>();
                Obj_client object = (Obj_client) iterator.next();
                vdata.addElement(object.getKhbh());
                vdata.addElement(object.getKhmc());
                vdata.addElement(object.getPym());
                vdata.addElement(object.getKhdz());
                vdata.addElement(object.getSsdq());
                vdata.addElement(object.getYzbm());
                vdata.addElement(object.getTel());
                vdata.addElement(object.getLxr());
                vdata.addElement(object.getKhyh());
                vdata.addElement(object.getKhzh());
                
                tableModel.addRow(vdata);
            }
        }
        return tableModel;
    }
}

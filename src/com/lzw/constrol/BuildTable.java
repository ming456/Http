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
        String[] Tname = { "��Ӧ�̱��", "��Ӧ������", "ƴ����", "��Ӧ�̵�ַ", "��������", "��������", "��ϵ�绰", "��ϵ��", "��������", "�����˺�" };
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
        String[] Tname = { "ҩƷ����", "����", "ҩƷ����", "ͨ����", "ƴ����", "��λ", "���", "����", "����", "��װ��", "��Ч��", "������׼", "��Ӫ��ʽ", "����", "���ۼ۸�", "�����۸�", "�����۸�", "ҩƷ����",
                "ҽ�Ʊ��" };
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
                 * "ҩƷ����","����","ҩƷ����","ͨ����","ƴ����","��λ","���","����"
                 * ,"����","��װ��","��Ч��","������׼","��Ӫ��ʽ","����","���ۼ۸�","�����۸�"
                 * ,"�����۸�","ҩƷ����","ҽ�Ʊ��","��Ӧ�̱��"};
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
        String[] Tname = { "�ͻ����", "�ͻ�����", "ƴ����", "�ͻ���ַ", "��������", "��������", "��ϵ�绰", "��ϵ��", "��������", "�����˺�" };
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

package com.lzw.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lzw.model.Obj_BuyDetaile;
import com.lzw.model.Obj_BuyMain;
import com.lzw.model.Obj_SellDetaile;
import com.lzw.model.Obj_SellDetaileTh;
import com.lzw.model.Obj_SellMain;
import com.lzw.model.Obj_Stock;
import com.lzw.model.Obj_UserName;
import com.lzw.model.Obj_client;
import com.lzw.model.Obj_gys;
import com.lzw.model.obj_medicine;

public class DaoSupport extends HibernateDaoSupport {
    public DaoSupport() {
        
    }
    
    /*---------���һ�����ݵ����ݱ���----------*/
    public boolean InsertMedicine(obj_medicine medicine) {
        getHibernateTemplate().saveOrUpdate(medicine);
        return true;
    }
    
    public boolean InsertClient(Obj_client objclient) {
        getHibernateTemplate().saveOrUpdate(objclient);
        return true;
    }
    
    public boolean InsertMedicine(Obj_gys objgys) {
        getHibernateTemplate().saveOrUpdate(objgys);
        return true;
    }
    
    public boolean InsertSellMain(Obj_SellMain obj) {
        getHibernateTemplate().saveOrUpdate(obj);
        return true;
    }
    
    public boolean InsertSellDetaile(Obj_SellDetaile obj) {
        getHibernateTemplate().saveOrUpdate(obj);
        return true;
    }
    
    public boolean InsertBuyMain(Obj_BuyMain obj) {
        getHibernateTemplate().saveOrUpdate(obj);
        return true;
    }
    
    public boolean InsertBuyDetaile(Obj_BuyDetaile obj) {
        getHibernateTemplate().saveOrUpdate(obj);
        return true;
    }
    
    public boolean InsertStock(Obj_Stock obj) {
        getHibernateTemplate().saveOrUpdate(obj);
        return true;
    }
    
    public boolean InsertObj_SellDetaileTh(Obj_SellDetaileTh obj) {
        getHibernateTemplate().saveOrUpdate(obj);
        return true;
    }
    
    public boolean InsertObj_UserName(Obj_UserName username) {
        
        getHibernateTemplate().saveOrUpdate(username);
        return true;
    }
    
    /*----------��ѯ�������ݱ��е��������������ݼ���-------*/
    public List getAllMedicine() {
        return getHibernateTemplate().find("from obj_medicine ");
    }
    
    public List QueryObject(String QueryStr) {
        return getHibernateTemplate().find(QueryStr);
    }
    
    /*---------------ɾ����Ӧ�ı�����-----------*/

    public void DeleteUser(Obj_UserName user) {
        getHibernateTemplate().delete(user);
    }
    
}

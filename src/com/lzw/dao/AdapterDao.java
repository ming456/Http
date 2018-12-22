package com.lzw.dao;

import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

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
import com.lzw.view.JF_view_error;

public class AdapterDao {
    private Resource resource = null;
    private XmlBeanFactory factory = null;
    
    private static DaoSupport dao = null;
    
    public AdapterDao() {
    }
    
    public boolean getdao() {
        try {
            resource = new ClassPathResource("appcontext.xml", getClass());
            factory = new XmlBeanFactory(resource);
            dao = (DaoSupport) factory.getBean("DAOProxy");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JF_view_error error = new JF_view_error(e.getMessage());
            error.setTitle("初始化数据连接失败，错误信息如下：");
            return false;
        }
    }
    
    public static boolean insertmedicine(obj_medicine medicine) {
        return dao.InsertMedicine(medicine);
    }
    
    public static boolean insertclient(Obj_client objclient) {
        return dao.InsertClient(objclient);
    }
    
    public static boolean insertmedicine(Obj_gys objgys) {
        return dao.InsertMedicine(objgys);
    }
    
    public static boolean InsertSellMain(Obj_SellMain obj) {
        return dao.InsertSellMain(obj);
    }
    
    public static boolean InsertSellDetaile(Obj_SellDetaile obj) {
        return dao.InsertSellDetaile(obj);
    }
    
    public static boolean InsertBuyMain(Obj_BuyMain obj) {
        return dao.InsertBuyMain(obj);
    }
    
    public static boolean InsertBuyDetaile(Obj_BuyDetaile obj) {
        return dao.InsertBuyDetaile(obj);
    }
    
    public static boolean InsertStock(Obj_Stock obj) {
        return dao.InsertStock(obj);
    }
    
    public static boolean InsertObj_SellDetaileTh(Obj_SellDetaileTh obj) {
        return dao.InsertObj_SellDetaileTh(obj);
    }
    
    public static boolean InsertObj_UserName(Obj_UserName obj) {
        return dao.InsertObj_UserName(obj);
    }
    
    public static List QueryObject(String str) {
        return dao.QueryObject(str);
    }
    
    public static void DeleteUser(Obj_UserName user) {
        dao.DeleteUser(user);
    }
}

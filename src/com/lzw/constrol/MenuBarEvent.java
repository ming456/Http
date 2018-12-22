package com.lzw.constrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import com.lzw.view.JF_user_add;
import com.lzw.view.JF_user_modi;
import com.lzw.view.JF_view_buy;
import com.lzw.view.JF_view_client;
import com.lzw.view.JF_view_gys;
import com.lzw.view.JF_view_hkgl;
import com.lzw.view.JF_view_kcpd;
import com.lzw.view.JF_view_medicine;
import com.lzw.view.JF_view_query_jbqk;
import com.lzw.view.JF_view_query_kcmx_ck;
import com.lzw.view.JF_view_query_kcmx_hk;
import com.lzw.view.JF_view_query_kcmx_rk;
import com.lzw.view.JF_view_sell;
import com.lzw.view.JF_view_xstk;

public class MenuBarEvent implements ActionListener {
    private javax.swing.JDesktopPane JDeskTop = null;
    
    private String EventName = "";
    
    public void setDeskTop(javax.swing.JDesktopPane deskTop) {
        this.JDeskTop = deskTop;
    }
    
    public void setEventName(String eventName) {
        this.EventName = eventName;
    }
    
    public void actionPerformed(ActionEvent e) {
        JInternalFrame iFrame = null;
        System.out.println("e.getActionCommand() = " + e.getActionCommand() + ";EventName = " + EventName);
        if (e.getActionCommand().equals("JB_EXIT") || EventName.equals("JB_EXIT")) {
            int result = JOptionPane.showOptionDialog(null, "是否真的退出医药综合管理系统?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new String[] { "是", "否" }, "否");
            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
            EventName = "";
        }
        
        if (e.getActionCommand().equals("JF_view_medicine") || EventName.equals("JF_view_medicine")) {
            iFrame = new JF_view_medicine();
            iFrame.setLocation(50, 50);
            JDeskTop.add(iFrame);
            EventName = "";
        }
        if (e.getActionCommand().equals("JF_view_client") || EventName.equals("JF_view_client")) {
            iFrame = new JF_view_client();
            iFrame.setLocation(80, 80);
            JDeskTop.add(iFrame);
            EventName = "";
        }
        
        if (e.getActionCommand().equals("JF_view_gys") || EventName.equals("JF_view_gys")) {
            iFrame = new JF_view_gys();
            iFrame.setLocation(80, 80);
            JDeskTop.add(iFrame);
            EventName = "";
        }
        if (e.getActionCommand().equals("JF_view_sell") || EventName.equals("JF_view_sell")) {
            iFrame = new JF_view_sell();
            iFrame.setLocation(20, 20);
            JDeskTop.add(iFrame);
            EventName = "";
        }
        if (e.getActionCommand().equals("JF_view_buy") || EventName.equals("JF_view_buy")) {
            iFrame = new JF_view_buy();
            iFrame.setLocation(20, 20);
            JDeskTop.add(iFrame);
            EventName = "";
        }
        if (e.getActionCommand().equals("JF_view_stock") || EventName.equals("JF_view_stock")) {
            iFrame = new JF_view_kcpd();
            iFrame.setLocation(80, 20);
            JDeskTop.add(iFrame);
            EventName = "";
        }
        if (e.getActionCommand().equals("JF_view_xstk") || EventName.equals("JF_view_xstk")) {
            iFrame = new JF_view_xstk();
            iFrame.setLocation(80, 20);
            JDeskTop.add(iFrame);
            EventName = "";
        }
        if (e.getActionCommand().equals("JF_view_hkgl") || EventName.equals("JF_view_hkgl")) {
            iFrame = new JF_view_hkgl();
            iFrame.setLocation(20, 20);
            iFrame.setTitle("医药综合管理系统--[客户回款]");
            JDeskTop.add(iFrame);
            EventName = "";
        }
        if (e.getActionCommand().equals("JF_view_query_jbqk") || EventName.equals("JF_view_query_jbqk")) {
            iFrame = new JF_view_query_jbqk();
            iFrame.setLocation(20, 20);
            iFrame.setTitle("医药综合管理系统--[基本信息查询]");
            JDeskTop.add(iFrame);
            EventName = "";
        }
        if (e.getActionCommand().equals("JF_view_query_rkqk") || EventName.equals("JF_view_query_rkqk")) {
            iFrame = new JF_view_query_kcmx_rk();
            iFrame.setLocation(80, 20);
            iFrame.setTitle("医药综合管理系统--[入库明细表查询]");
            JDeskTop.add(iFrame);
            EventName = "";
        }
        if (e.getActionCommand().equals("JF_view_query_kcmx_ck") || EventName.equals("JF_view_query_kcmx_ck")) {
            iFrame = new JF_view_query_kcmx_ck();
            iFrame.setLocation(80, 20);
            iFrame.setTitle("医药综合管理系统--[销售明细表查询]");
            JDeskTop.add(iFrame);
            EventName = "";
        }
        if (e.getActionCommand().equals("JF_view_query_kcmx_hk") || EventName.equals("JF_view_query_kcmx_hk")) {
            iFrame = new JF_view_query_kcmx_hk();
            iFrame.setLocation(80, 20);
            iFrame.setTitle("医药综合管理系统--[客户回款情况查询]");
            JDeskTop.add(iFrame);
            EventName = "";
        }
        
        if (e.getActionCommand().equals("sys_user_add") || EventName.equals("sys_user_add")) {
            iFrame = new JF_user_add();
            iFrame.setLocation(150, 150);
            JDeskTop.add(iFrame);
            EventName = "";
        }
        
        if (e.getActionCommand().equals("sys_user_modify") || EventName.equals("sys_user_modify")) {
            iFrame = new JF_user_modi();
            iFrame.setLocation(150, 150);
            JDeskTop.add(iFrame);
            EventName = "";
        }
        try {
            iFrame.setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
    }
}

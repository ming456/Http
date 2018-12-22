package com.lzw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.DefaultDesktopManager;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class JF_view_hkgl extends JInternalFrame {// JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = -4798607617121116670L;
    BorderLayout borderLayout1 = new BorderLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JPanel jPanel1 = new JPanel();
    JTable jTable1 = new JTable();
    FlowLayout flowLayout1 = new FlowLayout();
    JButton jBsave = new JButton();
    JButton jBexit = new JButton();
    DefaultTableModel tableModel = null;
    JButton jBquery = new JButton();
    JLabel jLabel1 = new JLabel();
    JTextField jTdjh = new JTextField();
    java.sql.Date hkrq = null;
    
    java.util.Iterator iteratorupdate = null;
    
    public JF_view_hkgl() {
        try {
            jbInit();
            buildTable();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void buildTable() {
        String[] tname = { "客户名称", "销售单据号", "销售日期", "数目", "销售总量", "销售金额", "折扣金额", "应收金额", "实收金额", "未收金额", "回款金额", "回款日期" };
        java.util.Vector<String> vname = new java.util.Vector<String>();
        for (int i = 0; i < tname.length; i++) {
            vname.addElement(tname[i]);
        }
        tableModel = new DefaultTableModel(vname, 0);
        jTable1.setModel(tableModel);
        
    }
    
    private void jbInit() throws Exception {
        this.getContentPane().setLayout(borderLayout1);
        jPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jBquery.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jBquery.setText("查询");
        jBquery.addActionListener(new JF_view_hkgl_jBquery_actionAdapter(this));
        jBexit.addActionListener(new JF_view_hkgl_jBexit_actionAdapter(this));
        jBsave.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jBsave.addActionListener(new JF_view_hkgl_jBpd_actionAdapter(this));
        jBexit.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        this.setClosable(true);
        this.setMaximizable(true);
        
        jLabel1.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jLabel1.setText("输入客户编号:");
        jTdjh.setPreferredSize(new Dimension(226, 27));
        jTdjh.setText("");
        jTdjh.addKeyListener(new JF_view_hkgl_jTdjh_keyAdapter(this));
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        flowLayout1.setHgap(10);
        this.getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jBsave.setText("存盘");
        jPanel1.setLayout(flowLayout1);
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        jBexit.setText("退出");
        jPanel1.add(jLabel1);
        jPanel1.add(jTdjh);
        jPanel1.add(jBquery);
        jPanel1.add(jBsave);
        jPanel1.add(jBexit);
        jScrollPane1.getViewport().add(jTable1);
        setSize(800, 500);
        setVisible(true);
    }
    
    public void jBquery_actionPerformed(ActionEvent e) {
        if (jTable1.getRowCount() > 0)
            return;
        String khbh = null;
        String queryStr = null;
        khbh = jTdjh.getText().trim();
        queryStr = "select khmc from Obj_client where khbh = '" + khbh + "'";
        java.util.List listmc = null;
        listmc = com.lzw.dao.AdapterDao.QueryObject(queryStr);
        if (listmc.size() == 0) {
            JOptionPane.showMessageDialog(null, "客户编号的数据不存在,请重新输入!!!", "系统提示", JOptionPane.ERROR_MESSAGE);
            jTdjh.requestFocus();
            return;
        }
        Object khmc = listmc.get(0);
        java.util.Calendar calendar = null;
        Locale loc = new Locale("CN");
        calendar = Calendar.getInstance(loc);
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String rqStr = year + "-" + month + "-" + day;
        hkrq = java.sql.Date.valueOf(rqStr);
        
        queryStr = "FROM Obj_SellMain where khbh = '" + khbh + "' and qssts = 'F'";
        java.util.List list = null;
        java.util.Iterator iterator = null;
        
        list = com.lzw.dao.AdapterDao.QueryObject(queryStr);
        if (list.size() == 0) {
            JOptionPane.showMessageDialog(null, "没有满足条件的数据,请重新输入!!!", "系统提示", JOptionPane.ERROR_MESSAGE);
            jTdjh.requestFocus();
            return;
        }
        
        iterator = list.iterator();
        iteratorupdate = list.iterator();
        while (iterator.hasNext()) {
            com.lzw.model.Obj_SellMain objsell = (com.lzw.model.Obj_SellMain) iterator.next();
            java.util.Vector<Object> vdata = new java.util.Vector<Object>();
            vdata.addElement(khmc);
            vdata.addElement(objsell.getXsdjh());
            vdata.addElement(objsell.getXsrq());
            
            vdata.addElement(Integer.valueOf(String.valueOf(objsell.getPzs())));
            vdata.addElement(Integer.valueOf(String.valueOf(objsell.getXszs())));
            vdata.addElement(objsell.getXsje());
            vdata.addElement(objsell.getXszk());
            vdata.addElement(objsell.getYsje());
            vdata.addElement(objsell.getSsje());
            System.out.println("wsje = " + objsell.getWsje());
            vdata.addElement(objsell.getWsje());
            vdata.addElement(objsell.getWsje());
            vdata.addElement(hkrq);
            tableModel.addRow(vdata);
        }
        jTable1.setRowHeight(20);
    }
    
    public void jBexit_actionPerformed(ActionEvent e) {
        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "是否真的退出客户回款情况?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }
    }
    
    public void jBsave_actionPerformed(ActionEvent e) {
        if (jTable1.getRowCount() <= 0)
            return;
        int result = JOptionPane.showOptionDialog(null, "是否存盘客户回款信息情况?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.NO_OPTION)
            return;
        
        int i = 0;
        while (iteratorupdate.hasNext()) {
            String sts = null;
            Double whje = null, hkje = null;
            if (jTable1.getValueAt(i, 10) == null) {
                JOptionPane.showMessageDialog(null, "回款金额不允许为空,请录入!!!", "系统提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try {
                whje = Double.valueOf(String.valueOf(jTable1.getValueAt(i, 9)));
                hkje = Double.valueOf(String.valueOf(jTable1.getValueAt(i, 10)));
                if (!whje.equals(hkje)) {
                    JOptionPane.showMessageDialog(null, "回款金额必须一次性完成,请重新录入!!!", "系统提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                sts = "T";
            } catch (java.lang.NumberFormatException format) {
                JOptionPane.showMessageDialog(null, "输入的数据格式有误,请重新录入!!\n" + format.getMessage(), "系统提示", JOptionPane.ERROR_MESSAGE);
                System.out.println(format.getMessage());
                return;
            }
            com.lzw.model.Obj_SellMain sell = (com.lzw.model.Obj_SellMain) iteratorupdate.next();
            
            sell.setHkrq(hkrq);
            sell.setHkje(hkje);
            sell.setQssts(sts);
            com.lzw.dao.AdapterDao.InsertSellMain(sell);
            i++;
        }
        JOptionPane.showMessageDialog(null, "客户回款数据存盘成功!!!", "系统提示", JOptionPane.OK_OPTION);
        jTdjh.setText("");
        
        String[] tname = { "客户名称", "销售单据号", "销售日期", "数目", "销售总量", "销售金额", "折扣金额", "应收金额", "实收金额", "未收金额", "回款金额", "回款日期" };
        java.util.Vector<String> vname = new java.util.Vector<String>();
        for (int a = 0; a < tname.length; a++) {
            vname.addElement(tname[i]);
        }
        tableModel = new DefaultTableModel(vname, 0);
        jTable1.setModel(tableModel);
        
    }
    
    public void jTdjh_keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            ActionEvent query = new ActionEvent(jBquery, 0, null);
            jBquery_actionPerformed(query);
        }
    }
}

class JF_view_hkgl_jBpd_actionAdapter implements ActionListener {
    private JF_view_hkgl adaptee;
    
    JF_view_hkgl_jBpd_actionAdapter(JF_view_hkgl adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBsave_actionPerformed(e);
    }
}

class JF_view_hkgl_jTdjh_keyAdapter extends KeyAdapter {
    private JF_view_hkgl adaptee;
    
    JF_view_hkgl_jTdjh_keyAdapter(JF_view_hkgl adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void keyPressed(KeyEvent e) {
        adaptee.jTdjh_keyPressed(e);
    }
}

class JF_view_hkgl_jBexit_actionAdapter implements ActionListener {
    private JF_view_hkgl adaptee;
    
    JF_view_hkgl_jBexit_actionAdapter(JF_view_hkgl adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBexit_actionPerformed(e);
    }
}

class JF_view_hkgl_jBquery_actionAdapter implements ActionListener {
    private JF_view_hkgl adaptee;
    
    JF_view_hkgl_jBquery_actionAdapter(JF_view_hkgl adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBquery_actionPerformed(e);
    }
}

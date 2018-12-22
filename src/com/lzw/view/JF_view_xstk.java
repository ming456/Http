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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultDesktopManager;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.lzw.dao.AdapterDao;
import com.lzw.model.Obj_SellDetaile;
import com.lzw.model.Obj_SellDetaileTh;
import com.lzw.model.Obj_Stock;
import com.lzw.model.obj_medicine;

public class JF_view_xstk extends JInternalFrame {
    private static final long serialVersionUID = -7367973658282186469L;
    BorderLayout borderLayout1 = new BorderLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JPanel jPanel1 = new JPanel();
    JTable jTable1 = new JTable();
    FlowLayout flowLayout1 = new FlowLayout();
    JButton jBth = new JButton();
    JButton jBexit = new JButton();
    DefaultTableModel tableModel = null;
    DefaultTableModel tableMode2 = null;
    JButton jBquery = new JButton();
    JLabel jLabel1 = new JLabel();
    JTextField jTdjh = new JTextField();
    JSplitPane jSplitPane1 = new JSplitPane();
    JScrollPane jScrollPane2 = new JScrollPane();
    JTable jTable2 = new JTable();
    Obj_SellDetaile selldetaile[] = null;
    
    public JF_view_xstk() {
        try {
            jbInit();
            buildTable();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void buildTable() {
        String[] tname = { "药品编号", "药品名称", "药品批号", "规格", "产地", "单位", "剂型", "有效期至" };
        String[] tname1 = { "销售流水号", "药品编号", "销售价格", "销售数量", "销售金额", "销售日期", "退库数量", "退库金额", "退库日期", "经办人" };
        Vector<String> vname = new Vector<String>();
        Vector<String> vname1 = new Vector<String>();
        for (int i = 0; i < tname.length; i++) {
            vname.addElement(tname[i]);
        }
        for (int i = 0; i < tname1.length; i++) {
            vname1.addElement(tname1[i]);
        }
        
        tableModel = new DefaultTableModel(vname, 0);
        tableMode2 = new DefaultTableModel(vname1, 0);
        jTable1.setModel(tableModel);
        jTable2.setModel(tableMode2);
        jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
    }
    
    private void jbInit() throws Exception {
        this.getContentPane().setLayout(borderLayout1);
        jPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.addMouseListener(new JF_view_xstk_jTable1_mouseAdapter(this));
        
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jBquery.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jBquery.setText("查询");
        jBquery.addActionListener(new JF_view_xstk_jBquery_actionAdapter(this));
        jBexit.addActionListener(new JF_view_xstk_jBexit_actionAdapter(this));
        jBth.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jBth.addActionListener(new JF_view_xstk_jBpd_actionAdapter(this));
        jBexit.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        this.setClosable(true);
        this.setTitle("医药综合管理系统-[销售退货]");
        jLabel1.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jLabel1.setText("销售单据号:");
        jTdjh.setPreferredSize(new Dimension(226, 27));
        jTdjh.setText("");
        jTdjh.addKeyListener(new JF_view_xstk_jTdjh_keyAdapter(this));
        flowLayout1.setHgap(10);
        jBth.setText("退货");
        jPanel1.setLayout(flowLayout1);
        jBexit.setText("退出");
        jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jPanel1.add(jLabel1);
        jPanel1.add(jTdjh);
        jPanel1.add(jBquery);
        jPanel1.add(jBth);
        jPanel1.add(jBexit);
        this.getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);
        jScrollPane1.getViewport().add(jTable1);
        jSplitPane1.add(jScrollPane1, JSplitPane.TOP);
        jSplitPane1.add(jScrollPane2, JSplitPane.BOTTOM);
        jScrollPane2.getViewport().add(jTable2);
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        
        setSize(700, 500);
        setVisible(true);
        jSplitPane1.setDividerLocation(110);
    }
    
    public void jBquery_actionPerformed(ActionEvent e) {
        if (jTdjh.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "销售单据号不允许为空,请输入!!!", "系统提示", JOptionPane.ERROR_MESSAGE);
            jTdjh.requestFocus();
            return;
        }
        String[] tname = { "药品编号", "药品名称", "药品批号", "规格", "产地", "单位", "剂型", "有效期至" };
        String[] tname1 = { "销售流水号", "药品编号", "销售价格", "销售数量", "销售金额", "销售日期", "退库数量", "退库金额", "退库日期", "经办人" };
        Vector<String> vname = new Vector<String>();
        Vector<String> vname1 = new Vector<String>();
        for (int i = 0; i < tname.length; i++) {
            vname.addElement(tname[i]);
        }
        for (int i = 0; i < tname1.length; i++) {
            vname1.addElement(tname1[i]);
        }
        
        tableModel = new DefaultTableModel(vname, 0);
        tableMode2 = new DefaultTableModel(vname1, 0);
        jTable1.setModel(tableModel);
        jTable2.setModel(tableMode2);
        
        String djh = null, queryStr = null;
        djh = jTdjh.getText().trim();
        queryStr = "FROM Obj_SellDetaile s JOIN s.medicine where s.thsts = 'F' and s.xsdjh = '" + djh + "'";
        List list = null;
        list = AdapterDao.QueryObject(queryStr);
        if (list.size() <= 0) {
            JOptionPane.showMessageDialog(null, "销售单据号码不存在或已经退货,请重新输入!!!", "系统提示", JOptionPane.ERROR_MESSAGE);
            jTdjh.requestFocus();
            return;
        }
        System.out.println(list.size());
        Object obj[] = null;
        selldetaile = new Obj_SellDetaile[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            obj = (Object[]) list.get(i);
            selldetaile[i] = (Obj_SellDetaile) obj[0];// 获得关联中的对象
            obj_medicine objmed = (obj_medicine) obj[1];
            Vector<Comparable> vdata = new Vector<Comparable>();
            vdata.addElement(objmed.getYpbh());
            vdata.addElement(objmed.getYpmc());
            vdata.addElement(objmed.getPh());
            vdata.addElement(objmed.getGg());
            vdata.addElement(objmed.getCd());
            vdata.addElement(objmed.getDw());
            vdata.addElement(objmed.getJx());
            vdata.addElement(objmed.getYxq());
            tableModel.addRow(vdata);
            
        }
        jTable1.setModel(tableModel);
        jTable1.setRowHeight(20);
    }
    
    public void jBexit_actionPerformed(ActionEvent e) {
        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "是否真的退出药品销售退货情况?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }
    }
    
    public void jBth_actionPerformed(ActionEvent e) {
        if (jTable2.getRowCount() <= 0)
            return;
        int result = JOptionPane.showOptionDialog(null, "是否存盘药品销售退货情况?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.NO_OPTION)
            return;
        
        Calendar calendar = null;
        Locale loc = new Locale("CN");
        calendar = Calendar.getInstance(loc);
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String rqStr = year + "-" + month + "-" + day;
        java.sql.Date thrq = java.sql.Date.valueOf(rqStr);
        // "销售价格","销售数量","销售金额","销售日期","退库金额","退库日期","经办人"
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            if (jTable1.getValueAt(i, 6) == null) {
                JOptionPane.showMessageDialog(null, "退库金额不允许为空,请录入!!!", "系统提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // "销售流水号","药品编号","销售价格","销售数量","销售金额","销售日期","退库数量","退库金额","退库日期","经办人"
            float xsje, thje;
            xsje = Float.parseFloat(String.valueOf(jTable2.getValueAt(i, 4)));
            thje = Float.parseFloat(String.valueOf(jTable2.getValueAt(i, 7)));
            if (thje != xsje) {
                JOptionPane.showMessageDialog(null, "退还金额【" + thje + "】必须等于销售金额【" + xsje + "】,请修改！！！", "系统提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Obj_SellDetaileTh selldetaileTh = new Obj_SellDetaileTh();
            selldetaileTh.setXslsh(jTable2.getValueAt(i, 0).toString());
            selldetaileTh.setYpbh(jTable2.getValueAt(i, 1).toString());
            selldetaileTh.setJbr("经办人");
            selldetaileTh.setThrq(thrq);
            
            selldetaileTh.setThsl(Integer.parseInt(jTable2.getValueAt(i, 6).toString()));
            selldetaileTh.setThje(Float.parseFloat(String.valueOf(thje)));
            selldetaileTh.setThje(thje);
            AdapterDao.InsertObj_SellDetaileTh(selldetaileTh);
            // 更新退货明晰表状态
            Obj_SellDetaile sell = selldetaile[i];
            sell.setThsts("T");
            AdapterDao.InsertSellDetaile(sell);
            // 更新盘点数据表中的库存数量
            String strSql = null;
            strSql = "from Obj_Stock where ypbh = '" + jTable2.getValueAt(i, 1).toString() + "'";
            List stockList = AdapterDao.QueryObject(strSql);
            Obj_Stock stock = (Obj_Stock) stockList.get(0);
            stock.setKcsl(stock.getKcsl() + selldetaileTh.getThsl());
            AdapterDao.InsertStock(stock);
        }
        JOptionPane.showMessageDialog(null, "销售退货数据存盘成功!!!", "系统提示", JOptionPane.OK_OPTION);
        ActionEvent frase = new ActionEvent(jBquery, 0, null);
        this.jBquery_actionPerformed(frase);
        
    }
    
    public void jTable1_mouseClicked(MouseEvent e) {
        if (jTable1.getRowCount() <= 0)
            return;
        java.util.Calendar calendar = null;
        Locale loc = new Locale("CN");
        calendar = Calendar.getInstance(loc);
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String rqStr = year + "-" + month + "-" + day;
        java.sql.Date thrq = java.sql.Date.valueOf(rqStr);
        
        int row = jTable1.getSelectedRow();
        Obj_SellDetaile sell = selldetaile[row];
        String hm = null, hm1 = null;
        hm = String.valueOf(jTable1.getValueAt(row, 0));
        System.out.println("hm = " + hm);
        if (jTable2.getRowCount() > 0) {
            for (int i = 0; i < jTable2.getRowCount(); i++) {
                hm1 = String.valueOf(jTable2.getValueAt(i, 1));
                System.out.println("hm1 = " + hm1);
                if (hm.equals(hm1))
                    return;
            }
            
        }
        Vector<Comparable> vdata = new Vector<Comparable>();
        vdata.addElement(sell.getXslsh());
        vdata.addElement(sell.getYpbh());
        vdata.addElement(String.valueOf(sell.getXsdj()));
        vdata.addElement(String.valueOf(sell.getXssl()));
        vdata.addElement(String.valueOf(sell.getXsje()));
        vdata.addElement(sell.getXsrq());
        vdata.addElement(String.valueOf(sell.getXssl()));
        vdata.addElement(String.valueOf(sell.getXsje()));
        vdata.addElement(thrq);
        tableMode2.addRow(vdata);
        jTable2.setRowHeight(20);
    }
    
    public void jTdjh_keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            ActionEvent query = new ActionEvent(jBquery, 0, null);
            this.jBquery_actionPerformed(query);
        }
    }
}

class JF_view_xstk_jBpd_actionAdapter implements ActionListener {
    private JF_view_xstk adaptee;
    
    JF_view_xstk_jBpd_actionAdapter(JF_view_xstk adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBth_actionPerformed(e);
    }
}

class JF_view_xstk_jBexit_actionAdapter implements ActionListener {
    private JF_view_xstk adaptee;
    
    JF_view_xstk_jBexit_actionAdapter(JF_view_xstk adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBexit_actionPerformed(e);
    }
}

class JF_view_xstk_jTable1_mouseAdapter extends MouseAdapter {
    private JF_view_xstk adaptee;
    
    JF_view_xstk_jTable1_mouseAdapter(JF_view_xstk adaptee) {
        this.adaptee = adaptee;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        adaptee.jTable1_mouseClicked(e);
    }
}

class JF_view_xstk_jBquery_actionAdapter implements ActionListener {
    private JF_view_xstk adaptee;
    
    JF_view_xstk_jBquery_actionAdapter(JF_view_xstk adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBquery_actionPerformed(e);
    }
}

class JF_view_xstk_jTdjh_keyAdapter extends KeyAdapter {
    private JF_view_xstk adaptee;
    
    JF_view_xstk_jTdjh_keyAdapter(JF_view_xstk adaptee) {
        this.adaptee = adaptee;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        adaptee.jTdjh_keyPressed(e);
    }
}

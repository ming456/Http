package com.lzw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.lzw.model.Obj_BuyDetaile;

public class JF_view_query_kcmx_rk extends JInternalFrame {
    /**
     * 
     */
    private static final long serialVersionUID = -6939254280695048011L;
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    GridLayout gridLayout1 = new GridLayout();
    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();
    FlowLayout flowLayout1 = new FlowLayout();
    JCheckBox jCheckBox1 = new JCheckBox();
    JLabel jLabel1 = new JLabel();
    JComboBox jCid = new JComboBox();
    JComboBox jCysf = new JComboBox();
    JTextField jTvalue = new JTextField();
    JCheckBox jCheckBox2 = new JCheckBox();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel6 = new JLabel();
    FlowLayout flowLayout2 = new FlowLayout();
    Border border1 = BorderFactory.createLineBorder(UIManager.getColor("ToolBar.dockingForeground"), 2);
    Border border2 = BorderFactory.createLineBorder(Color.magenta, 1);
    JButton jByes = new JButton();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable jTable1 = new JTable();
    JFormattedTextField jFormattedTextField1 = new JFormattedTextField();
    JFormattedTextField jFormattedTextField2 = new JFormattedTextField();
    
    String[] name = { "rkdjh", "rksl", "rkje" };
    int _idIndex, _ysfIndex;
    
    public JF_view_query_kcmx_rk() {
        _idIndex = 0;
        _ysfIndex = 0;
        try {
            buildTable();
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public void setjSpinner() {
    }
    
    private void jbInit() throws Exception {
        border2 = BorderFactory.createLineBorder(Color.magenta, 2);
        jFormattedTextField1.setEnabled(false);
        jFormattedTextField2.setEnabled(false);
        border1 = BorderFactory.createLineBorder(Color.red, 1);
        jCheckBox1.setSelected(true);
        jCheckBox1.setVisible(false);
        jCheckBox2.setSelected(false);
        jCysf.addItem("like");
        jCysf.addItem(">");
        jCysf.addItem("<");
        jCysf.addItem(">=");
        jCysf.addItem("<=");
        
        jCid.addItem("入库单据号");
        jCid.addItem("入库数量");
        jCid.addItem("入库金额");
        
        getContentPane().setLayout(borderLayout1);
        jCheckBox2.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jCheckBox2.setText("入库日期");
        jCheckBox2.addChangeListener(new JF_view_query_kcmx_rk_jCheckBox2_changeAdapter(this));
        jLabel2.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jLabel2.setText("起始日期:");
        jLabel3.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jLabel3.setText("终止日期:");
        jLabel4.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jLabel4.setText("运算符:");
        jLabel6.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jLabel6.setText("数值:");
        flowLayout1.setHgap(8);
        jPanel3.setLayout(flowLayout2);
        flowLayout2.setHgap(8);
        jCheckBox1.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jLabel1.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jCid.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jCid.setPreferredSize(new Dimension(97, 23));
        jCid.addItemListener(new JF_view_query_kcmx_rk_jCid_itemAdapter(this));
        jPanel2.setBorder(border1);
        jPanel3.setBorder(border2);
        jTvalue.setPreferredSize(new Dimension(156, 24));
        jCysf.setPreferredSize(new Dimension(53, 23));
        jCysf.addItemListener(new JF_view_query_kcmx_rk_jCysf_itemAdapter(this));
        jByes.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jByes.setText("查询");
        jByes.addActionListener(new JF_view_query_kcmx_rk_jByes_actionAdapter(this));
        jFormattedTextField1.setPreferredSize(new Dimension(139, 24));
        jFormattedTextField2.setPreferredSize(new Dimension(139, 24));
        this.setClosable(true);
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        jPanel2.setLayout(flowLayout1);
        jCheckBox1.setText("查询条件");
        jLabel1.setText("选择字段:");
        jPanel1.add(jPanel2);
        jPanel2.add(jCheckBox1);
        jPanel2.add(jLabel1);
        jPanel2.add(jCid);
        jPanel2.add(jLabel4);
        jPanel2.add(jCysf);
        jPanel2.add(jLabel6);
        jPanel2.add(jTvalue);
        
        jPanel1.add(jPanel3);
        jPanel3.add(jCheckBox2);
        jPanel3.add(jLabel2);
        jPanel3.add(jFormattedTextField1);
        jPanel3.add(jLabel3);
        jPanel3.add(jFormattedTextField2);
        jPanel3.add(jByes);
        this.getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jScrollPane1.getViewport().add(jTable1);
        gridLayout1.setColumns(1);
        gridLayout1.setRows(2);
        jPanel1.setLayout(gridLayout1);
        
        this.setSize(750, 550);
        this.setVisible(true);
    }
    
    public void buildTable() {// "药品名称","药品批号","规格","产地","单位",,"零售价","有效期至"
        String[] tname = { "入库单据号", "药品编号", "进货价格", "进货数量", "进货金额", "进货日期" };
        Vector<String> vname = new Vector<String>();
        for (int i = 0; i < tname.length; i++) {
            vname.addElement(tname[i]);
        }
        DefaultTableModel tableModel = null;
        tableModel = new DefaultTableModel(vname, 0);
        jTable1.setModel(tableModel);
        TableColumnModel tcm = jTable1.getColumnModel();
        
    }
    
    public void jCheckBox2_stateChanged(ChangeEvent e) {
        if (jCheckBox2.isSelected()) {
            jFormattedTextField1.setEnabled(true);
            jFormattedTextField2.setEnabled(true);
            long nCurrentTime = System.currentTimeMillis();
            java.util.Calendar calendar = java.util.Calendar.getInstance(new Locale("CN"));
            calendar.setTimeInMillis(nCurrentTime);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            String mm, dd;
            if (month < 10) {
                mm = "0" + String.valueOf(month);
            } else {
                mm = String.valueOf(month);
            }
            if (day < 10) {
                dd = "0" + String.valueOf(day);
            } else {
                dd = String.valueOf(day);
            }
            
            java.sql.Date date = java.sql.Date.valueOf(year + "-" + mm + "-" + dd);
            jFormattedTextField1.setText(String.valueOf(date));
            jFormattedTextField2.setText(String.valueOf(date));
            
        } else {
            jFormattedTextField1.setEnabled(false);
            jFormattedTextField2.setEnabled(false);
            jFormattedTextField1.setText(String.valueOf(""));
            jFormattedTextField2.setText(String.valueOf(""));
        }
        
    }
    
    public void jByes_actionPerformed(ActionEvent e) {
        if (jCheckBox1.isSelected()) {
            if (jTvalue.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null, "请输入查询数值!!", "提示", JOptionPane.ERROR_MESSAGE);
                jTvalue.requestFocus();
                return;
            }
        }
        
        String[] tname = { "入库单据号", "药品编号", "进货价格", "进货数量", "进货金额", "进货日期" };
        Vector<String> vname = new Vector<String>();
        for (int i = 0; i < tname.length; i++) {
            vname.addElement(tname[i]);
        }
        DefaultTableModel tableModel = null;
        tableModel = new DefaultTableModel(vname, 0);
        jTable1.setModel(tableModel);
        
        String whereStr = null, queryStr = null;
        System.out.println(_ysfIndex);
        if (jCheckBox1.isSelected() && !jCheckBox2.isSelected()) {
            if (_ysfIndex == 0) {
                whereStr = name[_idIndex] + " " + jCysf.getSelectedItem() + " '%" + jTvalue.getText().trim() + "%'";
            } else {
                whereStr = name[_idIndex] + " " + jCysf.getSelectedItem() + " '" + jTvalue.getText().trim() + "'";
            }
            
        } else if (jCheckBox1.isSelected() && jCheckBox2.isSelected()) {
            java.sql.Date date1, date2;
            try {
                date1 = java.sql.Date.valueOf(jFormattedTextField1.getText().trim());
                date2 = java.sql.Date.valueOf(jFormattedTextField2.getText().trim());
                System.out.println("date1 = " + date1 + "; date2 = " + date2);
                jFormattedTextField1.setText(String.valueOf(date1));
                jFormattedTextField2.setText(String.valueOf(date2));
                if (date1.after(date2)) {
                    JOptionPane.showMessageDialog(null, "输入的起始日期不能小于终止日期!!!", "系统提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (java.lang.NumberFormatException formate) {
                JOptionPane.showMessageDialog(null, "输入的日期有误!!!\n" + formate.getMessage(), "系统提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (_ysfIndex == 0) {
                whereStr = name[_idIndex] + " " + jCysf.getSelectedItem() + " '%" + jTvalue.getText().trim() + "%' and rkrq >= '" + date1 + "' and rkrq <= '"
                        + date2 + "'";
            } else {
                whereStr = name[_idIndex] + " " + jCysf.getSelectedItem() + " '" + jTvalue.getText().trim() + "' and rkrq >= '" + date1 + "' and rkrq <= '"
                        + date2 + "'";
            }
            
        } else if (!jCheckBox1.isSelected() && jCheckBox2.isSelected()) {
            java.sql.Date date1, date2;
            try {
                date1 = java.sql.Date.valueOf(jFormattedTextField1.getText().trim());
                date2 = java.sql.Date.valueOf(jFormattedTextField2.getText().trim());
                System.out.println("date1 = " + date1 + "; date2 = " + date2);
                jFormattedTextField1.setText(String.valueOf(date1));
                jFormattedTextField2.setText(String.valueOf(date2));
                if (date1.after(date2)) {
                    JOptionPane.showMessageDialog(null, "输入的起始日期不能小于终止日期!!!", "系统提示", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (java.lang.NumberFormatException formate) {
                JOptionPane.showMessageDialog(null, "输入的日期有误!!!\n" + formate.getMessage(), "系统提示", JOptionPane.ERROR_MESSAGE);
                return;
            }
            whereStr = " rkrq >= '" + date1 + "' and rkrq <= '" + date2 + "'";
            
        } else if (!jCheckBox1.isSelected() && !jCheckBox2.isSelected()) {
            return;
        }
        queryStr = " from Obj_BuyDetaile where " + whereStr;
        List list = com.lzw.dao.AdapterDao.QueryObject(queryStr);
        if (list.size() <= 0) {
            JOptionPane.showMessageDialog(null, "没有找到满足条件的数据!!", "系统提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int rowcount = jTable1.getRowCount();
        
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Obj_BuyDetaile buy = (Obj_BuyDetaile) iterator.next();
            Vector<Comparable> vdata = new Vector<Comparable>();
            vdata.addElement(buy.getRkdjh());
            vdata.addElement(buy.getYpbh());
            vdata.addElement(String.valueOf(buy.getRkdj()));
            vdata.addElement(String.valueOf(buy.getRksl()));
            vdata.addElement(String.valueOf(buy.getRkje()));
            vdata.addElement(buy.getRkrq());
            
            tableModel.addRow(vdata);
        }
        jTable1.setModel(tableModel);
        jTable1.setRowHeight(20);
    }
    
    public void jCid_itemStateChanged(ItemEvent e) {
        _idIndex = jCid.getSelectedIndex();
    }
    
    public void jCysf_itemStateChanged(ItemEvent e) {
        _ysfIndex = jCysf.getSelectedIndex();
    }
}

class JF_view_query_kcmx_rk_jByes_actionAdapter implements ActionListener {
    private JF_view_query_kcmx_rk adaptee;
    
    JF_view_query_kcmx_rk_jByes_actionAdapter(JF_view_query_kcmx_rk adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jByes_actionPerformed(e);
    }
}

class JF_view_query_kcmx_rk_jCid_itemAdapter implements ItemListener {
    private JF_view_query_kcmx_rk adaptee;
    
    JF_view_query_kcmx_rk_jCid_itemAdapter(JF_view_query_kcmx_rk adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void itemStateChanged(ItemEvent e) {
        adaptee.jCid_itemStateChanged(e);
    }
}

class JF_view_query_kcmx_rk_jCysf_itemAdapter implements ItemListener {
    private JF_view_query_kcmx_rk adaptee;
    
    JF_view_query_kcmx_rk_jCysf_itemAdapter(JF_view_query_kcmx_rk adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void itemStateChanged(ItemEvent e) {
        adaptee.jCysf_itemStateChanged(e);
    }
}

class JF_view_query_kcmx_rk_jCheckBox2_changeAdapter implements ChangeListener {
    private JF_view_query_kcmx_rk adaptee;
    
    JF_view_query_kcmx_rk_jCheckBox2_changeAdapter(JF_view_query_kcmx_rk adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void stateChanged(ChangeEvent e) {
        adaptee.jCheckBox2_stateChanged(e);
    }
}

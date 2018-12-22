package com.lzw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultDesktopManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.lzw.constrol.BuildTable;
import com.lzw.model.Obj_client;
import com.lzw.model.Obj_gys;
import com.lzw.model.obj_medicine;

public class JF_view_query_jbqk extends JInternalFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 3596698860893885615L;
    
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable jTable1 = new JTable();
    FlowLayout flowLayout1 = new FlowLayout();
    JLabel jLabel1 = new JLabel();
    JComboBox jCobj = new JComboBox();
    Border border1 = BorderFactory.createLineBorder(SystemColor.controlText, 2);
    Border border2 = new TitledBorder(border1, "查询参数设置");
    JLabel jLabel2 = new JLabel();
    JComboBox jCid = new JComboBox();
    JComboBox jCysf = new JComboBox();
    JLabel jLabel3 = new JLabel();
    JTextField jTvalue = new JTextField();
    JButton jByes = new JButton();
    JButton jBquit = new JButton();
    Object[] object = { new obj_medicine(), new Obj_client(), new Obj_gys() };
    String[] name = { "ypbh", "pym" };
    int _objIndex = 0, _idIndex = 0, _ysfIndex = 0;
    private DefaultTableModel defaultmodel;
    private BuildTable buildTable;
    
    public JF_view_query_jbqk() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        buildTable = new BuildTable();
        defaultmodel = buildTable.getGysTableModel("From Obj_gys");
        jTable1.setModel(defaultmodel);
    }
    
    private void jbInit() throws Exception {
        jCobj.addItem("药品基本信息");
        jCobj.addItem("客户基本信息");
        jCobj.addItem("供应商基本信息");
        jCysf.addItem("like");
        jCysf.addItem(">");
        jCysf.addItem("<");
        jCid.addItem("信息编号");
        jCid.addItem("拼音码");
        border2 = new TitledBorder(border1, "设置查询参数", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("新宋体", 0, 12),
                Color.red);
        
        this.getContentPane().setLayout(borderLayout1);
        jCobj.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jCobj.addItemListener(new JF_view_query_jbqk_jCobj_itemAdapter(this));
        jLabel3.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jLabel3.setText("数值:");
        jTvalue.setMinimumSize(new Dimension(106, 21));
        jTvalue.setPreferredSize(new Dimension(136, 24));
        jTvalue.setText("");
        jByes.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jByes.setText("查询");
        jByes.addActionListener(new JF_view_query_jbqk_jByes_actionAdapter(this));
        jBquit.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jBquit.setText("关闭");
        jLabel1.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jLabel2.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jCid.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jCid.addItemListener(new JF_view_query_jbqk_jCid_itemAdapter(this));
        jCysf.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        flowLayout1.setHgap(8);
        flowLayout1.setVgap(8);
        borderLayout1.setVgap(3);
        this.setClosable(true);
        this.setMaximizable(true);
        jCysf.addItemListener(new JF_view_query_jbqk_jCysf_itemAdapter(this));
        jCobj.setPreferredSize(new Dimension(133, 25));
        jCid.setPreferredSize(new Dimension(95, 25));
        jCysf.setPreferredSize(new Dimension(85, 25));
        jTvalue.addKeyListener(new JF_view_query_jbqk_jTvalue_keyAdapter(this));
        jBquit.addActionListener(new JF_view_query_jbqk_jBquit_actionAdapter(this));
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        jPanel1.setFont(new java.awt.Font("新宋体", Font.PLAIN, 12));
        jPanel1.setBorder(border2);
        jLabel2.setText("运算符:");
        jPanel1.add(jCobj);
        jPanel1.add(jLabel1);
        jPanel1.add(jCid);
        jPanel1.add(jLabel2);
        jPanel1.add(jCysf);
        jPanel1.add(jLabel3);
        jPanel1.add(jTvalue);
        jPanel1.add(jByes);
        jPanel1.add(jBquit);
        jLabel1.setText("查询字段:");
        jPanel1.setLayout(flowLayout1);
        this.getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jScrollPane1.getViewport().add(jTable1);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setSize(850, 550);
        this.setVisible(true);
    }
    
    public void jCobj_itemStateChanged(ItemEvent e) {
        _objIndex = jCobj.getSelectedIndex();
        if (_objIndex == 0) {
            name[0] = "ypbh";
            name[1] = "pym";
        }
        if (_objIndex == 1) {
            name[0] = "khbh";
            name[1] = "pym";
        }
        if (_objIndex == 2) {
            name[0] = "gysbh";
            name[1] = "pym";
        }
        System.out.println(_objIndex);
    }
    
    public void jByes_actionPerformed(ActionEvent e) {
        if (jTvalue.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "请输入查询数值!!", "提示", JOptionPane.ERROR_MESSAGE);
            jTvalue.requestFocus();
            return;
        }
        int choose;
        choose = jCobj.getSelectedIndex();
        String queryStr = null, whereStr = null;
        
        if (_ysfIndex == 0) {
            whereStr = name[_idIndex] + " " + String.valueOf(jCysf.getItemAt(_ysfIndex)) + " '%" + jTvalue.getText().trim() + "%'";
        } else {
            whereStr = name[_idIndex] + " " + String.valueOf(jCysf.getItemAt(_ysfIndex)) + " '" + jTvalue.getText().trim() + "'";
        }
        
        switch (choose) {
            case 0:
                queryStr = " From  obj_medicine where " + whereStr;
                defaultmodel = buildTable.getmedicineTableModel(queryStr);
                break;
            case 1:
                queryStr = " From  Obj_client where " + whereStr;
                defaultmodel = buildTable.getClientTableModel(queryStr);
                break;
            case 2:
                queryStr = " From  Obj_gys where " + whereStr;
                defaultmodel = buildTable.getGysTableModel(queryStr);
                break;
        }
        jTable1.setModel(defaultmodel);
        if (jTable1.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(null, "没有找到满足条件的数据!!!", "系统提示", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void jCid_itemStateChanged(ItemEvent e) {
        System.out.println(_idIndex);
        _idIndex = jCid.getSelectedIndex();
    }
    
    public void jCysf_itemStateChanged(ItemEvent e) {
        _ysfIndex = jCysf.getSelectedIndex();
    }
    
    public void jTvalue_keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            ActionEvent yesevent = new ActionEvent(jByes, 0, null);
            this.jByes_actionPerformed(yesevent);
        }
    }
    
    public void jBquit_actionPerformed(ActionEvent actionEvent) {
        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "是否真的退出基本信息查询?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "是", "否" }, "否");
        if (result == JOptionPane.YES_OPTION) {
            try {
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            manger.closeFrame(this);
        }
        
    }
    
}

class JF_view_query_jbqk_jBquit_actionAdapter implements ActionListener {
    private JF_view_query_jbqk adaptee;
    
    JF_view_query_jbqk_jBquit_actionAdapter(JF_view_query_jbqk adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jBquit_actionPerformed(actionEvent);
    }
}

class JF_view_query_jbqk_jTvalue_keyAdapter extends KeyAdapter {
    private JF_view_query_jbqk adaptee;
    
    JF_view_query_jbqk_jTvalue_keyAdapter(JF_view_query_jbqk adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void keyPressed(KeyEvent e) {
        adaptee.jTvalue_keyPressed(e);
    }
}

class JF_view_query_jbqk_jCysf_itemAdapter implements ItemListener {
    private JF_view_query_jbqk adaptee;
    
    JF_view_query_jbqk_jCysf_itemAdapter(JF_view_query_jbqk adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void itemStateChanged(ItemEvent e) {
        adaptee.jCysf_itemStateChanged(e);
    }
}

class JF_view_query_jbqk_jCid_itemAdapter implements ItemListener {
    private JF_view_query_jbqk adaptee;
    
    JF_view_query_jbqk_jCid_itemAdapter(JF_view_query_jbqk adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void itemStateChanged(ItemEvent e) {
        adaptee.jCid_itemStateChanged(e);
    }
}

class JF_view_query_jbqk_jByes_actionAdapter implements ActionListener {
    private JF_view_query_jbqk adaptee;
    
    JF_view_query_jbqk_jByes_actionAdapter(JF_view_query_jbqk adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jByes_actionPerformed(e);
    }
}

class JF_view_query_jbqk_jCobj_itemAdapter implements ItemListener {
    private JF_view_query_jbqk adaptee;
    
    JF_view_query_jbqk_jCobj_itemAdapter(JF_view_query_jbqk adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void itemStateChanged(ItemEvent e) {
        adaptee.jCobj_itemStateChanged(e);
    }
}

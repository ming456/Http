package com.lzw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.lzw.constrol.BuildTable;
import com.lzw.constrol.JTkeyAdapter;
import com.lzw.dao.AdapterDao;
import com.lzw.model.Obj_gys;

public class JF_view_gys extends JInternalFrame {
    /**
     * 
     */
    private static final long serialVersionUID = -1393675697042100405L;
    BorderLayout borderLayout1 = new BorderLayout();
    JTabbedPane jTabbedPane1 = new JTabbedPane();
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    BorderLayout borderLayout2 = new BorderLayout();
    JPanel jPanel3 = new JPanel();
    JPanel jPanel4 = new JPanel();
    JButton jBadd = new JButton();
    JButton jBsave = new JButton();
    JButton jBexit = new JButton();
    GridLayout gridLayout1 = new GridLayout();
    JLabel jLabel1 = new JLabel();
    JTextField jTextField1 = new JTextField();
    JLabel jLabel2 = new JLabel();
    JTextField jTextField2 = new JTextField();
    JLabel jLabel3 = new JLabel();
    JTextField jTextField3 = new JTextField();
    JLabel jLabel4 = new JLabel();
    JTextField jTextField4 = new JTextField();
    JLabel jLabel5 = new JLabel();
    JTextField jTextField5 = new JTextField();
    JLabel jLabel6 = new JLabel();
    JTextField jTextField6 = new JTextField();
    JLabel jLabel7 = new JLabel();
    JTextField jTextField7 = new JTextField();
    JLabel jLabel8 = new JLabel();
    JTextField jTextField8 = new JTextField();
    JLabel jLabel9 = new JLabel();
    JTextField jTextField9 = new JTextField();
    JLabel jLabel10 = new JLabel();
    JTextField jTextField10 = new JTextField();
    FlowLayout flowLayout1 = new FlowLayout();
    JButton jBmodi = new JButton();
    BorderLayout borderLayout3 = new BorderLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable jTable1 = new JTable();
    JButton jBlookAll = new JButton();
    JPanel jPanel6 = new JPanel();
    FlowLayout flowLayout2 = new FlowLayout();
    JButton jButton2 = new JButton();
    JButton jBquery = new JButton();
    JLabel jLabel11 = new JLabel();
    JComboBox jComboBox1 = new JComboBox();
    JLabel jLabel12 = new JLabel();
    JComboBox jComboBox2 = new JComboBox();
    JLabel jLabel13 = new JLabel();
    JTextField jTvalue = new JTextField();
    BuildTable buildTable = new BuildTable();
    JLabel jLabel14 = new JLabel();
    JTextField jTbh = new JTextField();
    Border border1 = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.white, new Color(148, 145, 140));
    
    public JF_view_gys() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    private void jbInit() throws Exception {
        jComboBox1.addItem("供应商编号");
        jComboBox1.addItem("拼音编码");
        jComboBox2.addItem(">");
        jComboBox2.addItem("like");
        jComboBox2.addItem("<");
        getContentPane().setLayout(borderLayout1);
        jPanel1.setLayout(borderLayout2);
        jBadd.setText("添加");
        jBadd.addActionListener(new JF_view_gys_jBadd_actionAdapter(this));
        jBsave.setText("存盘");
        jBsave.addActionListener(new JF_view_gys_jBsave_actionAdapter(this));
        jBexit.setText("关闭");
        jBexit.addActionListener(new JF_view_gys_jBexit_actionAdapter(this));
        jPanel4.setLayout(gridLayout1);
        gridLayout1.setColumns(4);
        gridLayout1.setHgap(6);
        gridLayout1.setRows(5);
        jLabel1.setText("供应商编号");
        jTextField1.setText("");
        jLabel2.setText("供应商名称");
        jTextField2.setText("");
        jLabel3.setText("拼音编码");
        jTextField3.setText("");
        jLabel4.setText("供应商地址");
        jTextField4.setText("");
        jLabel5.setText("所属地区");
        jTextField5.setText("");
        jLabel6.setText("邮政编码");
        jTextField6.setText("");
        jLabel7.setText("联系电话");
        jTextField7.setText("");
        jLabel8.setText("联系人");
        jTextField8.setText("");
        jLabel9.setText("开户银行");
        jTextField9.setText("");
        jLabel10.setText("开户账号");
        jTextField10.setText("");
        
        jPanel3.setLayout(flowLayout1);
        flowLayout1.setAlignment(FlowLayout.CENTER);
        flowLayout1.setHgap(10);
        borderLayout2.setHgap(1);
        borderLayout2.setVgap(5);
        jBmodi.setText("修改");
        jBmodi.addActionListener(new JF_view_gys_jBmodi_actionAdapter(this));
        jPanel2.setLayout(borderLayout3);
        jTabbedPane1.addChangeListener(new JF_view_gys_jTabbedPane1_changeAdapter(this));
        jBlookAll.setText("全部查看");
        jBlookAll.addActionListener(new JF_view_gys_jBlookAll_actionAdapter(this));
        jPanel6.setLayout(flowLayout2);
        flowLayout2.setAlignment(FlowLayout.CENTER);
        jButton2.setText("退出");
        jButton2.addActionListener(new JF_view_gys_jButton2_actionAdapter(this));
        jBquery.setText("检索");
        jBquery.addActionListener(new JF_view_gys_jButton3_actionAdapter(this));
        jLabel11.setText("类别:");
        jComboBox1.setMinimumSize(new Dimension(100, 22));
        jComboBox1.setPreferredSize(new Dimension(110, 22));
        jLabel12.setText("运算符:");
        jLabel13.setText("数值:");
        jTvalue.setPreferredSize(new Dimension(169, 26));
        jComboBox2.setPreferredSize(new Dimension(50, 22));
        jLabel14.setText("请输入供应商编号:");
        jTbh.setPreferredSize(new Dimension(200, 28));
        jTbh.setText("");
        jTbh.addKeyListener(new JF_view_gys_jTbh_keyAdapter(this));
        jPanel6.setBorder(BorderFactory.createLoweredBevelBorder());
        jPanel3.setBorder(BorderFactory.createLoweredBevelBorder());
        jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        jTabbedPane1.add(jPanel1, "基本信息录入");
        jTabbedPane1.add(jPanel2, "浏览全部数据");
        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);
        jPanel4.add(jLabel1);
        jPanel4.add(jTextField1);
        jPanel4.add(jLabel2);
        jPanel4.add(jTextField2);
        jPanel4.add(jLabel3);
        jPanel4.add(jTextField3);
        jPanel4.add(jLabel4);
        jPanel4.add(jTextField4);
        jPanel4.add(jLabel5);
        jPanel4.add(jTextField5);
        jPanel4.add(jLabel6);
        jPanel4.add(jTextField6);
        jPanel4.add(jLabel7);
        jPanel4.add(jTextField7);
        jPanel4.add(jLabel8);
        jPanel4.add(jTextField8);
        jPanel4.add(jLabel9);
        jPanel4.add(jTextField9);
        jPanel4.add(jLabel10);
        jPanel4.add(jTextField10);
        jPanel3.add(jLabel14);
        jPanel3.add(jTbh);
        jPanel3.add(jBmodi);
        jPanel3.add(jBadd);
        jPanel3.add(jBsave);
        jPanel3.add(jBexit);
        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jPanel2.add(jPanel6, java.awt.BorderLayout.NORTH);
        jPanel6.add(jLabel11);
        jPanel6.add(jComboBox1);
        jPanel6.add(jLabel12);
        jPanel6.add(jComboBox2);
        jPanel6.add(jLabel13);
        jPanel6.add(jTvalue);
        jPanel6.add(jBquery);
        jPanel6.add(jBlookAll);
        jPanel6.add(jButton2);
        jScrollPane1.getViewport().add(jTable1);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);
        jTextField1.addKeyListener(new JTkeyAdapter(jTextField2));
        jTextField2.addKeyListener(new JTkeyAdapter(jTextField3));
        jTextField3.addKeyListener(new JTkeyAdapter(jTextField4));
        jTextField4.addKeyListener(new JTkeyAdapter(jTextField5));
        jTextField5.addKeyListener(new JTkeyAdapter(jTextField6));
        jTextField6.addKeyListener(new JTkeyAdapter(jTextField7));
        jTextField7.addKeyListener(new JTkeyAdapter(jTextField8));
        jTextField8.addKeyListener(new JTkeyAdapter(jTextField9));
        jTextField9.addKeyListener(new JTkeyAdapter(jTextField10));
        jTextField10.addKeyListener(new JF_view_gys_jTbh_keyAdapter(this));
        this.setSize(700, 300);
        this.setVisible(true);
        this.setTitle("供应商基本信息情况");
        this.setClosable(true);
    }
    
    public void jBexit_actionPerformed(ActionEvent e) {
        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "是否真的退出供应商基本信息情况?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new String[] { "是", "否" }, "否");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }
    }
    
    public void jBsave_actionPerformed(ActionEvent e) {
        int result = JOptionPane.showOptionDialog(null, "是否进行供应商基本信息情况存盘?", "系统提示", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new String[] { "是", "否" }, "否");
        
        if (result == JOptionPane.NO_OPTION)
            return;
        
        /*---校验数据不允许为空----*/
        JTextField jText = null;
        String className = null;
        int count = jPanel4.getComponentCount();
        for (int i = 0; i <= count - 1; i++) {
            className = jPanel4.getComponent(i).getClass().getName();
            if (className.equals("javax.swing.JTextField")) {
                jText = (JTextField) jPanel4.getComponent(i);
                if (jText.getText().length() <= 0) {
                    JLabel jLstr = null;
                    jLstr = (JLabel) jPanel4.getComponent(i - 1);
                    JOptionPane.showMessageDialog(null, jLstr.getText() + "不允许为空,请录入!!!", "系统提示", JOptionPane.ERROR_MESSAGE);
                    jText.requestFocus();
                    return;
                }
            }
        }
        /*---执行添加数据到数据表中----*/
        Obj_gys objgys = new Obj_gys();
        objgys.setGysbh(jTextField1.getText().trim());
        objgys.setGysmc(jTextField2.getText().trim());
        objgys.setPym(jTextField3.getText().trim());
        objgys.setGysdz(jTextField4.getText().trim());
        objgys.setSsdq(jTextField5.getText().trim());
        objgys.setYzbm(jTextField6.getText().trim());
        objgys.setTel(jTextField7.getText().trim());
        objgys.setLxr(jTextField8.getText().trim());
        objgys.setKhyh(jTextField9.getText().trim());
        objgys.setKhzh(jTextField10.getText().trim());
        if (AdapterDao.insertmedicine(objgys)) {
            JOptionPane.showMessageDialog(null, "供应商基本数据录入成功", "系统提示", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "供应商基本数据存盘失败", "系统提示", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void jTabbedPane1_stateChanged(ChangeEvent e) {
        int index = jTabbedPane1.getSelectedIndex();
        if (index == 1) {
            
        }
    }
    
    public void jBlookAll_actionPerformed(ActionEvent e) {
        DefaultTableModel defaultModel;
        defaultModel = buildTable.getGysTableModel(" from Obj_gys ");
        jTable1.setModel(defaultModel);
        if (defaultModel == null) {
            JOptionPane.showMessageDialog(null, "没有查询到该条件下的数据", "系统提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        jTable1.setRowHeight(22);
        jTabbedPane1.setSelectedIndex(1);
        
    }
    
    public void jButton2_actionPerformed(ActionEvent e) {
        jBexit_actionPerformed(e);
    }
    
    public void jBquery_actionPerformed(ActionEvent e) {
        if (jTvalue.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "查询数值不能为空，请输入！！！", "系统提示", JOptionPane.ERROR_MESSAGE);
            jTvalue.requestFocus();
            return;
        }
        String queryName, queryYsf, queryValue;
        String[] queryName1 = { "gysbh", "pym" };
        int index1 = jComboBox1.getSelectedIndex();
        queryName = queryName1[index1];
        queryYsf = jComboBox2.getSelectedItem().toString().trim();
        if (queryYsf.equals("like") || queryYsf == "like") {
            queryValue = "%" + jTvalue.getText().trim() + "%";
        } else {
            queryValue = jTvalue.getText().trim();
        }
        
        String queryStr;
        queryStr = " from Obj_gys  where " + queryName + " " + queryYsf + " '" + queryValue + "'";
        
        DefaultTableModel defaultModel = null;
        defaultModel = buildTable.getGysTableModel(queryStr);
        jTable1.setModel(defaultModel);
        if (defaultModel.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(null, "没有查询到该条件下的数据", "系统提示", JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            return;
        }
        jTable1.setRowHeight(22);
        jTabbedPane1.setSelectedIndex(1);
    }
    
    public void jBadd_actionPerformed(ActionEvent e) {
        String QueryStr = null;
        QueryStr = "Select max(g.gysbh) from Obj_gys g";
        java.util.List list = null;
        list = AdapterDao.QueryObject(QueryStr);
        String bh;
        if (list.isEmpty()) {
            bh = "1000";
        } else {
            int max = Integer.parseInt(list.get(0).toString()) + 1;
            bh = String.valueOf(max);
        }
        jTextField1.setText(bh);
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTbh.setText("");
        jTextField2.requestFocus();
    }
    
    public void jTbh_keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource().equals(jTbh)) {
                String bh = jTbh.getText().trim();
                if (bh.length() <= 0) {
                    JOptionPane.showMessageDialog(null, "编号不允许为空!!!", "系统提示", JOptionPane.ERROR_MESSAGE);
                    jTbh.requestFocus();
                    return;
                }
                String QueryStr = null;
                java.util.List list = null;
                java.util.Iterator iterator = null;
                QueryStr = " from Obj_gys where gysbh = '" + bh + "'";
                list = AdapterDao.QueryObject(QueryStr);
                if (list.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "编号不存在请重新输入!!!", "系统提示", JOptionPane.ERROR_MESSAGE);
                    jTbh.requestFocus();
                    return;
                    
                }
                iterator = list.iterator();
                while (iterator.hasNext()) {
                    Obj_gys objgys = (Obj_gys) iterator.next();
                    jTextField1.setText(objgys.getGysbh());
                    jTextField2.setText(objgys.getGysmc());
                    jTextField3.setText(objgys.getPym());
                    jTextField4.setText(objgys.getGysdz());
                    jTextField5.setText(objgys.getSsdq());
                    jTextField6.setText(objgys.getYzbm());
                    jTextField7.setText(objgys.getTel());
                    jTextField8.setText(objgys.getLxr());
                    jTextField9.setText(objgys.getKhyh());
                    jTextField10.setText(objgys.getKhzh());
                }
                jTextField1.setEnabled(false);
                jTextField2.requestFocus();
                
            } else if (e.getSource().equals(jTextField10)) {
                ActionEvent save = new ActionEvent(jBsave, 0, null);
                this.jBsave_actionPerformed(save);
                
            }
        }
    }
    
    public void jBmodi_actionPerformed(ActionEvent e) {
        KeyEvent ke = new KeyEvent(jTbh, 0, 0, 0, KeyEvent.VK_ENTER, 'e', 0);
        jTbh_keyPressed(ke);
    }
}

class JF_view_gys_jBmodi_actionAdapter implements ActionListener {
    private JF_view_gys adaptee;
    
    JF_view_gys_jBmodi_actionAdapter(JF_view_gys adaptee) {
        this.adaptee = adaptee;
    }
    
     
    public void actionPerformed(ActionEvent e) {
        adaptee.jBmodi_actionPerformed(e);
    }
}

class JF_view_gys_jTbh_keyAdapter extends KeyAdapter {
    private JF_view_gys adaptee;
    
    JF_view_gys_jTbh_keyAdapter(JF_view_gys adaptee) {
        this.adaptee = adaptee;
    }
    
     
    public void keyPressed(KeyEvent e) {
        adaptee.jTbh_keyPressed(e);
    }
}

class JF_view_gys_jBadd_actionAdapter implements ActionListener {
    private JF_view_gys adaptee;
    
    JF_view_gys_jBadd_actionAdapter(JF_view_gys adaptee) {
        this.adaptee = adaptee;
    }
    
     
    public void actionPerformed(ActionEvent e) {
        adaptee.jBadd_actionPerformed(e);
    }
}

class JF_view_gys_jButton3_actionAdapter implements ActionListener {
    private JF_view_gys adaptee;
    
    JF_view_gys_jButton3_actionAdapter(JF_view_gys adaptee) {
        this.adaptee = adaptee;
    }
    
     
    public void actionPerformed(ActionEvent e) {
        adaptee.jBquery_actionPerformed(e);
    }
}

class JF_view_gys_jButton2_actionAdapter implements ActionListener {
    private JF_view_gys adaptee;
    
    JF_view_gys_jButton2_actionAdapter(JF_view_gys adaptee) {
        this.adaptee = adaptee;
    }
    
     
    public void actionPerformed(ActionEvent e) {
        adaptee.jButton2_actionPerformed(e);
    }
}

class JF_view_gys_jBlookAll_actionAdapter implements ActionListener {
    private JF_view_gys adaptee;
    
    JF_view_gys_jBlookAll_actionAdapter(JF_view_gys adaptee) {
        this.adaptee = adaptee;
    }
    
     
    public void actionPerformed(ActionEvent e) {
        adaptee.jBlookAll_actionPerformed(e);
    }
}

class JF_view_gys_jTabbedPane1_changeAdapter implements ChangeListener {
    private JF_view_gys adaptee;
    
    JF_view_gys_jTabbedPane1_changeAdapter(JF_view_gys adaptee) {
        this.adaptee = adaptee;
    }
    
     
    public void stateChanged(ChangeEvent e) {
        adaptee.jTabbedPane1_stateChanged(e);
    }
}

class JF_view_gys_jBsave_actionAdapter implements ActionListener {
    private JF_view_gys adaptee;
    
    JF_view_gys_jBsave_actionAdapter(JF_view_gys adaptee) {
        this.adaptee = adaptee;
    }
    
     
    public void actionPerformed(ActionEvent e) {
        adaptee.jBsave_actionPerformed(e);
    }
}

class JF_view_gys_jBexit_actionAdapter implements ActionListener {
    private JF_view_gys adaptee;
    
    JF_view_gys_jBexit_actionAdapter(JF_view_gys adaptee) {
        this.adaptee = adaptee;
    }
    
     
    public void actionPerformed(ActionEvent e) {
        adaptee.jBexit_actionPerformed(e);
    }
}

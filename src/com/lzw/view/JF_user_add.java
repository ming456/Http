package com.lzw.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultDesktopManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.lzw.constrol.JTkeyAdapter;

public class JF_user_add extends javax.swing.JInternalFrame {// JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = -5257947703495710870L;
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel2 = new JPanel();
    FlowLayout flowLayout1 = new FlowLayout();
    JButton jBadd = new JButton();
    JButton jBsave = new JButton();
    JButton jBexit = new JButton();
    
    javax.sql.DataSource ds = null;
    java.sql.Connection con = null;
    java.sql.Statement stmt = null;
    java.sql.ResultSet rs = null;
    
    DefaultTableModel defaultModel = null;
    JPanel jPanel1 = new JPanel();
    GridLayout gridLayout1 = new GridLayout();
    JLabel jLabel1 = new JLabel();
    JTextField jTid = new JTextField();
    JLabel jLabel2 = new JLabel();
    JTextField jTname = new JTextField();
    JLabel jLabel3 = new JLabel();
    JPasswordField jPass = new JPasswordField();
    JLabel jLabel4 = new JLabel();
    JPasswordField jPassconf = new JPasswordField();
    
    public JF_user_add() {
        try {
            jbInit();
            jTid.setText("");
            jTid.requestFocus();
            jTname.addKeyListener(new JTkeyAdapter(jPass));
            jPass.addKeyListener(new JTkeyAdapter(jPassconf));
            // buildeTable();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public String getID() {
        String maxid = "", newid = "";
        String queryStr = "select max(userid) as id from Obj_UserName";
        java.util.List list = com.lzw.dao.AdapterDao.QueryObject(queryStr);
        if (list.size() > 0) {
            maxid = String.valueOf(list.get(0));
            newid = String.valueOf(Integer.parseInt(maxid) + 1);
        }
        
        return newid;
    }
    
    public void buildeTable() {
        java.util.Vector<String> vname = new java.util.Vector<String>();
        vname.addElement("�û�ID");
        vname.addElement("�û�����");
        vname.addElement("�û�����");
        vname.addElement("�ظ�����");
        defaultModel = new DefaultTableModel(vname, 0);
        
        ds = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            stmt.execute("select * from t_user");
            rs = stmt.getResultSet();
            while (rs.next()) {
                java.util.Vector<String> vdata = new java.util.Vector<String>();
                vdata.addElement(rs.getString("id").trim());
                vdata.addElement(rs.getString("name").trim());
                vdata.addElement(rs.getString("pass").trim());
                vdata.addElement(rs.getString("passconf").trim());
                defaultModel.addRow(vdata);
            }
            con.close();
        } catch (java.sql.SQLException sql) {
            sql.printStackTrace();
        }
        
    }
    
    private void jbInit() throws Exception {
        getContentPane().setLayout(borderLayout1);
        jPanel2.setLayout(flowLayout1);
        jBadd.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        jBadd.setText("����");
        jBadd.addActionListener(new JF_user_add_jBadd_actionAdapter(this));
        jBsave.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        jBsave.setText("����");
        jBsave.addActionListener(new JF_user_add_jBsave_actionAdapter(this));
        jBexit.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        jBexit.setText("�˳�");
        jBexit.addActionListener(new JF_user_add_jBexit_actionAdapter(this));
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        jPanel1.setLayout(gridLayout1);
        gridLayout1.setColumns(4);
        gridLayout1.setRows(2);
        jLabel1.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("�û�ID");
        jTid.setText("");
        jTid.addKeyListener(new JF_user_add_jTid_keyAdapter(this));
        jLabel2.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("�û�����");
        jTname.setText("");
        jLabel3.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("�û�����");
        jPass.setText("");
        jLabel4.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("�ظ�����");
        jPassconf.setText("");
        this.setClosable(true);
        this.setTitle("�û������Ϣ����");
        this.getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);
        jPanel2.add(jBadd);
        jPanel2.add(jBsave);
        jPanel2.add(jBexit);
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        jPanel1.add(jLabel1);
        jPanel1.add(jTid);
        jPanel1.add(jLabel2);
        jPanel1.add(jTname);
        jPanel1.add(jLabel3);
        jPanel1.add(jPass);
        jPanel1.add(jLabel4);
        jPanel1.add(jPassconf);
        
        this.setBounds(50, 50, 400, 120);
        this.setVisible(true);
    }
    
    public void jBadd_actionPerformed(ActionEvent actionEvent) {
        jTid.setText("");
        jTname.setText("");
        jPass.setText("");
        jPassconf.setText("");
        jTname.requestFocus();
        jBsave.setEnabled(true);
    }
    
    public void jBsave_actionPerformed(ActionEvent actionEvent) {
        int result = JOptionPane.showOptionDialog(null, "�Ƿ������µ��û���Ϣ?", "ϵͳ��ʾ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "��", "��" }, "��");
        if (result == JOptionPane.NO_OPTION)
            return;
        
        if (jTid.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "�û�ID������Ϊ��,��¼��!!!", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            jTid.requestFocus();
            return;
        }
        if (jTname.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "�û�����������Ϊ��,��¼��!!!", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            jTname.requestFocus();
            return;
        }
        if (jPass.getPassword().toString().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "�û��������Ϊ��,��¼��!!!", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            jPass.requestFocus();
            return;
        }
        if (jPassconf.getPassword().toString().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "�ظ��������Ϊ��,��¼��!!!", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            jPassconf.requestFocus();
            return;
        }
        String password, password1;
        password = new String(jPass.getPassword());
        password1 = new String(jPassconf.getPassword());
        
        if (!(password.equals(password1))) {
            JOptionPane.showMessageDialog(null, "��������ο��һ��,������¼��!!!", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            jPassconf.requestFocus();
            return;
        }
        String id, user, pass, passconf;
        id = jTid.getText().trim();
        user = jTname.getText().trim();
        pass = String.valueOf(jPass.getPassword());
        passconf = String.valueOf(jPassconf.getPassword());
        
        com.lzw.model.Obj_UserName objuser = new com.lzw.model.Obj_UserName();
        objuser.setUserid(id);
        objuser.setUsername(user);
        objuser.setPassword(pass);
        objuser.setPassconf(passconf);
        
        com.lzw.dao.AdapterDao.InsertObj_UserName(objuser);
        JOptionPane.showMessageDialog(null, "���û���ӳɹ�!!!", "ϵͳ��ʾ", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public void jBexit_actionPerformed(ActionEvent actionEvent) {
        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "�Ƿ��˳��û�����ģ��?", "ϵͳ��ʾ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "��", "��" }, "��");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }
        
    }
    
    public void jTid_keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            String userid = jTid.getText().trim();
            String queryStr = " from Obj_UserName where userid = '" + userid + "'";
            java.util.List list = com.lzw.dao.AdapterDao.QueryObject(queryStr);
            java.util.Iterator iterator = list.iterator();
            if (iterator.hasNext()) {
                JOptionPane.showMessageDialog(null, "�û�ID�Ѿ���������������!!", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
                jTid.requestFocus();
                return;
            }
            jTname.requestFocus();
            
        }
    }
}

class JF_user_add_jTid_keyAdapter extends KeyAdapter {
    private JF_user_add adaptee;
    
    JF_user_add_jTid_keyAdapter(JF_user_add adaptee) {
        this.adaptee = adaptee;
    }
    
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        adaptee.jTid_keyPressed(keyEvent);
    }
}

class JF_user_add_jBexit_actionAdapter implements ActionListener {
    private JF_user_add adaptee;
    
    JF_user_add_jBexit_actionAdapter(JF_user_add adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jBexit_actionPerformed(actionEvent);
    }
}

class JF_user_add_jBsave_actionAdapter implements ActionListener {
    private JF_user_add adaptee;
    
    JF_user_add_jBsave_actionAdapter(JF_user_add adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jBsave_actionPerformed(actionEvent);
    }
}

class JF_user_add_jBadd_actionAdapter implements ActionListener {
    private JF_user_add adaptee;
    
    JF_user_add_jBadd_actionAdapter(JF_user_add adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jBadd_actionPerformed(actionEvent);
    }
}

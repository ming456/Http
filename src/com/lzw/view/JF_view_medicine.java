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
import java.util.Iterator;
import java.util.List;

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
import javax.swing.table.DefaultTableModel;

import com.lzw.constrol.BuildTable;
import com.lzw.constrol.JTkeyAdapter;
import com.lzw.dao.AdapterDao;
import com.lzw.model.Obj_Stock;
import com.lzw.model.Obj_gys;
import com.lzw.model.obj_medicine;

public class JF_view_medicine extends JInternalFrame {
    /**
     * 
     */
    private static final long serialVersionUID = -5089456104401918676L;
    BorderLayout borderLayout1 = new BorderLayout();
    JTabbedPane jTabbedPane1 = new JTabbedPane();
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    BorderLayout borderLayout2 = new BorderLayout();
    JPanel jPanel3 = new JPanel();
    JButton jBmodi = new JButton();
    JButton jBsave = new JButton();
    JButton jBadd = new JButton();
    JButton jBexit = new JButton();
    FlowLayout flowLayout2 = new FlowLayout();
    JPanel jPanel4 = new JPanel();
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
    JLabel jLabel7 = new JLabel();
    JTextField jTextField7 = new JTextField();
    JLabel jLabel8 = new JLabel();
    JLabel jLabel9 = new JLabel();
    JTextField jTextField9 = new JTextField();
    JLabel jLabel10 = new JLabel();
    JTextField jTextField10 = new JTextField();
    JLabel jLabel11 = new JLabel();
    JLabel jLabel12 = new JLabel();
    JLabel jLabel13 = new JLabel();
    JLabel jLabel14 = new JLabel();
    JTextField jTextField14 = new JTextField();
    JLabel jLabel15 = new JLabel();
    JTextField jTextField15 = new JTextField();
    JLabel jLabel16 = new JLabel();
    JTextField jTextField16 = new JTextField();
    JLabel jLabel17 = new JLabel();
    JTextField jTextField17 = new JTextField();
    JLabel jLabel18 = new JLabel();
    JLabel jLabel19 = new JLabel();
    JTextField jTextField19 = new JTextField();
    // �����������
    Object[] dw = { "��", "��", "��", "��", "��", "��", "Ƭ", "ƿ" };
    Object[] jyfs = { "����", "����" };
    Object[] zlbz = { "�й�ҩ��", "������ҩƷ��׼", "�ط�ҩƷ��׼", "���ڹ�ҩ��׼", "��ҵ��׼" };
    Object[] jx = { "���", "Ƭ��", "����", "�ڷ�Һ", "���", "���" };
    Object[] yxq = { "����", "һ��", "һ���", "����", "�����", "����", "��������" };
    Object[] lb = { "��ҩ", "��ҩ", "�г�ҩ", "�г�ҩ(����)", "����", "����" };
    // ���ù��췽��������Ӧ�Ķ���
    JComboBox jCdw = new JComboBox(dw);
    JComboBox jCzlbz = new JComboBox(zlbz);
    JComboBox jCjyfs = new JComboBox(jyfs);
    JComboBox jCyj = new JComboBox(jx);
    JComboBox jCyxq = new JComboBox(yxq);
    JComboBox jClb = new JComboBox(lb);
    BorderLayout borderLayout3 = new BorderLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable jTable1 = new JTable();
    JLabel jLabel21 = new JLabel();
    JTextField jTbh = new JTextField();
    JPanel jPanel5 = new JPanel();
    FlowLayout flowLayout1 = new FlowLayout();
    JLabel jLabel22 = new JLabel();
    JTextField jTvalue = new JTextField();
    JComboBox jCysf = new JComboBox();
    JLabel jLabel23 = new JLabel();
    JLabel jLabel24 = new JLabel();
    JComboBox jCzd = new JComboBox();
    JButton jBquery = new JButton();
    JButton jBlookall = new JButton();
    JButton jButton3 = new JButton();
    
    public JF_view_medicine() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    private void jbInit() throws Exception {
        jCzd.addItem("ҩƷ���");
        jCzd.addItem("ƴ������");
        jCysf.addItem("like");
        jCysf.addItem(">");
        jCysf.addItem("=");
        jCysf.addItem("<");
        jCdw.setEditable(true);
        jCdw.configureEditor(jCdw.getEditor(), "��");
        jCzlbz.setEditable(true);
        jCzlbz.configureEditor(jCzlbz.getEditor(), "�й�ҩ��");
        jCjyfs.setEditable(true);
        jCjyfs.configureEditor(jCjyfs.getEditor(), "����");
        jCyj.setEditable(true);
        jCyj.configureEditor(jCyj.getEditor(), "���");
        jCyxq.setEditable(true);
        jCyxq.configureEditor(jCyxq.getEditor(), "����");
        jClb.setEditable(true);
        jClb.configureEditor(jClb.getEditor(), "��ҩ");
        getContentPane().setLayout(borderLayout1);
        jPanel1.setLayout(borderLayout2);
        jBmodi.setText("�޸�");
        jBmodi.addActionListener(new JF_view_medicine_jBmodi_actionAdapter(this));
        jBsave.setText("����");
        jBsave.addActionListener(new JF_view_medicine_jBsave_actionAdapter(this));
        jBadd.setText("���");
        jBadd.addActionListener(new JF_view_medicine_jBadd_actionAdapter(this));
        jBexit.setText("�˳�");
        jBexit.addActionListener(new JF_view_medicine_jBexit_actionAdapter(this));
        jPanel2.setLayout(borderLayout3);
        jPanel3.setLayout(flowLayout2);
        jPanel4.setLayout(gridLayout1);
        gridLayout1.setColumns(4);
        gridLayout1.setRows(10);
        
        jLabel1.setText("ҩƷ���");
        jTextField1.setText("");
        jLabel2.setText("ҩƷ����");
        jTextField2.setText("");
        jLabel3.setText("ҩƷ����");
        jTextField3.setText("");
        jLabel4.setText("ͨ������");
        jTextField4.setText("");
        jLabel5.setText("ƴ����");
        jTextField5.setText("");
        jLabel6.setText("��λ");
        jLabel7.setText("���");
        jTextField7.setText("");
        jLabel8.setText("����");
        jLabel9.setText("����");
        jTextField9.setText("");
        jLabel10.setText("��װ����");
        jTextField10.setText("");
        jLabel11.setText("��Ч��");
        jLabel12.setText("������׼");
        jLabel13.setText("��Ӫ��ʽ");
        jLabel14.setText("����");
        jTextField14.setText("");
        jLabel15.setText("���ۼ۸�");
        jTextField15.setText("");
        jLabel16.setText("�����۸�");
        jTextField16.setText("");
        jLabel17.setText("�����۸�");
        jTextField17.setText("");
        jLabel18.setText("ҩƷ����");
        jLabel19.setText("ҽ�Ʊ��ձ��");
        jTextField19.setText("");
        flowLayout2.setAlignment(FlowLayout.RIGHT);
        
        jLabel21.setText("ҩƷ���");
        jTbh.setPreferredSize(new Dimension(126, 29));
        jTbh.setText("");
        jPanel1.setBorder(null);
        jPanel4.setBorder(BorderFactory.createLoweredBevelBorder());
        jPanel3.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanel5.setLayout(flowLayout1);
        jLabel22.setText("��ֵ:");
        jTvalue.setPreferredSize(new Dimension(110, 22));
        jTvalue.setText("");
        jLabel23.setText("�����:");
        jLabel24.setText("���:");
        jBquery.setText("����");
        jBquery.addActionListener(new JF_view_medicine_jBquery_actionAdapter(this));
        jBlookall.setText("ȫ���鿴");
        jBlookall.addActionListener(new JF_view_medicine_jBlookall_actionAdapter(this));
        jButton3.setText("�ر�");
        jButton3.addActionListener(new JF_view_medicine_jButton3_actionAdapter(this));
        jPanel5.setBorder(BorderFactory.createLoweredBevelBorder());
        jScrollPane1.setBorder(BorderFactory.createLineBorder(Color.black));
        jCzd.setPreferredSize(new Dimension(99, 22));
        jCysf.setPreferredSize(new Dimension(59, 22));
        jTable1.setAutoscrolls(false);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
        jTabbedPane1.add(jPanel1, "����¼��");
        jTabbedPane1.add(jPanel2, "�������");
        jPanel3.add(jLabel21);
        jPanel3.add(jTbh);
        jPanel3.add(jBmodi);
        jPanel3.add(jBadd);
        jPanel3.add(jBsave);
        jPanel3.add(jBexit);
        jPanel1.add(jPanel4, BorderLayout.CENTER);
        
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
        jPanel4.add(jCdw);
        jPanel4.add(jLabel7);
        jPanel4.add(jTextField7);
        jPanel4.add(jLabel8);
        jPanel4.add(jCyj);
        jPanel4.add(jLabel9);
        jPanel4.add(jTextField9);
        jPanel4.add(jLabel10);
        jPanel4.add(jTextField10);
        jPanel4.add(jLabel11);
        jPanel4.add(jCyxq);
        jPanel4.add(jLabel12);
        jPanel4.add(jCzlbz);
        jPanel4.add(jLabel13);
        jPanel4.add(jCjyfs);
        jPanel4.add(jLabel14);
        jPanel4.add(jTextField14);
        jPanel4.add(jLabel15);
        jPanel4.add(jTextField15);
        jPanel4.add(jLabel16);
        jPanel4.add(jTextField16);
        jPanel4.add(jLabel17);
        jPanel4.add(jTextField17);
        jPanel4.add(jLabel18);
        jPanel4.add(jClb);
        jPanel4.add(jLabel19);
        jPanel4.add(jTextField19);
        jPanel1.add(jPanel3, BorderLayout.SOUTH);
        jPanel2.add(jScrollPane1, BorderLayout.CENTER);
        jPanel2.add(jPanel5, BorderLayout.NORTH);
        jPanel5.add(jLabel24);
        jPanel5.add(jCzd);
        jPanel5.add(jLabel23);
        jPanel5.add(jCysf);
        jPanel5.add(jLabel22);
        jPanel5.add(jTvalue);
        jPanel5.add(jBquery);
        jPanel5.add(jBlookall);
        jPanel5.add(jButton3);
        jScrollPane1.getViewport().add(jTable1);
        jTextField1.addKeyListener(new JTkeyAdapter(jTextField2));
        jTextField2.addKeyListener(new JTkeyAdapter(jTextField3));
        jTextField3.addKeyListener(new JTkeyAdapter(jTextField4));
        jTextField4.addKeyListener(new JTkeyAdapter(jTextField5));
        jTextField5.addKeyListener(new JTkeyAdapter(jTextField7));
        jCdw.addKeyListener(new JTkeyAdapter(jTextField7));
        jTextField7.addKeyListener(new JTkeyAdapter(jTextField9));
        jTextField9.addKeyListener(new JTkeyAdapter(jTextField10));
        jTextField10.addKeyListener(new JTkeyAdapter(jTextField14));
        jTextField14.addKeyListener(new JTkeyAdapter(jTextField15));
        jTextField15.addKeyListener(new JTkeyAdapter(jTextField16));
        jTextField16.addKeyListener(new JTkeyAdapter(jTextField17));
        jTextField17.addKeyListener(new JTkeyAdapter(jTextField19));
        jTbh.addKeyListener(new JF_view_medicine_jTbh_keyAdapter(this));
        setVisible(true);
        setSize(new Dimension(782, 502));
        this.setClosable(true);
        this.setMaximizable(true);
        this.setTitle("ҩƷ������Ϣ���");
        getGys();
    }
    
    public void jBsave_actionPerformed(ActionEvent e) {
        // �����û���ʾ�Ի���ѯ���û��Ƿ���д��̲���
        int result = JOptionPane.showOptionDialog(null, "�Ƿ����ҩƷ������Ϣ�������?", "ϵͳ��ʾ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "��", "��" }, "��");
        
        if (result == JOptionPane.NO_OPTION)
            return;
        
        JTextField jText = null;
        String className = null;
        for (int i = 0; i <= 37; i++) {
            className = jPanel4.getComponent(i).getClass().getName();
            if (className.equals("javax.swing.JTextField")) {
                jText = (JTextField) jPanel4.getComponent(i);
                if (jText.getText().length() <= 0) {
                    JLabel jLstr = null;
                    jLstr = (JLabel) jPanel4.getComponent(i - 1);
                    JOptionPane.showMessageDialog(null, jLstr.getText() + "������Ϊ��,��¼��!!!", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
                    jText.requestFocus();
                    return;
                }
            }
        }
        
        obj_medicine medicine = new obj_medicine();
        medicine.setYpbh(jTextField1.getText().trim());
        medicine.setYpmc(jTextField2.getText().trim());
        medicine.setYptm(jTextField3.getText().trim());
        medicine.setTym(jTextField4.getText().trim());
        medicine.setPym(jTextField5.getText().trim());
        medicine.setDw(jCdw.getSelectedItem().toString());
        medicine.setGg(jTextField7.getText().trim());
        medicine.setJx(jCyj.getSelectedItem().toString());
        medicine.setCd(jTextField9.getText().trim());
        int bzsl;
        Double lsjg, jhjg, pfjg;
        try {
            bzsl = Integer.parseInt(jTextField10.getText().trim());
            lsjg = Double.valueOf(jTextField15.getText().trim());
            jhjg = Double.valueOf(jTextField16.getText().trim());
            pfjg = Double.valueOf(jTextField17.getText().trim());
        } catch (java.lang.NumberFormatException format) {
            JOptionPane.showMessageDialog(null, "��������ݸ�ʽ����,������¼��!!\n" + format.getMessage(), "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            return;
        }
        medicine.setBzsl(bzsl);
        medicine.setYxq(jCyxq.getSelectedItem().toString());
        
        medicine.setZlbz(jCzlbz.getSelectedItem().toString());
        medicine.setJyfs(jCjyfs.getSelectedItem().toString());
        medicine.setPh(jTextField14.getText().trim());
        medicine.setLsjg(lsjg);
        medicine.setJhjg(jhjg);
        medicine.setPfjg(pfjg);
        medicine.setYplb(jClb.getSelectedItem().toString());
        medicine.setYlbh(jTextField19.getText().trim());
        Obj_Stock objstock = new Obj_Stock();
        objstock.setYpbh(jTextField1.getText().trim());
        objstock.setRksl(0);
        objstock.setXssl(0);
        objstock.setKcsl(0);
        objstock.setPdsl(0);
        objstock.setPdrq(null);
        
        if (AdapterDao.insertmedicine(medicine) && AdapterDao.InsertStock(objstock)) {
            JOptionPane.showMessageDialog(null, "ҩƷ�������ݴ��̳ɹ�", "ϵͳ��ʾ", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "ҩƷ�������ݴ���ʧ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void jTbh_keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource().equals(jTbh)) {
                String bh = jTbh.getText().trim();
                if (bh.length() <= 0) {
                    JOptionPane.showMessageDialog(null, "��Ų�����Ϊ��!!!", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
                    jTbh.requestFocus();
                    return;
                }
                String QueryStr = " from obj_medicine where ypbh = '" + bh + "'";
                List list = AdapterDao.QueryObject(QueryStr);
                if (list.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "��Ų���������������!!!", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
                    jTbh.requestFocus();
                    return;
                    
                }
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    obj_medicine objmdedi = (obj_medicine) iterator.next();
                    jTextField1.setText(objmdedi.getYpbh());
                    jTextField2.setText(objmdedi.getYpmc());
                    jTextField3.setText(objmdedi.getYptm());
                    jTextField4.setText(objmdedi.getTym());
                    jTextField5.setText(objmdedi.getPym());
                    jCdw.setSelectedItem(objmdedi.getDw());
                    jTextField7.setText(objmdedi.getGg());
                    jCyj.setSelectedItem(objmdedi.getJx());
                    jTextField9.setText(objmdedi.getCd());
                    jTextField10.setText(String.valueOf(objmdedi.getBzsl()));
                    jCyxq.setSelectedItem(objmdedi.getYxq());
                    jCzlbz.setSelectedItem(objmdedi.getZlbz());
                    jCjyfs.setSelectedItem(objmdedi.getJyfs());
                    jTextField14.setText(objmdedi.getPh());
                    jTextField15.setText(objmdedi.getLsjg().toString());
                    jTextField16.setText(objmdedi.getJhjg().toString());
                    jTextField17.setText(objmdedi.getPfjg().toString());
                    jClb.setSelectedItem(objmdedi.getYplb());
                    jTextField19.setText(objmdedi.getYlbh());
                }
                jTextField1.setEnabled(false);
                jTextField2.requestFocus();
                
            }
        }
    }
    
    public void jBexit_actionPerformed(ActionEvent e) {
        DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "�Ƿ�����˳�ҩƷ������Ϣ���?", "ϵͳ��ʾ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "��", "��" }, "��");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }
    }
    
    public void jBmodi_actionPerformed(ActionEvent e) {
        KeyEvent ke = new KeyEvent(jTbh, 0, 0, 0, KeyEvent.VK_ENTER, 'e', 0);
        jTbh_keyPressed(ke);
    }
    
    public void getGys() {
        String QueryGys = null;
        QueryGys = "from Obj_gys";
        List gyslist = AdapterDao.QueryObject(QueryGys);
        Iterator iteragys = gyslist.iterator();
        while (iteragys.hasNext()) {
            Obj_gys gys = (Obj_gys) iteragys.next();
        }
        
    }
    
    public void jBadd_actionPerformed(ActionEvent e) {
        // �����ַ������ͱ���������ѯ���ҩƷ���
        String QueryStr = "Select max(m.ypbh) from obj_medicine m";
        // ����AdapterDao�����Ĳ�ѯ�������ʵ�������
        List list = AdapterDao.QueryObject(QueryStr);
        String bh = null;
        bh = String.valueOf(list.get(0));
        System.out.println("bh =" + bh);
        if (bh.equals("null")) {
            bh = "10000";
        } else {
            int max = Integer.parseInt(list.get(0).toString()) + 1;
            bh = String.valueOf(max);
        }
        jTextField1.setText(bh);
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField7.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField14.setText("");
        jTextField15.setText("");
        jTextField16.setText("");
        jTextField17.setText("");
        jTextField19.setText("");
        jTextField1.setEnabled(false);
        jTextField2.requestFocus();
    }
    
    public void jBlookall_actionPerformed(ActionEvent e) {
        DefaultTableModel defaultModel;
        BuildTable buildTable = new BuildTable();
        defaultModel = buildTable.getmedicineTableModel(" from obj_medicine ");
        jTable1.setModel(defaultModel);
        if (defaultModel == null) {
            JOptionPane.showMessageDialog(null, "û�в�ѯ���������µ�����", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            return;
        }
        jTable1.setRowHeight(22);
        jTabbedPane1.setSelectedIndex(1);
        
    }
    
    public void jBquery_actionPerformed(ActionEvent e) {
        if (jTvalue.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "��ѯ��ֵ����Ϊ�գ������룡����", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            jTvalue.requestFocus();
            return;
        }
        
        String queryName, queryYsf, queryValue;
        String[] queryName1 = { "ypbh", "pym" };
        int index1 = jCzd.getSelectedIndex();
        queryName = queryName1[index1];
        queryYsf = jCysf.getSelectedItem().toString().trim();
        if (queryYsf.equals("like") || queryYsf == "like") {
            queryValue = "%" + jTvalue.getText().trim() + "%";
        } else {
            queryValue = jTvalue.getText().trim();
        }
        
        String queryStr = " from obj_medicine  where " + queryName + " " + queryYsf + " '" + queryValue + "'";
        
        DefaultTableModel defaultModel = null;
        BuildTable buildTable = new BuildTable();
        defaultModel = buildTable.getmedicineTableModel(queryStr);
        jTable1.setModel(defaultModel);
        if (defaultModel.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(null, "û�в�ѯ���������µ�����", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            return;
        }
        jTable1.setRowHeight(22);
        jTabbedPane1.setSelectedIndex(1);
        
    }
    
    public void jButton3_actionPerformed(ActionEvent e) {
        jBexit_actionPerformed(e);
    }
}

class JF_view_medicine_jButton3_actionAdapter implements ActionListener {
    private JF_view_medicine adaptee;
    
    JF_view_medicine_jButton3_actionAdapter(JF_view_medicine adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jButton3_actionPerformed(e);
    }
}

class JF_view_medicine_jBquery_actionAdapter implements ActionListener {
    private JF_view_medicine adaptee;
    
    JF_view_medicine_jBquery_actionAdapter(JF_view_medicine adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBquery_actionPerformed(e);
    }
}

class JF_view_medicine_jBlookall_actionAdapter implements ActionListener {
    private JF_view_medicine adaptee;
    
    JF_view_medicine_jBlookall_actionAdapter(JF_view_medicine adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBlookall_actionPerformed(e);
    }
}

class JF_view_medicine_jBadd_actionAdapter implements ActionListener {
    private JF_view_medicine adaptee;
    
    JF_view_medicine_jBadd_actionAdapter(JF_view_medicine adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBadd_actionPerformed(e);
    }
}

class JF_view_medicine_jBmodi_actionAdapter implements ActionListener {
    private JF_view_medicine adaptee;
    
    JF_view_medicine_jBmodi_actionAdapter(JF_view_medicine adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBmodi_actionPerformed(e);
    }
}

class JF_view_medicine_jTbh_keyAdapter extends KeyAdapter {
    private JF_view_medicine adaptee;
    
    JF_view_medicine_jTbh_keyAdapter(JF_view_medicine adaptee) {
        this.adaptee = adaptee;
    }
    
    public void keyPressed(KeyEvent e) {
        adaptee.jTbh_keyPressed(e);
    }
}

class JF_view_medicine_jBexit_actionAdapter implements ActionListener {
    private JF_view_medicine adaptee;
    
    JF_view_medicine_jBexit_actionAdapter(JF_view_medicine adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBexit_actionPerformed(e);
    }
}

class JF_view_medicine_jBsave_actionAdapter implements ActionListener {
    private JF_view_medicine adaptee;
    
    JF_view_medicine_jBsave_actionAdapter(JF_view_medicine adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBsave_actionPerformed(e);
    }
}

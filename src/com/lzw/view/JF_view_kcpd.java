package com.lzw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultDesktopManager;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.lzw.dao.AdapterDao;
import com.lzw.model.Obj_Stock;
import com.lzw.model.obj_medicine;

public class JF_view_kcpd extends JInternalFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 8988748097722631287L;
    BorderLayout borderLayout1 = new BorderLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JPanel jPanel1 = new JPanel();
    JTable jTable1 = new JTable();
    FlowLayout flowLayout1 = new FlowLayout();
    JButton jBpd = new JButton();
    JButton jBsave = new JButton();
    JButton jBexit = new JButton();
    DefaultTableModel tableModel = null;
    JButton jBquery = new JButton();
    
    List liststock = null;
    
    public JF_view_kcpd() {
        try {
            jbInit();
            buildTable();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void buildTable() {
        String[] tname = { "ҩƷ���", "ҩƷ����", "ҩƷ����", "���", "����", "��λ", "����", "��Ч����", "�������", "�̵�����" };
        Vector<String> vname = new Vector<String>();
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
        jBquery.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        jBquery.setText("��ѯ���");
        jBquery.addActionListener(new JF_view_kcpd_jBquery_actionAdapter(this));
        jBexit.addActionListener(new JF_view_kcpd_jBexit_actionAdapter(this));
        jBpd.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        jBpd.addActionListener(new JF_view_kcpd_jBpd_actionAdapter(this));
        jBsave.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        jBexit.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        this.setClosable(true);
        this.setTitle("ҽҩ�ۺϹ���ϵͳ-[����̵�]");
        this.getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jBpd.setText("�̵�");
        jPanel1.setLayout(flowLayout1);
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        jBsave.setVisible(false);
        jBsave.setText("����Excel");
        jBexit.setText("�˳�");
        jPanel1.add(jBquery);
        jPanel1.add(jBpd);
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        jPanel1.add(jBsave);
        jPanel1.add(jBexit);
        jScrollPane1.getViewport().add(jTable1);
        setSize(700, 500);
        setVisible(true);
    }
    
    public void jBquery_actionPerformed(ActionEvent e) {
        if (jTable1.getRowCount() > 0)
            return;
        String queryStr = null;
        // �ñ�����ķ�ʽ��������ͳ�ƣ�������һһ��Ӧ�ı��н�����ϲ�ѯ����( �о����!!!!)
        queryStr = "FROM Obj_Stock s JOIN s.objmedicine where kcsl > 0";
        List list = null;
        list = AdapterDao.QueryObject(queryStr);
        Object obj[] = null;
        liststock = list;
        for (int i = 0; i < list.size(); i++) {
            obj = (Object[]) list.get(i);
            Obj_Stock stock = (Obj_Stock) obj[0]; // ��ù����еĶ���
            obj_medicine objmed = (obj_medicine) obj[1];
            Vector<String> vdata = new Vector<String>();
            vdata.addElement(objmed.getYpbh());
            vdata.addElement(objmed.getYpmc());
            vdata.addElement(objmed.getPh());
            vdata.addElement(objmed.getGg());
            vdata.addElement(objmed.getCd());
            vdata.addElement(objmed.getDw());
            vdata.addElement(objmed.getJx());
            vdata.addElement(objmed.getYxq());
            vdata.addElement(String.valueOf(stock.getKcsl()));
            tableModel.addRow(vdata);
        }
        jTable1.setRowHeight(20);
    }
    
    public void jBexit_actionPerformed(ActionEvent e) {
        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "�Ƿ�����˳�ҩƷҩƷ�̵����?", "ϵͳ��ʾ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "��", "��" }, "��");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }
    }
    
    public void jBpd_actionPerformed(ActionEvent e) {
        if (jTable1.getRowCount() <= 0)
            return;
        int result = JOptionPane.showOptionDialog(null, "�Ƿ���Ĵ���ҩƷ�����Ϣ���?", "ϵͳ��ʾ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "��", "��" }, "��");
        if (result == JOptionPane.NO_OPTION)
            return;
        
        java.util.Calendar calendar = null;
        Locale loc = new Locale("CN");
        calendar = Calendar.getInstance(loc);
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String rqStr = year + "-" + month + "-" + day;
        java.sql.Date pdrq = java.sql.Date.valueOf(rqStr);
        
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Object[] obj = (Object[]) liststock.get(i);
            Obj_Stock stock = null;
            String ypbh = null;
            String sqlStr = null;
            ypbh = jTable1.getValueAt(i, 0).toString();
            sqlStr = " from Obj_Stock where ypbh = '" + ypbh + "'";
            List list = null;
            list = com.lzw.dao.AdapterDao.QueryObject(sqlStr);
            stock = (Obj_Stock) list.get(0);
            
            int kcsl, pdsl;
            try {
                kcsl = Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 8)));
                pdsl = Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 9)));
            } catch (java.lang.NumberFormatException format) {
                JOptionPane.showMessageDialog(null, "�̵������Ƿ�,����д!!!\n" + format.getMessage(), "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (pdsl < 0) {
                
            }
            stock.setKcsl(kcsl);
            stock.setPdsl(pdsl);
            stock.setPdrq(pdrq);
            com.lzw.dao.AdapterDao.InsertStock(stock);
        }
        JOptionPane.showMessageDialog(null, "�̵����ݴ��̳ɹ�!!!", "ϵͳ��ʾ", JOptionPane.INFORMATION_MESSAGE);
    }
}

class JF_view_kcpd_jBpd_actionAdapter implements ActionListener {
    private JF_view_kcpd adaptee;
    
    JF_view_kcpd_jBpd_actionAdapter(JF_view_kcpd adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBpd_actionPerformed(e);
    }
}

class JF_view_kcpd_jBexit_actionAdapter implements ActionListener {
    private JF_view_kcpd adaptee;
    
    JF_view_kcpd_jBexit_actionAdapter(JF_view_kcpd adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBexit_actionPerformed(e);
    }
}

class JF_view_kcpd_jBquery_actionAdapter implements ActionListener {
    private JF_view_kcpd adaptee;
    
    JF_view_kcpd_jBquery_actionAdapter(JF_view_kcpd adaptee) {
        this.adaptee = adaptee;
    }
    
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBquery_actionPerformed(e);
    }
}

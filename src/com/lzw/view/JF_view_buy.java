package com.lzw.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultDesktopManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.lzw.dao.AdapterDao;
import com.lzw.model.Obj_BuyDetaile;
import com.lzw.model.Obj_BuyMain;
import com.lzw.model.Obj_Stock;
import com.lzw.model.Obj_gys;
import com.lzw.model.obj_medicine;

public class JF_view_buy extends JInternalFrame implements TableModelListener {
    /**
     * 
     */
    private static final long serialVersionUID = 6186599960402254361L;
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    JLabel jLabel1 = new JLabel();
    JTextField jTxszl = new JTextField();
    JLabel jLabel2 = new JLabel();
    JTextField jTxssl = new JTextField();
    JLabel jLabel3 = new JLabel();
    JTextField jThjje = new JTextField();
    JSplitPane jSplitPane1 = new JSplitPane();
    BorderLayout borderLayout2 = new BorderLayout();
    JPanel jPanel4 = new JPanel();
    JPanel jPanel5 = new JPanel();
    GridLayout gridLayout2 = new GridLayout();
    JLabel jLabel9 = new JLabel();
    JTextField jTxsph = new JTextField();
    JLabel jLabel10 = new JLabel();
    JTextField jTldrq = new JTextField();
    JLabel jLabel11 = new JLabel();
    JLabel jLabel12 = new JLabel();
    JTextField jTjbr = new JTextField();
    FlowLayout flowLayout1 = new FlowLayout();
    JButton jBadd = new JButton();
    JButton jBsave = new JButton();
    JButton jButton3 = new JButton();
    JComboBox jComboBox1 = new JComboBox();
    BorderLayout borderLayout3 = new BorderLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable jTable1 = new JTable();
    DefaultTableModel tableModel = null;
    JComboBox jcbh = new JComboBox();
    JComboBox jComboBox21 = new JComboBox();
    JButton jBreg = new JButton();
    JButton jBdel = new JButton();
    private Calendar calendar;
    
    public JF_view_buy() {
        try {
            buildTable();
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void buildTable() {
        String[] tname = { "��ˮ��", "ҩƷ���", "ҩƷ����", "ҩƷ����", "���", "����", "��λ", "�����۸�", "��������", "�������", "���ۼ�", "��Ч����" };
        Vector<String> vname = new Vector<String>();
        for (int i = 0; i < tname.length; i++) {
            vname.addElement(tname[i]);
        }
        tableModel = new DefaultTableModel(vname, 0);
        tableModel.addTableModelListener(this);
        jTable1.setModel(tableModel);
        jTable1.setShowGrid(true);
        TableColumnModel tcm = jTable1.getColumnModel();
        
    }
    
    private void jbInit() throws Exception {
        tableModel.addTableModelListener(this);
        this.getContentPane().setLayout(borderLayout1);
        jPanel1.setLayout(borderLayout2);
        jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setVerifyInputWhenFocusTarget(false);
        jPanel4.setLayout(gridLayout2);
        gridLayout2.setColumns(4);
        gridLayout2.setRows(4);
        jLabel9.setFont(new Font("������", Font.PLAIN, 12));
        jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel9.setText("�ɹ�Ʊ��");
        jTxsph.setText("");
        jLabel10.setFont(new Font("������", Font.PLAIN, 12));
        jLabel10.setText("¼������");
        jTldrq.setText("");
        jLabel11.setFont(new Font("������", Font.PLAIN, 12));
        jLabel11.setToolTipText("");
        jLabel11.setText("��Ӧ������");
        jLabel12.setFont(new Font("������", Font.PLAIN, 12));
        jLabel12.setText("������");
        jTjbr.setText("");
        jPanel5.setLayout(flowLayout1);
        jBadd.setEnabled(false);
        jBadd.setFont(new Font("������", Font.PLAIN, 12));
        jBadd.setText("���");
        jBadd.addActionListener(new JF_view_buy_jBadd_actionAdapter(this));
        jBsave.setEnabled(false);
        jBsave.setFont(new Font("������", Font.PLAIN, 12));
        jBsave.setText("����");
        jBsave.addActionListener(new JF_view_buy_jBsave_actionAdapter(this));
        jButton3.setFont(new Font("������", Font.PLAIN, 12));
        jButton3.setText("�˳�");
        jButton3.addActionListener(new JF_view_buy_jButton3_actionAdapter(this));
        jPanel2.setLayout(borderLayout3);
        jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setClosable(true);
        this.setMaximizable(true);
        this.setTitle("ҽҩ�ۺϹ���ϵͳ-[ҩƷ���]");
        jBreg.setFont(new Font("������", Font.PLAIN, 12));
        jBreg.setText("�Ǽ�");
        jBreg.addActionListener(new JF_view_buy_jBreg_actionAdapter(this));
        jLabel1.setFont(new Font("������", Font.PLAIN, 12));
        jLabel2.setFont(new Font("������", Font.PLAIN, 12));
        jLabel3.setFont(new Font("������", Font.PLAIN, 12));
        jBdel.setEnabled(false);
        jBdel.setFont(new Font("������", Font.PLAIN, 12));
        jBdel.setText("ɾ��");
        jBdel.addActionListener(new JF_view_buy_jBdel_actionAdapter(this));
        jTxszl.setEnabled(false);
        jTxssl.setEnabled(false);
        jThjje.setEnabled(false);
        jComboBox1.setFont(new Font("������", Font.PLAIN, 12));
        
        this.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jScrollPane1.getViewport().add(jTable1);
        jLabel1.setText("�ɹ�Ʒ��");
        jTxszl.setText("");
        jLabel2.setText("�ɹ�����");
        jTxssl.setText("");
        jLabel3.setText("�ϼƽ��");
        jThjje.setText("");
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        jPanel1.add(jSplitPane1, java.awt.BorderLayout.CENTER);
        jSplitPane1.add(jPanel4, JSplitPane.TOP);
        jPanel4.add(jLabel9);
        jPanel4.add(jTxsph);
        jPanel4.add(jLabel10);
        jPanel4.add(jTldrq);
        jPanel4.add(jLabel11);
        jPanel4.add(jComboBox1);
        jPanel4.add(jLabel1);
        jPanel4.add(jTxszl);
        jPanel4.add(jLabel12);
        jPanel4.add(jTjbr);
        jPanel4.add(jLabel2);
        jPanel4.add(jTxssl);
        jPanel4.add(jLabel3);
        jPanel4.add(jThjje);
        jSplitPane1.add(jPanel5, JSplitPane.BOTTOM);
        jPanel5.add(jBreg);
        jPanel5.add(jBadd);
        jPanel5.add(jBdel);
        jPanel5.add(jBsave);
        jPanel5.add(jButton3);
        setSize(850, 550);
        setVisible(true);
    }
    
    public void jBadd_actionPerformed(ActionEvent e) {
        
        // ����vector�����������һ���ɹ���ϸ��¼
        Vector<String> vdata = new Vector<String>();
        String lsh = new com.lzw.constrol.GenalLsh().getLsh();
        vdata.addElement(lsh);
        tableModel.addRow(vdata);
        jTable1.setModel(tableModel);
        // �˴���ദ��Ϊһ�ζ������֮���ڽ��еǼ���ӵ�ʱ�򲻽��ж�ȡ�����Ч��
        if (jcbh.getItemCount() <= 0) {
            String queryStr = "select m.ypbh from obj_medicine m";
            List list = AdapterDao.QueryObject(queryStr);
            Iterator iterator = list.iterator();
            jcbh.removeAllItems();
            while (iterator.hasNext()) {
                jcbh.addItem(iterator.next());
            }
            jcbh.addItemListener(new JF_view_buy_jcbh_itemAdapter(this));// Ϊjcbh�ؼ�ע���������
        }
        TableColumnModel tcm = jTable1.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(140);
        tcm.getColumn(1).setCellEditor(new DefaultCellEditor(jcbh));// ���õ�Ԫ���е���ģ��Ϊ�����б�
        jTable1.setRowHeight(20);
        jTable1.requestFocus();
        jBdel.setEnabled(true);
        jBsave.setEnabled(true);
        
    }
    
    public void tableChanged(javax.swing.event.TableModelEvent e) {
        int row = e.getFirstRow();
        int col = e.getColumn();
        if (col == 8) { // Ϊ��������
            Object obj = jTable1.getValueAt(row, col);
            int jhsl;
            float jhdj, jhje;
            jhdj = Float.parseFloat(String.valueOf(jTable1.getValueAt(row, 7)).trim());
            jhsl = Integer.parseInt(String.valueOf(obj).trim());
            jhje = jhdj * jhsl;
            jTable1.setValueAt(String.valueOf(jhje), row, 9);
            jTxszl.setText(String.valueOf(jTable1.getRowCount())); // ����Ʒ����
            int xszs = 0;
            float hjje = 0;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                xszs = xszs + Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 8)).trim());
                hjje = hjje + Float.parseFloat(String.valueOf(jTable1.getValueAt(i, 9)).trim());
            }
            jTxssl.setText(String.valueOf(xszs)); // ��������
            jThjje.setText(String.valueOf(hjje)); // �ϼƽ��
        }
        
    }
    
    public void jcbh_itemStateChanged(ItemEvent itemEvent) {
        Object obj = jcbh.getSelectedItem();
        if (obj == null)
            return;
        int row;
        row = jTable1.getSelectedRow();
        if (row < 0)
            return;
        String bh = obj.toString();
        String queryStr = "from obj_medicine m where m.ypbh = '" + bh + "'";
        
        List list = AdapterDao.QueryObject(queryStr);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            obj_medicine objm = (obj_medicine) iterator.next();
            jTable1.setValueAt(objm.getYpmc(), row, 2);
            jTable1.setValueAt(objm.getPh(), row, 3);
            jTable1.setValueAt(objm.getGg(), row, 4);
            jTable1.setValueAt(objm.getCd(), row, 5);
            jTable1.setValueAt(objm.getDw(), row, 6);
            jTable1.setValueAt(objm.getJhjg(), row, 7);
            jTable1.setValueAt(objm.getLsjg(), row, 10);
            jTable1.setValueAt(objm.getYxq(), row, 11);
        }
    }
    
    public void jCbox_itemStateChanged(ItemEvent e) {
        if (jComboBox1.getItemCount() > 0) {
            int selectindex;
            selectindex = jComboBox1.getSelectedIndex();
            if (jComboBox21.getItemCount() > 0) {
                jComboBox21.setSelectedIndex(selectindex);
            }
        }
        
    }
    
    public void jButton3_actionPerformed(ActionEvent e) {
        DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "�Ƿ�����˳�ҩƷ�����Ϣ���?", "ϵͳ��ʾ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "��", "��" }, "��");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }
        
    }
    
    public void jBsave_actionPerformed(ActionEvent e) {
        DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "�Ƿ���Ĵ���ҩƷ�����Ϣ���?", "ϵͳ��ʾ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "��", "��" }, "��");
        if (result == JOptionPane.NO_OPTION)
            return;
        if (jTjbr.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "�����˲�����Ϊ��,��¼��!!!", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            jTjbr.requestFocus();
            return;
        }
        if (jTable1.getRowCount() > 1) {
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                String ypbh, ypbh1;
                ypbh = String.valueOf(jTable1.getValueAt(i, 1));
                int j = i + 1;
                if (j == jTable1.getRowCount())
                    continue;
                for (; j < jTable1.getRowCount(); j++) {
                    ypbh1 = String.valueOf(jTable1.getValueAt(j, 1));
                    if (ypbh.equals(ypbh1)) {
                        JOptionPane.showMessageDialog(null, "��š�" + ypbh1 + "���ظ�������ѡ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
        }
        
        /*------����������¶��� Obj_BuyMain--------*/
        Obj_BuyMain objmain = new Obj_BuyMain();
        objmain.setGysbh(String.valueOf(jComboBox21.getSelectedItem()));
        int pzs, rksl;
        float rkje, xszk, ysje, ssje, wsje;
        try {
            pzs = Integer.parseInt(jTxszl.getText().trim());
            rksl = Integer.parseInt(jTxssl.getText().trim());
            rkje = Float.parseFloat(jThjje.getText().trim());
            
        } catch (java.lang.NumberFormatException format) {
            JOptionPane.showMessageDialog(null, "��������ݸ�ʽ����,������¼��!!\n" + format.getMessage(), "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            System.out.println(format.getMessage());
            return;
        }
        objmain.setPzs(pzs);
        objmain.setRksl(rksl);
        objmain.setRkje(rkje);
        
        java.sql.Date rq = null;
        try {
            rq = java.sql.Date.valueOf(jTldrq.getText().trim());
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
        objmain.setRkrq(rq);
        objmain.setJbr(jTjbr.getText().trim());
        objmain.setSts("F");
        objmain.setRkdjh(jTxsph.getText().trim());
        
        if (AdapterDao.InsertBuyMain(objmain)) {
            JOptionPane.showMessageDialog(null, "ҩƷ����������¼��ɹ�", "ϵͳ��ʾ", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
            JOptionPane.showMessageDialog(null, "����������ݴ���ʧ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
        }
        
        /*------���ɴӱ���¶��� Obj_BuyDetaile--------*/

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Obj_BuyDetaile objbuydetaile = new Obj_BuyDetaile();
            String lsh, ypbh, xsdjh;
            int drksl;
            float rkdj, je;
            lsh = String.valueOf(jTable1.getValueAt(i, 0));
            ypbh = String.valueOf(jTable1.getValueAt(i, 1));
            xsdjh = jTxsph.getText().trim();
            drksl = Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 8)));
            rkdj = Float.parseFloat(String.valueOf(jTable1.getValueAt(i, 7)));
            je = Float.parseFloat(String.valueOf(jTable1.getValueAt(i, 9)));
            objbuydetaile.setRklsh(lsh);
            objbuydetaile.setYpbh(ypbh);
            objbuydetaile.setRkdjh(xsdjh);
            objbuydetaile.setRksl(drksl);
            objbuydetaile.setRkdj(rkdj);
            objbuydetaile.setRkje(je);
            objbuydetaile.setRkrq(rq);
            objbuydetaile.setKcsl(drksl);
            AdapterDao.InsertBuyDetaile(objbuydetaile);
            
            // �����̵����ݱ�Obj_Stock �Ա���в�ѯ
            String stockQuery = "from Obj_Stock where ypbh = '" + ypbh + "'";
            List list = AdapterDao.QueryObject(stockQuery);
            Iterator iterator = list.iterator();
            
            Obj_Stock objstock = (Obj_Stock) iterator.next();
            objstock.setRksl(drksl + objstock.getRksl());
            objstock.setKcsl(rksl + objstock.getKcsl());
            
            AdapterDao.InsertStock(objstock);
        }
        this.jThjje.setText("");
        this.jTjbr.setText("");
        this.jTldrq.setText("");
        this.jTxsph.setText("");
        this.jTxssl.setText("");
        this.jTxszl.setText("");
        jBreg.setEnabled(true);
        jBadd.setEnabled(false);
        jBdel.setEnabled(false);
        jBsave.setEnabled(false);
        jComboBox1.removeAllItems();
        jComboBox21.removeAllItems();
        String[] tname = { "��ˮ��", "ҩƷ���", "ҩƷ����", "ҩƷ����", "���", "����", "��λ", "�����۸�", "��������", "�������", "���ۼ�", "��Ч����" };
        Vector<String> vname = new Vector<String>();
        for (int i = 0; i < tname.length; i++) {
            vname.addElement(tname[i]);
        }
        tableModel = new DefaultTableModel(vname, 0);
        tableModel.addTableModelListener(this);
        jTable1.setModel(tableModel);
        
    }
    
    public void jBreg_actionPerformed(ActionEvent e) {
        // ͨ���������getph()������òɹ�Ʊ��
        String cgph;
        cgph = new com.lzw.constrol.GenalLsh().getPh();
        jTxsph.setText(cgph);
        jTxsph.setEnabled(false);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Locale loc = new Locale("CN");
        calendar = Calendar.getInstance(loc);
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        
        jTldrq.setText(year + "-" + month + "-" + day);
        jTldrq.setEnabled(false);
        jComboBox1.requestFocus();
        
        // �˴���ദ��Ϊһ�ζ������֮���ڽ��еǼ���ӵ�ʱ�򲻽��ж�ȡ�����Ч��
        if (jComboBox1.getItemCount() <= 0) {
            String queryClient = "";
            queryClient = "from Obj_gys";
            List listClient = AdapterDao.QueryObject(queryClient);
            Iterator iteratorclient = listClient.iterator();
            jComboBox1.removeAllItems();
            jComboBox21.removeAllItems();
            while (iteratorclient.hasNext()) {
                Obj_gys object = (Obj_gys) iteratorclient.next();
                jComboBox1.addItem(object.getGysmc());
                jComboBox21.addItem(object.getGysbh());
            }
            jComboBox1.addItemListener(new JF_view_buy_jCbox_itemAdapter(this));
        }
        jTjbr.requestFocus();
        jBreg.setEnabled(false);
        jBadd.setEnabled(true);
        
    }
    
    public void jBdel_actionPerformed(ActionEvent e) {
        int row = jTable1.getSelectedRow();
        if (row < 0)
            return;
        Object ypbh = jTable1.getValueAt(row, 1);
        int result = JOptionPane.showOptionDialog(null, "�Ƿ����ɾ�����Ϊ��" + ypbh + "����������ϸ��Ϣ���?", "ϵͳ��ʾ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, new String[] { "��", "��" }, "��");
        if (result == JOptionPane.NO_OPTION)
            return;
        tableModel.removeRow(row);
        
    }
}

class JF_view_buy_jBdel_actionAdapter implements ActionListener {
    private JF_view_buy adaptee;
    
    JF_view_buy_jBdel_actionAdapter(JF_view_buy adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBdel_actionPerformed(e);
    }
}

class JF_view_buy_jBreg_actionAdapter implements ActionListener {
    private JF_view_buy adaptee;
    
    JF_view_buy_jBreg_actionAdapter(JF_view_buy adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBreg_actionPerformed(e);
    }
}

class JF_view_buy_jBsave_actionAdapter implements ActionListener {
    private JF_view_buy adaptee;
    
    JF_view_buy_jBsave_actionAdapter(JF_view_buy adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBsave_actionPerformed(e);
    }
}

class JF_view_buy_jButton3_actionAdapter implements ActionListener {
    private JF_view_buy adaptee;
    
    JF_view_buy_jButton3_actionAdapter(JF_view_buy adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jButton3_actionPerformed(e);
    }
}

class JF_view_buy_jCbox_itemAdapter implements ItemListener {
    private JF_view_buy adaptee;
    
    JF_view_buy_jCbox_itemAdapter(JF_view_buy adaptee) {
        this.adaptee = adaptee;
    }
    
    public void itemStateChanged(ItemEvent itemEvent) {
        adaptee.jCbox_itemStateChanged(itemEvent);
    }
}

class JF_view_buy_jcbh_itemAdapter implements ItemListener {
    private JF_view_buy adaptee;
    
    JF_view_buy_jcbh_itemAdapter(JF_view_buy adaptee) {
        this.adaptee = adaptee;
    }
    
    public void itemStateChanged(ItemEvent itemEvent) {
        adaptee.jcbh_itemStateChanged(itemEvent);
    }
}

class JF_view_buy_jBadd_actionAdapter implements ActionListener {
    private JF_view_buy adaptee;
    
    JF_view_buy_jBadd_actionAdapter(JF_view_buy adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBadd_actionPerformed(e);
    }
}

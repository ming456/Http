package com.lzw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

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
import com.lzw.model.Obj_SellDetaile;
import com.lzw.model.Obj_SellMain;
import com.lzw.model.Obj_Stock;
import com.lzw.model.Obj_client;
import com.lzw.model.obj_medicine;

public class JF_view_sell extends JInternalFrame implements TableModelListener {
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();
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
    JLabel jLabel8 = new JLabel();
    JTextField jTextField8 = new JTextField();
    JComboBox jComboBox1 = new JComboBox();
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
    JComboBox jComboBox2 = new JComboBox();
    BorderLayout borderLayout3 = new BorderLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTable jTable1 = new JTable();
    DefaultTableModel tableModel = null;
    JComboBox jcbh = new JComboBox();
    JComboBox jComboBox21 = new JComboBox();
    JButton jBreg = new JButton();
    JButton jBdel = new JButton();
    
    private Calendar calendar;
    
    public JF_view_sell() {
        try {
            buildTable();
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void buildTable() {
        String[] tname = { "��ˮ��", "ҩƷ���", "ҩƷ����", "ҩƷ����", "���", "����", "��λ", "���ۼ�", "��������", "���۽��", "�������" };
        java.util.Vector<String> vname = new java.util.Vector<String>();
        for (int i = 0; i < tname.length; i++) {
            vname.addElement(tname[i]);
        }
        tableModel = new DefaultTableModel(vname, 0);
        tableModel.addTableModelListener(this);
        jTable1.setModel(tableModel);
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
        gridLayout2.setRows(2);
        jLabel9.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel9.setText("����Ʊ�ţ�");
        jTxsph.setText("");
        jLabel10.setText("¼�����ڣ�");
        jLabel10.setHorizontalAlignment(SwingConstants.RIGHT);
        jTldrq.setText("");
        jLabel11.setText("���ۿͻ���");
        jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel12.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel12.setText("�����ˣ�");
        jTjbr.setText("");
        jPanel5.setLayout(flowLayout1);
        jBadd.setEnabled(false);
        jBadd.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        jBadd.setText("���");
        jBadd.addActionListener(new JF_view_sell_jBadd_actionAdapter(this));
        jBsave.setEnabled(false);
        jBsave.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        jBsave.setText("����");
        jBsave.addActionListener(new JF_view_sell_jBsave_actionAdapter(this));
        jButton3.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        jButton3.setText("�˳�");
        jButton3.addActionListener(new JF_view_sell_jButton3_actionAdapter(this));
        jPanel2.setLayout(borderLayout3);
        jPanel2.setBorder(BorderFactory.createLoweredBevelBorder());
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        jTable1.setAutoscrolls(false);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setClosable(true);
        this.setMaximizable(true);
        this.setTitle("ҽҩ�ۺϹ���ϵͳ-[ҩƷ����]");
        jBreg.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        jBreg.setText("�Ǽ�");
        jBreg.addActionListener(new JF_view_sell_jBreg_actionAdapter(this));
        jComboBox1.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        jBdel.setEnabled(false);
        jBdel.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        jBdel.setText("ɾ��");
        jBdel.addActionListener(new JF_view_sell_jBdel_actionAdapter(this));
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField5.setEnabled(false);
        jTextField6.addKeyListener(new JF_view_sell_jTextField6_keyAdapter(this));
        jComboBox2.setFont(new java.awt.Font("������", Font.PLAIN, 12));
        this.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jScrollPane1.getViewport().add(jTable1);
        jLabel1.setText("����Ʒ�֣�");
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jPanel3.setBorder(BorderFactory.createLineBorder(Color.black));
        gridLayout1.setColumns(4);
        gridLayout1.setRows(4);
        jPanel3.setLayout(gridLayout1);
        this.getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);
        jTextField1.setText("");
        jLabel2.setText("����������");
        jTextField2.setText("0");
        jLabel3.setText("�ϼƽ�");
        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextField3.setText("0");
        jLabel4.setText("�ۿ۽�");
        jTextField4.setText("0");
        jTextField4.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                double zkje, ysje, hjje;
                try {
                    hjje = Double.parseDouble(jTextField3.getText().trim());
                    zkje = Double.parseDouble(jTextField4.getText().trim());
                } catch (java.lang.NumberFormatException format) {
                    JOptionPane.showMessageDialog(null, "��������ݸ�ʽ����,������¼��!!\n" + format.getMessage(), "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
                    System.out.println(format.getMessage());
                    return;
                }
                ysje = hjje - zkje;
                
                if (ysje >= 0) {
                    jTextField5.setText(String.valueOf(ysje));
                    jTextField6.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "������ۿ۽�����Ⱥϼƽ���,����������!!!", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
                    jTextField4.setText("0");
                    jTextField4.requestFocus();
                }
            }
        });
        jLabel5.setText("ʵ�ս�");
        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextField5.setText("");
        jLabel6.setText("Ӧ�ս�");
        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextField6.setText("");
        jLabel7.setText("�տʽ��");
        jLabel7.setHorizontalAlignment(SwingConstants.RIGHT);
        jComboBox1.addItem("�ֽ�");
        jComboBox1.addItem("ת��");
        jLabel8.setText("δ�ս�");
        jLabel8.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextField8.setText("");
        jPanel3.add(jLabel1);
        jPanel3.add(jTextField1);
        jPanel3.add(jLabel2);
        jPanel3.add(jTextField2);
        jPanel3.add(jLabel3);
        jPanel3.add(jTextField3);
        jPanel3.add(jLabel4);
        jPanel3.add(jTextField4);
        jPanel3.add(jLabel6);
        jPanel3.add(jTextField5);
        jPanel3.add(jLabel5);
        jPanel3.add(jTextField6);
        jPanel3.add(jLabel7);
        jPanel3.add(jComboBox1);
        jPanel3.add(jLabel8);
        jPanel3.add(jTextField8);
        this.getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        jPanel1.add(jSplitPane1, java.awt.BorderLayout.CENTER);
        jSplitPane1.add(jPanel4, JSplitPane.TOP);
        jPanel4.add(jLabel9);
        jPanel4.add(jTxsph);
        jPanel4.add(jLabel10);
        jPanel4.add(jTldrq);
        jPanel4.add(jLabel11);
        jPanel4.add(jComboBox2);
        jPanel4.add(jLabel12);
        jPanel4.add(jTjbr);
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
        /*-----���ҩƷ��ϸ��¼-------*/
        java.util.Vector<String> vdata = new java.util.Vector<String>();
        String lsh = new com.lzw.constrol.GenalLsh().getLsh();
        vdata.addElement(lsh);
        tableModel.addRow(vdata);
        jTable1.setModel(tableModel);
        // �˴���ദ��Ϊһ�ζ������֮���ڽ��еǼ���ӵ�ʱ�򲻽��ж�ȡ�����Ч��
        if (jcbh.getItemCount() <= 0) {
            String queryStr = "";
            queryStr = "select m.ypbh from obj_medicine m";
            
            List list = AdapterDao.QueryObject(queryStr);
            Iterator iterator = list.iterator();
            jcbh.removeAllItems();
            while (iterator.hasNext()) {
                jcbh.addItem(iterator.next());
            }
            jcbh.addItemListener(new JF_view_sell_jcbh_itemAdapter(this));
        }
        TableColumnModel tcm = jTable1.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(140);
        tcm.getColumn(1).setCellEditor(new DefaultCellEditor(jcbh));
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
            int xssl, kcsl;
            double xsdj, xsje;
            xsdj = Double.parseDouble(String.valueOf(jTable1.getValueAt(row, 7)).trim());
            xssl = Integer.parseInt(String.valueOf(obj).trim());
            kcsl = Integer.parseInt(String.valueOf(jTable1.getValueAt(row, 10)));
            if (xssl > kcsl) {
                JOptionPane.showMessageDialog(null, "����������" + xssl + "�����ܴ��ڿ��������" + kcsl + "��,���޸ģ�����", "ϵͳ��ʾ", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            xsje = xsdj * xssl;
            System.out.println("xssl" + xssl + ";xsdj" + xsdj + ";xsje" + xsje);
            jTable1.setValueAt(String.valueOf(xsje), row, 9);
            jTextField1.setText(String.valueOf(jTable1.getRowCount())); // ����Ʒ����
            int xszs = 0;
            double hjje = 0.00;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                xszs = xszs + Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 8)).trim());
                hjje = hjje + Double.parseDouble(String.valueOf(jTable1.getValueAt(i, 9)).trim());
            }
            jTextField2.setText(String.valueOf(xszs)); // ��������
            jTextField3.setText(String.valueOf(hjje)); // �ϼƽ��
        }
    }
    
    public void jcbh_itemStateChanged(ItemEvent itemEvent) {
        String bh;
        Object obj = jcbh.getSelectedItem();
        if (obj == null)
            return;
        int row;
        row = jTable1.getSelectedRow();
        if (row < 0)
            return;
        bh = obj.toString();
        String queryStr;
        System.out.println("queryStr = from obj_medicine m where m.ypbh = '" + bh);
        queryStr = "FROM Obj_Stock s JOIN s.objmedicine where s.ypbh = '" + bh + "'";
        List list = AdapterDao.QueryObject(queryStr);
        if (list.size() <= 0) {
            JOptionPane.showMessageDialog(this, "����Ʒ�ڿ����û�м�¼", "δ�ɹ���Ʒ", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Object objlist[] = null;
        objlist = (Object[]) list.get(0);
        obj_medicine objm = (obj_medicine) objlist[1];
        jTable1.setValueAt(objm.getYpmc(), row, 2);
        jTable1.setValueAt(objm.getPh(), row, 3);
        jTable1.setValueAt(objm.getGg(), row, 4);
        jTable1.setValueAt(objm.getCd(), row, 5);
        jTable1.setValueAt(objm.getDw(), row, 6);
        jTable1.setValueAt(objm.getLsjg(), row, 7);
        Obj_Stock objstock = (Obj_Stock) objlist[0];
        System.out.println(objstock);
        System.out.println(objstock.getKcsl());
        jTable1.setValueAt(String.valueOf(objstock.getKcsl()), row, 10);
    }
    
    public void jCbox_itemStateChanged(ItemEvent e) {
        if (jComboBox2.getItemCount() > 0) {
            int selectindex;
            selectindex = jComboBox2.getSelectedIndex();
            System.out.println(jComboBox2.getSelectedIndex());
            if (jComboBox21.getItemCount() > 0) {
                jComboBox21.setSelectedIndex(selectindex);
            }
        }
    }
    
    public void jButton3_actionPerformed(ActionEvent e) {
        javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
        int result = JOptionPane.showOptionDialog(null, "�Ƿ�����˳�������Ϣ�����?", "ϵͳ��ʾ", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
                "��", "��" }, "��");
        if (result == JOptionPane.YES_OPTION) {
            manger.closeFrame(this);
        }
        
    }
    
    public void jBsave_actionPerformed(ActionEvent e) {
        if (jTjbr.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "�����˲�����Ϊ��,��¼��!!!", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            jTjbr.requestFocus();
            return;
        }
        if (jTable1.getRowCount() > 1) {
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                String ypbh, ypbh1;
                ypbh = String.valueOf(jTable1.getValueAt(i, 1));
                System.out.println("ypbh = " + ypbh + "; i = " + i);
                int j = i + 1;
                if (j == jTable1.getRowCount())
                    continue;
                for (; j < jTable1.getRowCount(); j++) {
                    ypbh1 = String.valueOf(jTable1.getValueAt(j, 1));
                    System.out.println("ypbh1 = " + ypbh1 + "; j = " + j);
                    if (ypbh.equals(ypbh1)) {
                        JOptionPane.showMessageDialog(null, "��š�" + ypbh1 + "���ظ�������ѡ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
        }
        if (jTextField4.getText().trim().length() <= 0) {
            jTextField4.setText("0");
            jTextField4.requestFocus();
            return;
        }
        if (jTextField5.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "���޸��ۿ۽��!!!", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            jTextField5.requestFocus();
            return;
        }
        if (jTextField6.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null, "ʵ�ս�����Ϊ��,��¼��!!!", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            jTextField6.requestFocus();
            return;
        }
        
        /*------����������¶��� Obj_SellMain--------*/
        Obj_SellMain objsellmain = new Obj_SellMain();
        objsellmain.setKhbh(String.valueOf(jComboBox21.getSelectedItem()));
        int pzs, xszs;
        Double xsje, xszk, ysje, ssje, wsje;
        try {
            pzs = Integer.parseInt(jTextField1.getText().trim());
            xszs = Integer.parseInt(jTextField2.getText().trim());
            xsje = Double.valueOf(jTextField3.getText().trim());
            xszk = Double.valueOf(jTextField4.getText().trim());
            ysje = Double.valueOf(jTextField5.getText().trim());
            ssje = Double.valueOf(jTextField6.getText().trim());
            wsje = Double.valueOf(jTextField8.getText().trim());
            
        } catch (java.lang.NumberFormatException format) {
            JOptionPane.showMessageDialog(null, "��������ݸ�ʽ����,������¼��!!\n" + format.getMessage(), "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            System.out.println(format.getMessage());
            return;
        }
        
        objsellmain.setPzs(pzs);
        objsellmain.setXszs(xszs);
        objsellmain.setXsje(xsje);
        objsellmain.setXszk(xszk);
        objsellmain.setYsje(ysje);
        objsellmain.setSsje(ssje);
        objsellmain.setWsje(wsje);
        
        java.sql.Date xsrq = null;
        try {
            xsrq = java.sql.Date.valueOf(jTldrq.getText().trim());
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
        objsellmain.setXsrq(xsrq);
        objsellmain.setSkfs(String.valueOf(jComboBox1.getSelectedItem()));
        objsellmain.setJbr(jTjbr.getText().trim());
        if (wsje.floatValue() <= 0) {
            objsellmain.setQssts("T");
        } else {
            objsellmain.setQssts("F");
        }
        
        objsellmain.setXsdjh(jTxsph.getText().trim());
        if (AdapterDao.InsertSellMain(objsellmain)) {
            JOptionPane.showMessageDialog(null, "ҩƷ���������������¼��ɹ�", "ϵͳ��ʾ", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "ҩƷ����������ݴ���ʧ��", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
        }
        
        /*------���ɴӱ���¶��� Obj_SellDetaile--------*/

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Obj_SellDetaile objselldetaile = new Obj_SellDetaile();
            String lsh, ypbh, xsdjh;
            int xssl, kcsl;
            float xsdj, je;
            lsh = String.valueOf(jTable1.getValueAt(i, 0));
            ypbh = String.valueOf(jTable1.getValueAt(i, 1));
            xsdjh = jTxsph.getText().trim();
            xssl = Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 8)));
            kcsl = Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 10)));
            if (xssl > kcsl) {
                JOptionPane.showMessageDialog(null, "����������" + xssl + "�����ܴ��ڿ��������" + kcsl + "��,���޸ģ�����", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
                return;
            }
            xsdj = Float.parseFloat(String.valueOf(jTable1.getValueAt(i, 7)));
            je = Float.parseFloat(String.valueOf(jTable1.getValueAt(i, 9)));
            objselldetaile.setXslsh(lsh);
            objselldetaile.setYpbh(ypbh);
            // ��������Ĺ��������������������е�ypbh
            com.lzw.model.obj_medicine medicne = new obj_medicine();
            medicne.setYpbh(ypbh);
            objselldetaile.setMedicine(medicne);
            objselldetaile.setXsdjh(xsdjh);
            objselldetaile.setXssl(xssl);
            objselldetaile.setXsdj(xsdj);
            objselldetaile.setXsje(je);
            objselldetaile.setXsrq(xsrq);
            objselldetaile.setThsts("F");
            AdapterDao.InsertSellDetaile(objselldetaile);
            // �����̵����ݱ�Obj_Stock �Ա���в�ѯ
            String stockQuery = "from Obj_Stock where ypbh = '" + ypbh + "'";
            java.util.List list = AdapterDao.QueryObject(stockQuery);
            java.util.Iterator iterator = list.iterator();
            
            Obj_Stock objstock = (Obj_Stock) iterator.next();
            objstock.setYpbh(ypbh);
            
            int kcslnew = 0, xsslnew = 0;
            xsslnew = objstock.getXssl() + xssl;
            kcslnew = objstock.getKcsl() - xssl;
            System.out.println("kcslnew = " + kcslnew + "\n xsslnew = " + xsslnew);
            
            objstock.setXssl(xsslnew);
            objstock.setKcsl(kcslnew);
            AdapterDao.InsertStock(objstock);
            
        }
        jBreg.setEnabled(true);
        jBadd.setEnabled(false);
        jBdel.setEnabled(false);
        jBsave.setEnabled(false);
        this.jTjbr.setText("");
        this.jTldrq.setText("");
        this.jTxsph.setText("");
        jComboBox2.removeAllItems();
        jComboBox21.removeAllItems();
        this.jTextField1.setText("");
        this.jTextField2.setText("");
        this.jTextField3.setText("");
        this.jTextField4.setText("");
        this.jTextField5.setText("");
        this.jTextField6.setText("");
        this.jTextField8.setText("");
        String[] tname = { "��ˮ��", "ҩƷ���", "ҩƷ����", "ҩƷ����", "���", "����", "��λ", "���ۼ�", "��������", "���۽��", "�������" };
        java.util.Vector<String> vname = new java.util.Vector<String>();
        for (int i = 0; i < tname.length; i++) {
            vname.addElement(tname[i]);
        }
        tableModel = new DefaultTableModel(vname, 0);
        tableModel.addTableModelListener(this);
        jTable1.setModel(tableModel);
        
    }
    
    public void jBreg_actionPerformed(ActionEvent e) {
        /*-----�������������------*/
        String xsph;
        xsph = new com.lzw.constrol.GenalLsh().getPh();
        jTxsph.setText(xsph);
        jTxsph.setEnabled(false);
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-mm-dd");
        Locale loc = new Locale("CN");
        String lsh = null;
        calendar = Calendar.getInstance(loc);
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        // System.out.println("" + year + "" + month + "" + day);
        jTldrq.setText(year + "-" + month + "-" + day);
        jTldrq.setEnabled(false);
        jComboBox2.requestFocus();
        
        // �˴���ദ��Ϊһ�ζ������֮���ڽ��еǼ���ӵ�ʱ�򲻽��ж�ȡ�����Ч��
        if (jComboBox2.getItemCount() <= 0) {
            String queryClient = "";
            queryClient = "from Obj_client";
            List listClient = AdapterDao.QueryObject(queryClient);
            Iterator iteratorclient = listClient.iterator();
            jComboBox2.removeAllItems();
            jComboBox21.removeAllItems();
            while (iteratorclient.hasNext()) {
                Obj_client object = (Obj_client) iteratorclient.next();
                jComboBox2.addItem(object.getKhmc());
                jComboBox21.addItem(object.getKhbh());
            }
            jComboBox2.addItemListener(new JF_view_sell_jCbox_itemAdapter(this));
        }
        jTjbr.requestFocus();
        jBreg.setEnabled(false);
        jBadd.setEnabled(true);
        
    }
    
    public void jTextField6_keyPressed(KeyEvent e) {
        double ysje, sjje, wsje;
        try {
            ysje = Double.parseDouble(jTextField5.getText().trim());
            sjje = Double.parseDouble(jTextField6.getText().trim());
        } catch (java.lang.NumberFormatException format) {
            JOptionPane.showMessageDialog(null, "��������ݸ�ʽ����,������¼��!!\n" + format.getMessage(), "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            jTextField6.setText("0");
            return;
        }
        wsje = ysje - sjje;
        if (wsje >= 0) {
            jTextField8.setText(String.valueOf(wsje));
            jTextField8.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "�����ʵ�ս������Ӧ�ս���,����������!!!", "ϵͳ��ʾ", JOptionPane.ERROR_MESSAGE);
            e.consume();
            jTextField6.requestFocus();
        }
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

class JF_view_sell_jBdel_actionAdapter implements ActionListener {
    private JF_view_sell adaptee;
    
    JF_view_sell_jBdel_actionAdapter(JF_view_sell adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBdel_actionPerformed(e);
    }
}

class JF_view_sell_jTextField6_keyAdapter extends KeyAdapter {
    private JF_view_sell adaptee;
    
    JF_view_sell_jTextField6_keyAdapter(JF_view_sell adaptee) {
        this.adaptee = adaptee;
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        adaptee.jTextField6_keyPressed(e);
    }
    
}

class JF_view_sell_jBreg_actionAdapter implements ActionListener {
    private JF_view_sell adaptee;
    
    JF_view_sell_jBreg_actionAdapter(JF_view_sell adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBreg_actionPerformed(e);
    }
}

class JF_view_sell_jBsave_actionAdapter implements ActionListener {
    private JF_view_sell adaptee;
    
    JF_view_sell_jBsave_actionAdapter(JF_view_sell adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBsave_actionPerformed(e);
    }
}

class JF_view_sell_jButton3_actionAdapter implements ActionListener {
    private JF_view_sell adaptee;
    
    JF_view_sell_jButton3_actionAdapter(JF_view_sell adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jButton3_actionPerformed(e);
    }
}

class JF_view_sell_jCbox_itemAdapter implements ItemListener {
    private JF_view_sell adaptee;
    
    JF_view_sell_jCbox_itemAdapter(JF_view_sell adaptee) {
        this.adaptee = adaptee;
    }
    
    public void itemStateChanged(ItemEvent itemEvent) {
        adaptee.jCbox_itemStateChanged(itemEvent);
    }
}

class JF_view_sell_jcbh_itemAdapter implements ItemListener {
    private JF_view_sell adaptee;
    
    JF_view_sell_jcbh_itemAdapter(JF_view_sell adaptee) {
        this.adaptee = adaptee;
    }
    
    public void itemStateChanged(ItemEvent itemEvent) {
        adaptee.jcbh_itemStateChanged(itemEvent);
    }
}

class JF_view_sell_jBadd_actionAdapter implements ActionListener {
    private JF_view_sell adaptee;
    
    JF_view_sell_jBadd_actionAdapter(JF_view_sell adaptee) {
        this.adaptee = adaptee;
    }
    
    public void actionPerformed(ActionEvent e) {
        adaptee.jBadd_actionPerformed(e);
    }
}

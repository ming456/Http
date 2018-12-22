package com.lzw.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.net.URI;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import com.lzw.constrol.MenuBarEvent;

public class JF_main extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = -7937168858579661660L;
    JPanel contentPane;
    BorderLayout borderLayout1 = new BorderLayout();
    // ���徲̬ʵ������desktop���������������
    public static JDesktopPane desktop = new JDesktopPane();
    MenuBarEvent _MenuBarEvent = new MenuBarEvent();// �Զ����¼��ദ��
    JMenuBar jMenuBarMain = new JMenuBar(); // ��������е����˵��ؼ�
    JToolBar jToolBarMain = new JToolBar();// ��������еĹ������ؼ�
    private JMenu chuang_kouMenu;
    private JMenuItem allResumeItem;
    private JMenuItem allIconItem;
    private JMenuItem closeAllItem;
    private JMenuItem pingpuItem;
    private JMenuItem fangwen_wangzhanItem;
    private JMenuItem bugItem;
    private JMenuItem guanyu_Item;
    private JMenu bang_zhuMenu;
    
    public JF_main() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            // ʹ��buildMenu()��buildToolBar()�������������˵��͹�����
            BuildMenuBar();
            BuildToolBar();
            jbInit();
            loadBackgroundImage();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    /**
     * Component initialization.
     * 
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(borderLayout1);
        
        jMenuBarMain.setFont(new Font("����", 0, 12));
        _MenuBarEvent.setDeskTop(JF_main.desktop);
        this.setJMenuBar(jMenuBarMain);
        this.setResizable(false);
        jToolBarMain.setFloatable(false);
        desktop.setBackground(SystemColor.desktop);
        contentPane.add(jToolBarMain, BorderLayout.NORTH);
        contentPane.add(desktop, BorderLayout.CENTER);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(960, 675));
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        setTitle("ҽҩ�ۺϹ���ϵͳ");
    }
    
    protected void loadBackgroundImage() {
        JLabel jl = new BackLabel();
        jl.setBounds(0, -20, 955, 600);
        desktop.add(jl);
    }
    
    /**
     * ��ʼ�����ڲ˵��ķ���
     * 
     * @return javax.swing.JMenu
     */
    public JMenu getChuang_kouMenu() {
        if (chuang_kouMenu == null) {
            chuang_kouMenu = new JMenu();
            chuang_kouMenu.setText("����(W)");
            chuang_kouMenu.setMnemonic(KeyEvent.VK_W);
            chuang_kouMenu.addMenuListener(new MenuListener() {
                public void menuSelected(MenuEvent e) {
                    chuang_kouMenu.removeAll();
                    chuang_kouMenu.add(getPingpuItem());
                    chuang_kouMenu.add(getClassAllItem());
                    chuang_kouMenu.add(getAllIconItem());
                    chuang_kouMenu.add(getAllResumeItem());
                    chuang_kouMenu.addSeparator();
                    int count = 0;
                    // ��ȡ��������������ڲ�����
                    JInternalFrame[] allFrames = desktop.getAllFrames();
                    // Foreach�����ڲ���������
                    for (final JInternalFrame frame : allFrames) {
                        String frameTitle = frame.getTitle();
                        count++; // ���������
                        final JMenuItem item = new JMenuItem(count + "  " + frameTitle); // ��������˵���
                        chuang_kouMenu.add(item);// ��Ӳ˵���˵���
                        item.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                try {// ������˵���ĵ����¼�
                                    frame.setIcon(false);
                                    frame.setSelected(true);
                                } catch (PropertyVetoException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        });
                    }
                }
                
                public void menuDeselected(javax.swing.event.MenuEvent e) {
                }
                
                public void menuCanceled(javax.swing.event.MenuEvent e) {
                }
            });
        }
        return chuang_kouMenu;
    }
    
    /**
     * ��ʼ��������ƽ�̣��˵���ķ���
     * 
     * @return javax.swing.JMenuItem
     */
    public JMenuItem getPingpuItem() {
        if (pingpuItem == null) {
            pingpuItem = new JMenuItem();
            pingpuItem.setText("����ƽ��");
            pingpuItem.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JInternalFrame[] allFrames = desktop.getAllFrames();
                    int x = 0, y = 0;
                    for (JInternalFrame iFrame : allFrames) {
                        iFrame.setLocation(x, y);
                        try {
                            iFrame.setSelected(true);
                        } catch (PropertyVetoException e1) {
                            e1.printStackTrace();
                        }
                        int frameH = iFrame.getPreferredSize().height;
                        int panelH = iFrame.getContentPane().getPreferredSize().height;
                        int fSpacing = frameH - panelH;
                        x += fSpacing;
                        y += fSpacing;
                        if (x + getWidth() / 2 > desktop.getWidth())
                            x = 0;
                        if (y + getHeight() / 2 > desktop.getHeight())
                            y = 0;
                    }
                }
            });
        }
        return pingpuItem;
    }
    
    /**
     * ��ʼ����ȫ���رգ��˵���ķ���
     * 
     * @return javax.swing.JMenuItem
     */
    private JMenuItem getClassAllItem() {
        if (closeAllItem == null) {
            closeAllItem = new JMenuItem();
            closeAllItem.setText("ȫ���ر�");
            closeAllItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JInternalFrame[] allFrames = desktop.getAllFrames();
                    for (JInternalFrame frame : allFrames) {
                        frame.doDefaultCloseAction();
                    }
                }
            });
        }
        return closeAllItem;
    }
    
    private JMenuItem getAllIconItem() {
        if (allIconItem == null) {
            allIconItem = new JMenuItem();
            allIconItem.setText("ȫ����С��");
            allIconItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JInternalFrame[] allFrames = desktop.getAllFrames();
                    for (JInternalFrame frame : allFrames) {
                        try {
                            frame.setIcon(true);
                        } catch (PropertyVetoException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
        }
        return allIconItem;
    }
    
    private JMenuItem getAllResumeItem() {
        if (allResumeItem == null) {
            allResumeItem = new JMenuItem();
            allResumeItem.setText("ȫ����ԭ");
            allResumeItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JInternalFrame[] allFrames = desktop.getAllFrames();
                    for (JInternalFrame frame : allFrames) {
                        try {
                            frame.setIcon(false);
                        } catch (PropertyVetoException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
        }
        return allResumeItem;
    }
    
    /**
     * ��ʼ�����������˵��ķ���
     * 
     * @return javax.swing.JMenu
     */
    public JMenu getBang_zhuMenu() {
        if (bang_zhuMenu == null) {
            bang_zhuMenu = new JMenu();
            bang_zhuMenu.setText("����(H)");
            bang_zhuMenu.setMnemonic(KeyEvent.VK_H);
            bang_zhuMenu.add(getGuanyu_Item());
            bang_zhuMenu.add(getBugItem());
            bang_zhuMenu.add(getFangwen_wangzhanItem());
        }
        return bang_zhuMenu;
    }
    
    /**
     * ��ʼ�������ڣ��˵���ķ���
     * 
     * @return javax.swing.JMenuItem
     */
    private JMenuItem getGuanyu_Item() {
        if (guanyu_Item == null) {
            guanyu_Item = new JMenuItem();
            guanyu_Item.setText("����");
            URL url = getClass().getResource("/images/about.png");
            ImageIcon aboutImage = new ImageIcon(url);
            final JLabel imgLabel = new JLabel(aboutImage);
            imgLabel.setVisible(false);
            imgLabel.setOpaque(false);
            desktop.add(imgLabel);
            desktop.setLayer(imgLabel, Integer.MAX_VALUE);
            guanyu_Item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int dw = desktop.getWidth();
                    int dh = desktop.getHeight();
                    imgLabel.setBounds((dw - 500) / 2, (dh - 350) / 2, 500, 350);
                    imgLabel.setVisible(true);
                }
            });
            imgLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    imgLabel.setVisible(false);
                }
            });
        }
        return guanyu_Item;
    }
    
    /**
     * ��ʼ������ϵ����֧�֣��˵���ķ���
     * 
     * @return javax.swing.JMenuItem
     */
    public JMenuItem getBugItem() {
        if (bugItem == null) {
            bugItem = new JMenuItem();
            bugItem.setText("��ϵ����֧��");
            bugItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (Desktop.isDesktopSupported()) {
                        Desktop desktop = Desktop.getDesktop();
                        try {
                            URI uri = new URI("mailto:tmoonbook@sina.com");
                            desktop.mail(uri);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
        }
        return bugItem;
    }
    
    /**
     * ��ʼ�������ʼ�����վ���˵���ķ���
     * 
     * @return javax.swing.JMenuItem
     */
    public JMenuItem getFangwen_wangzhanItem() {
        if (fangwen_wangzhanItem == null) {
            fangwen_wangzhanItem = new JMenuItem();
            fangwen_wangzhanItem.setText("���ʼ�����վ");
            fangwen_wangzhanItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if (Desktop.isDesktopSupported()) {
                        Desktop desktop = Desktop.getDesktop();
                        try {
                            URL url = new URL("http://www.mrbccd.com");
                            desktop.browse(url.toURI());
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
        }
        return fangwen_wangzhanItem;
    }
    
    private void BuildMenuBar() {
        // ����˵��������������������˵�
        JMenu[] _jMenu = { new JMenu("������Ϣ(B)"), new JMenu("ҵ�����(M)"), new JMenu("ҵ���ѯ(C)"), new JMenu("�û�����(U)"), new JMenu("ϵͳ����(S)") };
        _jMenu[0].setMnemonic(KeyEvent.VK_B);// ���ò˵������Ƿ�
        _jMenu[1].setMnemonic(KeyEvent.VK_M);// ���ò˵������Ƿ�
        _jMenu[2].setMnemonic(KeyEvent.VK_C);// ���ò˵������Ƿ�
        _jMenu[3].setMnemonic(KeyEvent.VK_U);// ���ò˵������Ƿ�
        _jMenu[4].setMnemonic(KeyEvent.VK_S);// ���ò˵������Ƿ�
        // ����˵���Ŀ�е��Ӳ˵�Ԫ��
        JMenuItem[] _jMenuItem0 = { new JMenuItem("ҩƷ���"), new JMenuItem("�ͻ����"), new JMenuItem("��Ӧ�����") };
        // ����˵���Ŀ��Ӧ������
        String[] _jMenuItem0Name = { "JF_view_medicine", "JF_view_client", "JF_view_gys" };
        // ����˵���Ŀ�е��Ӳ˵�Ԫ��
        JMenuItem[] _jMenuItem1 = { new JMenuItem("ҩƷ�ɹ�"), new JMenuItem("ҩƷ����"), new JMenuItem("����̵�"), new JMenuItem("�����˻�"), new JMenuItem("�ͻ��ؿ�") };
        // ����˵���Ŀ��Ӧ������
        String[] _jMenuItem1Name = { "JF_view_buy", "JF_view_sell", "JF_view_stock", "JF_view_xstk", "JF_view_hkgl" };
        // ����˵���Ŀ�е��Ӳ˵�Ԫ��
        JMenuItem[] _jMenuItem3 = { new JMenuItem("�����û�"), new JMenuItem("�û�ά��") };
        // ����˵���Ŀ��Ӧ������
        String[] _jMenuItem3Name = { "sys_user_add", "sys_user_modify" };
        // ����˵���Ŀ�е��Ӳ˵�Ԫ��
        JMenuItem[] _jMenuItem4 = { new JMenuItem("ϵͳ�˳�") };
        // ����˵���Ŀ��Ӧ������
        String[] _jMenuItem4Name = { "JB_EXIT" };
        // ����˵���Ŀ�е��Ӳ˵�Ԫ��
        JMenuItem[] _jMenuItem2 = { new JMenuItem("������Ϣ"), new JMenuItem("�����ϸ"), new JMenuItem("������ϸ"), new JMenuItem("�ؿ���Ϣ") };
        // ����˵���Ŀ��Ӧ������
        String[] _jMenuItem2Name = { "JF_view_query_jbqk", "JF_view_query_rkqk", "JF_view_query_kcmx_ck", "JF_view_query_kcmx_hk", "" };
        
        /* ���ò˵����˵��� */
        for (int i = 0; i < _jMenu.length; i++) {
            jMenuBarMain.add(_jMenu[i]);
        }
        jMenuBarMain.add(getChuang_kouMenu());// ��Ӵ��ڲ˵�
        jMenuBarMain.add(getBang_zhuMenu());// ��Ӱ����˵�
        for (int j = 0; j < _jMenuItem0.length; j++) {
            final String EventName1 = _jMenuItem0Name[j];
            _jMenuItem0[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    _MenuBarEvent.setEventName(EventName1);
                    _MenuBarEvent.actionPerformed(e);
                }
            });
            _jMenu[0].add(_jMenuItem0[j]);
            if (j == 1) {
                _jMenu[0].addSeparator();
            }
        }
        
        for (int j = 0; j < _jMenuItem1.length; j++) {
            final String EventName1 = _jMenuItem1Name[j];
            _jMenuItem1[j].addActionListener(_MenuBarEvent);
            _jMenuItem1[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    _MenuBarEvent.setEventName(EventName1);
                }
            });
            _jMenu[1].add(_jMenuItem1[j]);
            if (j == 1) {
                _jMenu[1].addSeparator();
            }
            if (j == 2) {
                _jMenu[1].addSeparator();
            }
        }
        
        for (int j = 0; j < _jMenuItem2.length; j++) {
            final String EventName2 = _jMenuItem2Name[j];
            _jMenuItem2[j].addActionListener(_MenuBarEvent);
            _jMenuItem2[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    _MenuBarEvent.setEventName(EventName2);
                }
            });
            _jMenu[2].add(_jMenuItem2[j]);
            if ((j == 0) || (j == 2)) {
                _jMenu[2].addSeparator();
            }
        }
        for (int j = 0; j < _jMenuItem3.length; j++) {
            final String EventName3 = _jMenuItem3Name[j];
            _jMenuItem3[j].addActionListener(_MenuBarEvent);
            _jMenuItem3[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    _MenuBarEvent.setEventName(EventName3);
                }
            });
            _jMenu[3].add(_jMenuItem3[j]);
            if (j == 0) {
                _jMenu[3].addSeparator();
            }
        }
        
        for (int j = 0; j < _jMenuItem4.length; j++) {
            final String EventName4 = _jMenuItem4Name[j];
            _jMenuItem4[j].addActionListener(_MenuBarEvent);
            _jMenuItem4[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    _MenuBarEvent.setEventName(EventName4);
                }
            });
            _jMenu[4].add(_jMenuItem4[j]);
        }
    }
    
    private void BuildToolBar() {
        String ImageName[] = { "yplr.png", "gyslr.png", "ypcg.png", "ypxs.png", "kcpd.png", "xsth.png", "khhk.png", "jbcx.png", "rkmx.png", "xsmx.png",
                "yhgl.png", "exit.png" };
        
        String TipString[] = { "ҩƷ¼��", "��Ӧ��¼��", "ҩƷ�ɹ�", "ҩƷ����", "����̵�", "�����˻�", "�ͻ��ؿ�", "������ѯ", "�����ϸ", "������ϸ", "�û�����", "ϵͳ�˳�" };
        
        String ComandString[] = { "JF_view_medicine", "JF_view_gys", "JF_view_buy", "JF_view_sell", "JF_view_stock", "JF_view_xstk", "JF_view_hkgl",
                "JF_view_query_jbqk", "JF_view_query_rkqk", "JF_view_query_kcmx_ck", "sys_user_modify", "JB_EXIT" };
        for (int i = 0; i < ComandString.length; i++) {
            JButton jb = new JButton();
            URL url = getClass().getResource("/images/" + ImageName[i]);
            if (url == null)
                continue;
            ImageIcon image = new ImageIcon(url);
            jb.setIcon(image);
            jb.setContentAreaFilled(false);
            jb.setBorderPainted(false);
            jb.setMargin(new Insets(0, 0, 0, 0));
            jb.setToolTipText(TipString[i]);
            jb.setActionCommand(ComandString[i]);
            jb.addActionListener(_MenuBarEvent);
            jToolBarMain.add(jb);
        }
    }
}

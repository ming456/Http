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
    // 定义静态实例变量desktop用来生成桌面面板
    public static JDesktopPane desktop = new JDesktopPane();
    MenuBarEvent _MenuBarEvent = new MenuBarEvent();// 自定义事件类处理
    JMenuBar jMenuBarMain = new JMenuBar(); // 定义界面中的主菜单控件
    JToolBar jToolBarMain = new JToolBar();// 定义界面中的工具栏控件
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
            // 使用buildMenu()和buildToolBar()两个方法建立菜单和工具栏
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
        
        jMenuBarMain.setFont(new Font("宋体", 0, 12));
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
        setTitle("医药综合管理系统");
    }
    
    protected void loadBackgroundImage() {
        JLabel jl = new BackLabel();
        jl.setBounds(0, -20, 955, 600);
        desktop.add(jl);
    }
    
    /**
     * 初始化窗口菜单的方法
     * 
     * @return javax.swing.JMenu
     */
    public JMenu getChuang_kouMenu() {
        if (chuang_kouMenu == null) {
            chuang_kouMenu = new JMenu();
            chuang_kouMenu.setText("窗口(W)");
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
                    // 获取桌面面板中所有内部窗体
                    JInternalFrame[] allFrames = desktop.getAllFrames();
                    // Foreach遍历内部窗体数组
                    for (final JInternalFrame frame : allFrames) {
                        String frameTitle = frame.getTitle();
                        count++; // 窗体计数器
                        final JMenuItem item = new JMenuItem(count + "  " + frameTitle); // 创建窗体菜单项
                        chuang_kouMenu.add(item);// 添加菜单项到菜单中
                        item.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                try {// 处理窗体菜单项的单击事件
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
     * 初始化（窗口平铺）菜单项的方法
     * 
     * @return javax.swing.JMenuItem
     */
    public JMenuItem getPingpuItem() {
        if (pingpuItem == null) {
            pingpuItem = new JMenuItem();
            pingpuItem.setText("窗口平铺");
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
     * 初始化（全部关闭）菜单项的方法
     * 
     * @return javax.swing.JMenuItem
     */
    private JMenuItem getClassAllItem() {
        if (closeAllItem == null) {
            closeAllItem = new JMenuItem();
            closeAllItem.setText("全部关闭");
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
            allIconItem.setText("全部最小化");
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
            allResumeItem.setText("全部还原");
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
     * 初始化（帮助）菜单的方法
     * 
     * @return javax.swing.JMenu
     */
    public JMenu getBang_zhuMenu() {
        if (bang_zhuMenu == null) {
            bang_zhuMenu = new JMenu();
            bang_zhuMenu.setText("帮助(H)");
            bang_zhuMenu.setMnemonic(KeyEvent.VK_H);
            bang_zhuMenu.add(getGuanyu_Item());
            bang_zhuMenu.add(getBugItem());
            bang_zhuMenu.add(getFangwen_wangzhanItem());
        }
        return bang_zhuMenu;
    }
    
    /**
     * 初始化（关于）菜单项的方法
     * 
     * @return javax.swing.JMenuItem
     */
    private JMenuItem getGuanyu_Item() {
        if (guanyu_Item == null) {
            guanyu_Item = new JMenuItem();
            guanyu_Item.setText("关于");
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
     * 初始化（联系技术支持）菜单项的方法
     * 
     * @return javax.swing.JMenuItem
     */
    public JMenuItem getBugItem() {
        if (bugItem == null) {
            bugItem = new JMenuItem();
            bugItem.setText("联系技术支持");
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
     * 初始化（访问技术网站）菜单项的方法
     * 
     * @return javax.swing.JMenuItem
     */
    public JMenuItem getFangwen_wangzhanItem() {
        if (fangwen_wangzhanItem == null) {
            fangwen_wangzhanItem = new JMenuItem();
            fangwen_wangzhanItem.setText("访问技术网站");
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
        // 定义菜单对象数组用来生成主菜单
        JMenu[] _jMenu = { new JMenu("基本信息(B)"), new JMenu("业务管理(M)"), new JMenu("业务查询(C)"), new JMenu("用户管理(U)"), new JMenu("系统管理(S)") };
        _jMenu[0].setMnemonic(KeyEvent.VK_B);// 设置菜单的助记符
        _jMenu[1].setMnemonic(KeyEvent.VK_M);// 设置菜单的助记符
        _jMenu[2].setMnemonic(KeyEvent.VK_C);// 设置菜单的助记符
        _jMenu[3].setMnemonic(KeyEvent.VK_U);// 设置菜单的助记符
        _jMenu[4].setMnemonic(KeyEvent.VK_S);// 设置菜单的助记符
        // 定义菜单项目中的子菜单元素
        JMenuItem[] _jMenuItem0 = { new JMenuItem("药品情况"), new JMenuItem("客户情况"), new JMenuItem("供应商情况") };
        // 定义菜单项目对应的名称
        String[] _jMenuItem0Name = { "JF_view_medicine", "JF_view_client", "JF_view_gys" };
        // 定义菜单项目中的子菜单元素
        JMenuItem[] _jMenuItem1 = { new JMenuItem("药品采购"), new JMenuItem("药品销售"), new JMenuItem("库存盘点"), new JMenuItem("销售退货"), new JMenuItem("客户回款") };
        // 定义菜单项目对应的名称
        String[] _jMenuItem1Name = { "JF_view_buy", "JF_view_sell", "JF_view_stock", "JF_view_xstk", "JF_view_hkgl" };
        // 定义菜单项目中的子菜单元素
        JMenuItem[] _jMenuItem3 = { new JMenuItem("增加用户"), new JMenuItem("用户维护") };
        // 定义菜单项目对应的名称
        String[] _jMenuItem3Name = { "sys_user_add", "sys_user_modify" };
        // 定义菜单项目中的子菜单元素
        JMenuItem[] _jMenuItem4 = { new JMenuItem("系统退出") };
        // 定义菜单项目对应的名称
        String[] _jMenuItem4Name = { "JB_EXIT" };
        // 定义菜单项目中的子菜单元素
        JMenuItem[] _jMenuItem2 = { new JMenuItem("基本信息"), new JMenuItem("入库明细"), new JMenuItem("销售明细"), new JMenuItem("回款信息") };
        // 定义菜单项目对应的名称
        String[] _jMenuItem2Name = { "JF_view_query_jbqk", "JF_view_query_rkqk", "JF_view_query_kcmx_ck", "JF_view_query_kcmx_hk", "" };
        
        /* 设置菜单、菜单项 */
        for (int i = 0; i < _jMenu.length; i++) {
            jMenuBarMain.add(_jMenu[i]);
        }
        jMenuBarMain.add(getChuang_kouMenu());// 添加窗口菜单
        jMenuBarMain.add(getBang_zhuMenu());// 添加帮助菜单
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
        
        String TipString[] = { "药品录入", "供应商录入", "药品采购", "药品销售", "库存盘点", "销售退货", "客户回款", "基本查询", "入库明细", "销售明细", "用户管理", "系统退出" };
        
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

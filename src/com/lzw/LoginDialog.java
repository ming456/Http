package com.lzw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import com.lzw.dao.AdapterDao;
import com.lzw.model.Obj_UserName;
import com.lzw.view.JF_main;

public class LoginDialog extends JFrame {
    private static final long serialVersionUID = 8107215375516572660L;
    private LoginPanel loginPanel = null;
    private JLabel jLabel = null;
    private JTextField userField = null;
    private JLabel jLabel1 = null;
    private JPasswordField passwordField = null;
    private JButton loginButton = null;
    private JButton exitButton = null;
    private JF_main mainFrame;
    
    /**
     * @param owner
     */
    public LoginDialog() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            mainFrame = new JF_main();
            initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 初始化loginPanel登录面板的方法
     * 
     * @return com.lzw.login.LoginPanel
     */
    private LoginPanel getLoginPanel() {
        if (loginPanel == null) {
            jLabel1 = new JLabel();
            jLabel1.setFont(new Font("", Font.BOLD, 12));
            jLabel1.setBounds(new Rectangle(101, 147, 55, 18));
            jLabel1.setText("密　码：");
            jLabel = new JLabel();
            jLabel.setFont(new Font("", Font.BOLD, 12));
            jLabel.setText("用户名：");
            jLabel.setBounds(new Rectangle(100, 117, 56, 18));
            loginPanel = new LoginPanel();
            loginPanel.setLayout(null);
            loginPanel.setBackground(new Color(0xD8DDC7));
            loginPanel.add(jLabel);
            loginPanel.add(getUserField());
            loginPanel.add(jLabel1);
            loginPanel.add(getPasswordField());
            loginPanel.add(getLoginButton());
            loginPanel.add(getExitButton());
        }
        return loginPanel;
    }
    
    /**
     * This method initializes userField
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getUserField() {
        if (userField == null) {
            userField = new JTextField();
            userField.setBorder(new BevelBorder(BevelBorder.LOWERED));
            userField.setBounds(new Rectangle(157, 115, 127, 22));
        }
        return userField;
    }
    
    /**
     * This method initializes passwordField
     * 
     * @return javax.swing.JPasswordField
     */
    private JPasswordField getPasswordField() {
        if (passwordField == null) {
            passwordField = new JPasswordField();
            passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED));
            passwordField.setBounds(new Rectangle(158, 145, 125, 22));
            passwordField.addKeyListener(new KeyAdapter() {
               
                public void keyTyped(KeyEvent e) {
                    if (e.getKeyChar() == '\n')
                        loginButton.doClick();
                }
            });
        }
        return passwordField;
    }
    
    /**
     * This method initializes loginButton
     * 
     * @return javax.swing.JButton
     */
    private JButton getLoginButton() {
        if (loginButton == null) {
            loginButton = new JButton();
            loginButton.setContentAreaFilled(false);
            loginButton.setBounds(new Rectangle(155, 175, 58, 25));
            loginButton.setIcon(new ImageIcon(getClass().getResource("/images/loginButton.png")));
            loginButton.addActionListener(new ActionListener() {
                private Obj_UserName user;
                
          
                public void actionPerformed(ActionEvent e) {
                    String id = getUserField().getText().trim();
                    if (id == null || id.length() <= 0) {
                        JOptionPane.showMessageDialog(null, "输入用户ID不能为空,请重新输入!!!", "系统提示", JOptionPane.ERROR_MESSAGE);
                        getUserField().requestFocus();
                        return;
                    }
                    String sqlStr = "from Obj_UserName where id = '" + id + "'";
                    List list = null;
                    list = AdapterDao.QueryObject(sqlStr);
                    if (list.size() > 0) {
                        Iterator iterator = list.iterator();
                        user = (Obj_UserName) iterator.next();
                        String pass = new String(getPasswordField().getPassword());
                        if (!user.getPassword().equals(pass)) {
                            JOptionPane.showMessageDialog(LoginDialog.this, "用户名或密码错误，无法登录", "登录失败", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    Dimension frameSize = mainFrame.getSize();
                    if (frameSize.height > screenSize.height) {
                        frameSize.height = screenSize.height;
                    }
                    if (frameSize.width > screenSize.width) {
                        frameSize.width = screenSize.width;
                    }
                    mainFrame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
                    mainFrame.setVisible(true);
                    LoginDialog.this.setVisible(false);
                }
            });
        }
        return loginButton;
    }
    
    /**
     * This method initializes exitButton
     * 
     * @return javax.swing.JButton
     */
    private JButton getExitButton() {
        if (exitButton == null) {
            exitButton = new JButton();
            exitButton.setContentAreaFilled(false);
            exitButton.setBounds(new Rectangle(230, 175, 58, 25));
            exitButton.setIcon(new ImageIcon(getClass().getResource("/images/exitButton.png")));
            exitButton.addActionListener(new java.awt.event.ActionListener() {
                
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    System.exit(0);
                }
            });
        }
        return exitButton;
    }
    
    /**
     * 界面初始化方法
     * 
     * @return void
     */
    private void initialize() {
        Dimension size = getToolkit().getScreenSize();
        setLocation((size.width - 296) / 2, (size.height - 188) / 2);
        setSize(389, 256);
        this.setTitle("系统登录");
        setContentPane(getLoginPanel());
    }
    
    public static void main(String[] args) {
        try {
            new Thread() {
                private FileInputStream fis;
                private Scanner scanner;
                private LoginDialog jf_login;
                
                
                public void run() {
                    try {
                        initAndRecLog(); // 初始化并记录日志
                        fis = new FileInputStream("E:/18/APPJXC.log");
                        scanner = new Scanner(fis);
                        while (scanner.hasNextLine()) {
                            String str = scanner.nextLine();
                            int startInt = str.indexOf('-') + 1;
                            if (startInt == -1)
                                startInt = 0;
                            str = "启动信息：" + str.substring(startInt);
                            Thread.sleep(100);
                        }
                        scanner.close();
                        fis.close();
                        jf_login.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                
                // 初始化系统，并记录日志
                private void initAndRecLog() throws FileNotFoundException {
                    FileOutputStream fop = new FileOutputStream("E:/18/APPJXC.log", false);
                    PrintStream ps = new PrintStream(fop);
                    System.setOut(ps);
                    AdapterDao dao = new AdapterDao();
                    if (!dao.getdao())
                        return;
                    jf_login = new LoginDialog();
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

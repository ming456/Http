package com.lzw;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LoginPanel extends JPanel {
    private static final long serialVersionUID = 3500214226612130324L;
    public int width, height;
    private Image img;
    
    public LoginPanel() {
        super();
        URL url = getClass().getResource("/images/login.png");
        img = new ImageIcon(url).getImage();
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }
}
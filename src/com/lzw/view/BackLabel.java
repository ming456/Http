package com.lzw.view;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackLabel extends JLabel {
    /**
     * 
     */
    private static final long serialVersionUID = 1833942753717789856L;
    public int width, height;
    private Image img;
    
    public BackLabel() {
        super();
        URL url = getClass().getResource("/images/main.png");
        img = new ImageIcon(url).getImage();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        g.drawImage(img, 0, 0, width, height, this);
    }
}
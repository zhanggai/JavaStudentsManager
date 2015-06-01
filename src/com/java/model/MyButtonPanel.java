package com.java.model;

import javax.swing.*;

/**
 * 重写的JPanel类，用来放置一组按钮
 *
 * @author XuDing
 * @version 1.0
 */
public class MyButtonPanel extends JPanel {
    public MyButtonPanel(int y) {
        this(251, y, 192, 29);
    }

    public MyButtonPanel(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
    }

}

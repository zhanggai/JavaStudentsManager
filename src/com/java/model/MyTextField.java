package com.java.model;

import javax.swing.*;

/**
 * 重写的JTextField
 *
 * @author XuDing
 * @version 1.0
 */
public class MyTextField extends JTextField {
    public MyTextField(int y) {
        this(null, 251, y, 192, 29);
    }

    public MyTextField(String text, int x, int y, int width, int height) {
        setText(text);
        setBounds(x, y, width, height);

    }
}



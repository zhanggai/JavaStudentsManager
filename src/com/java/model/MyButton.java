package com.java.model;

import javax.swing.*;
import java.awt.*;

/**
 * 重写的JButton类
 */

public class MyButton extends JButton {
    public MyButton(String name, int font_size, int x, int y, int width, int height) {
        super(name);
        setFont(new Font("微软雅黑", Font.PLAIN, font_size));
        setBounds(x, y, width, height);
    }

}

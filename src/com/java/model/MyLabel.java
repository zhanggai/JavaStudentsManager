package com.java.model;

import javax.swing.*;
import java.awt.*;

/**
 * 重写的JLabel类
 *
 * @author XuDing
 * @version 1.0
 */
public class MyLabel extends JLabel
{
    public MyLabel(String name, int y)
    {
        this(name, 175, y, 66, 30);
    }

    public MyLabel(String name, int x, int y, int width, int height)
    {
        this(name, x, y, width, height, 19);
    }

    public MyLabel(String name, int x, int y, int width, int height, int font_size)
    {
        super(name);
        setFont(new Font("微软雅黑", Font.PLAIN, font_size));
        setBounds(x, y, width, height);
    }
}

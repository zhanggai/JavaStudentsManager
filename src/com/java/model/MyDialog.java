package com.java.model;

import javax.swing.*;

/**
 * 封装了弹出对话框功能的类
 *
 * @author XuDing
 * @version 1.0
 */
public class MyDialog
{
    public static void show(String message)
    {
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.WARNING_MESSAGE);
    }
}

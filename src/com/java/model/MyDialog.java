package com.java.model;

import javax.swing.*;

/**
 * 用于弹出对话框
 *
 * @author XuDing
 * @version 1.0
 */
public class MyDialog
{
    public static void show(String message)
    {
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.CLOSED_OPTION);
    }
}

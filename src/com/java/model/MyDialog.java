package com.java.model;

import javax.swing.JOptionPane;
/**
 * <p>Description: </p>
 *
 * @author XuDing
 * @version 1.0
 */
public class MyDialog
{
    public static void show(String message)
    {// 该函数封装了显示对话框的功能
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.CLOSED_OPTION);
    }
}

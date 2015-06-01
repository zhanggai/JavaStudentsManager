package com.java.model;

import javax.swing.*;

/**
 * 封装了弹出对话框功能的类
 *
 * @author XuDing
 * @version 1.0
 */
public class MyDialog {
    /**
     * 调用该方法将弹出一个对话框
     *
     * @param message 要显示在对话框里的信息
     */
    public static void show(String message) {
        JOptionPane.showMessageDialog(null, message, "", JOptionPane.WARNING_MESSAGE);
    }
}

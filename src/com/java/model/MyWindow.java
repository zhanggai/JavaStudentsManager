package com.java.model;

import com.java.utils.Strings;

import javax.swing.*;
import java.awt.*;

/**
 * 重写的JFrame
 *
 * @author XuDing
 */
public class MyWindow extends JFrame
{
    //    protected修饰的变量子类也能继承
    protected JPanel contentPane;

    //初始化窗口
    public void initialWindow(String title, String topic_label, int[] location)
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置点击叉号的操作为退出程序
        setAutoRequestFocus(true);//设置窗口最前
        setIconImage(Toolkit.getDefaultToolkit().getImage(Strings.ICON));// 设置左上角图标
        setSize(650, 450);
        setLocationRelativeTo(null);// 让窗口居中显示
        setTitle(title);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);// 设置窗口的布局方式为绝对布局，只根据坐标来定位
        // 设置主题标语
        JLabel label = new JLabel(topic_label);
        label.setFont(new Font("华文行楷", Font.PLAIN, 41));
        label.setBounds(location[0], location[1], location[2], location[3]);
        contentPane.add(label);
        setResizable(false);// 使窗口不可改变大小
    }
}

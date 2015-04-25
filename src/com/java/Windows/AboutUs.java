package com.java.Windows;

import com.java.model.MyWindow;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class AboutUs extends MyWindow
{

    /**
     * Create the frame.
     */
    public AboutUs()
    {
        initialWindow("关于我们", "关于我们", new int[]{227, 27, 181, 55});

        JLabel label_1 = new JLabel("班级：计类1402");
        label_1.setFont(new Font("微软雅黑", Font.PLAIN, 21));
        label_1.setBounds(237, 103, 234, 46);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("徐鼎");
        label_2.setFont(new Font("微软雅黑", Font.PLAIN, 22));
        label_2.setBounds(291, 177, 57, 30);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("郑炜");
        label_3.setFont(new Font("微软雅黑", Font.PLAIN, 22));
        label_3.setBounds(291, 229, 57, 30);
        contentPane.add(label_3);

        JLabel label_4 = new JLabel("许广悦");
        label_4.setFont(new Font("微软雅黑", Font.PLAIN, 22));
        label_4.setBounds(282, 275, 79, 30);
        contentPane.add(label_4);

        JButton backToHome = new JButton("返回首页");
        backToHome.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        backToHome.setBounds(265, 342, 105, 35);
        backToHome.addActionListener(e -> {
            new HomePage();
            setVisible(false);
        });
        contentPane.add(backToHome);

        setVisible(true);
    }
}
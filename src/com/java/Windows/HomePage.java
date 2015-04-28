package com.java.Windows;

import com.java.model.MyWindow;
import com.java.tools.Path;
import com.java.tools.WindowCache;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HomePage extends MyWindow
{
    /**
     * Create the frame.
     */
    public HomePage()
    {
        initialWindow("学籍管理系统", " 欢迎使用学籍管理系统", new int[]{108, 53, 466, 55});

        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setBounds(394, 171, 196, 196);
        contentPane.add(lblNewLabel);
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNewLabel.setIcon(new ImageIcon(Path.BAYMAX));//设置标签图片

        JButton button = new JButton("进入系统");
        button.addActionListener(e -> {
            WindowCache.showWindow("check_student");
            setVisible(false);
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 21));
        button.setBounds(108, 190, 229, 35);
        contentPane.add(button);

        JButton button_3 = new JButton("关于我们");
        button_3.addActionListener(e -> {
            WindowCache.showWindow("about_us");
            setVisible(false);
        });
        button_3.setFont(new Font("微软雅黑", Font.PLAIN, 21));
        button_3.setBounds(108, 260, 229, 35);
        contentPane.add(button_3);

        JButton button_2 = new JButton("注销账户");
        button_2.addActionListener(e -> {
            // new Login();
            WindowCache.showWindow("login");
            setVisible(false);
        });
        button_2.setFont(new Font("微软雅黑", Font.PLAIN, 21));
        button_2.setBounds(108, 330, 229, 35);
        contentPane.add(button_2);

    }
}

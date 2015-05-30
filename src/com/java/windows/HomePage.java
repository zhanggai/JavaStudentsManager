package com.java.windows;

import com.java.model.MyButton;
import com.java.model.MyWindow;
import com.java.utils.Strings;
import com.java.utils.WindowCache;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 主页
 */
public class HomePage extends MyWindow {
    /**
     * Create the frame.
     */
    public HomePage() {
        initialWindow("学籍管理系统", " 欢迎使用学籍管理系统", new int[]{108, 53, 466, 55});

        //set the image label
        JLabel image_label = new JLabel();
        image_label.setBounds(394, 171, 196, 196);
        contentPane.add(image_label);
        image_label.setHorizontalAlignment(SwingConstants.RIGHT);
        image_label.setVerticalAlignment(SwingConstants.BOTTOM);
        image_label.setIcon(new ImageIcon(Strings.BAYMAX));

        MyButton button_enter = new MyButton("进入系统", 21, 108, 190, 229, 35);
        button_enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    new ShowStudent().setVisible(true);
                    setVisible(false);
                }
            }
        });
        contentPane.add(button_enter);

        MyButton button_about = new MyButton("关于我们", 21, 108, 260, 229, 35);
        button_about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    WindowCache.showWindow("about_us");
                    setVisible(false);
                }
            }
        });
        contentPane.add(button_about);

        MyButton button_logout = new MyButton("注销账户", 21, 108, 330, 229, 35);
        button_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowCache.showWindow("login");
                setVisible(false);
            }
        });
        contentPane.add(button_logout);

    }
}

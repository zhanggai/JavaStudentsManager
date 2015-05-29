package com.java.windows;

import com.java.model.MyButton;
import com.java.model.MyLabel;
import com.java.model.MyWindow;
import com.java.utils.WindowCache;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutUs extends MyWindow {
    public AboutUs() {
        initialWindow("关于我们", "关于我们", new int[]{227, 27, 181, 55});

        contentPane.add(new MyLabel("班级：计类1402", 237, 103, 234, 46, 21));
        contentPane.add(new MyLabel("徐鼎", 291, 177, 57, 30, 22));
        contentPane.add(new MyLabel("郑炜", 291, 229, 57, 30, 22));
        contentPane.add(new MyLabel("许广悦", 282, 275, 79, 30, 22));

        MyButton Button_back = new MyButton("返回首页", 17, 265, 342, 105, 35);
        Button_back.addActionListener(

                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        WindowCache.showWindow("home_page");
                        setVisible(false);
                    }
                });

        contentPane.add(Button_back);

    }

}





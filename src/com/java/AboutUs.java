package com.java;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutUs extends JFrame
{

    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public AboutUs()
    {
        setAutoRequestFocus(true);//窗口自动最前
        setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\图片\\ps素材\\扁平化\\Nokia-MixRadio.png"));//设置左上角图标
        /*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
        setBounds(100, 100, 650, 450);
        setTitle("登录学籍管理系统");
        contentPane = new JPanel();
        /*contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));*/
        setContentPane(contentPane);
        contentPane.setLayout(null);//设置绝对布局

        //欢迎语
        JLabel label = new JLabel("关于我们");
        label.setFont(new Font("华文行楷", Font.PLAIN, 41));
        label.setBounds(227, 27, 181, 55);
        contentPane.add(label);

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
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    AboutUs frame = new AboutUs();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

}
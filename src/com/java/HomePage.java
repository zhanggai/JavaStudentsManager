package com.java;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HomePage extends JFrame
{

    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public HomePage()
    {
        setAutoRequestFocus(true);//窗口自动最前
        setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\图片\\ps素材\\扁平化\\Nokia-MixRadio.png"));//设置左上角图标
        /*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
        setBounds(100, 100, 650, 450);
        setTitle("学籍管理系统");
        contentPane = new JPanel();
		/*contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));*/
        setContentPane(contentPane);
        contentPane.setLayout(null);//设置绝对布局

        //欢迎语
        JLabel label = new JLabel("欢迎使用学籍管理系统");
        label.setFont(new Font("华文行楷", Font.PLAIN, 41));
        label.setBounds(108, 53, 466, 55);
        contentPane.add(label);

        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setBounds(394, 171, 196, 196);
        contentPane.add(lblNewLabel);
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		/*lblNewLabel.setToolTipText("");*/
        lblNewLabel.setIcon(new ImageIcon("F:\\图片\\BayMax.png"));//设置标签图片

        JButton button = new JButton("查询学生信息");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            }
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 21));
        button.setBounds(108, 187, 229, 35);
        contentPane.add(button);

        JButton button_1 = new JButton("添加学生信息");
        button_1.setFont(new Font("微软雅黑", Font.PLAIN, 21));
        button_1.setBounds(108, 257, 229, 35);
        contentPane.add(button_1);

        JButton button_3 = new JButton("关于我们");
        button_3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            }
        });
        button_3.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        button_3.setBounds(110, 342, 105, 35);
        contentPane.add(button_3);

        JButton button_2 = new JButton("退出系统");
        button_2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            }
        });
        button_2.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        button_2.setBounds(228, 342, 105, 35);
        contentPane.add(button_2);


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
                    HomePage frame = new HomePage();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}

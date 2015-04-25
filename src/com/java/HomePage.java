package com.java;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

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
        setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\\u56FE\u7247\\ps\u7D20\u6750\\\u6241\u5E73\u5316\\Nokia-MixRadio.png"));//设置左上角图标
        /*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
        setBounds(100, 100, 650, 450);
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
        lblNewLabel.setIcon(new ImageIcon("F:\\\u56FE\u7247\\BayMax.png"));//设置标签图片

        JButton button = new JButton("查询学生信息");
        button.setFont(new Font("微软雅黑", Font.PLAIN, 21));
        button.setBounds(108, 159, 229, 35);
        contentPane.add(button);

        JButton button_1 = new JButton("添加学生信息");
        button_1.setFont(new Font("微软雅黑", Font.PLAIN, 21));
        button_1.setBounds(108, 220, 229, 35);
        contentPane.add(button_1);

        JButton button_2 = new JButton("修改学生信息");
        button_2.setFont(new Font("微软雅黑", Font.PLAIN, 21));
        button_2.setBounds(108, 281, 229, 35);
        contentPane.add(button_2);

        JButton button_3 = new JButton("删除学生信息");
        button_3.setFont(new Font("微软雅黑", Font.PLAIN, 21));
        button_3.setBounds(108, 342, 229, 35);
        contentPane.add(button_3);


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

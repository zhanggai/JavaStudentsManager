package com.java;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddStudent extends JFrame
{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    /**
     * Create the frame.
     */
    public AddStudent()
    {
        setAutoRequestFocus(true);//窗口自动最前
        setTitle("添加学生信息");
        setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\图片\\ps素材\\扁平化\\Nokia-MixRadio.png"));//设置左上角图标
        /*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
        setBounds(100, 100, 650, 450);
        contentPane = new JPanel();
        /*contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));*/
        setContentPane(contentPane);
        contentPane.setLayout(null);//设置绝对布局

        //欢迎语
        JLabel label = new JLabel("添加学生信息");
        label.setFont(new Font("华文行楷", Font.PLAIN, 41));
        label.setBounds(192, 24, 279, 55);
        contentPane.add(label);

        JLabel label_1 = new JLabel("学号：");
        label_1.setFont(new Font("微软雅黑", Font.PLAIN, 19));
        label_1.setBounds(175, 120, 66, 30);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("姓名：");
        label_2.setFont(new Font("微软雅黑", Font.PLAIN, 19));
        label_2.setBounds(175, 170, 66, 30);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("性别：");
        label_3.setFont(new Font("微软雅黑", Font.PLAIN, 19));
        label_3.setBounds(175, 220, 66, 30);
        contentPane.add(label_3);

        JLabel label_4 = new JLabel("籍贯：");
        label_4.setFont(new Font("微软雅黑", Font.PLAIN, 19));
        label_4.setBounds(175, 270, 66, 30);
        contentPane.add(label_4);

        JLabel label_5 = new JLabel("生日：");
        label_5.setFont(new Font("微软雅黑", Font.PLAIN, 19));
        label_5.setBounds(175, 320, 66, 30);
        contentPane.add(label_5);

        textField = new JTextField();
        textField.setBounds(251, 120, 177, 29);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(251, 170, 177, 29);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(251, 220, 177, 29);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(251, 270, 177, 29);
        contentPane.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(251, 320, 177, 29);
        contentPane.add(textField_4);

        JButton button = new JButton("确定");
        button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button.setBounds(242, 371, 81, 30);
        contentPane.add(button);

        JButton button_1 = new JButton("取消");
        button_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button_1.setBounds(358, 371, 81, 30);
        contentPane.add(button_1);
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
                    AddStudent frame = new AddStudent();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

}

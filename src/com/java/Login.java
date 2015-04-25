package com.java;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame
{

    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Create the frame.
     */
    public Login()
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
        JLabel label = new JLabel("管理员登录");
        label.setFont(new Font("华文行楷", Font.PLAIN, 41));
        label.setBounds(203, 31, 216, 55);
        contentPane.add(label);

        JLabel label_1 = new JLabel("账号：");
        label_1.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        label_1.setBounds(142, 131, 54, 15);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("密码：");
        label_2.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        label_2.setBounds(142, 204, 54, 15);
        contentPane.add(label_2);

        textField = new JTextField();
        textField.setBounds(227, 122, 192, 29);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(227, 195, 192, 29);
        contentPane.add(passwordField);

        JButton btnNewButton = new JButton("登录");
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        btnNewButton.setBounds(270, 310, 98, 38);
        contentPane.add(btnNewButton);

        JCheckBox chckbxNewCheckBox = new JCheckBox("记住密码");
        chckbxNewCheckBox.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        chckbxNewCheckBox.setBounds(280, 244, 78, 23);
        contentPane.add(chckbxNewCheckBox);
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
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}

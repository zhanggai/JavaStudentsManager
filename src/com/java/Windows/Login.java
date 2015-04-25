package com.java.Windows;

import com.java.model.MyWindow;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends MyWindow
{

    public Login()
    {
        initialWindow("登录", "管理员登录", new int[]{203, 31, 216, 55});


        JLabel label_1 = new JLabel("账号：");
        label_1.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        label_1.setBounds(142, 131, 54, 15);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("密码：");
        label_2.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        label_2.setBounds(142, 204, 54, 15);
        contentPane.add(label_2);

        JTextField textField = new JTextField();
        textField.setBounds(227, 122, 192, 29);
        contentPane.add(textField);
        textField.setColumns(10);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(227, 195, 192, 29);
        contentPane.add(passwordField);

        JButton btnNewButton = new JButton("登录");
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        btnNewButton.setBounds(270, 310, 98, 38);
        btnNewButton.addActionListener(e -> {
            new HomePage();
            setVisible(false);
        });
        contentPane.add(btnNewButton);

        JCheckBox chckbxNewCheckBox = new JCheckBox("记住密码");
        chckbxNewCheckBox.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        chckbxNewCheckBox.setBounds(280, 244, 78, 23);
        contentPane.add(chckbxNewCheckBox);

        setVisible(true);
    }
}

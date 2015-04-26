package com.java.Windows;

import com.java.model.MyWindow;
import com.java.model.User;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        textField.setText(User.ID);
        textField.setBounds(227, 122, 192, 29);
        contentPane.add(textField);
        textField.setColumns(10);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setText(String.valueOf(User.PASSWORD));
        passwordField.setBounds(227, 195, 192, 29);
        contentPane.add(passwordField);

        JButton btnNewButton = new JButton("登录");
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        btnNewButton.setBounds(270, 310, 98, 38);
        btnNewButton.addActionListener(e -> {

            String id = textField.getText();
            String password = new String(passwordField.getPassword());
            String userId = User.ID;
            String userPw = new String(User.PASSWORD);

            if (id.equals(userId) && password.equals(userPw))
            {
                new HomePage();
                setVisible(false);
            } else
            {
                JOptionPane.showMessageDialog(null, "用户名或密码错误！", "错误", JOptionPane.ERROR_MESSAGE);
            }

        });
        contentPane.add(btnNewButton);

        setVisible(true);
    }
}

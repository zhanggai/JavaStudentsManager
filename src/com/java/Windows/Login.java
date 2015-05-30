package com.java.windows;

import com.java.model.MyButton;
import com.java.model.MyLabel;
import com.java.model.MyTextField;
import com.java.model.MyWindow;
import com.java.utils.JDBCutils;
import com.java.utils.Strings;
import com.java.utils.WindowCache;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 登录界面
 */
public class Login extends MyWindow {
    public Login() {
        initialWindow("登录", "管理员登录", new int[]{203, 31, 216, 55});

        contentPane.add(new MyLabel("账号：", 142, 119, 66, 30));
        contentPane.add(new MyLabel("密码：", 142, 193, 66, 30));

        MyTextField textField = new MyTextField(Strings.ID, 227, 122, 192, 29);
        contentPane.add(textField);

        JPasswordField passwordField = new JPasswordField(Strings.PASSWORD);
        passwordField.setBounds(227, 195, 192, 29);
        contentPane.add(passwordField);

        MyButton button_login = new MyButton("登录", 20, 270, 310, 98, 38);
        button_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    String id = textField.getText();
                    String password = passwordField.getText();

                    loginConfirm(id, password);
                }
            }
        });
        contentPane.add(button_login);
    }

    public void loginConfirm(String id, String password) {
        if (id.equals(Strings.ID) && password.equals(Strings.PASSWORD)) {
            WindowCache.showWindow("home_page");
            setVisible(false);
            JDBCutils.getConnection();//打开数据库连接
        } else {
            JOptionPane.showMessageDialog(null, "用户名或密码错误！", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }
}

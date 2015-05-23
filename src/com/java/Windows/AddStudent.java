package com.java.windows;

import com.java.data.Data;
import com.java.model.MyButton;
import com.java.model.MyButtonPanel;
import com.java.model.MyDialog;
import com.java.model.MyLabel;
import com.java.model.MyTextField;
import com.java.model.MyWindow;
import com.java.model.Student;
import com.java.utils.WindowCache;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class AddStudent extends MyWindow
{
    private String sex;
    public AddStudent()
    {
        initialWindow("添加学生信息", "添加学生信息", new int[]{192, 24, 279, 55});

        contentPane.add(new MyLabel("学号：", 120));
        contentPane.add(new MyLabel("姓名：", 170));
        contentPane.add(new MyLabel("性别：", 220));
        contentPane.add(new MyLabel("籍贯：", 270));
        contentPane.add(new MyLabel("生日：", 320));
        MyTextField num_field = new MyTextField(120);
        MyTextField name_field = new MyTextField(170);
        MyTextField location_field = new MyTextField(270);
        MyTextField birth_field = new MyTextField(320);
        MyButtonPanel button_panel = new MyButtonPanel(220);

        initButtonPanel(button_panel);

        contentPane.add(button_panel);
        contentPane.add(num_field);
        contentPane.add(name_field);
        contentPane.add(location_field);
        contentPane.add(birth_field);

        MyButton button_ensure = new MyButton("确定", 18, 242, 371, 81, 30);

        button_ensure.addActionListener(e -> {
            String num = num_field.getText();
            String name = name_field.getText();
            String location = location_field.getText();
            String birth = birth_field.getText();
            if (checkInput(num, name, location, birth))
            {
                Student student = new Student(num, name, sex, location, birth);
                Data.getData().add(student);
                WindowCache.showWindow("check_student");
                setVisible(false);
            }
        });
        contentPane.add(button_ensure);
        MyButton button_cancel = new MyButton("取消", 18, 358, 371, 81, 30);
        button_cancel.addActionListener(e -> {
            WindowCache.showWindow("home_page");
            setVisible(false);
        });
        contentPane.add(button_cancel);
    }

    private void initButtonPanel(MyButtonPanel button_panel)
    {
        ButtonGroup radio_group = new ButtonGroup();
        JRadioButton male_button = new JRadioButton("男");
        JRadioButton female_button = new JRadioButton("女");
        button_panel.add(male_button);
        button_panel.add(female_button);
        radio_group.add(male_button);
        radio_group.add(female_button);

        male_button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                sex = "男";
            }
        });
        female_button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                sex = "女";
            }
        });
    }

    private boolean checkInput(String num, String name, String location, String birth)
    {
        boolean flag = false;
        if (!num.matches("[0-9]{10}"))
        {
            MyDialog.show("学号为10位数字！");
        } else if (!name.matches("[\\u4E00-\\u9FA5]{2,4}"))
        {
            MyDialog.show("请填写正确的姓名！");
        } else if (!location.matches("[\\u4E00-\\u9FA5]{2,5}"))
        {
            MyDialog.show("请填写正确的籍贯！");
        } else if (!birth.matches("[1][9][0-9]{2}[/.]([0][1-9]|[1][0-2])[/.]([0][1-9]|[1][0-9]|[2][0-9]|[3][0-1])"))
        {
            MyDialog.show("请填写正确的出生年月！如1996.01.01");
        } else flag = true;

        return flag;
    }
}

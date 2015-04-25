package com.java.Windows;

import com.java.model.MyWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


public class CheckStudent extends MyWindow
{


    /**
     * Create the frame.
     */
    public CheckStudent()
    {
        initialWindow("学生信息", "学生信息", new int[]{238, 10, 173, 45});

        JTable table = new JTable(15, 6);
        table.setRowSelectionAllowed(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.setBounds(10, 86, 614, 240);
        contentPane.add(table);



        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(360, 55, 76, 21);
        contentPane.add(comboBox);

        JTextField textField = new JTextField();
        textField.setBounds(133, 55, 217, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton button = new JButton("搜索");
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
        button.setBounds(457, 54, 63, 23);
        contentPane.add(button);

        JButton button_1 = new JButton("保存修改");
        button_1.addActionListener(e -> {

        });
        button_1.setBounds(279, 364, 93, 23);
        contentPane.add(button_1);

        JButton btnNewButton = new JButton("删除选中");
        btnNewButton.addActionListener(e -> JOptionPane.showConfirmDialog(null, "删除后不可恢复，你确定要删除吗？", "确认删除", JOptionPane.OK_CANCEL_OPTION));
        btnNewButton.setBounds(176, 364, 93, 23);
        contentPane.add(btnNewButton);

        JButton button_2 = new JButton("返回首页");
        button_2.addActionListener(e -> {
            new HomePage();
            setVisible(false);
        });
        button_2.setBounds(382, 364, 93, 23);
        contentPane.add(button_2);

        JLabel label_1 = new JLabel("第");
        label_1.setBounds(489, 336, 30, 15);
        contentPane.add(label_1);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(507, 333, 48, 21);
        contentPane.add(comboBox_1);

        JLabel label_2 = new JLabel("页");
        label_2.setBounds(558, 336, 54, 15);
        contentPane.add(label_2);


        setVisible(true);
    }
}

package com.java;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class CheckStudent extends JFrame
{

    private JPanel contentPane;
    private JTable table;
    private JTextField textField;

    /**
     * Create the frame.
     */
    public CheckStudent()
    {
        setAutoRequestFocus(true);//窗口自动最前
        setTitle("学生信息");
        setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\\u56FE\u7247\\ps\u7D20\u6750\\\u6241\u5E73\u5316\\Nokia-MixRadio.png"));//设置左上角图标
        /*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
        setBounds(100, 100, 650, 450);
        contentPane = new JPanel();
        /*contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));*/
        setContentPane(contentPane);
        contentPane.setLayout(null);//设置绝对布局

        table = new JTable(15, 6);
        table.setRowSelectionAllowed(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.setBounds(10, 86, 614, 240);
        contentPane.add(table);

        //欢迎语
        JLabel label = new JLabel("学生信息");
        label.setFont(new Font("华文行楷", Font.PLAIN, 41));
        label.setBounds(238, 10, 173, 45);
        contentPane.add(label);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(360, 55, 76, 21);
        contentPane.add(comboBox);

        textField = new JTextField();
        textField.setBounds(133, 55, 217, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton button = new JButton("\u641C\u7D22");
        button.setBounds(457, 54, 63, 23);
        contentPane.add(button);

        JButton button_1 = new JButton("保存修改");
        button_1.setBounds(279, 364, 93, 23);
        contentPane.add(button_1);

        JButton button_2 = new JButton("返回首页");
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

        JButton btnNewButton = new JButton("删除选中");
        btnNewButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            }
        });
        btnNewButton.setBounds(176, 364, 93, 23);
        contentPane.add(btnNewButton);
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
                    CheckStudent frame = new CheckStudent();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}

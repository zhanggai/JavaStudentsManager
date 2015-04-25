package com.java.model;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * <p>Description:A class that describes window.</p>
 *
 * @author XuDing
 * @version1.0
 * @date 2015/4/21
 */
public class MyWindow extends JFrame
{
    protected JPanel contentPane;//子类可访问

    public void initialWindow(String title, String topic_label, int[] location)
    {
        setType(Type.POPUP);//窗口标题栏类型
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置点击叉的操作
        setAutoRequestFocus(true);//窗口自动最前
        setIconImage(Toolkit.getDefaultToolkit().getImage(Path.ICON));//设置左上角图标
        setSize(650, 450);
        setLocationRelativeTo(null);//窗口居中
        setTitle(title);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);//设置绝对布局
        //欢迎语
        JLabel label = new JLabel(topic_label);
        label.setFont(new Font("华文行楷", Font.PLAIN, 41));
        label.setBounds(location[0], location[1], location[2], location[3]);
        contentPane.add(label);
        setResizable(false);//窗口大小固定
    }
}


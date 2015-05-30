package com.java.model;

import com.java.utils.Strings;

import javax.swing.*;
import java.awt.*;

/**
 * <p>
 * Description:A class that describes window.
 * </p>
 *
 * @author XuDing
 */
public class MyWindow extends JFrame
{
    protected JPanel contentPane;// keep the variable be available to subclass

    public void initialWindow(String title, String topic_label, int[] location)
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// set the operation of clicking the fork
        setAutoRequestFocus(true);// keep the window focused
        setIconImage(Toolkit.getDefaultToolkit().getImage(Strings.ICON));// set icon
        setSize(650, 450);
        setLocationRelativeTo(null);// set the window in the center of screen
        setTitle(title);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);// set the layout by coordinate
        // set topic
        JLabel label = new JLabel(topic_label);
        label.setFont(new Font("华文行楷", Font.PLAIN, 41));
        label.setBounds(location[0], location[1], location[2], location[3]);
        contentPane.add(label);
        setResizable(false);// make the window keep it's size
    }
}

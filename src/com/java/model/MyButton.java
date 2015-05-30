package com.java.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Description: a button model</p> </p>
 *
 * @author XuDing
 * @version 1.0
 */
public class MyButton extends JButton
{
    public MyButton(String name, int font_size, int x, int y, int width, int height)
    {
        super(name);
        setFont(new Font("微软雅黑", Font.PLAIN, font_size));
        setBounds(x, y, width, height);
        addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
        });
    }

}

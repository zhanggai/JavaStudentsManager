package com.java.model;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <p>Description:A class that describes window.</p>
 *
 * @author XuDing
 * @version1.0
 * @date 2015/4/21
 */
public class MyWindow extends JFrame
{
    private JPanel image_panel;
    private JPanel defaultPanel;
    public MyWindow(String image_path)
    {
        image_panel = new JPanel()
        {
            @Override
            public void paint(Graphics g)
            {
                Image image = new ImageIcon(image_path).getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
            }
        };
        add(image_panel);
    }


    public MyWindow()
    {
        defaultPanel = new JPanel(new FlowLayout());
        add(defaultPanel);
    }

    public JPanel getImage_panel()
    {
        return image_panel;
    }

    public JPanel getDefaultPanel()
    {
        return defaultPanel;
    }
    public void init()
    {
    /*Set the location relative to the parent component.
    If the parent is null,it will be set in the center of screen.*/
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}


package com.experience.model;


import java.awt.FlowLayout;

import javax.swing.JButton;
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
    public MyWindow()
    {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JButton("管理登录"));
        /*JPanel contentPane=new JPanel(){
            public void paint(Graphics g) {
                ImageIcon icon=new ImageIcon("2.jpg");
                Image image=icon.getImage();
                g.drawImage(image, 0,0,null);
            }
        };*/
        getContentPane().add(panel);
    }

    public void init()
    {
    /*Set the location relative to the parent component.
    If the parent is null,it will be set in the center of screen.*/
        this.setSize(800, 600);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
}


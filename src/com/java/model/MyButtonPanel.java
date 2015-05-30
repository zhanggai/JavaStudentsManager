package com.java.model;

import javax.swing.*;

/**
 * <p>Description: </p>
 *
 * @author XuDing
 * @version 1.0
 */
public class MyButtonPanel extends JPanel
{
    public MyButtonPanel(int y)
    {
        this(251, y, 192, 29);
    }

    public MyButtonPanel(int x, int y, int width, int height)
    {
        setBounds(x, y, width, height);
    }

}

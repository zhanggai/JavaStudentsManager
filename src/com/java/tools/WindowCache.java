package com.java.tools;

import com.java.model.MyWindow;

import java.util.HashMap;

/**
 * <p>Description: </p>
 *
 * @author XuDing
 * @version 1.0
 */

public class WindowCache
{
    static HashMap<String, MyWindow> windowMap = new HashMap<>();

    public static MyWindow getWindow(String key)
    {
        return windowMap.get(key);
    }

    public static void addWindow(String key, MyWindow window)
    {
        windowMap.put(key, window);
    }
}
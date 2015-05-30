package com.java.utils;

import com.java.model.MyWindow;
import com.java.windows.*;

import java.util.HashMap;

/**
 * 存放了所有窗口对象的类，当需要显示一个窗口时，就将该窗口对象调用，避免重复建立窗口对象
 *
 * @author XuDing
 * @version 1.0
 */

public class WindowCache
{
    //使用HashMap存放窗口对象
    static HashMap<String, MyWindow> windowMap = new HashMap<>();

    static
    {
        windowMap.put("login", new Login());
        windowMap.put("home_page", new HomePage());
        windowMap.put("show_student", new ShowStudent());
        windowMap.put("add_student", new AddStudent());
        windowMap.put("about_us", new AboutUs());
        windowMap.put(null, null);
    }

    public static void showWindow(String key)
    {
        windowMap.get(key).setVisible(true);
    }
}



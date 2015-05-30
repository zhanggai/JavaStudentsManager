package com.java.utils;

import com.java.model.MyWindow;
import com.java.windows.*;

import java.util.HashMap;

/**
 * <p>Description: a container for window instance</p>
 *
 * @author XuDing
 * @version 1.0
 */

public class WindowCache
{
    //save all window instance
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
        getWindow(key).setVisible(true);
    }

    public static MyWindow getWindow(String key)
    {
        return windowMap.get(key);
    }
}



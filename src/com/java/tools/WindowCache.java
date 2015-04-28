package com.java.tools;

import com.java.Windows.AboutUs;
import com.java.Windows.AddStudent;
import com.java.Windows.CheckStudent;
import com.java.Windows.HomePage;
import com.java.Windows.Login;
import com.java.model.MyWindow;

import java.util.HashMap;

/**
 * <p>Description: a container for window instance</p>
 *
 * @author XuDing
 * @version 1.0
 */

public class WindowCache
{//save all window instance
    static HashMap<String, MyWindow> windowMap = new HashMap<>();

    static
    {
        windowMap.put("login", new Login());
        windowMap.put("home_page", new HomePage());
        windowMap.put("check_student", new CheckStudent());
        windowMap.put("add_student", new AddStudent());
        windowMap.put("about_us", new AboutUs());
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



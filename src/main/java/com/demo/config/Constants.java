package com.demo.config;

import com.demo.driver.BrowserType;

public final class Constants {

    //Prevent Init
    private Constants() {};

    /**
     * Change the value to switch between browsers
     */
    public static final String BROWSER_TYPE = "chrome";

    /**
     * Javafaker locale
     */
    public static String Faker_Locale = "us";

    /**
     * Global test timeout
     */
    public static int Timeout = 20;

    public static String Grid_Url = "hvnhcvdev08.cybersoft.vn:4444";

    /**
     * Initial URL
     */
    public static String Url_OrangeHRM = "https://opensource-demo.orangehrmlive.com/";
    public static String Url_herokuapp = "https://the-internet.herokuapp.com/";

}
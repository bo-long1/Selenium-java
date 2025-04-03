package com.demo.config;

import com.demo.driver.BrowserType;

public final class Constants {

    //Prevent Init
    private Constants() {};

    /**
     * Change the value to switch between browsers
     */
    public static final String BROWSER_TYPE = "Chrome";

    /**
     * Javafaker locale
     */
    public static String Faker_Locale = "us";

    /**
     * Global test timeout
     */
    public static int Timeout = 20;

    //public static String Grid_Url = "donkey.cybersoft.vn:8083";
    public static String Grid_Url = "";

    /**
     * Initial URL
     */
    // public static String Url_OrangeHRM = "https://opensource-demo.orangehrmlive.com/";
    // public static String Url = "https://the-internet.herokuapp.com/";
    // public static String Url = "https://www.fahasa.com/customer/account/create";
    // public static String Url = "https://login.ubuntu.com/";  //ubuntu.com
    // public static String Url = "https://automationfc.github.io/basic-form/index.html"; //basic-form
    // public static String Url = "https://automationfc.github.io/jquery-selectable/"; //jquery-selectable
    public static String Url = "https://vnexpress.net/";

}
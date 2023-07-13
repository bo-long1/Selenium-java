package com.demo.driver;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LaunchBrowser {
    static WebDriver driver;

    public static WebDriver getDriver(String browser) {

        driver = BrowserType.valueOf(browser.toUpperCase()).createDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
        
    }
}


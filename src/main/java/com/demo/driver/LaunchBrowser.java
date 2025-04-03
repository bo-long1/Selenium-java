package com.demo.driver;

import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class LaunchBrowser {
    static WebDriver driver;

    public static WebDriver getDriver(String browser) {

        driver = BrowserType.valueOf(browser.toUpperCase()).createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Use Duration-based API
        return driver;
        
    }
}


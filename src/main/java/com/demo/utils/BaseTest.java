package com.demo.utils;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.demo.config.Constants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;
import org.testng.annotations.Listeners;
import java.io.File;

import com.demo.driver.LaunchBrowser;
import com.demo.driver.DriverManager;
import com.demo.report.TestListener;
import com.demo.report.ReportListener;
import com.demo.report.AllureManager;

//@Listeners({ExtentITestListenerClassAdapter.class, ReportListener.class})
@Listeners({TestListener.class})
public abstract class BaseTest {

    //protected static WebDriver driver;

    // public static WebDriver getDriver() {
    //     return driver;
    // }

    @BeforeMethod
    @Parameters(value={"browser"})
    public void preCondition(@Optional(Constants.BROWSER_TYPE) String browser) {

        WebDriver driver = LaunchBrowser.getDriver(browser);
        DriverManager.setDriver(driver);
    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        DriverManager.quit();
    }
}
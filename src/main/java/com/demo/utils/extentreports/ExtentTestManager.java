package com.demo.utils.extentreports;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.demo.config.Constants;
import com.demo.driver.LaunchBrowser;

public class ExtentTestManager {
        static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ExtentManager.getExtentReports();

    public static ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest saveToReport(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }

    public WebDriver getDriver(@Optional(Constants.BROWSER_TYPE) String browser) {
        WebDriver driver = LaunchBrowser.getDriver(browser);
        return driver;
    }

    public static void addScreenShot(String message) throws IOException {
        String base64Image = "data:image/png;base64,"
                + ((TakesScreenshot) LaunchBrowser.getDriver("")).getScreenshotAs(OutputType.BASE64);
        getTest().log(Status.INFO, message,        
        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
    }

    public static void addScreenShot(Status status, String message) throws IOException {

        String base64Image = "data:image/png;base64,"
                + ((TakesScreenshot) LaunchBrowser.getDriver("")).getScreenshotAs(OutputType.BASE64);
        getTest().log(status, message,               
        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
    }

    public static void logMessage(String message) {
        getTest().log(Status.INFO, message);
    }

    public static void logMessage(Status status, String message) {
        getTest().log(status, message);
    }

}

package com.demo.utils;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.demo.config.Constants;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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

    private WebDriver driver;

    @BeforeTest
    @Parameters(value={"browser"})
    public void preCondition(@Optional(Constants.BROWSER_TYPE) String browser) {
        driver = LaunchBrowser.getDriver(browser);
        DriverManager.setDriver(driver);
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) throws InterruptedException {
        //WebDriver driver = LaunchBrowser.getDriver(Constants.BROWSER_TYPE);
        Thread.sleep(1000);
        //Khởi tạo đối tượng result thuộc ITestResult để lấy trạng thái và tên của từng Test Case
        //Ở đây sẽ so sánh điều kiện nếu testcase passed hoặc failed
        //passed = SUCCESS và failed = FAILURE
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // Tạo tham chiếu của TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;
                // Gọi hàm capture screenshot - getScreenshotAs
                File source = ts.getScreenshotAs(OutputType.FILE);
                //Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
                File theDir = new File("./reports/");
                if (!theDir.exists()) {
                    theDir.mkdirs();
                }
                // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình
                FileHandler.copy(source, new File("./reports/" + result.getName() + ".png"));
                System.out.println("Screenshot taken: " + result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }

    @AfterTest
    public void postCondition() throws Exception{
        // Quit the Browser
        Thread.sleep(1000);
        DriverManager.quit();
    }
}
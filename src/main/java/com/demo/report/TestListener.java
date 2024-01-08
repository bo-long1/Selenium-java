package com.demo.report;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.service.ExtentTestManager;
/*** Import modules from Selenium Base ***/
import com.demo.report.AllureManager;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        // empty
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        reportPrint();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failTest(result);
        reportPrint();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.error(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // empty
    }

    @Override
    public void onStart(ITestContext context) {
        // empty
    }

    @Override
    public void onFinish(ITestContext context) {
        // empty
    }

    // @Override
    // public void onTestFailure(ITestResult result) {
    //     LogUtils.error("Test case " + result.getName() + " is failed.");
    //     //Screenshot khi fail
    //     CaptureHelper.captureScreenshot(result.getName());
    //     LogUtils.error(result.getThrowable().toString());

    //     //Extent Report
    //     ExtentTestManager.addScreenShot(result.getName());
    //     ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
    //     ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");

    //     //Allure Report
    //     AllureManager.saveTextLog(result.getName() + " is failed.");
    //     AllureManager.saveScreenshotPNG();
    // }

    private void failTest(ITestResult iTestResult) {
        logger.error(iTestResult.getTestClass().getName());
        logger.error(iTestResult.getThrowable());
    }

    private void reportPrint() {
        AllureManager.takeScreenshotToAttachOnAllureReport();
    }
    
    
}


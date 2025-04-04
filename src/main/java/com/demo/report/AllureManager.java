package com.demo.report;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;

import static org.openqa.selenium.OutputType.BYTES;

import com.demo.driver.DriverManager;

public class AllureManager {

    private AllureManager() {
    }

    public static void setAllureEnvironmentInformation() {
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String, String>builder().
                        put("Target execution", "Local").
                        put("Global timeout", "10").
                        put("Faker locale", "us").
                        build(), System.getProperty("user.dir")
                        + "/target/allure-results/");
    }
    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
    //Screenshot attachments for Allure
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshotToAttachOnAllureReport() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(BYTES);
    }

    public static void saveScreenshotPNG() {
    }

}

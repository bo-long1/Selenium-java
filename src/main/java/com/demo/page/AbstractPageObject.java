package com.demo.page;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

import com.demo.config.Constants;
import com.demo.driver.DriverManager;

public class AbstractPageObject {

    protected static WebDriver driver; // Declare driver as protected

    public AbstractPageObject(WebDriver driver) {
        this.driver = driver; // Initialize driver in the constructor
        PageFactory.initElements(driver, this); // Initialize PageFactory elements
    }

    //*********Constructor*********
    protected AbstractPageObject() {
        this.driver = DriverManager.getDriver();
        
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @Step
    public void openWebsite() {
        DriverManager.getDriver().get(Constants.Url);
    }
}

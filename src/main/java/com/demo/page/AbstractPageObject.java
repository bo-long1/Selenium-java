package com.demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import com.demo.utils.BaseTest;

import io.qameta.allure.Step;

import com.demo.config.Constants;
import com.demo.driver.DriverManager;

public class AbstractPageObject {

    //*********Constructor*********
    protected AbstractPageObject() {
        //this.driver = DriverManager.getDriver();
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    // public void clickLink(String text){
    //     WebElement element = DriverManager.getDriver().findElement(By.xpath("//li/a[text()='"+ text +"']"));
    //     element.click();
    // }

    @Step
    public void openWebsite() {
        DriverManager.getDriver().get(Constants.Url_herokuapp);
    }
}

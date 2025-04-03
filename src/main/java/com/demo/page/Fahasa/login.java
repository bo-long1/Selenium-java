package com.demo.page.Fahasa;

import com.demo.driver.DriverManager;
import com.demo.utils.BaseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

import com.demo.page.AbstractPageObject;

public class login extends AbstractPageObject {
    public login(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(css = "a[href='/customer/account/']")
    private WebElement login_tab;

    @FindBy(xpath = "(//button[@class='fhs-btn-login'])")
    public WebElement btn_login;

    @FindBy(xpath = "//input[@id='login_username']") 
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@id='login_password']") 
    private WebElement inputPassword;

    @Step
    public void login_tab(){
        openWebsite();
        login_tab.click();
    }

    @Step
    public String check_btn_login(){
        if (btn_login.isDisplayed()) {
            return btn_login.getCssValue("background-color");
        } else {
            throw new IllegalStateException("Login button is not displayed");
        }
    }

    
    public boolean isLoginButtonDisabled() {
        return btn_login.isDisplayed();
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.elementToBeClickable(inputUsername));
        inputUsername.clear();
        inputUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(inputPassword));
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }

    public void login(String username, String password) {
        this.enterUsername(username);
        this.enterPassword(password);
        this.check_btn_login();
    }
}

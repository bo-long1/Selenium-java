package com.demo.page.autoOrangeHRM;

import io.qameta.allure.Step;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.driver.DriverManager;
import com.demo.page.AbstractPageObject;

public class loginPage extends AbstractPageObject{
    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;


    public loginPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Step
    public String getTitlePage() {
        openWebsite();
        return AbstractPageObject.driver.getTitle();
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

    public void clickLoginButton() {
        btnLogin.click();
    }

    public void login(String username, String password) {
        openWebsite();
        this.enterUsername(username);
        this.enterPassword(password);
        this.clickLoginButton();
    }

}

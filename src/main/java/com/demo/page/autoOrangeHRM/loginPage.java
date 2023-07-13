package com.demo.page.autoOrangeHRM;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.driver.DriverManager;

public class loginPage extends navigationPage{
    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
    public WebDriver driver;
    @Step
    public String getTitlePage() {
        openWebsite();
        this.driver.getTitle();
        return getTitlePage();
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

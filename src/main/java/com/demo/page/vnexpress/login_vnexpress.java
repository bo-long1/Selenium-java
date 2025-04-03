package com.demo.page.vnexpress;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

import com.demo.page.AbstractPageObject;

public class login_vnexpress extends AbstractPageObject {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath = "//a[@title='Đăng nhập']")
    private WebElement btnLogin;


    // public login_vnexpress(WebDriver driver) {
    //     super(driver); // Pass the WebDriver instance to the parent class
    //     PageFactory.initElements(driver, this); // Initialize WebElements
    // }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(btnLogin)); // Wait until the button is visible
        btnLogin.click(); // Click the login button
    }

    public String handleIframe() {
        // Wait for the iframe to be available and switch to it
        driver.switchTo().frame(0);
        // Locate the element inside the iframe and get its text
        WebElement textElement = driver.findElement(By.xpath("//h2[text()='Đăng nhập / Tạo tài khoản']")); // Replace with the correct locator
        String text = textElement.getText(); // Get the text inside the iframe
        return text; // Return the page title
    }

    public void inputEmail(String email) {
        WebElement emailField = driver.findElement(By.xpath("//input[@id='myvne_email_input']"));
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickNextButton() {
        WebElement nextButton = driver.findElement(By.xpath("//button[@id='checkAccount']"));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

    public void inputPassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='myvne_password_input']"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        // passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton2() {
        WebElement nextButton = driver.findElement(By.xpath("//button[@id='myvne_button_login']"));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        //nextButton.click();
        // Simulate pressing Enter
        nextButton.sendKeys(Keys.ENTER);
    }

    public String getErrorMessage() {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
        By errorMessageLocator = By.xpath("//div[@id='error_myvne_password']");
        try {
            WebElement errorMessage = wait2.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator)); // Wait until the error message is visible
            return errorMessage.getText(); // Return the error message text
        } catch (TimeoutException e) {
            throw new RuntimeException("Error message did not appear within the timeout period.", e);
        }
    }
}

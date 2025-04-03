package com.demo.page.basic_form;
import com.demo.page.AbstractPageObject;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class alert extends AbstractPageObject {
    
    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    private WebElement jsConfirmButton;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    private WebElement jsPromptButton;

    @FindBy(id = "result") // Replace "result" with the actual ID of the result element
    private WebElement resultMessageElement;

    public alert(WebDriver driver) {
        super(driver); // Call the superclass constructor
    }

    public void clickJSAlert() {
        jsConfirmButton.click();
    }

    public String handleAlert() {
        Alert jsAlert = driver.switchTo().alert(); // Use the inherited driver
        String alertText = jsAlert.getText();
        return alertText;
    }

    public String handleCancelAlert() {
        Alert jsAlert = driver.switchTo().alert();
        jsAlert.dismiss(); // Dismiss the alert (clicks "Cancel")
        return resultMessageElement.getText(); // Get the result message
    }

    public void clickJSPrompt_Alert() {
        jsPromptButton.click();
    }

    public String handleAlertJSPrompt() {
        Alert jsAlert = driver.switchTo().alert();
        String alertText = jsAlert.getText();
        return alertText;
    }

    public String handleAcceptAlert(String inputText) {
        Alert jsAlert = driver.switchTo().alert();
        jsAlert.sendKeys("hello world"); // Send text to the prompt
        jsAlert.accept(); // Accept the alert (clicks "OK")
        return resultMessageElement.getText(); // Get the result message
    }
}

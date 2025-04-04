package com.demo.page.postman_api;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.page.AbstractPageObject;

public class postman extends AbstractPageObject {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait with a timeout of 10 seconds

    @FindBy(xpath = "//input[@class='gsc-input']")
    private WebElement inputText;

    @FindBy(xpath = "//button[@class='gsc-search-button gsc-search-button-v2']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='gsc-wrapper']")
    private WebElement resultPresented;

    public void inputText(String text) {
        inputText.sendKeys(text); // Enter the specified text into the input field
    }
    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)); // Wait until the button is clickable
        searchButton.click(); // Click the button
    }

    public Boolean getResultText() {
        wait.until(ExpectedConditions.visibilityOf(resultPresented)); // Wait until the result is visible
        return resultPresented.isEnabled(); // Get the text of the result element
    }
}

package com.demo.page.ubuntu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demo.page.AbstractPageObject;

import io.qameta.allure.Step;

public class ubuntu extends AbstractPageObject{
    @FindBy(xpath = "//label[@for='id_new_user']")
    private WebElement radio1;

    @FindBy(xpath = "//input[@name='accept_tos']")
    private WebElement checkbox;
    

    @Step
    public boolean checklRadio() {
        // Return the current state of the radio button
        return !radio1.isSelected();
    }

    public void clickRadio() {
        // Click the radio button to select it
        if (checklRadio() == true) {
            radio1.click();
        }
        // radio1.click();
    }
    @Step
    public boolean checklbox() {
        // Return the current state of the radio button
        return !checkbox.isSelected();
    }
}

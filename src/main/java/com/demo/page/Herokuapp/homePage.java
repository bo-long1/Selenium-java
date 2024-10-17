package com.demo.page.Herokuapp;

import com.demo.page.AbstractPageObject;

import io.qameta.allure.Step;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class homePage extends AbstractPageObject{
    @FindBy(css = "[href='/abtest'1]")
    private WebElement a_btesting;

    @FindBy(xpath = "(//a[normalize-space()='Add/Remove Elements'])[1]")
    private WebElement linkAddElemens;

    @FindBy(xpath = "//button[normalize-space()='Add Element']")
    private WebElement addElement;

    @FindBy(xpath = "//button[@onclick='deleteElement()']")
    private WebElement removeElement;

    @FindBy(xpath = "//a[normalize-space()='Checkboxes']")
    private WebElement linkCheckboxes;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    private  WebElement checkBox1;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    private  WebElement checkBox2;

    @Step
    public void clickTest() {
        openWebsite();
        a_btesting.click();
    }
    
    @Step
    public void clickAddElements() {
        linkAddElemens.click();
    }
    @Step
    public void Elements() {
        addElement.click();
        removeElement.click();
    }
    @Step
    public void clickCheckbox() {
        linkCheckboxes.click();
    }
    @Step
    public void checBox() {
    boolean isSelected = checkBox1.isSelected();
    boolean isSelected2 = checkBox2.isSelected();

    if(isSelected == false){
        checkBox1.click();
    } else if (isSelected2 ==false) {
        checkBox2.click();
    }
    }
}

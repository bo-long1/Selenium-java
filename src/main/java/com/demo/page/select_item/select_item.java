package com.demo.page.select_item;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;

import com.demo.page.AbstractPageObject;

public class select_item extends AbstractPageObject {

    @FindBy(xpath = "//li[@class='ui-state-default ui-selectee']")
    private List<WebElement> items; // List of all selectable items

    @FindBy(xpath = "//li[contains(@class, 'ui-selected')]")
    private List<WebElement> selectedItems; // List of selected items

    public select_item(WebDriver driver) {
        super(driver);
    }

    // Method to select multiple items by their indices
    public void selectItems(int... indices) {
        Actions actions = new Actions(driver); // Create an Actions object
        actions.keyDown(Keys.CONTROL); // Hold down the Ctrl key

        for (int index : indices) {
            actions.click(items.get(index - 1)); // Click on the item (index - 1 because list is 0-based)
        }

        actions.keyUp(Keys.CONTROL).perform(); // Release the Ctrl key and perform the actions
    }

    // Method to verify the number of selected items
    public int getSelectedItemCount() {
        return selectedItems.size(); // Return the count of selected items
    }
}
package com.select_item;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.demo.page.select_item.select_item;
import com.demo.utils.BaseTest;

public class tc5 extends BaseTest {

    @Test(priority = 1)
    public void testSelectItem() { // Enclose code in a test method
        
        select_item click = new select_item(driver); // Pass the driver instance
        // Step 01 - Access the page: https://automationfc.github.io/jquery-selectable/
        click.openWebsite();

        // Step 02 - Click and select items: 1 - 3 - 6 - 11
        click.selectItems(1, 3, 6, 11);

        // Step 03 - Verify that exactly 4 items have been successfully selected
        int selectedCount = click.getSelectedItemCount();
        Assert.assertEquals("The number of selected items is incorrect!", 4, selectedCount);
    }
    
}

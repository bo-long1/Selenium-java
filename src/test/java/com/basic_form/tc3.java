package com.basic_form;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.demo.page.basic_form.alert;
import com.demo.utils.BaseTest;

public class tc3 extends BaseTest {

    @Test(priority = 1)
    public void TC3() throws Exception {
        // TC 03 - Confirm Alert
        alert click = new alert(driver); // Pass the driver instance
        // Step 01 - Access the page: https://automationfc.github.io/basic-form/index.html
        click.openWebsite();

        // Step 02 - Click on the button: Click for JS Confirm
        click.clickJSAlert();
        

        // Step 03 - Verify the message displayed in the alert: I am a JS Confirm
        String alertMessage = click.handleAlert();
        Assert.assertEquals("I am a JS Confirm", alertMessage);

        // Step 04 - Cancel the alert and verify the message displayed in the Result:
        String cancelMessage = click.handleCancelAlert();
        Assert.assertEquals("You clicked: Cancel", cancelMessage);

    }

    @Test(priority = 2)
    public void TC4() throws Exception {
        // TC 04 - Prompt Alert
        alert click = new alert(driver); // Pass the driver instance
        // Step 01 - Access the page: https://automationfc.github.io/basic-form/index.html
        click.openWebsite();

        // Step 02 - Click on the button: Click for JS Prompt
        click.clickJSPrompt_Alert();
        

        // Step 03 - Verify the message displayed in the alert: I am a JS prompt
        String alertMessage = click.handleAlertJSPrompt();
        Assert.assertEquals("I am a JS prompt", alertMessage);

        // Step 04 - Enter any text (it is JS Prompt verify) and verify the message displayed in the Result: You entered: it is JS Prompt verify
        String inputText = "hello world"; // The text to enter
        String resultMessage = click.handleAcceptAlert(inputText); // Pass the text
        Assert.assertEquals("You entered: hello world", resultMessage); // Match the text

    }
    
}

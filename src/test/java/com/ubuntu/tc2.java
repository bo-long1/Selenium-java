package com.ubuntu;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.demo.page.ubuntu.ubuntu;
import com.demo.utils.BaseTest;

public class tc2 extends BaseTest{

    @Test(priority = 1)
    public void TC2() throws Exception{
        ubuntu click = new ubuntu();
        // Step 01 - Access the page: https://login.ubuntu.com/
        click.openWebsite();

        // Step 02 - Verify radio button : [I don't have an Ubuntu One account ] is not clicked
        Assert.assertTrue("Verify radio button : [I don't have an Ubuntu One account ] is not clicked", click.checklRadio());

        // Step 03 - Click on the radio button: [I don't have an Ubuntu One account], Verify radio button clicked
        click.clickRadio();
        // Thread.sleep(5000);

        // Step 04 - Verify checkbox  : [I have read and accept the Ubuntu One terms of service, data privacy policy, and Canonical's SSO privacy notice]. is not clicked
        Assert.assertTrue("Verify checkbox  : [I have read and accept the Ubuntu One terms of service, data privacy policy, and Canonical's SSO privacy notice]. is not clicked",
        
        // Step 05 - Click on the checkbox:[ I have read and accept the Ubuntu One terms of service, data privacy policy, and Canonical's SSO privacy notice]. Verify checkbox clicked
        click.checklbox());
    }
    
}

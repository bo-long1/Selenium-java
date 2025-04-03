package com.fahasa_web;
import org.testng.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.internal.Utils;
import com.demo.page.Fahasa.login;
import com.demo.utils.BaseTest;

public class login_user extends BaseTest {
    // private login loginPage;

    @Test(priority = 1)
    public void Verify_btn_login() throws Exception{
        login click = new login(driver);
        // Step 02 - Navigate via the Login tab
        click.login_tab();
        // Step 03 - Verify "Login" button is disabled
        click.check_btn_login();
        boolean Disabled = click.isLoginButtonDisabled();
        Assert.assertTrue(Disabled, "The login button should be disabled");

        // Step 04 - Verify "Login" button has gray background color
        String buttonColor = click.check_btn_login();
        if (buttonColor.startsWith("rgba")) {
            buttonColor = buttonColor.replace("rgba", "rgb").replace(", 1)", ")");
        }
        Assert.assertEquals(buttonColor, "rgb(0, 0, 0, 0)", "The button should have a gray background color");

        // Step 05 - Input valid data into Email/Password textbox
        click.login("user_test@gmail.com", "123123");

        // Step 06 - Verify "Login" button is enabled
        click.check_btn_login();
        boolean isEnable = click.isLoginButtonDisabled();
        Assert.assertTrue(isEnable, "The login button should be enabled");

        // Step 07 - Verify the "Login" button has a background color of red
        buttonColor = click.check_btn_login();
        if (buttonColor.startsWith("rgba")) {
            buttonColor = buttonColor.replace("rgba", "rgb").replace(", 1)", ")");
        }
        Assert.assertEquals(buttonColor, "rgb(201, 33, 39)", "The button should have a red background color");
        
    }
    }

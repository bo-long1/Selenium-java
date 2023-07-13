package com.demo.autoOrangeHRM;

import com.demo.page.autoOrangeHRM.loginPage;
import com.demo.utils.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends BaseTest {

    @Test(priority = 1)
    public void singIn() throws Exception {
        loginPage singinPage = new loginPage();
        singinPage.login("Admin", "admin123");
    }

}

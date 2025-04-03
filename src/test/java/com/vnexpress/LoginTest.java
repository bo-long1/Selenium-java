package com.vnexpress;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.demo.page.vnexpress.login_vnexpress;
import com.demo.utils.BaseTest;

public class LoginTest extends BaseTest {
    
    @Test(priority = 1)
    public void checkLogin() throws Exception {
        login_vnexpress click = new login_vnexpress();
        // Click the login button to open the login form
        click.openWebsite();
        click.clickLoginButton();

        // Switch to the iframe containing the login form
        String getTitle = click.handleIframe();

        // System.out.println("Page title: " + getTitle);
        Assert.assertTrue(getTitle.contains("Đăng nhập / Tạo tài khoản"), 
            "The page title does not contain the expected text: 'Đăng nhập / Tạo tài khoản'"); 
            
        // input username
        click.inputEmail("1234@gmail.com");

        // click Next button
        click.clickNextButton();

        //input password and click login button
        click.inputPassword("123");
        click.clickLoginButton2();

        // Verify that the login was successful by checking the page title or URL
        String getError = click.getErrorMessage();
        Assert.assertTrue(getError.contains("expected error"), "Error message displayed:  Địa chỉ email hoặc mật khẩu của bạn không chính xác, vui lòng kiểm tra & thử lại");
        }
    
}

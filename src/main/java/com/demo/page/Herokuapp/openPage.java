package com.demo.page.Herokuapp;

import com.demo.config.Constants;
import com.demo.driver.DriverManager;
import com.demo.page.AbstractPageObject;
import io.qameta.allure.Step;

public class openPage extends AbstractPageObject {

    @Step
    public void openWebsite() {
        DriverManager.getDriver().get(Constants.Url_herokuapp);
    }
}

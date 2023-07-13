package com.demo.page.autoOrangeHRM;

// import org.yaml.snakeyaml.scanner.Constant;
import io.qameta.allure.Step;
import com.demo.config.Constants;
import com.demo.driver.DriverManager;
import com.demo.page.AbstractPageObject;

public class navigationPage extends AbstractPageObject{
    @Step
    public void openWebsite() {
        DriverManager.getDriver().get(Constants.Url_OrangeHRM);
    } 
}

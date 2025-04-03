package com.herokuapp;

import com.demo.page.Herokuapp.homePage;
import com.demo.utils.BaseTest;

import org.testng.annotations.Test;

public class herokuPage extends BaseTest {

    // //CSS Selector
    // @Test(priority = 1)
    // public void clickABTest () throws Exception{
    //     homePage click = new homePage();
    //     click.clickTest();
    // }

    //Check button
    @Test(priority = 2)
    public void checkElements() throws Exception{
        homePage click = new homePage();
        click.openWebsite();
        click.clickAddElements();
        click.Elements();
    }

    //Check radio
    @Test(priority = 3)
    public void checkradio() throws Exception{
        homePage click = new homePage();
        click.openWebsite();
        click.clickCheckbox();
        click.checBox();
    }
}

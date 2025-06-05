package com.testing.page.pageObjectModel.improvedPOM;

import com.testing.base.CommonToAllPage;
import com.testing.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_challenge01 extends CommonToAllPage {
    WebDriver driver;

    public LoginPage_challenge01(WebDriver driver) {
        this.driver = driver;

    }

    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By SignIn = By.id("log-in");

    public void login(String user, String pwd) {
        openAutomationChallenge01();
        enterInput(username, user);
        WaitHelpers.visibilityOfElement(username);
        enterInput(password, pwd);
        clickElement(SignIn);
    }


}

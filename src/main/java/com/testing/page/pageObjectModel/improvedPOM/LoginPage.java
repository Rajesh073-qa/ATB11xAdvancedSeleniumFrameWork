package com.testing.page.pageObjectModel.improvedPOM;

import com.testing.base.CommonToAllPage;
import com.testing.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.testing.driver.DriverManager.getDriver;

public class LoginPage extends CommonToAllPage {
    // Page Class
    // Page Locators
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Step 1 - Page Locators
    private final By username = By.id("login-username");
    private final By password = By.id("login-password");
    private final By signButton = By.id("js-login-btn");
    private final By error_message = By.id("js-notification-box-msg");


    public String loginToVWOLoginInvalidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(signButton);
        WaitHelpers.checkVisibility(getDriver(), error_message);
        return getText(error_message);
    }

    public void loginToVWOLoginValidCreds(String user, String pwd) {
        openVWOUrl();
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(signButton);

    }
}


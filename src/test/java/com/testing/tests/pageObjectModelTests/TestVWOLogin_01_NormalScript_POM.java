package com.testing.tests.pageObjectModelTests;

import com.testing.base.CommonToAllTest;
import com.testing.page.pageObjectModel.improvedPOM.DashBoardPage;
import com.testing.page.pageObjectModel.improvedPOM.LoginPage;
import com.testing.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.testing.driver.DriverManager.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_01_NormalScript_POM extends CommonToAllTest {

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {

        // Driver Manager Code - 1
        // Page Class Code (POM Code) - 2
        LoginPage loginPage = new LoginPage(driver);
        String error_message = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));
        // Assertions - 3
        assertThat(error_message).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(error_message, PropertiesReader.readKey("error_message"));
    }

    @Owner("Rajesh")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        String loggedInUserName = dashBoardPage.loggedInUserName();
        assertThat(loggedInUserName).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(loggedInUserName, PropertiesReader.readKey("expected_username"));
    }
}
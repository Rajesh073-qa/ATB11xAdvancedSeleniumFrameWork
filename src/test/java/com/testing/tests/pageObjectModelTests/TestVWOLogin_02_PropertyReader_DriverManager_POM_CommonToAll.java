package com.testing.tests.pageObjectModelTests;

import com.testing.base.CommonToAllTest;
import com.testing.driver.DriverManager;
import com.testing.page.pageObjectModel.improvedPOM.DashBoardPage;
import com.testing.page.pageObjectModel.improvedPOM.LoginPage;
import com.testing.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_02_PropertyReader_DriverManager_POM_CommonToAll extends CommonToAllTest {
    @Description("TC#1- Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() throws Exception {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String error_message = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));
        assertThat(error_message).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_message, PropertiesReader.readKey("error_message"));
    }

    @Owner("Rajesh")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));

        DashBoardPage page = new DashBoardPage(DriverManager.getDriver());
        String Username = page.loggedInUserName();

        assertThat(Username).isNotEmpty().isNotBlank().isNotNull();
        Assert.assertEquals(Username, PropertiesReader.readKey("expected_username"));
    }
}
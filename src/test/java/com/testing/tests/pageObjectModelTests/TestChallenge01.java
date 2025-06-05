package com.testing.tests.pageObjectModelTests;

import com.testing.base.CommonToAllTest;
import com.testing.driver.DriverManager;
import com.testing.page.pageObjectModel.improvedPOM.Dashboard_challenge01;
import com.testing.page.pageObjectModel.improvedPOM.LoginPage_challenge01;
import com.testing.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestChallenge01 extends CommonToAllTest {
    @Test
    public void VerifyTotalAmount() {
        LoginPage_challenge01 challenge01 = new LoginPage_challenge01(DriverManager.getDriver());
        challenge01.login(PropertiesReader.readKey("username01"), PropertiesReader.readKey("password01"));

        Dashboard_challenge01 DC = new Dashboard_challenge01(DriverManager.getDriver());
        String ActualAmount = DC.dashboard_amount().toString();
        System.out.println("Actual amount $ - " + ActualAmount);
        Assert.assertEquals(ActualAmount, PropertiesReader.readKey("ExpectedAmount"));

    }

}

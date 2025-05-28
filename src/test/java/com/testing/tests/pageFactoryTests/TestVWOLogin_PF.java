package com.testing.tests.pageFactoryTests;

import com.testing.page.pageFactory.vwo.LoginPage_PF;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static com.testing.driver.DriverManager.driver;

public class TestVWOLogin_PF {
    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF.class);

    @Test
    public void testLoginNegativeVWO_PF() {
        logger.info("Starting the Testcases Page Factory");
        LoginPage_PF loginPage = new LoginPage_PF(driver);
        String error_message = loginPage.loginToVWOInvalidCreds();
        logger.info("Error message I got" + error_message);

    }
}
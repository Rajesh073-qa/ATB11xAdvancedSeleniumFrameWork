package com.testing.tests.pageObjectModelTests;

import com.testing.base.CommonToAllTest;
import com.testing.driver.DriverManager;
import com.testing.page.pageObjectModel.improvedPOM.Challenge02;
import org.testng.annotations.Test;

public class TestChallenge02 extends CommonToAllTest {
    Challenge02 challenge02;

    @Test
    public void ThirdEditIcon() {
        challenge02 = new Challenge02(DriverManager.getDriver());
        challenge02.openAutomationChallenge02();
        challenge02.ClickOnAndClose();
    }

    @Test
    public void AddRecord() {
        challenge02.AddNewRecord();
    }
}

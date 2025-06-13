package com.testing.base;

import com.testing.utils.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.testing.driver.DriverManager.getDriver;

public class CommonToAllPage {
    Logger logger = LogManager.getLogger();

    public CommonToAllPage() {
        // If you want to call something before every Page Object Class call, Put your Code here");
        // Open File, Open Data Base Connection You can write code here
    }

    public void openVWOUrl() {
        logger.info("Website opened.....");
        getDriver().get(PropertiesReader.readKey("url"));
    }

    public void openOrangeHRMUrl() {
        getDriver().get(PropertiesReader.readKey("ohr_url"));
    }

    public void openKatalonUrl() {
        getDriver().get(PropertiesReader.readKey("katalon_url"));
    }

    public void openAutomationChallenge01() {
        getDriver().get(PropertiesReader.readKey("challenge1_url"));
    }

    public void openAutomationChallenge02() {
        getDriver().get(PropertiesReader.readKey("challenge2_url"));
    }


    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by) {
        by.click();
    }

    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by, String key) {
        by.sendKeys(key);
    }

    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by) {
        return by.getText();
    }

    public void clickUsingJS(By element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
    }

    public void scrollToElement(By element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }


}
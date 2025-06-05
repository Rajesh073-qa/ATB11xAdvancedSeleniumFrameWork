package com.testing.page.pageObjectModel.improvedPOM;

import com.testing.base.CommonToAllPage;
import com.testing.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Challenge02 extends CommonToAllPage {
    WebDriver driver;

    public Challenge02(WebDriver driver) {
        this.driver = driver;

    }

    private final By ThirdRow = By.xpath("//span[@title='Edit']");

    private final By Close = By.xpath("//button[@class='close']");

    private final By AddNewRecord = By.id("addNewRecordButton");

    private final By FirstName = By.id("firstName");

    private final By LastName = By.id("lastName");

    private final By UserEmail = By.id("userEmail");

    private final By age = By.id("age");

    private final By salary = By.id("salary");

    private final By department = By.id("department");

    private final By submit = By.id("submit");

    //private final newRow = By.xpath("//div[@class='rt-tr-group']//div[text()='" + PropertiesReader.readKey("") + "']/ancestor::div[@class='rt-tr-group']");


    public void ClickOnAndClose() {
        openAutomationChallenge02();
        List<WebElement> allEditButtons = driver.findElements(ThirdRow);

        if (allEditButtons.size() >= 3) {
            WebElement thirdRowIcon = allEditButtons.get(2);
            scrollToElement(thirdRowIcon);
            clickElement(thirdRowIcon);
            clickElement(Close);
        } else {
            System.out.println("Less than 3 edit buttons found.");
        }

    }

    public void AddNewRecord() {
        clickElement(AddNewRecord);
        enterInput(FirstName, PropertiesReader.readKey("First_name"));
        enterInput(LastName, PropertiesReader.readKey("Last_name"));
        enterInput(UserEmail, PropertiesReader.readKey("Age"));
        enterInput(age, PropertiesReader.readKey("Email"));
        enterInput(salary, PropertiesReader.readKey("Salary"));
        enterInput(department, PropertiesReader.readKey("Dep"));
        clickElement(submit);
    }


}

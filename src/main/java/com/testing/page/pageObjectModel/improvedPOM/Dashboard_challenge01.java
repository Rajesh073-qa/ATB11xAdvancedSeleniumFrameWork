package com.testing.page.pageObjectModel.improvedPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard_challenge01 {
    WebDriver driver;

    public Dashboard_challenge01(WebDriver driver) {
        this.driver = driver;
    }


    public Double dashboard_amount() {

        String first_part = "//table[@class='table table-padded']/tbody/tr[",
                second_part = "]/td[",
                third_part = "]";

        int row = driver.findElements(By.xpath("//table[@class='table table-padded']/tbody/tr")).size();
        int column = driver.findElements(By.xpath("//table[@class='table table-padded']/tbody/tr[1]/td")).size();
        System.out.println(row);
        System.out.println(column);
        Double amount, total = 0.0;
        for (
                int i = 1;
                i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                String dynamic_path = first_part + i + second_part + j + third_part;
                String amountText = driver.findElement(By.xpath(dynamic_path)).getText();
                amountText = amountText
                        .replace(",", "")
                        .replace("USD", "")
                        .replace(" ", "")
                        .replace("$", "")
                        .trim();

                try {
                    amount = Double.parseDouble(amountText);
                    total += amount;
                } catch (NumberFormatException e) {
                    System.out.println("Skipping non-numeric value at row " + i + ": " + amountText);
                }
            }
            System.out.println("Total amount - " + total);
        }
        return total;
    }
}
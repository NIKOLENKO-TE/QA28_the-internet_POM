package com.it_internet.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ButtonsPage extends BasePage {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[onclick='jsAlert()']")
    WebElement jsAlertButton;

    public ButtonsPage testJSAlertButton() {
        click(jsAlertButton);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement resultElement = driver.findElement(By.cssSelector("#result"));
        String actualText = resultElement.getText();
        Assert.assertTrue(actualText.contains("You successfully clicked an alert"), "Текст в поле '#result' не совпадает с ожидаемым");
        return this;
    }

    @FindBy(css = "button[onclick='jsConfirm()']")
    WebElement jsConfirmButton;

    public ButtonsPage testJSConfirmButton() {
        click(jsConfirmButton);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement resultElement = driver.findElement(By.cssSelector("#result"));
        String actualText = resultElement.getText();
        Assert.assertTrue(actualText.contains("You clicked: Ok"), "Текст в поле '#result' не совпадает с Ok");
        return this;
    }

    @FindBy(css = "button[onclick='jsPrompt()']")
    WebElement jsPromptButton;

    public ButtonsPage testJSPromptButton() {
        String text_to_check = "Hello";
        click(jsPromptButton);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text_to_check);
        alert.accept();
        WebElement resultElement = driver.findElement(By.cssSelector("#result"));
        String actualText = resultElement.getText();
        Assert.assertTrue(actualText.contains(text_to_check), "Текст в поле '#result' не совпадает с ожидаемым");
        return this;
    }
}

package com.it_internet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MultipleWindowsPage extends BasePage {
    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Multiple Windows')]")
    WebElement multipleWindowsLink; // находим элемент Multiple Windows

    public void getMultipleWindow() {
        multipleWindowsLink.click();
        new MultipleWindowsPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Click Here')]")
    WebElement clickHereButton; // находим элемент Click Here

    public void clickMultipleWindowsButton() {
        Assert.assertTrue(clickHereButton.isDisplayed(), "Элемент Click Here не отображается");
    }

    public MultipleWindowsPage clickMultipleWindowsClickHereButton() {
        clickHereButton.click(); // кликаем на элемент Click Here
        return this;
    }

    public MultipleWindowsPage switchToNextTab(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles()); // получаем список вкладок
        driver.switchTo().window(tabs.get(index)); // переключаемся на новую вкладку
        return this;
    }

    @FindBy(xpath = "//h3[contains(text(),'New Window')]")
    WebElement newWindowText;

    public MultipleWindowsPage verifyTabTitle(String text) {
        Assert.assertTrue(shouldHaveText(newWindowText, text, 5), "Текст в новой вкладке не совпадает с ожидаемым");
        return this;
    }

    public boolean shouldHaveText(WebElement element, String text, int time) { // проверяем, что в элементе есть текст
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.textToBePresentInElement(element, text)); // ждем, пока в элементе не появится текст
    }
}

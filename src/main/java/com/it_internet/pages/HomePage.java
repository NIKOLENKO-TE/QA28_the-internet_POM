package com.it_internet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "li:nth-child(29) > a:nth-child(1)")
    WebElement javascript_alertsWindow;

    public SidePanel getJavascript_alertsWindow() {
        click(javascript_alertsWindow);
        return new SidePanel(driver);
    }
}

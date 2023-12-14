package com.it_internet.pages;

import org.openqa.selenium.WebDriver;

public class SidePanel extends BasePage {

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    public ButtonsPage selectAlerts() {
        return new ButtonsPage(driver);
    }
}

package com.it_internet.tests;

import com.it_internet.pages.ButtonsPage;
import com.it_internet.pages.HomePage;
import com.it_internet.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getJavascript_alertsWindow();
        new SidePanel(driver).selectAlerts();
    }

    @Test
    public void clickJsAlertButton() {
        new ButtonsPage(driver).testJSAlertButton();
    }

    @Test
    public void clickJsConfirmButton() {
        new ButtonsPage(driver).testJSConfirmButton();
    }

    @Test
    public void clickJsPromptButton() {
        new ButtonsPage(driver).testJSPromptButton();
    }
}

package com.it_internet.tests;

import com.it_internet.pages.MultipleWindowsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new MultipleWindowsPage(driver).getMultipleWindow();
    }

    @Test
    public void clickMultipleWindowsButtonTest() {
        new MultipleWindowsPage(driver).clickMultipleWindowsButton();
    }

    @Test
    public void clickMultipleWindowsClickHereButtonTest() {
        new MultipleWindowsPage(driver).clickMultipleWindowsClickHereButton();
    }

    @Test
    public void checkMultipleWindowsClickHereNewWindowTextTest() {
        new MultipleWindowsPage(driver)
                .clickMultipleWindowsClickHereButton()
                .switchToNextTab(1)
                .verifyTabTitle("New Window");
    }
}

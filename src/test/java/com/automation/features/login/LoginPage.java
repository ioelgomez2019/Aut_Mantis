package com.automation.features.login;

import com.automation.core.BasePage;
import org.openqa.selenium.By;

/**
 * LoginPage - Page Object for MantisBT login.
 * Contains only element locators - NO LOGIC.
 */
public class LoginPage extends BasePage {

    private static final By MANTIS_USERNAME = By.id("username");
    private static final By PASSWORD = By.id("password");
    private static final By MANTIS_SIGN_IN_BUTTON = By.xpath(
        "//input[@type='submit' and contains(@value,'Iniciar')] | //button[contains(normalize-space(.),'Iniciar')]"
    );
    private static final By MANTIS_USER_INFO = By.className("user-info");
    private static final By MANTIS_SMALLER_TEXT = By.className("smaller-75");

    public void enterUsername(String username) {
        type(MANTIS_USERNAME, username);
    }

    public void enterPassword(String password) {
        type(PASSWORD, password);
    }

    public void clickContinueAfterUsername() {
        if (isPresent(MANTIS_SIGN_IN_BUTTON)) {
            click(MANTIS_SIGN_IN_BUTTON);
        }
    }

    public void clickLoginButton() {
        click(MANTIS_SIGN_IN_BUTTON);
    }

    public boolean isMantisDashboardDisplayed() {
        return isElementDisplayed(MANTIS_USER_INFO);
    }

    public boolean isMessageClassDisplayed(String className) {
        try {
            return isPresent(By.className(className));
        } catch (Exception e) {
            return false;
        }
    }

    public String getDashboardSmallMessageText() {
        if (isElementDisplayed(MANTIS_SMALLER_TEXT)) {
            return getText(MANTIS_SMALLER_TEXT).trim();
        }
        return "";
    }

    public String getDashboardUserText() {
        if (isElementDisplayed(MANTIS_USER_INFO)) {
            return getText(MANTIS_USER_INFO).trim();
        }
        return "";
    }

    private boolean isPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
}

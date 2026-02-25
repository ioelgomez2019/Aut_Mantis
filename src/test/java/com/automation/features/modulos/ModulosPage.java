package com.automation.features.modulos;

import com.automation.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModulosPage extends BasePage {

    private static final String LOWER_TEXT =
        "translate(normalize-space(.), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')";

    private static final By MODULO_VISTA_LINK = By.xpath(
        "//a[(contains(@href,'my_view_page.php') or contains(@href,'my_view')) and " +
            "(contains(" + LOWER_TEXT + ",'mi vista') or contains(" + LOWER_TEXT + ",'my view'))]"
    );

    private static final By MODULO_PLANQA_LINK = By.xpath(
        "//a[contains(" + LOWER_TEXT + ",'plan qa')]"
    );

    private static final By MODULO_VER_INCIDENCIAS_LINK = By.xpath(
        "//a[(contains(@href,'view_all_bug_page.php') or contains(@href,'view_all_set.php') or " +
            "contains(@href,'view_all') or contains(@href,'view_issues')) and " +
            "(contains(" + LOWER_TEXT + ",'incid') or contains(" + LOWER_TEXT + ",'view issues') or " +
            "contains(" + LOWER_TEXT + ",'ver incid'))]"
    );

    private static final By MODULO_REPORTAR_INCIDENCIAS_LINK = By.xpath(
        "//a[(contains(@href,'bug_report_page.php') or contains(@href,'bug_report') or " +
            "contains(@href,'report_issue') or contains(@href,'create_issue')) and " +
            "(contains(" + LOWER_TEXT + ",'report') or contains(" + LOWER_TEXT + ",'incid') or " +
            "contains(" + LOWER_TEXT + ",'issue'))]"
    );

    private static final By MODULO_REGISTRAR_CAMBIOS_LINK = By.xpath(
        "//a[(contains(@href,'changelog_page.php') or contains(@href,'changelog')) and " +
            "(contains(" + LOWER_TEXT + ",'registro de cambi') or contains(" + LOWER_TEXT + ",'registrar cambi') " +
            "or contains(" + LOWER_TEXT + ",'change log') or contains(" + LOWER_TEXT + ",'changelog'))]"
    );

    private static final By MODULO_HOJA_RUTA_LINK = By.xpath(
        "//a[(contains(@href,'roadmap_page.php') or contains(@href,'roadmap') or contains(@href,'road_map')) and " +
            "(contains(" + LOWER_TEXT + ",'hoja de ruta') or contains(" + LOWER_TEXT + ",'roadmap') or " +
            "contains(" + LOWER_TEXT + ",'ruta'))]"
    );

    private static final By MODULO_CASOS_REGRESION_LINK = By.xpath(
        "//a[(contains(@href,'regres') or contains(@href,'regression') or " +
            "contains(@href,'summary_page.php') or contains(@href,'summary')) and " +
            "(contains(" + LOWER_TEXT + ",'casos de regres') or contains(" + LOWER_TEXT + ",'regres') or " +
            "contains(" + LOWER_TEXT + ",'regression') or contains(" + LOWER_TEXT + ",'summary') or " +
            "contains(" + LOWER_TEXT + ",'resumen'))]"
    );

    private static final By MODULO_ADMINISTRACION_LINK = By.xpath(
        "//a[(contains(@href,'manage_overview_page.php') or contains(@href,'manage')) and " +
            "(contains(" + LOWER_TEXT + ",'administr') or contains(" + LOWER_TEXT + ",'manage'))]"
    );

    private static final By USER_MENU_LINK = By.cssSelector("a.user-info, .user-info");
    private static final By LOGOUT_LINK = By.xpath(
        "//a[contains(@href,'logout_page.php') or contains(normalize-space(),'Salir') " +
            "or contains(normalize-space(),'Cerrar') or contains(normalize-space(),'Logout')]"
    );

    public void clickModuloVista() {
        clickMenu(MODULO_VISTA_LINK);
    }

    public void clickModuloPlanQa() {
        clickMenu(MODULO_PLANQA_LINK);
    }

    public void clickVerIncidencias() {
        clickMenu(MODULO_VER_INCIDENCIAS_LINK);
    }

    public void clickReportarIncidencias() {
        clickMenu(MODULO_REPORTAR_INCIDENCIAS_LINK);
    }

    public void clickRegistrarCambios() {
        clickMenu(MODULO_REGISTRAR_CAMBIOS_LINK);
    }

    public void clickHojaRuta() {
        clickMenu(MODULO_HOJA_RUTA_LINK);
    }

    public void clickCasosRegresion() {
        clickMenu(MODULO_CASOS_REGRESION_LINK);
    }

    public void clickAdministracion() {
        clickMenu(MODULO_ADMINISTRACION_LINK);
    }

    public void logout() {
        try {
            clickMenu(LOGOUT_LINK);
            return;
        } catch (Exception ignored) {
            // Continue with alternative flows
        }

        try {
            clickMenu(USER_MENU_LINK);
            clickMenu(LOGOUT_LINK);
            return;
        } catch (Exception ignored) {
            // Final fallback via direct URL
        }

        driver.navigate().to(buildPageUrl("logout_page.php"));
    }

    private void clickMenu(By locator) {
        WebElement element = wait.until(driver -> driver.findElements(locator).stream()
            .filter(webElement -> {
                try {
                    return webElement.isDisplayed();
                } catch (Exception ignored) {
                    return false;
                }
            })
            .findFirst()
            .orElse(null)
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    private String buildPageUrl(String page) {
        String currentUrl = driver.getCurrentUrl();
        int queryIndex = currentUrl.indexOf('?');
        if (queryIndex > -1) {
            currentUrl = currentUrl.substring(0, queryIndex);
        }
        int lastSlash = currentUrl.lastIndexOf('/');
        if (lastSlash < 0) {
            return currentUrl;
        }
        return currentUrl.substring(0, lastSlash + 1) + page;
    }
}

package com.automation.features.login;

import com.automation.config.ConfigManager;
import com.automation.features.login.LoginPage;
import org.testng.Assert;

public class LoginBusiness {

    private final LoginPage loginPage;
    private final ConfigManager config;

    public LoginBusiness() {
        this.loginPage = new LoginPage();
        this.config = ConfigManager.getInstance();
    }

    public void abrirPaginaLogin() {
        loginPage.navigateTo(config.getBaseUrl());
    }

    public void ingresarEmail(String email) {
        loginPage.enterUsername(email);
    }

    public void ingresarContrasena(String password) {
        loginPage.enterPassword(password);
    }

    public void clickIngresarUsuario() {
        loginPage.clickContinueAfterUsername();
    }

    public void clickBotonIngresar() {
        loginPage.clickLoginButton();
    }

    public void validarDashboardConMensajeYUsuario(String mensaje, String usuario) {
        Assert.assertTrue(loginPage.isMantisDashboardDisplayed(),
            "Mantis dashboard should be displayed after successful login");

        if (mensaje != null && !mensaje.trim().isEmpty()) {
            String expected = mensaje.trim();
            String visibleText = loginPage.getDashboardSmallMessageText();
            boolean classDisplayed = loginPage.isMessageClassDisplayed(expected);
            boolean textContains = !visibleText.isEmpty() && visibleText.toLowerCase().contains(expected.toLowerCase());

            Assert.assertTrue(classDisplayed || textContains,
                "Expected dashboard message class/text: " + expected + ". Actual text: " + visibleText);
        }

        if (usuario != null && !usuario.trim().isEmpty()) {
            String actualUser = loginPage.getDashboardUserText();
            Assert.assertTrue(actualUser.toLowerCase().contains(usuario.trim().toLowerCase()),
                "Expected user info to contain: " + usuario + ". Actual: " + actualUser);
        }
    }
}

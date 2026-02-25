package com.automation.features.modulos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ModulosSteps {

    private ModulosBusiness modulosBusiness;

    private ModulosBusiness getModulosBusiness() {
        if (modulosBusiness == null) {
            modulosBusiness = new ModulosBusiness();
        }
        return modulosBusiness;
    }

    @When("el usuario verifica el modulo vista")
    public void elUsuarioVerificaElModuloVista() {
        getModulosBusiness().verificarModuloVista();
    }

    @And("el usuario verifica plan QA")
    public void elUsuarioVerificaPlanQA() {
        getModulosBusiness().verificarModuloPlanQa();
    }

    @And("el usuario verifica que pueda ver incidencias")
    public void elUsuarioVerificaQuePuedaVerIncidencias() {
        getModulosBusiness().verificarVerIncidencias();
    }

    @And("el usuario verifica que pueda reportar incidencias")
    public void elUsuarioVerificaQuePuedaReportarIncidencias() {
        getModulosBusiness().verificarReportarIncidencias();
    }

    @And("el usuario verifica que pueda registrar cambios")
    public void elUsuarioVerificaQuePuedaRegistrarCambios() {
        getModulosBusiness().verificarRegistrarCambios();
    }

    @And("el usuario verifica que pueda ver la hoja de ruta")
    public void elUsuarioVerificaQuePuedaVerLaHojaDeRuta() {
        getModulosBusiness().verificarHojaRuta();
    }

    @And("el usuario verifica que pueda ver los casos de regresion")
    public void elUsuarioVerificaQuePuedaVerLosCasosDeRegresion() {
        getModulosBusiness().verificarCasosRegresion();
    }

    @And("el usuario verifica que pueda ver la Administracion")
    public void elUsuarioVerificaQuePuedaVerLaAdministracion() {
        getModulosBusiness().verificarAdministracion();
    }

    @And("el usuario sale del sistema")
    public void elUsuarioSaleDelSistema() {
        getModulosBusiness().salirDelSistema();
    }
}

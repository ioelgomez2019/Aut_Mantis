package com.automation.features.modulos;

public class ModulosBusiness {

    private final ModulosPage modulosPage;

    public ModulosBusiness() {
        this.modulosPage = new ModulosPage();
    }

    public void verificarModuloVista() {
        modulosPage.clickModuloVista();
    }

    public void verificarModuloPlanQa(){
        modulosPage.clickModuloPlanQa();
    }

    public void verificarVerIncidencias() {
        modulosPage.clickVerIncidencias();
    }

    public void verificarReportarIncidencias() {
        modulosPage.clickReportarIncidencias();
    }

    public void verificarRegistrarCambios() {
        modulosPage.clickRegistrarCambios();
    }

    public void verificarHojaRuta() {
        modulosPage.clickHojaRuta();
    }

    public void verificarCasosRegresion() {
        modulosPage.clickCasosRegresion();
    }

    public void verificarAdministracion() {
        modulosPage.clickAdministracion();
    }

    public void salirDelSistema() {
        modulosPage.logout();
    }
}

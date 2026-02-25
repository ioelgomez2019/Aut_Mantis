@echo off
REM ============================================
REM Script de Ejecucion de Pruebas BDD - TestNG
REM Automation Corebank - InicioSession
REM ============================================

echo.
echo ============================================
echo   MENU DE EJECUCION - INICIO SESSION
echo ============================================
echo.
echo 1. EJECUTAR SUITE DEFAULT (testng.xml)
echo 2. SOLO LOGIN (LoginRunner)
echo 3. EJECUTAR POR TAG PERSONALIZADO
echo 4. SALIR
echo.

set /p opcion="Ingrese una opcion (1-4): "

if "%opcion%"=="1" goto suite
if "%opcion%"=="2" goto login
if "%opcion%"=="3" goto custom
if "%opcion%"=="4" goto salir

echo Opcion invalida. Intente nuevamente.
pause
goto :eof

:suite
echo.
echo Ejecutando suite default...
call mvn clean test
goto fin

:login
echo.
echo Ejecutando LoginRunner...
call mvn clean test -Dtest=LoginRunner
goto fin

:custom
echo.
echo Ejemplos de tags:
echo   @login
echo   @InicioSession and @Login
echo   not @WIP
echo.
set /p tag="Ingrese el tag a ejecutar: "
echo.
call mvn clean test -Dcucumber.filter.tags="%tag%"
goto fin

:fin
echo.
echo Ejecucion completada.
pause
goto :eof

:salir
exit

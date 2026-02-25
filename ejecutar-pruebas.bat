@echo off
REM Automation Corebank - Test Execution Script
REM Usage: ejecutar-pruebas.bat [option]

echo.
echo ==================================================
echo    AUTOMATION COREBANK - TEST EXECUTION
echo ==================================================
echo.

if "%1"=="" (
    echo Usage: ejecutar-pruebas [option]
    echo.
    echo Options:
    echo   all          Run login tests (default suite)
    echo   login        Run only @login scenarios
    echo.
    exit /b 1
)

if "%1"=="all" (
    echo Running: LOGIN TESTS (DEFAULT SUITE)
    echo.
    call mvn clean test
    goto end
)

if "%1"=="login" (
    echo Running: LOGIN TESTS (@login)
    echo.
    call mvn clean test -Dtest=LoginRunner
    goto end
)

echo Unknown option: %1
exit /b 1

:end
echo.
echo ==================================================
echo    Test execution completed
echo ==================================================
pause

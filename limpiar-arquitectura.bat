@echo off
REM ============================================
REM Limpieza de carpeta Script/ obsoleta
REM ============================================

echo.
echo ============================================
echo   LIMPIAR ARQUITECTURA
echo ============================================
echo.
echo Este script elimina la carpeta Script/ si existe.
echo.
set /p confirmar="Desea eliminar la carpeta Script/? (S/N): "

if /i "%confirmar%"=="S" goto eliminar
if /i "%confirmar%"=="s" goto eliminar
goto cancelar

:eliminar
echo.
if exist "Script\" (
    rd /s /q "Script\"
    echo Carpeta Script/ eliminada.
) else (
    echo La carpeta Script/ no existe.
)
goto fin

:cancelar
echo.
echo Operacion cancelada.

:fin
pause

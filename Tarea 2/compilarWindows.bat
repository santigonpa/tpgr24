@echo off
setlocal EnableDelayedExpansion

:main
cls
echo Seleccione una opcion para compilar:
echo - 1. Compilar todo -
echo - 2. Compilar Estacion De Trabajo y Servidor Central -
echo - 3. Compilar Servidor Web y Dispositivo Movil -
echo - 4. Salir -
set /p mainmenuinput="Ingrese opcion: "

if "%mainmenuinput%"=="1" (
    call :compilarTodo
) else if "%mainmenuinput%"=="2" (
    call :compilarEstacionDeTrabajo
) else if "%mainmenuinput%"=="3" (
    call :compilarServidorWeb
) else if "%mainmenuinput%"=="4" (
    exit /b
) else (
    goto main
)

echo.
echo.
pause
goto main

:compilarEstacionDeTrabajo
echo Compilando Estacion De Trabajo y Servidor Central...
cd estacion_de_trabajo
call mvn clean package install
cd ..
exit /b

:compilarServidorWeb
echo Compilando el Servidor Web y el Dispositivo Movil...
cd servidor_web
cd sitio_web_dinamico
call mvn clean package install
cd ..\..
exit /b

:compilarTodo
call :compilarEstacionDeTrabajo
call :compilarServidorWeb
exit /b

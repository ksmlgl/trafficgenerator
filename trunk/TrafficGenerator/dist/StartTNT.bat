@echo off
title TestNetworkTool Console
:start
echo Starting TestNetworkTool.
echo.
REM -------------------------------------
REM Default parameters for a basic server.
java -jar tg-win32-win32-x86.jar
REM
REM -------------------------------------

SET CLASSPATH=%OLDCLASSPATH%


if ERRORLEVEL 1 goto error
goto end
:error
echo.
echo TestNetworkTool Terminated Abnormaly, Please Verify Your Files.
echo.
:end
echo.
echo TestNetworkTool Terminated.
echo.
pause
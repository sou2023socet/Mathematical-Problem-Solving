@echo off
REM Java Math Library Compilation and Test Script for Windows
REM Version: 2.1.0

echo.
echo ====================================
echo  Java Math Library v2.1 - Build
echo ====================================
echo.

REM Set paths
set SRC_DIR=src
set BIN_DIR=bin
set CLASSES=com.mathlib.test.ComprehensiveTest

REM Create bin directory if it doesn't exist
if not exist %BIN_DIR% mkdir %BIN_DIR%

REM Compile all Java files
echo [1/3] Compiling Java source files...
javac -d %BIN_DIR% %SRC_DIR%\com\mathlib\*.java %SRC_DIR%\com\mathlib\test\*.java

if errorlevel 1 (
    echo ERROR: Compilation failed!
    pause
    exit /b 1
)

echo [2/3] Compilation successful!

REM Run the test
echo [3/3] Running comprehensive tests...
echo.
cd %BIN_DIR%
java %CLASSES%
cd ..

echo.
echo ====================================
echo  Build and Test Completed!
echo ====================================
echo.
pause

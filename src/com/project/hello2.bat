@echo off
echo 2.1
for /F "tokens=2" %%i in ('date /t') do set mydate=%%i
set mytime=%time%
echo Current time from2.1 %mydate%:%mytime%

TIMEOUT  10
echo 2.2
for /F "tokens=2" %%i in ('date /t') do set mydate=%%i
set mytime=%time%
echo Current time from2.2 %mydate%:%mytime%

TIMEOUT  10

echo 2.3
for /F "tokens=2" %%i in ('date /t') do set mydate=%%i
set mytime=%time%
echo Current time from2.3 %mydate%:%mytime%

TIMEOUT  10

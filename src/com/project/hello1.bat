@echo off
echo 1.1
for /F "tokens=2" %%i in ('date /t') do set mydate=%%i
set mytime=%time%
echo Current time from1.1 %mydate%:%mytime%

TIMEOUT  10
echo 1.2
for /F "tokens=2" %%i in ('date /t') do set mydate=%%i
set mytime=%time%
echo Current time from1.2 %mydate%:%mytime%

TIMEOUT  10

echo 1.3
for /F "tokens=2" %%i in ('date /t') do set mydate=%%i
set mytime=%time%
echo Current time from1.3 %mydate%:%mytime%

TIMEOUT  10

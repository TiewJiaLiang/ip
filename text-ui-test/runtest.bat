@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
if exist ACTUAL.TXT del ACTUAL.TXT

REM compile the code into the bin folder
for /R %%f in (..\src\main\java\*.java) do javac -cp ..\src\main\java -Xlint:none -d ..\bin %%f
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)

REM no error here, errorlevel == 0

REM Run the program from the bin folder, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ..\bin wizt.ui.WizT < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT

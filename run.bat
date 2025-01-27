@echo off

:: Put the path to the JDK bin folder in the PATH
set CLASSPATH=build\classes\java\main;build\libs\*

:: Execute the application
java boris.enterprice.infrastructure.Main
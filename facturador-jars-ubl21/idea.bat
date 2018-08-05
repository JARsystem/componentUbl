@ECHO OFF
set MAVEN_HOME=C:\apache-maven
set PATH=%MAVEN_HOME%\bin;%PATH%
call mvn idea:idea
pause
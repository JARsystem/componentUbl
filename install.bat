@ECHO OFF
set MAVEN_HOME=C:\apache-maven
set PATH=%MAVEN_HOME%\bin;%PATH%
call mvn clean install -Dmaven.test.skip=true
pause
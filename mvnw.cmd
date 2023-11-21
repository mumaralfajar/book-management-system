@echo off
setlocal
set DIRNAME=%~dp0%
set APP_BASE_NAME=%~n0%
set APP_HOME=%DIRNAME%
set MAVEN_JAR=%APP_HOME%\.mvn\wrapper\maven-wrapper.jar

if not exist "%MAVEN_JAR%" (
  echo "The specified path was not found: %MAVEN_JAR%"
  exit /b 1
)

java -jar "%MAVEN_JAR%" %*
FROM java:8
LABEL developer="Tibin Lukose"
VOLUME /tmp
ARG JAR_FILE="target/echo.jar"
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

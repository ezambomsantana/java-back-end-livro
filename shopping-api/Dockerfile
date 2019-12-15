FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/shopping-api-0.0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
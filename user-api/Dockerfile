FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/dependency/doc-0.0.1-SNAPSHOT
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
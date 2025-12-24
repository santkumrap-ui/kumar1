# Use JDK 23
FROM eclipse-temurin:23-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/deploy-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
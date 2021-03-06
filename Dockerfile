FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/slacker-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
COPY config config
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
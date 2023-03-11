FROM amazoncorretto:17.0.6-alpine3.17
ARG JAR_FILE=build/libs/slacker-1.2.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
COPY config config
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
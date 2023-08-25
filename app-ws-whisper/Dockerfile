FROM --platform=linux/amd64 eclipse-temurin:17-jre-alpine
EXPOSE 8080
ARG JAR_FILE=target/app-ws-whisper-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
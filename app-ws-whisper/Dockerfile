FROM suroerst-east-docker.k22.desa/wwdf-8434-local-2ddd-3414/peru-images/verde/java:11
EXPOSE 8080
ARG JAR_FILE=target/app-ws-whisper-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
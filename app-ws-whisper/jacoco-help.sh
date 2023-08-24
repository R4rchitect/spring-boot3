mvn clean install
sleep 5
java -javaagent:src/main/resources/lib/jacocoagent.jar=address=*,port=36320,destfile=jacoco-it.exec,output=tcpserver -jar target/jacoco-code-coverage-example-0.0.1-SNAPSHOT.jar
sleep 5
curl -X GET http://localhost:8080/test/9
curl -X GET http://localhost:8080/test/50
sleep 5
java -jar src/main/resources/lib/jacococli.jar dump --address localhost --port 36320 --destfile target/jacoco-it.exec
sleep 5
java -jar src/main/resources/lib/jacococli.jar report target/jacoco-it.exec --classfiles target/classes/com --sourcefiles src/main/java/ --html target/jacoco-report

https://mvnrepository.com/artifact/org.jacoco/org.jacoco.agent/0.8.10


java 11 + springboot 3.0 + coverage jars jacocoagent-0.8.10-runtime.java and jacococli-0.8.10-nodeps.java

#correr el compilado con el agente
java "-javaagent:src/main/resources/lib/jacocoagent-0.8.10-runtime.jar=address=*,port=36320,destfile=jacoco-it.exec,output=tcpserver" -jar target/app-ws-whisper-0.0.1-SNAPSHOT.jar

#traer lo analizado en runtime a directorio local
java -jar src/main/resources/lib/jacococli-0.8.10-nodeps.jar dump --address localhost --port 36320 --destfile target/jacoco-it.exec

#generar reporte con el binario .exe que se encuentra en el directorio local
java -jar src/main/resources/lib/jacococli-0.8.10-nodeps.jar report target/jacoco-it.exec --classfiles target/classes/com --sourcefiles src/main/java/ --html target/jacoco-report


work 1

java -javaagent:src/main/resources/lib/jacocoagent-0.8.10-runtime.jar -jar target/app-ws-whisper-0.0.1-SNAPSHOT.jar

java -jar src/main/resources/lib/jacococli-0.8.10-nodeps.jar report jacoco.exec --classfiles target/classes/com --sourcefiles src/main/java/ --html target/jacoco-report
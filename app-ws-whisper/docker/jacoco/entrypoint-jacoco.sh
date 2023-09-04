#!/bin/bash
set -m
java -javaagent:jacocoagent-0.8.10-runtime.jar=address=*,port=36320,destfile=jacoco-pr.exec,output=tcpserver -jar /app.jar &
python3 /jacoco-scripts/httpserver-flask.py &
python3 /jacoco-scripts/httpserver-directory.py &
fg %1
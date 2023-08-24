#cat Dockerfile
agent='"-javaagent:src/main/resources/lib/jacocoagent-0.8.10-runtime.jar=address=*,port=36320,destfile=jacoco-it.exec,output=tcpserver"'
add_agent='"java",'"${agent}"''
line=$(grep -n "ENTRYPOINT" Dockerfile | cut -d : -f 1)
sed -i '' ''"$line"' s@"java"@'"${add_agent}"'@' Dockerfile
build:
	mvn clean install
build-image:
	docker build -t app-ws-whisper:0.1 . --platform linux/amd64
run-image:
	docker run --platform=linux/amd64 -d -p 8080:8080 app-ws-whisper:0.1
stop-image:
	docker stop app-ws-whisper:0.1
docker run -d -p 8888:8080 --name plantuml plantuml/plantuml-server

docker stop plantuml
docker rm plantuml
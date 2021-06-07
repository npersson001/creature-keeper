#! /bin/bash

docker pull openjdk:11.0.3-jre-slim
docker tag openjdk:11.0.3-jre-slim localhost:5000/openjdk:11.0.3-jre-slim
docker push localhost:5000/openjdk:11.0.3-jre-slim
mvn clean install -DskipTests -Djib.allowInsecureRegistries=true

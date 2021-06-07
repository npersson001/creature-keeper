#! /bin/bash

docker network create creature

./run_mariadb.sh -c 

sleep 5

docker-compose -f localdocker/creature/docker-compose.yml pull
docker-compose -f localdocker/creature/docker-compose.yml up -d


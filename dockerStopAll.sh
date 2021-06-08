#!/bin/bash

cd localdocker/creature
docker-compose down

docker stop maria

docker network rm creature

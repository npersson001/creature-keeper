#!/bin/bash

PROJECT_ROOT="$(dirname "$BASH_SOURCE")/"
COMPOSE_FILE="$PROJECT_ROOT/localdocker/creature/docker-compose.yml"

docker-compose -f "$COMPOSE_FILE" logs -f $1

#!/bin/bash

conn_config_host="127.0.0.1"

if docker top maria > /dev/null 2>&1; then
    echo "DB container already running, stopping..."
    exit 0
fi

docker run --rm --env MYSQL_ROOT_PASSWORD=root --env MYSQL_DATABASE=creature_keeper_db \
  --env MYSQL_USER=user \
  --env MYSQL_PASSWORD=pass \
  --name maria \
  -p 3306:3306 -d mariadb:10.2

while [[ ! $(mysql -h 127.0.0.1 -P 3306 -u root -proot -e "SELECT 1" 2> /dev/null) ]]; do
  echo "waiting for mysql..."
  sleep 3
done

echo "Flyway migrate common..."
flyway -user=root -password=root -url=jdbc:mariadb://127.0.0.1:3306/creature_keeper_db \
  -locations=filesystem:db/creature_keeper_db/common migrate \
  -ignoreMissingMigrations=true migrate

echo "Flyway migrate local..."
flyway -user=root -password=root -url=jdbc:mariadb://127.0.0.1:3306/creature_keeper_db \
  -locations=filesystem:db/creature_keeper_db/local \
  -placeholders.host=${conn_config_host} \
  -ignoreMissingMigrations=true migrate


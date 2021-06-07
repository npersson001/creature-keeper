# Creature Keeper Demo Project

## Overview

The purpose of this demo is to show a resilient rest api with a persistent layer which runs in a containerized 
environment.  To this end a Java11/Spring backend was chosen and implemented with a mariaDB acting as
the persistent layer.  All components run in docker containers.

### Prerequisites
* Java (v11.0.2)
* Docker (v19.03.13)
* Flyway (v7.5.4)

### The API

This demo project provides endpoints that allow the user to store and retrieve objects that represent
creatures in our world (ex. fox, cat, dog).  The endpoints available to hit are: 

`POST {host}/creatures`

where the body of the POST contains a JSON object representing the creature.  Here is an example:
```
{
     "name": "alex",
     "species": "cool species",
     "age": 11
}
```

`GET {host}/creatures/{creatureId}`

When running locally the host is `localhost:8090`

You will need to use basic authentication on the requests you send to the api, locally the username and
password are set to `user` and `password` respectively.

### Running Locally
You can run both the rest application and the database in docker containers by running the following 
sequence of commands in your terminal:

```
$ ./dockerStartRegistry.sh
$ ./dockerBuildAll.sh
$ ./dockerStartAll.sh
```

This will allow you to hit the api with the directions given in the above section. To tear down the 
containers simply run:

```
$ ./dockerStopAll.sh
```

The registry is a local docker registry that will hold the image jib builds of the application. The 
build is run by the buildAll script and the image is put into the registry.  Running the startAll script
pulls the images from the registry and creates the docker containers and the connecting bridged network. 

### Interacting with MariaDB Container
You can open an interactive terminal in the mariadb container by running the following command:

```docker exec -it maria /bin/bash```

Then you can interact with the db by running: 

```mysql -u root -p```

Entering `root` as password when prompted for it. 

## Demo Focus

### Security
* Basic auth added for local, to support production secrets vaults need to be created
* User never able to choose id for db primary key

### Resilience
* Logback using SLF4J logging 
* Cache in front of DB (caffeine)
* Specific error response status/message
* Flyway migration files for safe database maintenance 
* Pooled DB connections

## Future Development

### TODO
* comment on important methods
* enforce code style
* micrometer metrics added
* fix garbage exceptions during build from jacoco
* add integration tests for api endpoints

### If Time Allows
* Add undo Flyway migration files
* Async DB connection (jasync-sql)
* Using embedded db for unit test for repository
* Queue between api worker thread and worker threads that interact with the db
* Encrypt data at rest



